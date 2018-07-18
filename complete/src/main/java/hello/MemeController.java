package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
public class MemeController {

    private final static Logger log = LoggerFactory.getLogger(Application.class);


    @Autowired
    private MemeRepository memeRepository;

    private String bla = "[";

    private void setBla(String asdf) {
        if(bla.equals("[")){
            bla = bla + asdf;
        }else{
            bla = bla +","+ asdf;
        }
    };

    @RequestMapping("/meme")
    public String meme() {
    bla = "[";

        memeRepository.findAll().forEach(meme ->setBla(meme.getJson()));
        return bla + "]";
    }
}
