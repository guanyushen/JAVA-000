package week05.springwork.src.vo;

import org.springframework.stereotype.Component;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: week05.springwork.src.vo
 * @ClassName: AutoBeanTest
 * @Description: 自动注入bean
 * @Date: 2020/11/17 18:16
 */
@Component
public class AutoBeanTest {
    public AutoBeanTest(){
        System.out.println("AutoBeanTest类已加载。。。。。");
    }

}
