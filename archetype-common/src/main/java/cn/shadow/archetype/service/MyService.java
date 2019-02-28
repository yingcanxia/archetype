package cn.shadow.archetype.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shadow.archetype.dao.UserMapper;
import cn.shadow.archetype.entity.User;


@Service("MyService")
public class MyService {
	@Autowired
	private UserMapper mapper;
	
	
	public User selectone(Map map) {
		User user=mapper.selectById(map);
		return user;
	}
	protected UserMapper getMapper() {
		return mapper;
	}
	protected void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}
	
}
