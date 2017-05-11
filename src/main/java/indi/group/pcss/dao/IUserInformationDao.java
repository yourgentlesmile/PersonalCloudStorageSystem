package indi.group.pcss.dao;


import java.util.List;

import indi.group.pcss.model.UserInformation;


public interface IUserInformationDao {
    int insert(UserInformation record);
    int deleteByUserId(Integer id);
    UserInformation selectByUserId(Integer id);
    int updateByUserId(UserInformation record);
    List<UserInformation> listGetAll();
    
    
    
//    int deleteByPrimaryKey(Integer id);
//    int insert(User record);
//    int insertSelective(User record);
//    User selectByPrimaryKey(Integer id);
//    int updateByPrimaryKeySelective(User record);
//    int updateByPrimaryKey(User record);
//    User selectByUserName(String username);
}