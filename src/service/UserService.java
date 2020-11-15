package service;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mangodb.DatabaseManager;

public class UserService {
	
	String userName="";
	
	public UserService (String userName) {
		this.userName=userName;	
	}
	
	public String getUserPassword() {
		
		DatabaseManager dbManager = new DatabaseManager();
		MongoClient client = dbManager.connect();
		
		 MongoDatabase mydatabase = dbManager.getDatabase(client);
	     MongoCollection<Document> collection = mydatabase.getCollection("UserCredentials");
	     
	    	System.out.println("count: "+collection.count());
	    	
//	    	Document myDoc = collection.find().first();
//	    	System.out.println(myDoc.toJson());
	    	
	    	Document UserDoc = collection.find(eq("name", userName)).first();
	    	System.out.println(UserDoc.toJson());
	    	System.out.println(UserDoc.getString("password"));

		
		
		
		return UserDoc.getString("password");
		
	}

}
