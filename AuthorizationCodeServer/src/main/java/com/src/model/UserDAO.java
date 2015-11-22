package com.src.model;

import java.util.List;

import com.src.entity.User;

public interface UserDAO {
    public User getUserFromName(String name) throws Exception;
    public List<User> getListUser() ;
    public User getUser();
}
