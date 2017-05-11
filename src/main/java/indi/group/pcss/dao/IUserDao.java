package indi.group.pcss.dao;

import java.util.List;

import indi.group.pcss.model.User;

public interface IUserDao {
    int insert(User record);
    int deleteByUserId(Integer id);
    User selectByUsername(String username);
    int updateByUserId(User record);
    List<User> listGetAll();
}
