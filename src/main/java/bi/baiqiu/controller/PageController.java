package bi.baiqiu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bi.baiqiu.pojo.User;

@Controller
@RequestMapping("page")
public class PageController {
	
	@RequestMapping("{value}")
	public String page(@PathVariable String value) {
		return "/"+value;
	}
/*	
	@RequestMapping("shopsale")
	public String shopsale() {
		return "/shopsale";
	}
	
	@RequestMapping("top")
	public String top() {

		return "/top";
	}
	
	@RequestMapping("left")
	public String left() {
		
		return "/left";
	}

	@RequestMapping("showlogin")
	public String showlogin(Model model, HttpServletRequest request) {
		System.out.println(11);
		return "/login";
	}

	@RequestMapping("index")
	public String index(Model model, HttpServletRequest request) {

		return "/index2";
	}

	@RequestMapping("index11")
	public String index11(Model model, HttpServletRequest request) {

		return "/index11";
	}

	@RequestMapping("demo3")
	public String index() {

		return "/demo3";
	}*/

	@RequestMapping("login")
	public String dologin(Model model, HttpServletRequest request) {

		String localAddr = request.getRemoteAddr();
		if (localAddr.contains("fasdfasdf")) {
			User user = new User();
			user.setName("baiqiu");
			user.setPassword("1234");
			return "redirect:/user/index.do";
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ("baiqiu".equals(username) && "1234".equals(password)) {
			User user = new User();
			user.setName(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
			return "redirect:/user/index.do";

		} else {
			return "redirect:/user/showlogin.do";
		}

	}

	@RequestMapping("logout")
	public String logout(Model model, HttpServletRequest request) {

		// request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("name");

		return "redirect:/user/login.do";
	}
}
