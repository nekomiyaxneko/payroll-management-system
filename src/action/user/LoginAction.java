package action.user;

import util.Factory;
import action.BaseAction;
import dao.UserDao;
import entity.User;


public class LoginAction extends BaseAction{
	private String username;
	private String password;
	private User user;
	
	public String execute() throws Exception{
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		user=userDao.findByUsername(username);
		if(user==null){
			request.put("username_error", "用户名不存在");
			return "username_error";
		}else if(!user.getPassword().equals(password)){
				request.put("password_error", "用户名密码错误");
				return "password_error";
			}else{
				session.put("userInfo", user.getId());
				return "success";
			}
		
	}
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
