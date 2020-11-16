package mangodb;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class DatabaseManager {
	MongoClient mongoClient;

	
	public DatabaseManager() {
		init();
		
	}
	
	public void init() {
    	System.out.println("Database initialisation...");

		// here we create the collections and documents to populate our database, ex: users, courses etc..
    	mongoClient = MongoClients.create("mongodb://localhost:27017");

		//check if UserCredentials collection already exists
		if(collectionExists("UserCredentials")) {
			// if exists do nothing
		}else {
	    	System.out.println("Database is creating user stuff...");

	    	// creating users credentials
	        MongoDatabase mydatabase = mongoClient.getDatabase("MyDatabase");
			Document user1Cred = new Document("userName", "User1")
				      .append("password", "pass1")
				      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
			Document user2Cred = new Document("userName", "User2")
				      .append("password", "pass2")
				      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
		    MongoCollection<Document> UCredcollection = mydatabase.getCollection("UserCredentials");
		    UCredcollection.insertOne(user1Cred);
		    UCredcollection.insertOne(user2Cred);
			
		    //creating user profiles
		    MongoCollection<Document> UsersCollection = mydatabase.getCollection("Users");
			Document user1_Profile = new Document("userName", "User1")
				      .append("password", "pass1")
				      .append("firstname", "John")
				      .append("lastname", "Doe")
				      .append("email", "John@example.com")
				      .append("adress", "999 av.xxx")
				      .append("bdate", "99/99/9999");
			
			Document user2_Profile = new Document("userName", "User2")
				      .append("password", "pass2")
				      .append("firstname", "Smith")
				      .append("lastname", "Jael")
				      .append("email", "Smith@example.com")
				      .append("adress", "9191 av.yyy")
				      .append("bdate", "99/99/9999");
			UsersCollection.insertOne(user1_Profile);
			UsersCollection.insertOne(user2_Profile);
			
			
		}
		
		//check if AdminCredentials collection already exists
		if(collectionExists("AdminCredentials")) {
			// if exists do nothing
		}else {
	    	System.out.println("Database is creating admin stuff...");

	        MongoDatabase mydatabase = mongoClient.getDatabase("MyDatabase");

			Document admin1 = new Document("userName", "admintest1")
				      .append("password", "pass1")
				      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
			Document admin2 = new Document("userName", "admintest2")
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
	
	private boolean collectionExists(String collection) {
		
		return mongoClient.getDatabase("MyDatabase").listCollectionNames().into(new ArrayList<String>()).contains("UserCredentials");
		
	}

}
