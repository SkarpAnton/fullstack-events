package skarp.anton.eventsbackend.mongo;

import com.mongodb.MongoClient;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class CodecBuilder
{
  public static CodecRegistry buildCodec()
  {

    PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder()
        .register("skarp.anton.eventsbackend.models.mongo")
        .automatic(true)
        .build();
    CodecRegistry codecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),fromProviders(pojoCodecProvider));
    return codecRegistry;
  }
}
