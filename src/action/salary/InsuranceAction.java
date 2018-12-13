package action.salary;

import action.BaseAction;
import util.Factory;
import dao.AttendenceDao;
import dao.SalaryDao;
import entity.Insurance;

public class InsuranceAction extends BaseAction{
	private Insurance insurance;

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public String load(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			insurance=salaryDao.findInsurance();
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
			salaryDao.updateInsurance(insurance);
			request.put("message", "ÐÞ¸Ä³É¹¦");
			return "message";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}


