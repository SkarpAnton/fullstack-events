package skarp.anton.eventsbackend.models;

import java.util.Date;
import java.util.List;

public class Event
{
  private String name;
  private Date startTime;
  private Date endTime;
  private Boolean privateEvent;
  private Boolean onlyFriends;
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

  public Boolean getOnlyFriends()
  {
    return onlyFriends;
  }

  public void setOnlyFriends(Boolean onlyFriends)
  {
    this.onlyFriends = onlyFriends;
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
}