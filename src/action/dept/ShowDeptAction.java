package action.dept;

import java.util.List;

import util.Factory;
import dao.DeptDao;

import entity.Dept;

public class ShowDeptAction {
	private List<Dept> depts;

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}
	public String execute(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			depts=deptDao.showDept();
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
