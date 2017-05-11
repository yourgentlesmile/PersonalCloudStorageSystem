package indi.group.pcss.services;

import java.util.List;
import indi.group.pcss.model.User;
import indi.group.pcss.model.UserInformation;

public interface IUserService {
    List<User> getAllUser();
    int registerUser(User user,UserInformation userInformation);
    int deleteByUserId(Integer userId);
    User selectByUsername(String username);
    int modifyUser(User user);
}
