package bi.baiqiu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import bi.baiqiu.pojo.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
	//	String name =  (String) session.getAttribute("username");
//	已登录
		if (user != null) {
			return true;
//	进行登录,登录页面显示	
		}else if(request.getRequestURI().contains("login") ){
			return true;
//	未登录
		}else{
			response.sendRedirect("/user/showlogin.do"); 
			return false;
		}
	}

	
	
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
