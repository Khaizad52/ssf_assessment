package SSF.Assessment.model;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;

public class Articles {
    public static final Logger logger = LoggerFactory.getLogger(Articles.class);

    public String id;
    public int publishedOn;
    public String title;
    public String url;
    public String imageurl;
    public String body;
    public String tags;
    public String categories;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getPublished_on() {
        return publishedOn;
    }
    public void setPublished_on(int published_on) {
        this.publishedOn = published_on;
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

        JsonString IdJs = articles.getJsonString("id");
        a.id = IdJs.getString();
        JsonNumber PublishedOnJn = articles.getJsonNumber("published_on");
        a.publishedOn = PublishedOnJn.intValue();

        JsonString TitleJs = articles.getJsonString("title");
        a.title = TitleJs.getString();
        JsonString UrlJs = articles.getJsonString("url");
        a.url = UrlJs.getString();
        JsonString ImageUrlJs = articles.getJsonString("image url");
        a.imageurl = ImageUrlJs.getString();
        JsonString BodyJs = articles.getJsonString("body");
        a.body = BodyJs.getString();
        JsonString TagsJs = articles.getJsonString("tags");
        a.tags = TagsJs.getString();
        JsonString CategoriesJs = articles.getJsonString("categories");
        a.categories = CategoriesJs.getString();

        return a;
    }

}
