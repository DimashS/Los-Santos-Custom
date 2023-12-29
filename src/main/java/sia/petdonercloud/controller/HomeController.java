package sia.petdonercloud.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Service
@Component
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "design";
    }
}
