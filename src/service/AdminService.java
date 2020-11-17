package service;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mangodb.DatabaseManager;

public class AdminService {
	
	String userName="";
	DatabaseManager dbManager;
	MongoClient client;
	MongoDatabase mydatabase;
	
	public AdminService (String userName) {
		
		this.userName=userName;	
		dbManager = new DatabaseManager();
		client = dbManager.connect();
		mydatabase = dbManager.getDatabase(client);
	}
	
	public String getUserPassword() {
		

	     MongoCollection<Document> collection = mydatabase.getCollection("AdminCredentials");
	     
	    	System.out.println("count: "+collection.count());
	    	
	    	Document UserDoc = collection.find(eq("name", userName)).first();
	    	System.out.println(UserDoc.toJson());
	    	System.out.println(UserDoc.getString("password"));

		
		
		
		return UserDoc.getString("password");
		
	}
}
