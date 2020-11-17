package week05.springwork.src;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: week05.springwork.src
 * @ClassName: SpringTest
 * @Description:
 * @Date: 2020/11/17 10:45
 */

public class SpringTest {


    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("springbean.xml");
        // 构造方式输出结果
        System.out.println(applicationContext.getBean("student1"));
        // 设值方式输出结果
        System.out.println(applicationContext.getBean("student2"));
    }
}
