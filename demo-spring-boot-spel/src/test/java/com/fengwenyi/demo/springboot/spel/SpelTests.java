package com.fengwenyi.demo.springboot.spel;

import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-08-01
 */
public class SpelTests {

    @Test
    public void testVariableExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name", "路人甲java");
        context.setVariable("lesson", "Spring系列");

        //获取name变量，lesson变量
        String name = parser.parseExpression("#name").getValue(context, String.class);
        System.out.println(name);
        String lesson = parser.parseExpression("#lesson").getValue(context, String.class);
        System.out.println(lesson);

    }

}
