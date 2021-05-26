package hr.learning.spring.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

  @GetMapping("/")
  public String greeting(
      @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    model.addAttribute("name", name);

    return "greeting";
  }

  @GetMapping("/better")
  public ModelAndView greetingBetter(
      @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    model.addAttribute("name", name);

    ModelAndView mav = new ModelAndView("greeting");
    mav.addAllObjects(model.asMap());

    return mav;
  }

}
