package hello;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import hello.User;
import hello.UserRepository;

@Controller
public class MainController extends WebMvcConfigurerAdapter {
	@Autowired
	private UserRepository userRepository;

    @GetMapping("/")
    public String showForm() {
        return "result";
    }
    @GetMapping("/register")
    public String register(User user) {
        return "register";
    }
	
	@PostMapping(path="/register") // Map ONLY GET Requests
	public  String doRegister (@Valid User user, BindingResult result) {
		// @RequestParam means it is a parameter from the GET or POST request
        if (result.hasErrors()) {
            return "register";
        }
		userRepository.save(user);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}