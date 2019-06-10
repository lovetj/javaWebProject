package Administarator_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import person.Administarator;

import Admin.dao.AdministaratorDAO;

public class Admin_servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Admin_servlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String adminname =request.getParameter("adminname").trim();
		String adminpassword =request.getParameter("adminpassword").trim();
		String checkcode = request.getParameter("checkcode").trim();
		Administarator adm = new Administarator();
		adm.setAdminName(adminname);
		adm.setAdminPass(adminpassword);
		AdministaratorDAO AD = new AdministaratorDAO();
		String info = "";
		HttpSession session = request.getSession();
		String servercheckcode = (String) session.getAttribute("checkCode");
		if(adminname=="" || adminpassword=="" || (adminname=="" && adminpassword=="")){
			info = "�û������벻��Ϊ��!";
			request.setAttribute("info", info);
			request.getRequestDispatcher("/Administarator_login_interface.jsp").forward(request, response);
		}else{
			if (!servercheckcode.equalsIgnoreCase(checkcode)) {
				info = "��֤�벻��ȷ������������!";
				request.setAttribute("info", info);
				request.getRequestDispatcher("/Administarator_login_interface.jsp").forward(request, response);
			} else{
				 if (AD.find(adm)) 
				 request.getRequestDispatcher("/MyJsp_success.jsp").forward(request, response);
				 else {
						info = "�û��������벻��ȷ!";
						request.setAttribute("info", info);
						request.getRequestDispatcher("/Administarator_login_interface.jsp").forward(request, response);
					}
			}
			}
		}
	public void init() throws ServletException {
		// Put your code here
	}

}