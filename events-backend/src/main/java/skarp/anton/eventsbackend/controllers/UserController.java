package skarp.anton.eventsbackend.controllers;

import javax.xml.bind.ValidationException;
import skarp.anton.eventsbackend.managers.UsersManager;
import skarp.anton.eventsbackend.models.request.SignUpRequest;
import skarp.anton.eventsbackend.utils.JsonUtils;
import spark.Request;
import spark.Response;
import static skarp.anton.eventsbackend.EventsLogger.LOGGER;

public class UserController
{
  private UsersManager usersManager;

  public String signUp(Request request, Response response)
  {
    String responseBody = "";
    String signUpJson = request.body();
    SignUpRequest signUpRequest = JsonUtils.jsonToObject(signUpJson, SignUpRequest.class);
    try
    {
      String sessionId = usersManager.signUp(signUpRequest);
      responseBody = sessionId;
    }
    catch (ValidationException e)
    {
      LOGGER.warn("Sign up failed due to: " + e.getMessage());
      responseBody = e.getMessage();
      response.status(400);
    }
    return responseBody;
  }





}
