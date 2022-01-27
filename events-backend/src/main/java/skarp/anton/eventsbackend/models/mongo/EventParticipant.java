package skarp.anton.eventsbackend.models.mongo;

public class EventParticipant
{
  private String userId;
  private Role role;
  private String inviteLink;
  private String eventUsername;



  public Role getRole()
  {
    return role;
  }

  public void setRole(Role role)
  {
    this.role = role;
  }

  public String getInviteLink()
  {
    return inviteLink;
  }

  public void setInviteLink(String inviteLink)
  {
    this.inviteLink = inviteLink;
  }

  public String getEventUsername()
  {
    return eventUsername;
  }

  public void setEventUsername(String eventUsername)
  {
    this.eventUsername = eventUsername;
  }

  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userId)
  {
    this.userId = userId;
  }
}
