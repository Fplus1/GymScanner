package GymScanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GymController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

//    @GetMapping("/greeting")
//    public Gym greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Gym("id_number", "gym_name", Team.VALOR, (byte)5, true, "http://");
//    }
}
