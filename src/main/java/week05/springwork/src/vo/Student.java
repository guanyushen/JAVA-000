package week05.springwork.src.vo;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: week05.springwork.src.vo
 * @ClassName: Student
 * @Description: 实体
 * @Date: 2020/11/17 10:45
 */

public class Student {

    private String name;
    private Integer sex;

    public Student(){
        super();
    }

    public Student(String name,Integer sex){
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
