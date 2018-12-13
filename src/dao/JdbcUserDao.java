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

public class JdbcUserDao implements UserDao{

	public User findByUsername(String username) throws Exception {
		Connection conn=DbUtil.getConnection();
		User user=null;
		Statement stat=conn.createStatement();
		String sql="select * from user where username='"+username+"'";
		ResultSet rs=stat.executeQuery(sql);
		if(rs.next()){
			String id=rs.getString("uid");
			String password = rs.getString("password");
			user = new User();
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
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

	public void save(User user) throws Exception {
		Connection conn=DbUtil.getConnection();
		String sql="insert into user(uid,username,password,utruename,uempId) values(?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1, id.toString());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getTrueName());
		pst.setString(5, user.getEmpId());
		pst.executeUpdate();
	
		DbUtil.closeConnection();
	}

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
			User user = new User();
			user.setId(rs.getString("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmpId(rs.getString("uempid"));
			user.setTrueName(rs.getString("utruename"));
			list.add(user);
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
			user.setEmpId(rs.getString("uempid"));
		}
		DbUtil.closeConnection();
		return user;
	}

	public void update(User user) throws Exception {
		String sql="update user set username=?,password=?," +
				"utruename=?,uempid=? where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getPassword());
		pst.setString(3, user.getTrueName());
		pst.setString(4, user.getEmpId());
		pst.setString(5, user.getId());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public void deleteById(String id) throws Exception {
		String sql="delete from user where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	
}





