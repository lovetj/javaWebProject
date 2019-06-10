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

	/*�޸����ݿ�Administrator����Ϣ�ķ���update()*/
	public void update(Administarator admin) {
		
		Connection con = null;//conΪ���ݿ����Ӷ���
		PreparedStatement preStem = null;//preStemΪ���ݿ��������
		ResultSet rs = null;//rsΪ��ѯ�Ľ����
		con = dbConnect.getdbConnection();//������ݿ������
		try {
			preStem = con.prepareStatement(update_sql);//Ϊ�����������������
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
	
	/*�������ݿ�Administrator������Ϣ*/
	public boolean find(Administarator admin) {
		Connection con = null;//conΪ���ݿ����Ӷ���
		PreparedStatement preStem = null;//preStemΪ���ݿ��������
		ResultSet rs = null;//rsΪ��ѯ�Ľ����
		boolean f = false;
		con = dbConnect.getdbConnection();//������ݿ������	
		try {
			preStem = con.prepareStatement(select_sql);//Ϊ�����������������
			rs = preStem.executeQuery();
			while(rs.next()){
				System.out.println("�˹���Ա�ڱ��ĵ�"+rs.getRow()+"��");
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