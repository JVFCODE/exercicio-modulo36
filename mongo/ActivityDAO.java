package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class ActivityDAO {
    public void logActivity(int userId, String action) {
        try (MongoClient mongoClient = MongoDBConnection.connect()) {
            MongoDatabase database = mongoClient.getDatabase("user_logs");
            MongoCollection<Document> collection = database.getCollection("activities");

            Document activity = new Document("userId", userId)
                    .append("action", action)
                    .append("timestamp", System.currentTimeMillis());
            collection.insertOne(activity);
        }
    }

    public void listActivities() {
        try (MongoClient mongoClient = MongoDBConnection.connect()) {
            MongoDatabase database = mongoClient.getDatabase("user_logs");
            MongoCollection<Document> collection = database.getCollection("activities");

            FindIterable<Document> activities = collection.find();
            for (Document activity : activities) {
                System.out.println(activity.toJson());
            }
        }
    }
}
