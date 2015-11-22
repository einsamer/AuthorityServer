package com.src.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import com.src.model.ClientDAOImp;

public class ClientCustomDetailsService implements ClientDetailsService {

    @Autowired
    ClientDAOImp clientDAOImp;

    public ClientDetails loadClientByClientId(String client_id) throws ClientRegistrationException {
        // TODO Auto-generated method stub
        ClientDetails client = clientDAOImp.findClientById(client_id);
        return client;
    }

}
