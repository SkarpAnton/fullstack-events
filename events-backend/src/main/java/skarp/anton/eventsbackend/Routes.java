package skarp.anton.eventsbackend;

import skarp.anton.eventsbackend.controllers.EventsController;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class Routes
{


  private EventsController eventsController;

  public Routes(EventsController eventsController)
  {

    this.eventsController = eventsController;
  }

  public void run(int port)
  {
    port(port);
    initRoutes();
  }

  private void initRoutes()
  {
    path("/api", () -> {
      get("/events", eventsController::getEvents);
    });
  }


}
