package com.alex.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @version 1.0.0
 * @className CacheUtils.java
 * @author: yz
 * @date: 2021/5/13 20:42
 */
@Slf4j
public class CacheUtils {

    private static final ExpressionParser parser ;
    private static final LocalVariableTableParameterNameDiscoverer discover;

    static {
        parser = new SpelExpressionParser();
        discover = new LocalVariableTableParameterNameDiscoverer();
    }

    public static <T> T parseSpel(Method method, Object[] arguments, String spel, Class<T> klass, T defaultResult){
        if(StringUtils.isEmpty(spel)){
            return null;
        }
        String [] params = discover.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < Objects.requireNonNull(params).length; i++) {
            context.setVariable(params[i], arguments[i]);
        }
        try{
            Expression expression = parser.parseExpression(spel);
            return expression.getValue(context, klass);
        }catch (Exception exception){
            exception.printStackTrace();
            log.error(exception.getMessage());
            return defaultResult;
        }
    }
}
