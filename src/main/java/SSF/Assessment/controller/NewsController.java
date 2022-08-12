package SSF.Assessment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import SSF.Assessment.model.Articles;
import SSF.Assessment.model.Raw;
import SSF.Assessment.service.NewsService;

import org.slf4j.*;

@Controller
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
    
    @Autowired
    private NewsService ns;

    @GetMapping("/")
    public String rawPage(Model model){
        Raw raw = new Raw();
        Optional<Raw> dRaw = ns.getArticles();


        if(dRaw == null){
            model.addAttribute("raw", new Raw());
            return "raw";
        }
        List<Articles> art = Raw.getArticles();
        
        //model.addAttribute("raw", raw);
        model.addAttribute("art", art);
        
        return "index";
    }
}
