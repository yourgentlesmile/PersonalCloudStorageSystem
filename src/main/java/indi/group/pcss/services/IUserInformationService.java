package indi.group.pcss.services;

import java.util.List;

import indi.group.pcss.model.UserInformation;

public interface IUserInformationService {
    List<UserInformation> getAllUser();
    int registerUser(UserInformation userInformation);
    int deleteByUserId(Integer userId);
    UserInformation selectByUserId(Integer userId);
    int modifyUserInformation(UserInformation userInformation);
}
