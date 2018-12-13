package dao;

import java.util.List;

import entity.Attendence;
import entity.Insurance;
import entity.Salary;
import entity.SalaryStandard;


public interface SalaryDao {
	
	
	public void save(Salary salary)throws Exception;
	public Salary findById(String id)throws Exception;
	public void update(Salary salary)throws Exception;
	public void deleteById(String id)throws Exception;
	public List<Salary> showSalary() throws Exception;
	public void saveSalarys(List<Salary> salarys) throws Exception;
	
	
	
	public List<Salary> findAll(int page,int pageSize,String year,String month)throws Exception;
	public int countTotalPage(int pageSize) throws Exception;
	public int countTotalPage2(int pageSize) throws Exception;	
	public List<Salary> saveSalarysByMonth(int page, int pageSize,String year,String month)throws Exception;
	
	public List<SalaryStandard> findStand(SalaryStandard salaryStandard)throws Exception;
	public List<SalaryStandard> findStandAll(int page,int pageSize)throws Exception;
	
	public SalaryStandard loadStand(String id)throws Exception;
	public void updateStand(SalaryStandard salaryStandard)throws Exception;
	public List<Salary> findSalary(Salary salary)throws Exception;
	
	public Insurance findInsurance()throws Exception;
	public void updateInsurance(Insurance insurance)throws Exception;
}





