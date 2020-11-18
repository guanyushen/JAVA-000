package week05.database.src.main.java.user.service;

import ds.entity.User;

import java.util.List;

public interface UserService {

    public List<User> query();

    public void add(List<User> userList);

    public int delete(int id);

    public int update(User user);
}
