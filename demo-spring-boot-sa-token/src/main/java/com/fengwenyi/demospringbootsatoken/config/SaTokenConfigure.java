package com.fengwenyi.demospringbootsatoken.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-01-13
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册Sa-Token的路由拦截器
        /*registry.addInterceptor(new SaRouteInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**", "/demo/index");*/

        registry.addInterceptor(new SaRouteInterceptor((req, res, handler)->{
                    // 根据路由划分模块，不同模块不同鉴权
//                    SaRouter.match("/user/**", r -> StpUtil.checkRoleOr("ROLE_USER", "ROLE_ADMIN"));
//                    SaRouter.match("/admin/**", r -> StpUtil.checkRole("ROLE_ADMIN"));
                }))
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**", "/demo/index");

        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor())
                .addPathPatterns("/**");
    }
}
