package skarp.anton.eventsbackend.utils;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static skarp.anton.eventsbackend.EventsLogger.LOGGER;

public class JsonUtils
{
  private static ObjectMapper objectMapper = new ObjectMapper()
      .setSerializationInclusion(JsonInclude.Include.NON_NULL)
      .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
      .setTimeZone(TimeZone.getDefault());
  
  public static String objectToJson(Object object)
  {
    String json = null;
    try
    {
      json = objectMapper.writeValueAsString(object);
    } catch(JsonProcessingException e)
    {
      LOGGER.error("Error converting object to json", e);
    }
    return json;
  }
  
  public static <T> T jsonToObject(String json, Class<T> objectClass)
  {
    Object object = null;
    try
    {
      object = objectMapper.readValue(json, objectClass);
    } catch(IOException e)
    {
      LOGGER.error("Error parsing json " + json, e);
    }
    return objectClass.cast(object);
  }

}
