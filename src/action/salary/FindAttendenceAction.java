package action.salary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import util.Factory;
import dao.AttendenceDao;
import dao.DeptDao;
import entity.Attendence;

public class FindAttendenceAction {
	private Attendence attendence;
	private List<Attendence> attendences;
	private Integer month;
	private List monthList;
	public Attendence getAttendence() {
		return attendence;
	}

	public void setAttendence(Attendence attendence) {
		this.attendence = attendence;
	}
	
	public List<Attendence> getAttendences() {
		return attendences;
	}

	public void setAttendences(List<Attendence> attendences) {
		this.attendences = attendences;
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
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
		
			month = Integer.parseInt(attendence.getMonth());
			monthList =new ArrayList();
			for(int i=1;i<=12;i++){
				monthList.add(i);
			}
			attendences=attendenceDao.findAttendence(attendence);
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
