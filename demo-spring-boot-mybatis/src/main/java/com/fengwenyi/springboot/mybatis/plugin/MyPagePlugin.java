package com.fengwenyi.springboot.mybatis.plugin;

import com.fengwenyi.springboot.mybatis.model.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-14
 */
@Intercepts({
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {
                        Connection.class,
                        Integer.class
                }
        )
})
@Slf4j
public class MyPagePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取StatementHandler,默认的是RoutingStatementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //获取StatementHandler的包装类
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        //分隔代理对象
        while (metaObject.hasGetter("h")) {
            Object obj = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(obj);
        }
        while (metaObject.hasGetter("target")) {
            Object obj = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(obj);
        }
        //获取查看接口映射的相关信息
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();
        //拦截以ByInterceptor结尾的请求，统一实现分页
        if (mapId.matches(".+ByInterceptor$")) {
            System.out.println("LOG:已触发分页拦截器");
            //获取进行数据库操作时管理参数的Handler
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            // 分页对象需要自己构建，到时候分页方法中要传入
            //获取请求时的参数
            PageModel pageModel = (PageModel) parameterHandler.getParameterObject();
            //获取原始SQL语句
            String originalSql = (String) metaObject.getValue("delegate.boundSql.sql");
            //构建分页功能的SQL语句
            String sql = originalSql.trim() + " limit " + pageModel.getCurrent() + ", " + pageModel.getPageSize();
            System.out.println(sql);
            metaObject.setValue("delegate.boundSql.sql", sql);
        }
        //调用原对象方法，进入责任链下一级
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
//        return Interceptor.super.plugin(target);
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
