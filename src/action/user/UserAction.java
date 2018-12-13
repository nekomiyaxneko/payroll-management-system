package action.user;

import action.BaseAction;
import dao.UserDao;
import util.Factory;
import entity.User;

public class UserAction extends BaseAction{
	private String id;
	private User user;
	private String password2;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String add(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			if(!user.getPassword().equals(password2)){
				request.put("password_error", "两次密码不一致");
				return "password_error";
			}else{
			userDao.save(user);
			return "list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String load(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			user=userDao.findById(id);
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			userDao.deleteById(id);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			userDao.update(user);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
}









