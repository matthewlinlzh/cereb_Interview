package com.cereb.restapi.cerebai_interview;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class UserSession extends User {

    private UUID userId;
    private UUID authToken;
    private Timestamp createAt;

    UserSession(UUID userId, UUID authToken, Timestamp createAt) {
        super();
        this.userId = userId;
        this.authToken = authToken;
        this.createAt = createAt;
    }

    UserSession() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getAuthToken() {
        return authToken;
    }

    public void setAuthToken(UUID authToken) {
        this.authToken = authToken;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

}
