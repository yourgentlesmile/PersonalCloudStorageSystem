package indi.group.pcss.dao;


import indi.group.pcss.model.User;


public interface IUserDao {
    int deleteByPrimaryKey(Integer id);
    int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
    User selectByUserName(String username);
}