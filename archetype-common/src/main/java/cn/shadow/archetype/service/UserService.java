package cn.shadow.archetype.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shadow.archetype.dao.TellerMapper;

@Service("UserService")
public class UserService {
	@Autowired
	private TellerMapper tellerMapper;
	
	public List<String> queryAllEnableInterface(Map map) {
		List<String> powerList=tellerMapper.TellerPower(map);
		return powerList;
	}
}
