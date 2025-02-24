package chrisnray.wedding.guestbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/guestbook")
    public String guestbook() {
        return "guestbook.html";
    }
}
