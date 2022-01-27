package skarp.anton.eventsbackend.controllers;

import java.util.List;
import skarp.anton.eventsbackend.models.mongo.Event;
import skarp.anton.eventsbackend.models.mongo.User;
import skarp.anton.eventsbackend.mongo.MongoStorage;
import skarp.anton.eventsbackend.utils.JsonUtils;
import spark.Request;
import spark.Response;

public class EventsController
{
  private MongoStorage mongoStorage;


  public String getEvents(Request request, Response response)
  {
    String responseBody;
    User user = mongoStorage.getUser(request);
    if(user != null)
    {
      List<Event> eventsForUser = mongoStorage.getEventsForUser(user.getId());
      responseBody = JsonUtils.objectToJson(eventsForUser);
      response.status(200);
    }
    else
    {
      responseBody = "Missing parameters";
      response.status(400);
    }
    return responseBody;
  }

  public String getEvent(Request request, Response response)
  {
    String responseBody;
    Event event = mongoStorage.getEvent(request);
    if(event != null)
    {
      if(!event.getRequiresLogin() || mongoStorage.getUser(request) != null)
      {
        responseBody = JsonUtils.objectToJson(event);
        response.status(200);
      }
      else
      {
        responseBody = "Event requires login";
        response.status(401);
      }
    }
    else
    {
      responseBody = "Event does not exist";
      response.status(404);
    }

    return responseBody;
  }

}
