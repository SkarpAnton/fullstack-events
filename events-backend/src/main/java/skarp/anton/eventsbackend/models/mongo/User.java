package skarp.anton.eventsbackend.models.mongo;

import java.util.UUID;

public class User
{
  private String id = UUID.randomUUID().toString();
  private String username;
  private String passwordHash;
  private String salt;
  private String sessionId;
  private String csrfToken;
  private String email;
  private String firstName;
  private String lastName;

  public String getCsrfToken()
  {
    return csrfToken;
  }

  public void setCsrfToken(String csrfToken)
  {
    this.csrfToken = csrfToken;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPasswordHash()
  {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash)
  {
    this.passwordHash = passwordHash;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getSessionId()
  {
    return sessionId;
  }

  public void setSessionId(String sessionId)
  {
    this.sessionId = sessionId;
  }

  public String getSalt()
  {
    return salt;
  }

  public void setSalt(String salt)
  {
    this.salt = salt;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
}
