package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;

import entity.Attendence;
import entity.AttendenceSet;
import entity.Dept;
import entity.Insurance;
import entity.QueryInfomation;
import entity.Salary;
import entity.SalaryStandard;
import entity.User;

public class JdbcSalaryDao implements SalaryDao{

	public List<Salary> findAll(int page, int pageSize,String year,String month) throws Exception {
		String sql = "select * from salary where syear=? and smonth=? limit ?,?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pst.setString(1, year);
		pst.setString(2, month);
		pst.setInt(3, begin);//设置抓取的起始点(从0开始)
		pst.setInt(4, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Salary> list = new ArrayList<Salary>();
		Salary salary=null;
		while(rs.next()){
			salary = new Salary();
			salary.setId(rs.getString("sid"));
			salary.setEmpId(rs.getString("sempid"));
			salary.setTrueName(rs.getString("struename"));
			salary.setYear(rs.getString("syear"));
			salary.setMonth(rs.getString("smonth"));
			salary.setBaseSalary(rs.getDouble("sbasesalary"));
			salary.setFinalSalary(rs.getDouble("sfinalsalary"));
			salary.setLateCome(rs.getDouble("slatecome"));
			salary.setEarlyLeave(rs.getDouble("searlyleave"));
			salary.setLeave(rs.getDouble("sleave"));
			salary.setOvertime(rs.getDouble("sovertime"));
			salary.setNegletwork(rs.getDouble("snegletwork"));
			salary.setOld(rs.getDouble("sold"));
			salary.setUnemployment(rs.getDouble("sunemployment"));
			salary.setInjury(rs.getDouble("sinjury"));
			salary.setBear(rs.getDouble("sbear"));
			salary.setMedical(rs.getDouble("smedical"));
			salary.setHouse(rs.getDouble("shouse"));
			list.add(salary);
		}
		DbUtil.closeConnection();
		return list;	
	}

	public int countTotalPage(int pageSize) throws Exception {
		String sql = "select count(*) from salarystandard";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();//任何情况下都返回一个结果才可以这么写
		int totalRows = rs.getInt(1);
		DbUtil.closeConnection();
		//根据totalRows和pageSize计算总页数totalPages
		if(totalRows == 0){
			return 1;//没有记录认为1页
		}else if(totalRows%pageSize == 0){
			return totalRows/pageSize;
		}else{
			return totalRows/pageSize+1;
		}
	}
	
	public int countTotalPage2(int pageSize) throws Exception {
		String sql = "select count(*) from salary";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();//任何情况下都返回一个结果才可以这么写
		int totalRows = rs.getInt(1);
		DbUtil.closeConnection();
		//根据totalRows和pageSize计算总页数totalPages
		if(totalRows == 0){
			return 1;//没有记录认为1页
		}else if(totalRows%pageSize == 0){
			return totalRows/pageSize;
		}else{
			return totalRows/pageSize+1;
		}
	}
	
	public void saveSalarys(List<Salary> salarys) throws Exception {
		/*String Sql="select b.*,c.* from user a left join salary b on a.empid=b.empid ";
		String attendenceSetSql="select * from attendenceset";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(attendenceSetSql);
		ResultSet rs=pst.executeQuery();
		AttendenceSet attendenceSet=null;
		if(rs.next()){
			attendenceSet=new AttendenceSet();
			attendenceSet.setId(rs.getString("id"));
			attendenceSet.setLateCome(rs.getDouble("latecome"));
			attendenceSet.setEarlyLeave(rs.getDouble("earlyleave"));
			attendenceSet.setAffairLeave(rs.getDouble("affairleave"));
			attendenceSet.setSickLeave(rs.getDouble("sickleave"));
		}*/
	}


	public void save(Salary salary) throws Exception {
		/*String sql = "insert into salary(id,empid,truename,year,month,basesalary,finalsalary," +
				"insurance,attendencefee) values(?,?,?,?,?,?,?,?,?)";
		
		String attendenceSql="select  * from attendence";
		String attendenceSetSql="select * from attendenceset";
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1,id.toString());
		pst.setString(2, salary.getEmpId());
		pst.setString(3, salary.getTrueName());
		pst.setString(4, salary.getYear());
		pst.setString(5, salary.getMonth());
		pst.setDouble(6, salary.getBaseSalary());
		pst.setDouble(7, salary.getFinalSalary());
		pst.setDouble(8, salary.getInsurance());
		pst.setDouble(9, salary.getAttendenceFee());
		pst.executeUpdate();
		DbUtil.closeConnection();
		*/
	}
	
	

	public Salary findById(String id) throws Exception {
		String sql = "select * from salary where sid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Salary salary = null;
		if(rs.next()){
			salary=new Salary();
			salary.setId(rs.getString("sid"));
			salary.setEmpId(rs.getString("sempid"));
			salary.setTrueName(rs.getString("struename"));
			salary.setYear(rs.getString("syear"));
			salary.setMonth(rs.getString("smonth"));
			salary.setBaseSalary(rs.getDouble("sbasesalary"));
			salary.setFinalSalary(rs.getDouble("sfinalsalary"));
			salary.setLateCome(rs.getDouble("slatecome"));
			salary.setEarlyLeave(rs.getDouble("searlyleave"));
			salary.setLeave(rs.getDouble("sleave"));
			salary.setOvertime(rs.getDouble("sovertime"));
			salary.setNegletwork(rs.getDouble("snegletwork"));
			salary.setOld(rs.getDouble("sold"));
			salary.setUnemployment(rs.getDouble("sunemployment"));
			salary.setInjury(rs.getDouble("sinjury"));
			salary.setBear(rs.getDouble("sbear"));
			salary.setMedical(rs.getDouble("smedical"));
			salary.setHouse(rs.getDouble("shouse"));
		
		}
		DbUtil.closeConnection();
		return salary;
		
	}

	public void update(Salary salary) throws Exception {
	/*	String sql = "update salary set sempid=?,struename=?," +
				"syear=?,smonth=?,sbasesalary=?,sfinalsalary=?,sinsurance=?,sattendencefee=?  where sid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1,id.toString());
		pst.setString(2, salary.getEmpId());
		pst.setString(3, salary.getTrueName());
		pst.setString(4, salary.getYear());
		pst.setString(5, salary.getMonth());
		pst.setDouble(6, salary.getBaseSalary());
		pst.setDouble(7, salary.getFinalSalary());
		pst.setDouble(8, salary.getInsurance());
		pst.setDouble(9, salary.getAttendenceFee());
		pst.executeUpdate();
		DbUtil.closeConnection();*/
		
	}

	public void deleteById(String id) throws Exception {
	/*	String sql="delete from salary where id=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();*/
	}

	

	public List<Salary> showSalary() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Salary> saveSalarysByMonth(int page, int pageSize,String year,String month) throws Exception {
		//查询所有员工的考勤信息、工资标准、考勤奖罚信息
				String sql = "select   a.*,b.* from salarystandard   a join attendence b " +
						"on a.dempid=b.aempid where b.ayear=? and b.amonth=?";
				Connection conn = DbUtil.getConnection();
				DbUtil.startTransaction();
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, year);
				pst.setString(2, month);
				ResultSet rs=pst.executeQuery();
				List<QueryInfomation> infos = new ArrayList<QueryInfomation>();
				QueryInfomation info=null;
				while(rs.next()){
					info=new QueryInfomation();
					info.setEmpId(rs.getString("aempid"));
					info.setTrueName(rs.getString("atruename"));
					info.setYear(rs.getString("ayear"));
					info.setMonth(rs.getString("amonth"));
					info.setBaseSalary(rs.getDouble("dbasesalary"));
					info.setLateCome(rs.getInt("alatecome"));
					info.setEarlyLeave(rs.getInt("aearlyleave"));
					info.setLeave(rs.getInt("aleave"));
					info.setOvertime(rs.getInt("aovertime"));
					info.setNegletwork(rs.getInt("anegletwork"));
					info.setUid(rs.getString("uid"));
					infos.add(info);
				}
				
				String sql2 = "select * from attendenceset";
				PreparedStatement pst2=conn.prepareStatement(sql2);
				ResultSet rs2=pst2.executeQuery();
				AttendenceSet attendenceSet=null;
				if(rs2.next()){
					attendenceSet=new AttendenceSet();
					attendenceSet.setEarlyLeave(rs2.getDouble("cearlyleave"));
					attendenceSet.setLateCome(rs2.getDouble("clatecome"));
					attendenceSet.setLeave(rs2.getDouble("cleave"));
					attendenceSet.setNegletwork(rs2.getDouble("cnegletwork"));
					attendenceSet.setOvertime(rs2.getDouble("covertime"));
				}
				String sqlDel="delete from salary where syear=? and smonth=? ";
				PreparedStatement pstDel=conn.prepareStatement(sqlDel);
				pstDel.setString(1, year);
				pstDel.setString(2, month);
				pstDel.executeUpdate();
				
				String sqlIn="select  * from insurance";
				conn = DbUtil.getConnection();
				Statement stmt=conn.createStatement();
				ResultSet rsIn=stmt.executeQuery(sqlIn);
				Insurance insurance=null;
				if(rsIn.next()){
					insurance=new Insurance();
					insurance.setId(rsIn.getString("id"));
					insurance.setBear(rsIn.getInt("bear"));
					insurance.setHouse(rsIn.getInt("house"));
					insurance.setInjury(rsIn.getInt("injury"));
					insurance.setMedical(rsIn.getInt("medical"));
					insurance.setOld(rsIn.getInt("old"));
					insurance.setUnemployment(rsIn.getInt("unemployment"));
				}
				
				
				
				//插入当月的考勤信息
				String sql3="insert into salary(sid,sempid,struename,syear,smonth,sbasesalary,sfinalsalary,slatecome," +
						"searlyleave,sleave,sovertime,snegletwork,sold,sunemployment,sinjury,sbear,smedical,shouse,uid) " +
						"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst3=conn.prepareStatement(sql3);
				for(int i=0;i<infos.size();i++){
					info=infos.get(i);
					
					double finalSalary=info.getBaseSalary()-info.getLateCome()*attendenceSet.getLateCome()
							-info.getEarlyLeave()*attendenceSet.getEarlyLeave()
							-info.getLeave()*attendenceSet.getLeave()
							+info.getOvertime()*attendenceSet.getOvertime()
							-info.getNegletwork()*attendenceSet.getNegletwork();
					
					double finalSal=info.getBaseSalary()-finalSalary*insurance.getOld()/100-finalSalary*insurance.getUnemployment()/100
														-finalSalary*insurance.getInjury()/100-finalSalary*insurance.getBear()/100
														-finalSalary*insurance.getMedical()/100-finalSalary*insurance.getHouse()/100;
					
					int s=(int) (finalSal);
					UUID id=UUID.randomUUID();
					pst3.setString(1, id.toString());
					pst3.setString(2, info.getEmpId());
					pst3.setString(3, info.getTrueName());
					pst3.setString(4, info.getYear());
					pst3.setString(5, info.getMonth());
					pst3.setDouble(6, info.getBaseSalary());
					pst3.setDouble(7, s);
					pst3.setDouble(8, info.getLateCome()*attendenceSet.getLateCome());
					pst3.setDouble(9, info.getEarlyLeave()*attendenceSet.getEarlyLeave());
					pst3.setDouble(10, info.getLeave()*attendenceSet.getLeave());
					pst3.setDouble(11, info.getOvertime()*attendenceSet.getOvertime());
					pst3.setDouble(12, info.getNegletwork()*attendenceSet.getNegletwork());
					pst3.setDouble(13, finalSalary*insurance.getOld()/100);
					pst3.setDouble(14, finalSalary*insurance.getUnemployment()/100);
					pst3.setDouble(15, finalSalary*insurance.getInjury()/100);
					pst3.setDouble(16, finalSalary*insurance.getBear()/100);
					pst3.setDouble(17, finalSalary*insurance.getMedical()/100);
					pst3.setDouble(18, finalSalary*insurance.getHouse()/100);
					pst3.setString(19, info.getUid());
					pst3.executeUpdate();
				}
				
				DbUtil.commit();
				DbUtil.closeConnection();
				
				
				conn = DbUtil.getConnection();
				
				//查询工资信息
				String sqlSalary="select * from salary where syear=? and smonth=? limit ?,?";
				PreparedStatement pstSalary=conn.prepareStatement(sqlSalary);
				pstSalary.setString(1, year);
				pstSalary.setString(2, month);
				//设置分页查询参数
				int begin = (page-1)*pageSize;
				pstSalary.setInt(3, begin);//设置抓取的起始点(从0开始)
				pstSalary.setInt(4, pageSize);//设置最多抓取记录数
				ResultSet rsSalary=pstSalary.executeQuery();
				List<Salary> salarys=new ArrayList<Salary>();
				Salary salary=null;
				while(rsSalary.next()){
					salary=new Salary();
					salary.setId(rsSalary.getString("sid"));
					salary.setEmpId(rsSalary.getString("sempid"));
					salary.setTrueName(rsSalary.getString("struename"));
					salary.setYear(rsSalary.getString("syear"));
					salary.setMonth(rsSalary.getString("smonth"));
					salary.setBaseSalary(rsSalary.getDouble("sbasesalary"));
					salary.setFinalSalary(rsSalary.getDouble("sfinalsalary"));
					salary.setLateCome(rsSalary.getDouble("slatecome"));
					salary.setEarlyLeave(rsSalary.getDouble("searlyleave"));
					salary.setLeave(rsSalary.getDouble("sleave"));
					salary.setOvertime(rsSalary.getDouble("sovertime"));
					salary.setNegletwork(rsSalary.getDouble("snegletwork"));
					salary.setOld(rsSalary.getDouble("sold"));
					salary.setUnemployment(rsSalary.getDouble("sunemployment"));
					salary.setInjury(rsSalary.getDouble("sinjury"));
					salary.setBear(rsSalary.getDouble("sbear"));
					salary.setMedical(rsSalary.getDouble("smedical"));
					salary.setHouse(rsSalary.getDouble("shouse"));
					salarys.add(salary);
				}
				DbUtil.closeConnection();
				return salarys;
	}

	public List<SalaryStandard> findStand(SalaryStandard salaryStand) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from salarystandard where 1=1");
		if(salaryStand.getEmpId()!=null&&!salaryStand.getEmpId().equals("")){
			sql.append(" and dempid like'%"+salaryStand.getEmpId()+"%'");
		}
		if(salaryStand.getTrueName()!=null&&!salaryStand.getTrueName().equals("")){
			sql.append(" and dtruename like'%"+salaryStand.getTrueName()+"%'");
		}
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		String str=sql.toString();
		ResultSet rs=stmt.executeQuery(str);
		List<SalaryStandard> list = new ArrayList<SalaryStandard>();
		SalaryStandard salaryStandard=null;
		while(rs.next()){
			salaryStandard=new SalaryStandard();
			salaryStandard.setBaseSalary(rs.getDouble("dbasesalary"));	
			salaryStandard.setEmpId(rs.getString("dempid"));
			salaryStandard.setId(rs.getString("did"));
			salaryStandard.setTrueName(rs.getString("dtruename"));
			list.add(salaryStandard);
		}
		DbUtil.closeConnection();
		return list;
	}

	public SalaryStandard loadStand(String id) throws Exception {
		String sql = "select * from salarystandard where did=?";
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs=pst.executeQuery();
		SalaryStandard salaryStandard=null;
		if(rs.next()){
			salaryStandard=new SalaryStandard();
			salaryStandard.setBaseSalary(rs.getDouble("dbasesalary"));	
			salaryStandard.setEmpId(rs.getString("dempid"));
			salaryStandard.setId(rs.getString("did"));
			salaryStandard.setTrueName(rs.getString("dtruename"));
		}
		return salaryStandard;
	}

	public void updateStand(SalaryStandard salaryStandard) throws Exception {
		String sql = "update salarystandard set dbasesalary=?," +
				    "dempid=? ,dtruename=? where did=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setDouble(1,salaryStandard.getBaseSalary() );
		pst.setString(2, salaryStandard.getEmpId());
		pst.setString(3, salaryStandard.getTrueName());
		pst.setString(4, salaryStandard.getId());
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	public List<Salary> findSalary(Salary salary) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from salary where 1=1");
		if(salary.getEmpId()!=null&&!salary.getEmpId().equals("")){
			sql.append(" and sempid like'%"+salary.getEmpId()+"%'");
		}
		if(salary.getTrueName()!=null&&!salary.getTrueName().equals("")){
			sql.append(" and struename like'%"+salary.getTrueName()+"%'");
		}
		sql.append(" and syear like'%"+salary.getYear()+"%'");
		sql.append(" and smonth like'%"+salary.getMonth()+"%'");
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		String str=sql.toString();
		ResultSet rs=stmt.executeQuery(str);
		Salary s = null;
		List<Salary> salarys=new ArrayList<Salary>();
		while(rs.next()){
			s=new Salary();
			s.setId(rs.getString("sid"));
			s.setEmpId(rs.getString("sempid"));
			s.setTrueName(rs.getString("struename"));
			s.setYear(rs.getString("syear"));
			s.setMonth(rs.getString("smonth"));
			s.setBaseSalary(rs.getDouble("sbasesalary"));
			s.setFinalSalary(rs.getDouble("sfinalsalary"));
			s.setLateCome(rs.getDouble("slatecome"));
			s.setEarlyLeave(rs.getDouble("searlyleave"));
			s.setLeave(rs.getDouble("sleave"));
			s.setOvertime(rs.getDouble("sovertime"));
			s.setNegletwork(rs.getDouble("snegletwork"));
			s.setOld(rs.getDouble("sold"));
			s.setUnemployment(rs.getDouble("sunemployment"));
			s.setInjury(rs.getDouble("sinjury"));
			s.setBear(rs.getDouble("sbear"));
			s.setMedical(rs.getDouble("smedical"));
			s.setHouse(rs.getDouble("shouse"));
			salarys.add(s);
		}
		return salarys;
	}

	public List<SalaryStandard> findStandAll(int page, int pageSize)
			throws Exception {
		String sql = "select * from salarystandard limit ?,?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pst.setInt(1, begin);//设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<SalaryStandard> list = new ArrayList<SalaryStandard>();
		SalaryStandard salaryStandard=null;
		while(rs.next()){
			salaryStandard=new SalaryStandard();
			salaryStandard.setBaseSalary(rs.getDouble("dbasesalary"));	
			salaryStandard.setEmpId(rs.getString("dempid"));
			salaryStandard.setId(rs.getString("did"));
			salaryStandard.setTrueName(rs.getString("dtruename"));
			list.add(salaryStandard);
		}
		DbUtil.closeConnection();
		return list;
	}

	public Insurance findInsurance() throws Exception {
		String sql="select  * from insurance";
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		Insurance insurance=null;
		if(rs.next()){
			insurance=new Insurance();
			insurance.setId(rs.getString("id"));
			insurance.setBear(rs.getInt("bear"));
			insurance.setHouse(rs.getInt("house"));
			insurance.setInjury(rs.getInt("injury"));
			insurance.setMedical(rs.getInt("medical"));
			insurance.setOld(rs.getInt("old"));
			insurance.setUnemployment(rs.getInt("unemployment"));
		}
		return insurance;
	}

	public void updateInsurance(Insurance insurance) throws Exception {
		String sql="update insurance set bear=?,house=?, " +
				"injury=?,medical=?,old=?,unemployment=? where id=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, insurance.getBear());
		pst.setInt(2, insurance.getHouse());
		pst.setInt(3, insurance.getInjury());
		pst.setInt(4, insurance.getMedical());
		pst.setInt(5, insurance.getOld());
		pst.setInt(6, insurance.getUnemployment());
		pst.setString(7, insurance.getId());
		pst.executeUpdate();
		
	}

	
}



