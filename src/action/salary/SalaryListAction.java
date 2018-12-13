package action.salary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import util.Factory;
import dao.DeptDao;
import dao.SalaryDao;
import entity.Dept;
import entity.Salary;

public class SalaryListAction {
	//input 
			private int page = 1;//当前显示的页数
			//output
			private int totalPages;//总页数
			private List<Salary> salarys;
			//injection
			private int pageSize = 3;
			private Integer month;
			private List monthList;
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
		
			public List<Salary> getSalarys() {
				return salarys;
			}
			public void setSalarys(List<Salary> salarys) {
				this.salarys = salarys;
			}
			public int getPageSize() {
				return pageSize;
			}
			public void setPageSize(int pageSize) {
				this.pageSize = pageSize;
			}
			
			
			
			public Integer getMonth() {
				return month;
			}
			public void setMonth(Integer month) {
				this.month = month;
			}
			public List getMonthList() {
				return monthList;
			}
			public void setMonthList(List monthList) {
				this.monthList = monthList;
			}
			public String showlist(){
				SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
				try {
					Calendar c = Calendar.getInstance();
					month = c.get(Calendar.MONTH) + 1;
					monthList =new ArrayList();
					for(int i=1;i<=12;i++){
						monthList.add(i);
					}
					String m=month.toString();
					Integer year = c.get(Calendar.YEAR);
					String y=year.toString();
					//获取当前页需要的记录
					salarys = salaryDao.findAll(page,pageSize,y,m);
					
					//计算总页数
					totalPages = salaryDao.countTotalPage(pageSize);
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
}
