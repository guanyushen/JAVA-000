package week05.database.src.main.java.ds.entity;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: ds.entity
 * @ClassName: User
 * @Description:
 * @Date: 2020/11/17 20:12
 */

public class User {

    private int id;
    private String name;

    public User(int id, String name){
        this.id = id ;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
