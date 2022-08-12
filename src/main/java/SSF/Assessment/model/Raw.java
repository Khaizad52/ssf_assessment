package SSF.Assessment.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Raw {
    private static final Logger logger = LoggerFactory.getLogger(Raw.class);

    private static List<Articles> articles = new ArrayList<>();

    public static List<Articles> getArticles() {
        return articles;
    }

    public static void setArticles(List<Articles> articles) {
        Raw.articles = articles;
    }

    public static Raw createJson(String json) throws IOException{
        logger.info("raw data");
        Raw raw = new Raw();

        try(InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            //logger.info(o.toString());
            JsonArray ar = o.getJsonArray("Data");

            if(ar != null){
                List<Articles> result = new ArrayList<>();
                for(Object a : ar){
                    JsonObject articles = (JsonObject) a;
                    result.add(Articles.createJson(articles)); 
                    logger.info("array read");   
                }
            }
            
        }

        return raw;
    }

}
