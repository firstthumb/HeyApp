package com.ekocaman.hey.entity;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {

    private String id;
    private String username;
    private Date createdOn = new Date();

    public UserEntity(BasicDBObject dbObject) {
        this.id = ((ObjectId) dbObject.get("_id")).toString();
        this.username = dbObject.getString("username");
        this.createdOn = dbObject.getDate("createdOn");
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
}