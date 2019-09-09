package cn.shadow.archetype.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.shadow.archetype.entity.City;
import cn.shadow.archetype.service.MyService;

@Controller
@RequestMapping(value="/test")
public class MyController {
	@Resource
	private MyService service;
	@ResponseBody
	@RequestMapping("/testcontroller.do")
	public List<City> mytest() {
		List<City>list=service.selectAll();
		return list;
	}
	protected MyService getService() {
		return service;
	}
	protected void setService(MyService service) {
		this.service = service;
	}
	
}
