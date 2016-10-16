package eMusicStore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController1 {
	
	@RequestMapping("/hello")
	public String helloPage(){
		return "hello";
	}

}
