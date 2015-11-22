package com.src.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.src.entity.Account;

@Service
public class AccountDAOImp implements AccountDAO {

    List<Account> listUser = new ArrayList<Account>();

    public AccountDAOImp() {
        // TODO Auto-generated constructor stub
        buildListUser();
    }

    private void buildListUser() {
        // TODO Auto-generated method stub

        listUser.add(new Account(1, "Einsamer", "khanhha.cntt@gmail.com", "01202411239"));
        listUser.add(new Account(2, "Harold", "harold@enclave.vn", "01202411239"));
        listUser.add(new Account(3, "Hawk", "hawk@enclave.vn", "01202411239"));
        listUser.add(new Account(4, "Vincent", "vincent@enclave.vn", "01202411239"));
        listUser.add(new Account(5, "Carter", "carter@enclave.vn", "01202411239"));
        listUser.add(new Account(6, "Akos", "akos@enclave.vn", "01202411239"));
        listUser.add(new Account(7, "Vidal", "vidal@enclave.vn", "01202411239"));
        listUser.add(new Account(8, "SomeoneElse", "unknown@enclave.vn", "01202411239"));

    }

    public Account findUserByUserName(String username) throws Exception {
        // TODO Auto-generated method stub
        for (Account account: listUser) {
            if (username.equals(account.getName())) {
                return account;
            }
        }
        throw new Exception("No account was found");
    }

}
