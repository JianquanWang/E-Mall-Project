package tech.oldwang.service.impl;

import tech.oldwang.dao.UserDao;
import tech.oldwang.dao.impl.UserDaoImpl;
import tech.oldwang.domain.User;
import tech.oldwang.service.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public User login(User user) {
		// call DAO to query user exist or not
		UserDao userDao = new UserDaoImpl();
		return userDao.login(user);
	}
}
