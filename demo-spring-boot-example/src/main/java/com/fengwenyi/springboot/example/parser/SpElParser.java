package com.fengwenyi.springboot.example.parser;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * SpEl 解析器
 * @author Erwin Feng
 * @since 2020-10-09
 */
public class SpElParser {

    private static final ExpressionParser parser = new SpelExpressionParser();

    public static String getKey(String key, String [] parameterNames, Object [] args) {
        // 第一步：将key字符串解析为el表达式
        Expression expression = parser.parseExpression(key);
        // 第二步：将形参和形参值以配对的方式配置到赋值上下文中
        EvaluationContext context = new StandardEvaluationContext(); // 初始化赋值上下文
        if (args.length <= 0) {
            return null;
        }
        for (int i = 0; i < args.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }
        // 第三步：根据赋值上下文运输el表达式
        return expression.getValue(context, String.class);
    }
}
