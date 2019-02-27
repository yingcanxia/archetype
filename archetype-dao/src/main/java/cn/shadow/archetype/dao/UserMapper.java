package cn.shadow.archetype.dao;

import java.util.Map;

import cn.shadow.archetype.entity.User;

public interface UserMapper {
	public User selectById(Map map);
}
