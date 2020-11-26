package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.pronatation.Courses.CourseBean;
import com.pronatation.Courses.CourseDTO;
import com.pronatation.Courses.CoursePrerequisite;

import mangodb.DatabaseManager;

public class CourseService {

	DatabaseManager dbManager;
	MongoClient client;
	MongoDatabase mydatabase;

	public CourseService() {

		dbManager = new DatabaseManager();
		client = dbManager.connect();
		mydatabase = dbManager.getDatabase(client);

	}


	public boolean createCourse(CourseDTO newCourse) {

		MongoCollection<Document> courseCollection = mydatabase.getCollection("Courses");

		Document course = new Document("courseLevel", newCourse.getCourseLevel())
				.append("sessionCode", newCourse.getSessionCode()).append("description", newCourse.getDescription())
				.append("NbPlace", newCourse.getNbPlace()).append("price", newCourse.getprice())
				.append("prerequisite", new CoursePrerequisite().getPrerequisiteOf(newCourse.getCourseLevel()));

		courseCollection.insertOne(course);

		return true;

	}

}
