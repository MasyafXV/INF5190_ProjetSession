package mangodb;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;


public class DatabaseManager {
	
	public DatabaseManager() {
		
	}
	
	public void init() {

		Document user1 = new Document("name", "User1")
		      .append("password", "pass1")
		      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
		Document user2 = new Document("name", "User2")
		      .append("password", "pass2")
		      .append("arrayTest", Arrays.asList("v3.2", "v3.0", "v2.6"));
		
    	MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		
        MongoDatabase mydatabase = mongoClient.getDatabase("MyDatabase");

		
	    MongoCollection<Document> collection = mydatabase.getCollection("UserCredentials");

		
		collection.insertOne(user1);
		collection.insertOne(user2);
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
