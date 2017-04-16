package indi.group.pcss.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import indi.group.pcss.dao.IUserDao;
import indi.group.pcss.model.User;
import indi.group.pcss.services.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
    @Autowired
    private IUserDao iUserDao;
    
    @Override
    public User getUserByName(String username) {
        // TODO Auto-generated method stub
        return this.iUserDao.selectByUserName(username);
    }

}
