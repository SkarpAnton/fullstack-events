package skarp.anton.eventsbackend.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.configuration.CodecRegistry;
import skarp.anton.eventsbackend.models.mongo.Event;
import skarp.anton.eventsbackend.models.mongo.User;
import spark.Request;

import static com.mongodb.client.model.Filters.eq;

public class MongoStorage
{
  private final MongoCollection<User> userCollection;
  private final MongoCollection<Event> eventCollection;
  private MongoClient mongoClient;
  protected MongoDatabase database;

  public MongoStorage(String host, int port, String username, String password, String databaseName)
  {
    ServerAddress serverAddress = new ServerAddress(host, port);
    CodecRegistry pojoCodecRegistry = CodecBuilder.buildCodec();
    MongoCredential credential = MongoCredential.createCredential(username, "admin", password.toCharArray());
    mongoClient = new MongoClient(serverAddress, credential, MongoClientOptions.builder()
        .codecRegistry(pojoCodecRegistry)
        .build());
    database = mongoClient.getDatabase(databaseName);
    userCollection = database.getCollection("user", User.class);
    eventCollection = database.getCollection("event", Event.class);
  }

  public void addEvent(Event event)
  {
    eventCollection.insertOne(event);
  }

  public void updateEvent(Event event)
  {
    eventCollection.replaceOne(eq("id", event.getId()) , event);
  }

  public void removeEvent(String id)
  {
    eventCollection.deleteOne(eq("id", id));
  }

  public List<Event> getEventsForUser(String userId)
  {
    return eventCollection.find(eq("eventParticipantList.userId", userId)).into(new ArrayList<>());
  }

  public Event getEvent(String eventId)
  {
    return eventCollection.find(eq("id", eventId)).first();
  }


  public User getUser(Request request)
  {
    String sessionId = request.cookie("sessionId");
    if(sessionId != null)
    {
      return userCollection.find(eq("sessionId", sessionId)).first();
    }
    return null;
  }

  public Event getEvent(Request request)
  {
    String eventId = request.params(":id");
    if(eventId != null)
    {
      return getEvent(eventId);
    }
    return null;
  }

  public boolean containsEmail(String email)
  {
      return userCollection.find(eq("email", email)).first() != null;
  }

  public boolean containsUsername(String username)
  {
    return userCollection.find(eq("username", username)).first() != null;
  }

  public void addUser(User user)
  {
    userCollection.insertOne(user);
  }
}
