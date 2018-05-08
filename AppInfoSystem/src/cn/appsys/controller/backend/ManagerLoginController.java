package cn.appsys.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backenduser.BackendUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping(value="/manager")
public class ManagerLoginController {

	private final Logger logger = Logger.getLogger(ManagerLoginController.class);
	@Resource
	private BackendUserService backendUserService;
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("login");
		return "backendlogin";
	}
	
	@RequestMapping(value="/dologin")
	public String doLogin(@RequestParam String userCode,@RequestParam String userPassword,
			HttpServletRequest request,HttpSession session){
		logger.debug("dologin userCode : " + userCode + " and userPassword : " + userPassword);
		BackendUser backendUser = backendUserService.getBackendUserByUserCode(userCode);
		if(null != backendUser){
			if(backendUser.getUserPassword().equals(userPassword)){
				session.setAttribute(Constants.USER_SESSION,backendUser);
				return "backend/main";
			}else{
				request.setAttribute("error", "密码不正确！");
			}
		}else{
			request.setAttribute("error", "用户不存在！");
		}
		return "backendlogin";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		try {
			BackendUser user = (BackendUser)session.getAttribute(Constants.USER_SESSION);
			logger.debug("logout ==== > backendlogin");
			return "backendlogin";
		} catch (Exception e) {
			logger.debug("logout ==== > devlogin");
			return "devlogin";
		}finally{
			session.removeAttribute(Constants.USER_SESSION);
		}
	}
}
