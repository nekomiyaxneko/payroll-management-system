package action.salary;

import util.Factory;
import dao.DeptDao;
import dao.SalaryDao;
import entity.SalaryStandard;

public class StandardAction {
	private SalaryStandard salaryStandard;

	public SalaryStandard getSalaryStandard() {
		return salaryStandard;
	}

	public void setSalaryStandard(SalaryStandard salaryStandard) {
		this.salaryStandard = salaryStandard;
	}
	public String load(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			salaryStandard=salaryDao.loadStand(salaryStandard.getId());
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	
	public String update(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			salaryDao.updateStand(salaryStandard);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
