package action.emp;

import java.util.List;

import util.Factory;
import dao.AttendenceDao;
import dao.EmpDao;

import entity.User;

public class FindEmpAction {
	private User emp;
	private List<User> emps;
	public User getEmp() {
		return emp;
	}
	public void setEmp(User emp) {
		this.emp = emp;
	}
	public List<User> getEmps() {
		return emps;
	}
	public void setEmps(List<User> emps) {
		this.emps = emps;
	}
	public String execute(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			emps=empDao.findEmp(emp);
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
