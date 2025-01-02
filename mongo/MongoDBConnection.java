package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDBConnection {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    public static MongoClient connect() {
        return MongoClients.create(CONNECTION_STRING);
    }
}
