package skarp.anton.eventsbackend.managers;

import java.security.SecureRandom;
import javax.xml.bind.ValidationException;
import org.mindrot.jbcrypt.BCrypt;
import skarp.anton.eventsbackend.models.mongo.User;
import skarp.anton.eventsbackend.models.request.SignUpRequest;
import skarp.anton.eventsbackend.mongo.MongoStorage;

public class UsersManager
{

  private MongoStorage mongoStorage;

  public UsersManager(MongoStorage mongoStorage)
  {
    this.mongoStorage = mongoStorage;
  }


  public String signUp(SignUpRequest signUpRequest) throws ValidationException
  {
    validateSignUp(signUpRequest);
    String salt = createSalt();
    String passwordHash = createPasswordHash(signUpRequest.getPassword(), salt);
    String sessionId = createSessionId();
    User user = createUser(signUpRequest, passwordHash, salt, sessionId);
    mongoStorage.addUser(user);
    return sessionId;
  }

  private String createSessionId()
  {
    SecureRandom secureRandom = new SecureRandom();
    byte[] sessionId = new byte[128];
    secureRandom.nextBytes(sessionId);
    return new String(sessionId);
  }
  
  private User createUser(SignUpRequest signUpRequest, String passwordHash, String salt, String sessionId)
  {
    User user = new User();
    user.setFirstName(signUpRequest.getFirstName());
    user.setLastName(signUpRequest.getLastName());
    user.setEmail(signUpRequest.getEmail());
    user.setPasswordHash(passwordHash);
    user.setSalt(salt);
    user.setSessionId(sessionId);
    return user;
  }

  private String createSalt()
  {
    SecureRandom secureRandom = new SecureRandom();
    byte[] salt = new byte[64];
    secureRandom.nextBytes(salt);
    return new String(salt);
  }

  private String createPasswordHash(String password, String salt)
  {
    return BCrypt.hashpw(password, salt);
  }

  private void validateSignUp(SignUpRequest signUpRequest) throws ValidationException
  {
    if(signUpRequest.getEmail() == null)
    {
      throw new ValidationException("Missing email");
    }
    else if(signUpRequest.getUserName() ==  null)
    {
      throw new ValidationException("Missing username");
    }
    else if(signUpRequest.getPassword() == null)
    {
      throw new ValidationException("Missing password");
    }
    else if(signUpRequest.getPassword().length() < 8) 
    {
      throw new ValidationException("Password is less than 8 characters long");
    }
    else if(mongoStorage.containsEmail(signUpRequest.getEmail()))
    {
      throw new ValidationException("There is already a user with the given email address");
    }
    else if(mongoStorage.containsUsername(signUpRequest.getUserName()))
    {
      throw new ValidationException("There is already a user with the given username");
    }
  }

}
