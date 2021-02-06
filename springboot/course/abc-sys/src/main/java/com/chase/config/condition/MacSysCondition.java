package com.chase.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author chase
 * Date: 2021/2/6
 **/
public class MacSysCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        SimpleMethodMetadata simpleMethodMetadata=(SimpleMethodMetadata)metadata;

        System.out.println(metadata);
        return System.getProperty("os.name").equals("Mac OS X");
    }
}
