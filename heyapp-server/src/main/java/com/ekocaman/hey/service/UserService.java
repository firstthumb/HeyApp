package com.ekocaman.hey.service;

import com.ekocaman.hey.entity.UserEntity;
import com.google.gson.Gson;
import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {

    private final DB db;
    private final DBCollection collection;

    public UserService(DB db) {
        this.db = db;
        this.collection = db.getCollection("users");
    }

    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        DBCursor dbObjects = collection.find();
        while (dbObjects.hasNext()) {
            DBObject dbObject = dbObjects.next();
            users.add(new UserEntity((BasicDBObject) dbObject));
        }
        return users;
    }

    public void createNewUser(String body) {
        UserEntity user = new Gson().fromJson(body, UserEntity.class);
        collection.insert(new BasicDBObject("username", user.getUsername()).append("deviceId", user.getDeviceId()).append("createdOn", new Date()));
    }

    public UserEntity find(String id) {
        return new UserEntity((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id))));
    }

    public UserEntity findByDeviceId(String deviceId) {
        return new UserEntity((BasicDBObject) collection.findOne(new BasicDBObject("deviceId", deviceId)));
    }

    public UserEntity register(String body) {
        UserEntity user = new Gson().fromJson(body, UserEntity.class);
        BasicDBObject basicDBObject = (BasicDBObject) collection.findOne(new BasicDBObject("deviceId", user.getDeviceId()));
        if (basicDBObject == null) {
            collection.insert(new BasicDBObject("username", user.getUsername()).append("deviceId", user.getDeviceId()).append("createdOn", new Date()).append("updatedOn", new Date()));
        } else {
            collection.update(basicDBObject, new BasicDBObject("$set", new BasicDBObject("updatedOn", new Date())));
            user = new UserEntity(basicDBObject);
        }

        return user;
    }
}