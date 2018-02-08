package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class GreetingController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }

    private final GoodbyeService service;

    public GreetingController(GoodbyeService service) {
        this.service = service;
    }

    @RequestMapping("/goodbye")
    public @ResponseBody String goodbye() {
        return service.greet();
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }


    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

}

