package indi.group.pcss.services;

import indi.group.pcss.model.User;

public interface IUserService {
    public User getUserByName(String username);
}
