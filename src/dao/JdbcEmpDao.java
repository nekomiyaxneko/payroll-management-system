package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;

import entity.User;

public class JdbcEmpDao implements EmpDao{

	public List<User> findAll(int page, int pageSize) throws Exception {
		String sql = "select * from user limit ?,?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pst.setInt(1, begin);//设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User emp = new User();
			emp.setId(rs.getString("uid"));
			emp.setEmpId(rs.getString("uempid"));
			emp.setTrueName(rs.getString("utruename"));
			emp.setAge(rs.getString("age"));
			emp.setSex(rs.getString("sex"));
			emp.setDeptName(rs.getString("deptName"));
			emp.setStartDate(rs.getString("startdate"));
			list.add(emp);
		}
		DbUtil.closeConnection();
		return list;
	}

	
	public int countTotalPage(int pageSize) throws Exception {
		String sql = "select count(*) from user";
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

	public void save(User emp) throws Exception {
		Connection conn=DbUtil.getConnection();
		DbUtil.startTransaction();
		String sql="insert into user(uid,uempid,utruename,age,sex,birthday,idnum," +
				"marry,polity,city,telnum,address,school,degree,startdate,deptname,remark) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1, id.toString());
		pst.setString(2, emp.getEmpId());
		pst.setString(3, emp.getTrueName());
		pst.setString(4, emp.getAge());
		pst.setString(5, emp.getSex());
		pst.setString(6, emp.getBirthday());
		pst.setString(7, emp.getIdNum());
		pst.setString(8, emp.getMarry());
		pst.setString(9, emp.getPolity());
		pst.setString(10, emp.getCity());
		pst.setString(11, emp.getTelNum());
		pst.setString(12, emp.getAddress());
		pst.setString(13, emp.getSchool());
		pst.setString(14, emp.getDegree());
		pst.setString(15, emp.getStartDate());
		pst.setString(16, emp.getDeptName());    //
		pst.setString(17, emp.getRemark());
		
		pst.executeUpdate();
		
		
		String sql2="insert into salarystandard(uid,did,dempid,dtruename) values(?,?,?,?)";
		PreparedStatement pst2=conn.prepareStatement(sql2);
		pst2.setString(1, id.toString());
		id=UUID.randomUUID();
		pst2.setString(2, id.toString());
		pst2.setString(3, emp.getEmpId());
		pst2.setString(4, emp.getTrueName());
		pst2.executeUpdate();
		
		
		DbUtil.commit();
		DbUtil.closeConnection();
		
	}

	
	public User findById(String id) throws Exception {
		String sql = "select * from user where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		User user = null;
		if(rs.next()){
			user=new User();
			user.setId(id);
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setTrueName(rs.getString("utruename"));
			user.setAddress(rs.getString("address"));
			user.setAge(rs.getString("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getString("city"));
			user.setDegree(rs.getString("degree"));
			user.setDeptName(rs.getString("deptname"));
			user.setEmpId(rs.getString("uempid"));
			user.setIdNum(rs.getString("idnum"));
			user.setMarry(rs.getString("marry"));
			user.setPolity(rs.getString("polity"));
			user.setRemark(rs.getString("remark"));
			user.setSex(rs.getString("sex"));
			user.setSchool(rs.getString("school"));
			user.setStartDate(rs.getString("startdate"));
			user.setTelNum(rs.getString("telnum"));
			user.setTrueName(rs.getString("utruename"));
		}
		DbUtil.closeConnection();
		return user;
	}

	public void update(User emp) throws Exception {
		String sql="update user set uempid=?,utruename=?,age=?,sex=?,birthday=?,"+
				"idnum=?,marry=?,polity=?,city=?,telnum=?,address=?,school=?," +
				"degree=?,startdate=?,deptname=?,remark=? where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setString(1, emp.getEmpId());
		pst.setString(2, emp.getTrueName());
		pst.setString(3, emp.getAge());
		pst.setString(4, emp.getSex());
		pst.setString(5, emp.getBirthday());
		pst.setString(6, emp.getIdNum());
		pst.setString(7, emp.getMarry());
		pst.setString(8, emp.getPolity());
		pst.setString(9, emp.getCity());
		pst.setString(10, emp.getTelNum());
		pst.setString(11, emp.getAddress());
		pst.setString(12, emp.getSchool());
		pst.setString(13, emp.getDegree());
		pst.setString(14, emp.getStartDate());
		pst.setString(15, emp.getDeptName());
		pst.setString(16, emp.getRemark());
		pst.setString(17, emp.getId());
		pst.executeUpdate();
		String sql1="update salary set sempid=?,struename=? where uid=?";
		String sql2="update salarystandard set dempid=?,dtruename=? where uid=?";
		String sql3="update attendence set aempid=?,atruename=? where uid=?";
		PreparedStatement pst1=conn.prepareStatement(sql1);
		pst1.setString(1, emp.getEmpId());
		pst1.setString(2, emp.getTrueName());
		pst1.setString(3, emp.getId());
		pst1.executeUpdate();
		
		PreparedStatement pst2=conn.prepareStatement(sql2);
		pst2.setString(1, emp.getEmpId());
		pst2.setString(2, emp.getTrueName());
		pst2.setString(3, emp.getId());
		pst2.executeUpdate();
		
		PreparedStatement pst3=conn.prepareStatement(sql3);
		pst3.setString(1, emp.getEmpId());
		pst3.setString(2, emp.getTrueName());
		pst3.setString(3, emp.getId());
		pst3.executeUpdate();
		DbUtil.closeConnection();
	}

	public void deleteById(String id) throws Exception {
		Connection conn=DbUtil.getConnection();
		String sql="delete from user where uid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		
		String sql1="delete from salary where uid=?";
		PreparedStatement pst1=conn.prepareStatement(sql1);
		pst1.setString(1, id);
		pst1.executeUpdate();
		
		String sql2="delete from salarystandard where uid=?";
		PreparedStatement pst2=conn.prepareStatement(sql2);
		pst2.setString(1, id);
		pst2.executeUpdate();
		
		String sql3="delete from attendence where uid=?";
		PreparedStatement pst3=conn.prepareStatement(sql3);
		pst3.setString(1, id);
		pst3.executeUpdate();
		DbUtil.closeConnection();
		
	}


	public List<User> findEmp(User emp) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from user where 1=1");
		if(emp.getEmpId()!=null&&!emp.getEmpId().equals("")){
			sql.append(" and uempid like'%"+emp.getEmpId()+"%'");
		}
		if(emp.getTrueName()!=null&&!emp.getTrueName().equals("")){
			sql.append(" and utruename like'%"+emp.getTrueName()+"%'");
		}
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		String str=sql.toString();
		ResultSet rs=stmt.executeQuery(str);
		User user = null;
		List<User> emps=new ArrayList<User>();
		while(rs.next()){
			user=new User();
			user.setId(rs.getString("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setTrueName(rs.getString("utruename"));
			user.setAddress(rs.getString("address"));
			user.setAge(rs.getString("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getString("city"));
			user.setDegree(rs.getString("degree"));
			user.setDeptName(rs.getString("deptname"));
			user.setEmpId(rs.getString("uempid"));
			user.setIdNum(rs.getString("idnum"));
			user.setMarry(rs.getString("marry"));
			user.setPolity(rs.getString("polity"));
			user.setRemark(rs.getString("remark"));
			user.setSex(rs.getString("sex"));
			user.setSchool(rs.getString("school"));
			user.setStartDate(rs.getString("startdate"));
			user.setTelNum(rs.getString("telnum"));
			user.setTrueName(rs.getString("utruename"));
			emps.add(user);
		}
		DbUtil.closeConnection();
		return emps;
	}

	

}
