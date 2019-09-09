package cn.shadow.archetype.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shadow.archetype.dao.CityMapper;
import cn.shadow.archetype.entity.City;


@Service("MyService")
public class MyService {
	@Autowired
	private CityMapper mapper;
	
	public List<City> selectAll() {
		List<City>list=mapper.selectAll();
		return list;
	}

	public CityMapper getMapper() {
		return mapper;
	}

	public void setMapper(CityMapper mapper) {
		this.mapper = mapper;
	}
	
	
	
	
	
}
