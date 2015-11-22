package com.src.model;

import com.src.entity.Account;

public interface AccountDAO {
    public Account findUserByUserName(String username) throws Exception;
}
