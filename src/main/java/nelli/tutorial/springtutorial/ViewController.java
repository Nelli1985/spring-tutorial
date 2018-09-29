package nelli.tutorial.springtutorial;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {

    // Mapping for homepage view
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime",new Date());
        model.addAttribute("username", "Nelli");
        model.addAttribute("mode", "development");

        return "index";
    }
}
