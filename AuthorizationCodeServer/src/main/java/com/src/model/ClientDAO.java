package com.src.model;

import com.src.entity.ClientCustomDetails;

public interface ClientDAO {
    public ClientCustomDetails findClientById(String clientId);
}
