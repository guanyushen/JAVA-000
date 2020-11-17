package week05.starter.src.main.java.study.guanys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: week05.starter
 * @ClassName: Student
 * @Description: 学生
 * @Date: 2020/11/17 19:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "student")
public class Student {

    private Long id;

    private String name;
}
