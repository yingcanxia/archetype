package cn.shadow.archetype.Login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shadow.archetype.entity.Teller;
import cn.shadow.archetype.service.UserService;

@Controller
@RequestMapping(value="/main")
public class LoginController {
	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/login.do")
	public String login(HttpServletRequest request) {
		int i=2;
		Map map=new HashMap();
		map.put("tellerId", i);
		Teller user=new Teller();
		user.setId(i);
		List<String>powerList=userService.queryAllEnableInterface(map);
		HttpSession session =request.getSession();
		session.setAttribute("powerList", powerList);
		session.setAttribute("user", user);
		return "success";
	}
}
