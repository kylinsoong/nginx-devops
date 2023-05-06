package io.github.cloudadc.dumpplane.hander;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.UpdateResult;

import io.github.cloudadc.dumpplane.model.Configuration;

public class DumpPersistHander extends AbstractHander {
	
	public static DumpPersistHander newInstance() {
		return new DumpPersistHander();
	}

	public DumpPersistHander() {
		super(null);
	}

	@Override
	public void execute(Configuration config) throws Exception {
		
		System.out.println(objectToDocument(config));

	}

	@Override
	public void execute(List<Configuration> list) throws Exception {
		for(Configuration c : list) {
			execute(c);
		}
	}

	public void dumpToMongoDB(Configuration config, MongoClient mongoClient) throws JsonProcessingException {

		MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = database.getCollection("configurations");
        
        Document doc = Document.parse(objectToDocument(config));
        
        Bson query = Filters.eq("dumpFileName", config.getDumpFileName());
        
        ReplaceOptions opts = new ReplaceOptions().upsert(true);
        
        UpdateResult result = collection.replaceOne(query, doc, opts);
        
        if(result.wasAcknowledged()) {
        	System.out.println("write " + config.getDumpFileName() + " to DB was acknowledged, matched count: " + result.getMatchedCount());
        }
	}

	
}
