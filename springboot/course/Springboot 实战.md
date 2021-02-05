# Springboot 实战

## 介绍

\1. 由 Pivotal 团队提供的全新框架，其设计目的是用来简化新 Spring 应用的初始搭建以及开发过程。

\2.   基于简单、快速、方便快速搭建web应用。

\3.   

## 快速搭建web应用

1 在springboot网站快速生成应用。https://start.spring.io/

![img](file:////Users/jiuxing/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image001.png)

将下下来的包解压导入到Idea就能快速构建一个web应用

2 也可以直接在IDEA新建项目时 选择Spring Initializr。创建一个应用

## 常用注解配置

### 注解原理，复核注解原理

### Web应用类

org.springframework.web.bind.annotation

 @RestController

 

@Service 相当于

  <bean id="courseDAO"

​     class="com.hzhi.course.dao.CourseDAOImpl" scope="prototype">  

  </bean>  

 

### 配置-条件配置类

 org.springframework.context.annotation

- @ConditionalOnMissingBean(GoodRepository.class)和@ConditionalOnBean(GoodRepository.class) 

  ConditionalOnMissingBean表示当GoodRepository.class的bean不存在时才会有效。在大型项目中，通常用来避免多个开发都生成相同的bean。

  而ConditionalOnBean 正好相反

  ```
  		当GoodRepository.class的bean不存在时，才会生成GoodItemRepository的bean
  		@Bean
      @ConditionalOnMissingBean(GoodRepository.class)
      public GoodItemRepository goodItemRepository2(){
          System.out.println("goodItemRepository2");
          return new GoodItemRepository();
      } 
  ```



- @ConditionalOnProperty

  作用：从配置文件中获取某个值，与定义的值比较，决定Bean是否创建

  ```
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ ElementType.TYPE, ElementType.METHOD })
  @Documented
  @Conditional(OnPropertyCondition.class)
  public @interface ConditionalOnProperty {
  	//数组，获取对应property名称的值，与name不可同时使用  
      String[] value() default {}; 
    	//property名称的前缀，可有可无
      String prefix() default "";  
    	//数组，property完整名称或部分名称（可与prefix组合使用，组成完整的property名称），与value不可同时使用  
      String[] name() default {};
    	//可与name组合使用，比较获取到的属性值与havingValue给定的值是否相同，相同才加载配置  
      String havingValue() default "";
    	//缺少该property时是否可以加载。如果为true，没有该property也会正常加载；反之报错  
      boolean matchIfMissing() default false;
    	//是否可以松散匹配  
      boolean relaxedNames() default true;
  } 
  ```

  其中

  - `matchIfMissing`用来指定如果配置文件中未进行对应属性配置时的默认处理：默认情况下`matchIfMissing`为`false`，也就是说如果未进行属性配置，则自动配置不生效。如果`matchIfMissing`为`true`，则表示如果没有对应的属性配置，则自动配置默认生效。
  - `name 用来从配置文件中读取某个属性值。在`matchIfMissing`为`false`时，如果`name`值为空，则返回`false`；如果`name`不为空，则将该值与`havingValue`指定的值进行比较，如果一样则返回`true`，否则返回`false`。返回`false`也就意味着自动配置不会生效。

- @Configuration

- @Import

 

### 数据库类

### 扩展，自定义注解

## Starter-原理和常用starter

### 介绍

starter使用的事Springboot扩展机制，主要原理是在META/spring.factories文件中配置接口的实现类名称，然后springboot在启动时会读取这些配置文件并实例化。

### springboot SPI demo

 自己扩展一个SPI实现。

1 在创建一个Maven项目。

2 创建一个ProviderApp

```java
@Component
public class ProviderApp {
    public ProviderApp(){
        System.out.println("ProviderApp");
    }
}
```

3 资源目录下创建META/spring.factories文件 内容如下：

```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.chase.ProviderApp
```

4 将项目mvn install打打包到本地，然后再springboot项目中引入我们打的包即可。启动就能再日志中看到输出

```
ProviderApp
```

### SPI 原理



## Springboot cloud服务

## 微服务构建

### 服务治理

## docker 