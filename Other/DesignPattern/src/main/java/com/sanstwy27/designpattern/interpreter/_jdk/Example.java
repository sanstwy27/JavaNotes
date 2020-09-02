package com.sanstwy27.designpattern.interpreter._jdk;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Example {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("10 * (2 + 1) * 1 + 66");
        /**
         * 1.
         *   public interface Expression {
         *       ...
         *   }
         *
         * 2.
         *   public class CompositeStringExpression implements Expression {
         *       ...
         *   }
         *
         *   public class SpelExpression implements Expression {
         *       ...
         *   }
         *
         * 3.
         *   public abstract class TemplateAwareExpressionParser implements ExpressionParser {
         *     ...
         *     public Expression parseExpression(String expressionString) throws ParseException {
         *         return this.parseExpression(expressionString, (ParserContext)null);
         *     }
         *     ...
         *     public Expression parseExpression(String expressionString, @Nullable ParserContext context) throws ParseException {
         *         return context != null && context.isTemplate() ? this.parseTemplate(expressionString, context) : this.doParseExpression(expressionString, context);
         *     }
         *
         *     private Expression parseTemplate(String expressionString, ParserContext context) throws ParseException {
         *         if (expressionString.isEmpty()) {
         *             return new LiteralExpression("");
         *         } else {
         *             Expression[] expressions = this.parseExpressions(expressionString, context);
         *             return (Expression)(expressions.length == 1 ? expressions[0] : new CompositeStringExpression(expressionString, expressions));
         *         }
         *     }
         *     ...
         *     protected abstract Expression doParseExpression(String var1, @Nullable ParserContext var2) throws ParseException;
         *     ...
         *   }
         *
         * 4.
         *   public class SpelExpressionParser extends TemplateAwareExpressionParser {
         *       ...
         *       protected SpelExpression doParseExpression(String expressionString, @Nullable ParserContext context) throws ParseException {
         *         return (new InternalSpelExpressionParser(this.configuration)).doParseExpression(expressionString, context);
         *       }
         *   }
         *
         */
        int result = (Integer) expression.getValue();
        System.out.println(result);
        /**
         * 96
         */
    }
}
