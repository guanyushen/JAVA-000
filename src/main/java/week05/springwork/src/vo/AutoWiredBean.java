package week05.springwork.src.vo;

import org.springframework.stereotype.Component;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: week05.springwork.src.vo
 * @ClassName: AutoWiredBean
 * @Description:
 * @Date: 2020/11/17 18:18
 */
@Component
public class AutoWiredBean {

    public AutoWiredBean(){
        System.out.println("AutoWiredBeane已加载。。。。。。。");
    }
    public void testBean(){
        System.out.println("11111");
    }
}
