package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.devuser.DevUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping(value="/dev")
public class DevLoginController {

	private final Logger logger = Logger.getLogger(DevLoginController.class);
	@Resource
	private DevUserService devUserService;
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("login");
		return "devlogin";
	}
	
	@RequestMapping(value="/dologin")
	public String doLogin(@RequestParam String devCode,@RequestParam String devPassword,
			HttpServletRequest request,HttpSession session){
		logger.debug("dologin devCode : " + devCode + " and devPassword : " + devPassword);
		DevUser devUser = devUserService.getDevUserByUserCode(devCode);
		if(null != devUser){
			if(devUser.getDevPassword().equals(devPassword)){
				session.setAttribute(Constants.DEVUSER_SESSION,devUser);
				return "developer/main";
			}else{
				request.setAttribute("error", "密码不正确！");
			}
		}else{
			request.setAttribute("error", "用户不存在！");
		}
		return "devlogin";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.DEVUSER_SESSION);
		return "devlogin";
	}
}
