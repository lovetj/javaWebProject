/**
 * 
 */
package Admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.dbConnect;

import person.Administarator;



/**
 * @author Administrator
 *
 */
public class AdministaratorDAO{
	protected static final String fields_insert = "user,password";
	protected static String select_sql = "select * from administarator";
	protected static String update_sql = "update administarator set password= ? where  user = ?";

	/**
	 * 
	 */
	public AdministaratorDAO() {
		// TODO Auto-generated constructor stub
	}

	/*修改数据库Administrator表信息的方法update()*/
	public void update(Administarator admin) {
		
		Connection con = null;//con为数据库连接对象
		PreparedStatement preStem = null;//preStem为数据库操作对象
		ResultSet rs = null;//rs为查询的结果集
		con = dbConnect.getdbConnection();//获得数据库的连接
		try {
			preStem = con.prepareStatement(update_sql);//为操作对象赋予操作方法
			preStem.setString(1, admin.getAdminPass());
			preStem.setString(2, admin.getAdminName());
			int count = preStem.executeUpdate();
			if(count == 0)
				System.out.println("error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbConnect.closeDB(con, preStem, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*查找数据库Administrator表的信息*/
	public boolean find(Administarator admin) {
		Connection con = null;//con为数据库连接对象
		PreparedStatement preStem = null;//preStem为数据库操作对象
		ResultSet rs = null;//rs为查询的结果集
		boolean f = false;
		con = dbConnect.getdbConnection();//获得数据库的连接	
		try {
			preStem = con.prepareStatement(select_sql);//为操作对象赋予操作方法
			rs = preStem.executeQuery();
			while(rs.next()){
				System.out.println("此管理员在表的第"+rs.getRow()+"行");
				if( admin.getAdminName().equals(rs.getString(1)) && admin.getAdminPass().equals(rs.getString(2))){
				f = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbConnect.closeDB(con, preStem, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
	}
}
