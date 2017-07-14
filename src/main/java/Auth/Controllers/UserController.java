package Auth.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import Auth.Models.User;
import Auth.Models.Register;
import Auth.Services.UserService;

@Controller
public class UserController extends WebMvcConfigurerAdapter {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showForm() {
        return "result";
    }
    @GetMapping("/register")
    public String register(Register register) {
        return "register";
    }
	
    @PostMapping(path="/register") // Map ONLY GET Requests
    public  String postRegister (@Valid Register register, BindingResult result) {
        // @RequestParam means it is a parameter from the GET or POST request
        if (result.hasErrors()) {
            return "register";
        }
        System.out.println(register.getId());
        User user = new User();
        user.setFromRegister(register);
        userService.save(user);
        return "result";
    }
	
    /*	
        @GetMapping("/login")
        public String login(User user) {
        return "login";
        }
    */
    /*
      @PostMapping(path="/login") // Map ONLY GET Requests
      public  String postLogin (@Valid User user, BindingResult result) {
      // @RequestParam means it is a parameter from the GET or POST request
      if (result.hasErrors()) {
      return "login";
      }
      userService.login(user);
      return "result";
      }
    */
    @GetMapping(path="/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users",userService.findAll());
        return "index";
    }
}
