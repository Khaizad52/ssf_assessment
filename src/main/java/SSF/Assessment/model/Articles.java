package SSF.Assessment.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;



public class Articles {
    public static final Logger logger = LoggerFactory.getLogger(Articles.class);

    public int id;
    public long published_on;
    public String title;
    public String url;
    public String imageurl;
    public String body;
    public String tags;
    public String categories;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getPublished_on() {
        return published_on;
    }
    public void setPublished_on(long published_on) {
        this.published_on = published_on;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }


    public static Articles createJson(JsonObject articles) throws IOException{
        logger.info("article createJson");
        Articles a = new Articles();

        try (InputStream is = new ByteArrayInputStream(articles.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            logger.info(o.toString());
        }


        return a;
    }

}
