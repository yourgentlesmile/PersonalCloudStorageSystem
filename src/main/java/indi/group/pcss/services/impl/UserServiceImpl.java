package indi.group.pcss.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import indi.group.pcss.dao.IUserDao;
import indi.group.pcss.dao.IUserInformationDao;
import indi.group.pcss.model.User;
import indi.group.pcss.model.UserInformation;
import indi.group.pcss.services.IUserService;
import indi.group.pcss.services.exception.UserException;
import indi.group.pcss.services.exception.UserInformationException;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private IUserInformationDao iUserInformationDao;
    @Override
    public List<User> getAllUser() {
        return iUserDao.listGetAll();
    }
    @Transactional
    @Override
    public int registerUser(User user,UserInformation userInformation) {
        int status1 = iUserDao.insert(user);  //向数据库添加账户成功则返回1，不成功则返回0
        if(status1 == 0) throw new UserException("用户表数据添加异常");
        int status2 = iUserInformationDao.insert(userInformation);//同上
        if(status2 == 0) throw new UserInformationException("用户表数据添加异常");
        return status1<<1+status2;
    }
    @Override
    public int deleteByUserId(Integer userId) {
        int result = iUserDao.deleteByUserId(userId);
        if(result == 0) throw new UserException("用户表数据删除异常");
        return result;
    }
    @Override
    public User selectByUsername(String username) {
        User result = iUserDao.selectByUsername(username);
        return result;
    }
    @Override
    public int modifyUser(User user) {
        int result = iUserDao.updateByUserId(user);
        if(result == 0) throw new UserException("用户表数据修改异常");
        return result;
    }
    
}
