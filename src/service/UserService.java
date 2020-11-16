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

	    	
	    	Document UserDoc = collection.find(eq("userName", userName)).first();
	    	System.out.println(UserDoc.toJson());
	    	System.out.println(UserDoc.getString("password"));

		
		
		
		return UserDoc.getString("password");
		
	}
	
	public boolean createUser(
			String userName,
			String password,
			String firstname,
			String lastname,
			String email,
			String adress,
			String bdate) {
		
		DatabaseManager dbManager = new DatabaseManager();
		MongoClient client = dbManager.connect();
		
		MongoDatabase mydatabase = dbManager.getDatabase(client);
		
	    MongoCollection<Document> UsersCollection = mydatabase.getCollection("Users");
		Document userProfile = new Document("userName", userName)
			      .append("password", password)
			      .append("firstname", firstname)
			      .append("lastname", lastname)
			      .append("email", email)
			      .append("adress", adress)
			      .append("bdate", bdate);
		UsersCollection.insertOne(userProfile);
		
		//adding the user pass to credentials collection
	    MongoCollection<Document> UsersCredCollection = mydatabase.getCollection("UserCredentials");
		Document userCred = new Document("userName", userName)
			      .append("password", password);
		UsersCredCollection.insertOne(userCred);



		
		return true;
		
	}

}
