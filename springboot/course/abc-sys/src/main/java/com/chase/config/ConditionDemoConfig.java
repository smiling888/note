package com.chase.config;

import com.chase.config.condition.MacSysCondition;
import com.chase.repository.GoodItemRepository;
import com.chase.repository.GoodRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiuxing.lzh
 * Date: 2021/2/5
 **/
@Configuration
public class ConditionDemoConfig {

    @Bean
    @ConditionalOnBean(GoodRepository.class)
    public GoodItemRepository goodItemRepository1() {
        System.out.println("goodItemRepository1");
        return new GoodItemRepository();
    }

    @Bean
    @ConditionalOnMissingBean(GoodRepository.class)
    public GoodItemRepository goodItemRepository2() {
        System.out.println("goodItemRepository2");
        return new GoodItemRepository();
    }

    @Bean
    @ConditionalOnClass(GoodRepository.class)
    public GoodItemRepository goodItemRepository3() {
        System.out.println("goodItemRepository3");
        return new GoodItemRepository();
    }


    //name用来从配置文件中读取某个属性值。在matchIfMissing为false时，如果name值为空，则返回false；如果name不为空，则将该值与havingValue指定的值进行比较，如果一样则返回true，否则返回false。返回false也就意味着自动配置不会生效。
    @Bean
    @ConditionalOnProperty(name = "spring.application.name", havingValue = "xxx-sys")
    public GoodItemRepository goodItemRepository4() {
        System.out.println("goodItemRepository4");
        return new GoodItemRepository();
    }

//    自定义条件

    /**
     *
     * @return
     */
    @Bean
    @Conditional(MacSysCondition.class)
    public GoodItemRepository goodItemRepository5(){
        System.out.println("goodItemRepository5");
        return new GoodItemRepository();
    }


}
