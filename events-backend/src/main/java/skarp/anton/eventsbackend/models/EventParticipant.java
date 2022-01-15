package skarp.anton.eventsbackend.models;

public class EventParticipant
{
  private User user;
  private Role role;
  private String inviteLink;
  private String eventUsername;

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

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
}
