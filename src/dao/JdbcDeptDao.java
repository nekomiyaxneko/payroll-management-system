package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;

import entity.Dept;
import entity.User;

public class JdbcDeptDao implements DeptDao{

	public List<Dept> findAll(int page, int pageSize) throws Exception {
		String sql = "select * from dept limit ?,?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pst.setInt(1, begin);//设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Dept> list = new ArrayList<Dept>();
		while(rs.next()){
			Dept dept = new Dept();
			dept.setId(rs.getString("id"));
			dept.setManager(rs.getString("manager"));
			dept.setName(rs.getString("name"));
			dept.setNumber(rs.getString("number"));
			dept.setRemark(rs.getString("remark"));
			dept.setTel(rs.getString("tel"));
			list.add(dept);
		}
		DbUtil.closeConnection();
		return list;
	}

	public int countTotalPage(int pageSize) throws Exception {
		String sql = "select count(*) from dept";
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

	public void save(Dept dept) throws Exception {
		String sql = "insert into dept(id,name,remark,manager,number,tel) values(?,?,?,?,?,?)";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1,id.toString());
		pst.setString(2,dept.getName());
		pst.setString(3,dept.getRemark() );
		pst.setString(4,dept.getManager());
		pst.setString(5,dept.getNumber());
		pst.setString(6,dept.getTel());
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	public Dept findById(String id) throws Exception {
		String sql = "select * from dept where id=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Dept dept = null;
		if(rs.next()){
			dept=new Dept();
			dept.setId(id);
			dept.setManager(rs.getString("manager"));
			dept.setName(rs.getString("name"));
			dept.setNumber(rs.getString("number"));
			dept.setRemark(rs.getString("remark"));
			dept.setTel(rs.getString("tel"));
		}
		DbUtil.closeConnection();
		return dept;
	}

	public void update(Dept dept) throws Exception {
		String sql = "update dept set name=?,remark=?," +
				"manager=?,number=?,tel=? where id=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		
		pst.setString(1,dept.getName());
		pst.setString(2,dept.getRemark());
		pst.setString(3,dept.getManager() );
		pst.setString(4,dept.getNumber() );
		pst.setString(5,dept.getTel());
		pst.setString(6,dept.getId() );
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public void deleteById(String id) throws Exception {
		String sql="delete from dept where id=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public List<Dept> findDept(String name, String manager) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from dept where 1=1");
		if(name!=null&&!name.equals("")){
			sql.append(" and name like'%"+name+"%'");
		}
		if(manager!=null&&!manager.equals("")){
			sql.append(" and manager like'%"+manager+"%'");
		}
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		String str=sql.toString();
		ResultSet rs=stmt.executeQuery(str);
		List<Dept> list = new ArrayList<Dept>();
		while(rs.next()){
			Dept dept = new Dept();
			dept.setId(rs.getString("id"));
			dept.setManager(rs.getString("manager"));
			dept.setName(rs.getString("name"));
			dept.setNumber(rs.getString("number"));
			dept.setRemark(rs.getString("remark"));
			dept.setTel(rs.getString("tel"));
			list.add(dept);
		}
		DbUtil.closeConnection();
		return list;
	}

	public List<Dept> showDept() throws Exception {
		String sql="select  * from dept";
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		List<Dept> list = new ArrayList<Dept>();
		while(rs.next()){
			Dept dept = new Dept();
			dept.setId(rs.getString("id"));
			dept.setManager(rs.getString("manager"));
			dept.setName(rs.getString("name"));
			dept.setNumber(rs.getString("number"));
			dept.setRemark(rs.getString("remark"));
			dept.setTel(rs.getString("tel"));
			list.add(dept);
		}
		DbUtil.closeConnection();
		return list;
	}

}



