package action.dept;

import java.util.List;

import util.Factory;
import dao.DeptDao;

import entity.Dept;

public class FindDeptAction {
	private String deptName;
	private String manager;
	private List<Dept> depts;
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	public String findDept(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			depts=deptDao.findDept(deptName, manager);
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
