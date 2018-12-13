package action.salary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.SalaryDao;
import entity.Salary;

import util.Factory;


public class AddSalarys {
	//input 
		private int page = 1;//��ǰ��ʾ��ҳ��
		//output
		private int totalPages;//��ҳ��
		private List<Salary> salarys;
		//injection
		private int pageSize = 3;
		private Integer month;
		private List monthList;
		private Salary salary;
		public String execute(){
			SalaryDao  salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
			try {
				//获取当前页需要的记录
				Calendar c = Calendar.getInstance();
//				month = c.get(Calendar.MONTH) + 1;
				month=Integer.parseInt(salary.getMonth());
				monthList =new ArrayList();
				for(int i=1;i<=12;i++){
					monthList.add(i);
				}
			/*	String m=month.toString();
				Integer year = c.get(Calendar.YEAR);
				String y=year.toString();*/
				salarys = salaryDao.saveSalarysByMonth(page, pageSize, salary.getYear(), salary.getMonth());			
				//������ҳ��
				totalPages = salaryDao.countTotalPage2(pageSize);
			
				return "add";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		
		
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


		public Salary getSalary() {
			return salary;
		}


		public void setSalary(Salary salary) {
			this.salary = salary;
		}

		
		
}
