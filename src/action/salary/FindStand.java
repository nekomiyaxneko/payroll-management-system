package action.salary;

import java.util.ArrayList;
import java.util.List;

import util.Factory;
import dao.SalaryDao;

import entity.SalaryStandard;

public class FindStand {
	private SalaryStandard salaryStandard;
	private List<SalaryStandard> salaryStandards;
	public SalaryStandard getSalaryStandard() {
		return salaryStandard;
	}
	public void setSalaryStandard(SalaryStandard salaryStandard) {
		this.salaryStandard = salaryStandard;
	}
	public List<SalaryStandard> getSalaryStandards() {
		return salaryStandards;
	}
	public void setSalaryStandards(List<SalaryStandard> salaryStandards) {
		this.salaryStandards = salaryStandards;
	}
	public String execute(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
		
			salaryStandards=salaryDao.findStand(salaryStandard);
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
