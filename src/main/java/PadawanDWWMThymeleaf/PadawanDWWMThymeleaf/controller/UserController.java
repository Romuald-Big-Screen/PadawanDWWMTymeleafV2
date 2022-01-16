package PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.controller;



import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.service.UserService;
import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.service.form.LoginForm;
import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.service.form.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public ModelAndView home(Model model) {


        return new ModelAndView("index");
    }



    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute("registrationForm") RegistrationForm form) {
        userService.registration(form);
        return new ModelAndView("login", "loginForm", new LoginForm());
    }

    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register", "registrationForm", new RegistrationForm());
    }




}

