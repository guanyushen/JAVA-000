package week05.springwork.src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import week05.springwork.src.vo.AutoBeanTest;
import week05.springwork.src.vo.AutoWiredBean;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: week05.springwork.src
 * @ClassName: AutoBeanConfig
 * @Description:
 * @Date: 2020/11/17 18:41
 */
@Configuration
@ComponentScan("week05.springwork.src.vo")
public class AutoBeanConfig {

    @Autowired
    private AutoWiredBean bean;

    @Bean
    public void autoBeanTest(){ 
    }

    public static void main(String[] args) {
        //创建容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AutoBeanConfig.class);
        //获得所有Bean的名字
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
