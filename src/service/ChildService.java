package service;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mangodb.DatabaseManager;

public class ChildService {
	private String childFname;
	
	public ChildService(String childFname) {
		this.childFname=childFname;
	}

	public boolean ChildcourseInscription(String courseLevel) {
		
		DatabaseManager dbManager = new DatabaseManager();

		
		MongoClient client = dbManager.connect();
		
		MongoDatabase mydatabase = dbManager.getDatabase(client);
		
	    MongoCollection<Document> childsCollection = mydatabase.getCollection("Childs");
	  
    	
    	Document course = new Document("RegisteredCourses", Arrays.asList(courseLevel));
    	childsCollection.updateOne(eq("childFname", childFname), new Document("$push", course));
    	
		return true;
		
	}

	public ArrayList<Object> getChildCourses() {
		
		DatabaseManager dbManager = new DatabaseManager();

		
		MongoClient client = dbManager.connect();
		
		MongoDatabase mydatabase = dbManager.getDatabase(client);
		
	    MongoCollection<Document> usersCollection = mydatabase.getCollection("Childs");
    	Document childDoc = usersCollection.find(eq("childFname", childFname)).first();

    	ArrayList<Object> courses =null;
    	courses = (ArrayList<Object>) childDoc.get("RegisteredCourses");
    	
		return courses;
	}
	

	public String getChildBdate() {
		
		DatabaseManager dbManager = new DatabaseManager();

		
		MongoClient client = dbManager.connect();
		
		MongoDatabase mydatabase = dbManager.getDatabase(client);
		
	    MongoCollection<Document> usersCollection = mydatabase.getCollection("Childs");
    	Document childDoc = usersCollection.find(eq("childFname", childFname)).first();

    	String bdate =  (String) childDoc.get("childAge");
    	
		return bdate;
	}

}
