package dao;

import java.util.List;

import entity.User;


public interface EmpDao {
	public List<User> findAll(int page,int pageSize)throws Exception;
	public int countTotalPage(int pageSize) throws Exception;
	public void save(User emp)throws Exception;
	public User findById(String id)throws Exception;
	public void update(User emp)throws Exception;
	public void deleteById(String id)throws Exception;
	
	
	public List<User> findEmp(User emp)throws Exception;
}
