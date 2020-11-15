package mangodb;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class DatabaseManager {
	
	public DatabaseManager() {
		init();
		
	}
	
	public void init() {
    	System.out.println("Database initialisation...");

		// here we create the collections and documents to populate our database, ex: users, courses etc..
		
    	MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		//check if UserCredentials collection already exists
		if(mongoClient.getDatabase("MyDatabase").listCollectionNames().into(new ArrayList<String>()).contains("UserCredentials")) {
			// if exists do nothing
		}else {
	    	System.out.println("Database is creating user stuff...");

	        MongoDatabase mydatabase = mongoClient.getDatabase("MyDatabase");
			Document user1 = new Document("name", "User1")
				      .append("password", "pass1")
				      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
			Document user2 = new Document("name", "User2")
				      .append("password", "pass2")
				      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
		    MongoCollection<Document> collection = mydatabase.getCollection("UserCredentials");
			collection.insertOne(user1);
			collection.insertOne(user2);
		}
		
		//check if AdminCredentials collection already exists
		if(mongoClient.getDatabase("MyDatabase").listCollectionNames().into(new ArrayList<String>()).contains("AdminCredentials")) {
			// if exists do nothing
		}else {
	    	System.out.println("Database is creating admin stuff...");

	        MongoDatabase mydatabase = mongoClient.getDatabase("MyDatabase");

			Document admin1 = new Document("name", "admintest1")
				      .append("password", "pass1")
				      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
			Document admin2 = new Document("name", "admintest2")
				      .append("password", "pass2")
				      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
		    MongoCollection<Document> collection = mydatabase.getCollection("AdminCredentials");
			collection.insertOne(admin1);
			collection.insertOne(admin1);

		}
	}
	
	
	
	
	
	
	public MongoClient connect() {
		
    	MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		return mongoClient;
      	
	}
	
	public MongoDatabase getDatabase(MongoClient mongoClient) {
		
        MongoDatabase mydatabase = mongoClient.getDatabase("MyDatabase");
        
        return mydatabase;
	}

}
