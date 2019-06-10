/**
 * 
 */
package person;

/**
 * @author Administrator
 *
 */
public class Administarator {
    private String adminName = null;//管理员账号
	private String adminPass = null;//管理员密码
	/**
	 * 
	 */
	public Administarator() {
		// TODO Auto-generated constructor stub
	}
	public Administarator(String adminName, String adminPass){
		this.adminName = adminName;
		this.adminPass = adminPass;
	}
	public String getAdminName() {
		return adminName;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

}
