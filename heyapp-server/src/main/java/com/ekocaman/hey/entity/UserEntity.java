package com.ekocaman.hey.entity;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {

    private String id;
    private String username;
    private String deviceId;
    private Date createdOn = new Date();
    private Date updatedOn = new Date();

    public UserEntity(BasicDBObject dbObject) {
        this.id = ((ObjectId) dbObject.get("_id")).toString();
        this.username = dbObject.getString("username");
        this.deviceId = dbObject.getString("deviceId");
        this.createdOn = dbObject.getDate("createdOn");
        this.updatedOn = dbObject.getDate("updatedOn");
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }
}