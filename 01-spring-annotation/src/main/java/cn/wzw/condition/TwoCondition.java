package cn.wzw.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author Wangzhiwen
 * @ClassName TwoCondition
 * @Description
 * @Date 2019/5/23 14:52
 * @Version 1.0
 */
public class TwoCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String name = environment.getProperty("os.name");
        if (name.contains("Linux"))
            return true;
        return false;
    }
}
