package com.src.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.src.entity.User;

@Service
public class UserDAOImp implements UserDAO{

    public UserDAOImp() {
        // TODO Auto-generated constructor stub
        buildListUser();
    }

    List<User> listUser = new ArrayList<User>();

    public User getUserFromName(String name) throws Exception {
        // TODO Auto-generated method stub

        for (User u : listUser) {
            if (u.getName().contains(name)) {
                return u;
            }
        }
         throw new Exception("User not found");
    }

    private void buildListUser() {
        listUser.add(new User(1, "Einsamer", "khanhha.cntt@gmail.com", "01202411239"));
        listUser.add(new User(2, "Harold", "harold@enclave.vn", "01202411239"));
        listUser.add(new User(3, "Hawk", "hawk@enclave.vn", "01202411239"));
        listUser.add(new User(4, "Vincent", "vincent@enclave.vn", "01202411239"));
        listUser.add(new User(5, "Carter", "carter@enclave.vn", "01202411239"));
        listUser.add(new User(6, "Akos", "akos@enclave.vn", "01202411239"));
        listUser.add(new User(7, "Vidal", "vidal@enclave.vn", "01202411239"));
        listUser.add(new User(8, "SomeoneElse", "unknown@enclave.vn", "01202411239"));
    }

    public List<User> getListUser() {
        // TODO Auto-generated method stub
        return listUser;
    }

    public User getUser() {
        // TODO Auto-generated method stub
        return this.listUser.get(0);
    }

}
