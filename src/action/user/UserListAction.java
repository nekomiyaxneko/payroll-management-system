package action.user;

import java.util.List;

import dao.UserDao;

import util.Factory;


import entity.User;

public class UserListAction {
	//input 
	private int page = 1;//��ǰ��ʾ��ҳ��
	//output
	private int totalPages;//��ҳ��
	private List<User> users;
	//injection
	private int pageSize = 3;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String showlist(){
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		try {
			//��ȡ��ǰҳ��Ҫ�ļ�¼
			users = userDao.findAll(page,pageSize);
			
			//������ҳ��
			totalPages = userDao.countTotalPage(pageSize);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}








