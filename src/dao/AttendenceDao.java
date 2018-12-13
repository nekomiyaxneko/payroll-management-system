package dao;

import java.util.List;

import entity.Attendence;
import entity.AttendenceSet;



public interface AttendenceDao {
	
	public int countTotalPage(int pageSize) throws Exception;
	public void save(Attendence attendence)throws Exception;
	public Attendence findById(String id)throws Exception;
	public void update(Attendence attendence)throws Exception;
	public void deleteById(String id)throws Exception;
	
	public List<Attendence> showAttendence() throws Exception;
	
	public AttendenceSet findAttendenceSet()throws Exception;
	public void updateSet(AttendenceSet attendenceSet)throws Exception;
	
	
	public List<Attendence> findAll(int page,int pageSize,String year,String month)throws Exception;
	public List<Attendence> generateByMonth(int page, int pageSize,String year,String month) throws Exception;
	public boolean checkMonth(String year,String month)throws Exception;
	public List<Attendence> findAttendence(Attendence attendence)throws Exception;
}
