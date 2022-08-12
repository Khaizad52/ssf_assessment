package SSF.Assessment.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import SSF.Assessment.model.Raw;

@Service
public class NewsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);

    private static String URL = "https://min-api.cryptocompare.com/data/v2/news/?lang=EN";

    public Optional<Raw> getArticles(){
        String apiKey = System.getenv("CRYPTO_API_KEY");

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = null;

        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("Apikey", apiKey);
            HttpEntity req = new HttpEntity(headers);
            response = template.exchange(URL, HttpMethod.GET, req, String.class, 1);
            
            Raw raw = Raw.createJson(response.getBody());
            return Optional.of(raw);
        }
        catch(Exception ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        return Optional.empty();
    }

}
