package week05.database.src.main.java.ds.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: ds.entity
 * @ClassName: NewUser
 * @Description: 电商User实体
 * @Date: 2020/11/30 14:49
 */

@Data
public class NewUser {

    private String id;
    private String username;
    private String password;
    private String mobile;
    private String email;
    private String real_name;
    private String s_did;
    private String did_type;
    private Integer is_business;
    private String address;
    private Date create_time;
    private Date update_time;

}
