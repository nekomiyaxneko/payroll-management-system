package util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
//数据库连接类
public class DbUtil {
	private static DataSource ds;
	private static ThreadLocal <Connection>connLocal=
		new ThreadLocal<Connection>();
	static {
		try {
			Properties prop = new Properties();
			InputStream is = DbUtil.class.getClassLoader().getResourceAsStream(
					"db.properties");
			prop.load(is);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
		Connection conn=connLocal.get();
		if(conn==null||conn.isClosed()){
			conn=ds.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}
	
	public static void closeConnection() throws Exception{
		Connection conn=connLocal.get();
		connLocal.set(null);
		if(conn!=null){
			conn.close();
		}
	}
	
	public static void startTransaction() throws Exception{
		Connection conn=getConnection();
		conn.setAutoCommit(false);
	}
	
	public static void commit(){
		try {
			Connection conn=getConnection();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void rollback(){
		try {
			Connection conn=getConnection();
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		try {
			System.out.println(getConnection());
			System.out.println(getConnection().hashCode());
			System.out.println(getConnection().hashCode());
			System.out.println(getConnection().hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





