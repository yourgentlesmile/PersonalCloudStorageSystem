package indi.group.pcss.services.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import indi.group.pcss.dao.IUserInformationDao;
import indi.group.pcss.model.UserInformation;
import indi.group.pcss.services.IUserInformationService;

@Service
public class UserInformationServiceImpl implements IUserInformationService {
	
    @Autowired
    private IUserInformationDao iUserInformationDao;
    @Override
    public List<UserInformation> getAllUser() {
        return iUserInformationDao.listGetAll();
    }
    @Override
    public int registerUser(UserInformation userInformation) {
        int result = iUserInformationDao.insert(userInformation);
        return result;
    }
    @Override
    public int deleteByUserId(Integer userId) {
        int result = iUserInformationDao.deleteByUserId(userId);
        return result;
    }
    @Override
    public UserInformation selectByUserId(Integer userId) {
        UserInformation result = iUserInformationDao.selectByUserId(userId);
        return result;
    }
    @Override
    public int modifyUserInformation(UserInformation userInformation) {
        int result = iUserInformationDao.updateByUserId(userInformation);
        return result;
    }
    
}
