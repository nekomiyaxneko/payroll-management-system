package action.salary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import util.Factory;
import dao.AttendenceDao;

import entity.Attendence;

public class AddAttendences {
	//input 
	private int page = 1;//当前显示的页数
	//output
	private int totalPages;//总页数
	private List<Attendence> attendences;
	//injection
	private int pageSize = 3;
	private Attendence attendence;
	private Integer month;
	private List monthList;
	public String execute(){
		AttendenceDao  attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			//获取当前页需要的记录
			Calendar c = Calendar.getInstance();
//			month = c.get(Calendar.MONTH) + 1;
			month = Integer.parseInt(attendence.getMonth());
			monthList =new ArrayList();
			for(int i=1;i<=12;i++){
				monthList.add(i);
			}
		/*	String m=month.toString();
			Integer year = c.get(Calendar.YEAR);
			String y=year.toString();*/
			attendences = attendenceDao.generateByMonth(page, pageSize,
					attendence.getYear(), attendence.getMonth());			
			//计算总页数
			totalPages = attendenceDao.countTotalPage(pageSize);
		
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<Attendence> getAttendences() {
		return attendences;
	}
	public void setAttendences(List<Attendence> attendences) {
		this.attendences = attendences;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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


	public Attendence getAttendence() {
		return attendence;
	}


	public void setAttendence(Attendence attendence) {
		this.attendence = attendence;
	}

	
	
}
