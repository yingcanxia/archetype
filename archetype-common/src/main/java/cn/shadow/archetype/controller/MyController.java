package cn.shadow.archetype.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.shadow.archetype.entity.User;
import cn.shadow.archetype.service.MyService;

@Controller
@RequestMapping(value="/test")
public class MyController {
	@Resource
	private MyService service;
	@ResponseBody
	@RequestMapping("/testcontroller.do")
	public User mytest() {
		Map map=new HashMap();
		map.put("id", 1);
		User user =service.selectone(map);
		return user;
	}
	protected MyService getService() {
		return service;
	}
	protected void setService(MyService service) {
		this.service = service;
	}
	
}
