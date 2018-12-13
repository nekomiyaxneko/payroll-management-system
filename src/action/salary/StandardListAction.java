package action.salary;

import java.util.List;

import dao.SalaryDao;

import util.Factory;


import entity.SalaryStandard;

public class StandardListAction {
	private int page = 1;//当前显示的页数
	//output
	private int totalPages;//总页数
	private int pageSize = 3;
	private List<SalaryStandard> salaryStandards;



	public List<SalaryStandard> getSalaryStandards() {
		return salaryStandards;
	}

	public void setSalaryStandards(List<SalaryStandard> salaryStandards) {
		this.salaryStandards = salaryStandards;
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String execute(){
		SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
		try {
			//获取当前页需要的记录
			salaryStandards = salaryDao.findStandAll(page, pageSize);
			
			//计算总页数
			totalPages = salaryDao.countTotalPage(pageSize);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}




