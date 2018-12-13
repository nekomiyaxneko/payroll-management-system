package action.salary;

import java.util.ArrayList;
import java.util.List;

import util.Factory;
import dao.DeptDao;
import dao.SalaryDao;
import entity.Salary;

public class FindSalaryAction {
	private Salary salary;
	private List<Salary> salarys;
	private Integer month;
	private List monthList;
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public List<Salary> getSalarys() {
		return salarys;
	}

	public void setSalarys(List<Salary> salarys) {
		this.salarys = salarys;
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

	public String execute(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			month = Integer.parseInt(salary.getMonth());
			monthList =new ArrayList();
			for(int i=1;i<=12;i++){
				monthList.add(i);
			}
			salarys=salaryDao.findSalary(salary);
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
