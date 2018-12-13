package action.emp;

import java.util.List;

import action.BaseAction;
import util.Factory;
import dao.DeptDao;
import dao.EmpDao;
import entity.Dept;
import entity.User;

public class EmpAction extends BaseAction{
	private User emp;
	private List<Dept> deptList;

	public User getEmp() {
		return emp;
	}

	public void setEmp(User emp) {
		this.emp = emp;
	}
	
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public String add(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.save(emp);
			return "list";
			} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String load(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			emp=empDao.findById(emp.getId());
			deptList=deptDao.showDept();
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String load2(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			String id=(String) session.get("userInfo");
			emp=empDao.findById(id);
			deptList=deptDao.showDept();
			return "update2";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.deleteById(emp.getId());
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.update(emp);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
}


