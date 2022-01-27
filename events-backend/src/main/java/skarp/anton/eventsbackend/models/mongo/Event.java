package skarp.anton.eventsbackend.models.mongo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Event
{
  private String id = UUID.randomUUID().toString();
  private String name;
  private Date startTime;
  private Date endTime;
  private Boolean privateEvent;
  private Boolean requiresLogin;
  private String address;
  private String description;
  private List<EventParticipant> eventParticipantList;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Date getStartTime()
  {
    return startTime;
  }

  public void setStartTime(Date startTime)
  {
    this.startTime = startTime;
  }

  public Date getEndTime()
  {
    return endTime;
  }

  public void setEndTime(Date endTime)
  {
    this.endTime = endTime;
  }

  public Boolean getPrivateEvent()
  {
    return privateEvent;
  }

  public void setPrivateEvent(Boolean privateEvent)
  {
    this.privateEvent = privateEvent;
  }

  public Boolean getRequiresLogin()
  {
    return requiresLogin;
  }

  public void setRequiresLogin(Boolean requiresLogin)
  {
    this.requiresLogin = requiresLogin;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public List<EventParticipant> getEventParticipantList()
  {
    return eventParticipantList;
  }

  public void setEventParticipantList(List<EventParticipant> eventParticipantList)
  {
    this.eventParticipantList = eventParticipantList;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
}
