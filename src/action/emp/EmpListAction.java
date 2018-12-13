package action.emp;

import java.util.List;

import dao.EmpDao;

import util.Factory;
import entity.Dept;
import entity.User;

public class EmpListAction {
	//input 
			private int page = 1;//当前显示的页数
			//output
			private int totalPages;//总页数
			private List<User> emps;
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
		
			
			public List<User> getEmps() {
				return emps;
			}
			public void setEmps(List<User> emps) {
				this.emps = emps;
			}
			public int getPageSize() {
				return pageSize;
			}
			public void setPageSize(int pageSize) {
				this.pageSize = pageSize;
			}
			public String showlist(){
				EmpDao empDao = (EmpDao) Factory.getInstance("EmpDao");
				try {
					//获取当前页需要的记录
					emps = empDao.findAll(page,pageSize);
					
					//计算总页数
					totalPages = empDao.countTotalPage(pageSize);
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
}
