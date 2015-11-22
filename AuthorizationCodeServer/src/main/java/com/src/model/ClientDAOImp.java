package com.src.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.src.entity.ClientCustomDetails;

@Service
public class ClientDAOImp implements ClientDAO {


    private List<ClientCustomDetails> listClient;

    public ClientDAOImp() {
        // TODO Auto-generated constructor stub
        buildListClient();
    }

    public ClientCustomDetails findClientById(String clientId) {
        // TODO Auto-generated method stub
        for (ClientCustomDetails client: listClient) {
            if (client.getClientId().equals(clientId)) {
                return client;
            }
        }
        return null;
    }

    private void buildListClient() {
        listClient = new ArrayList<ClientCustomDetails>();
        listClient.add(new ClientCustomDetails("trusted_client", "secret", "read,trusted", "rest-data",
                "ROLE_USER", "http://springapp-hirte.rhcloud.com/AuthorizationCodeClient/home"
                , "authorization_code"));
        listClient.add(new ClientCustomDetails("untrusted_client", "secret", "read,trusted", "rest-data",
                "ROLE_USER", "http://localhost:8888/AuthorizationCodeServer/anonymous/home"
                , "authorization_code,implicit"));
        listClient.add(new ClientCustomDetails("test", "secret", "read,trusted", "rest-data",
                "ROLE_USER", "http://localhost:8888/AuthorizationCodeServer/anonymous/home"
                , "authorization_code,implicit"));
        listClient.add(new ClientCustomDetails("android", "secret", "read,trusted", "rest-data",
                "ROLE_USER", "http://localhost:8888/AuthorizationCodeClient/home"
                , "authorization_code,implicit"));
        listClient.add(new ClientCustomDetails("android2", "secret", "read,trusted", "rest-data",
                "ROLE_USER", "http://springapp-hirte.rhcloud.com/AuthorizationCodeServer/anonymous/home"
                , "authorization_code,implicit"));
        listClient.add(new ClientCustomDetails("implicit_client", "secret", "read,trusted", "rest-data",
                "ROLE_USER", "http://localhost:8888/AuthorizationCodeServer/anonymous/home"
                , "authorization_code,implicit"));
    }

}
