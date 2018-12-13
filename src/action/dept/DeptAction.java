package action.dept;

import java.util.List;

import dao.DeptDao;
import util.Factory;

import entity.Dept;

public class DeptAction {
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
	

	public String add(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			deptDao.save(dept);
			return "list";
			} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String load(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			dept=deptDao.findById(dept.getId());
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			deptDao.deleteById(dept.getId());
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			deptDao.update(dept);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
}








