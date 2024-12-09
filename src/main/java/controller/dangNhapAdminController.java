package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dangNhapAdminModal.DangNhapAdminBO;
import nl.captcha.Captcha;

/**
 * Servlet implementation class dangNhapAdminController
 */
@WebServlet("/dangNhapAdminController")
public class dangNhapAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangNhapAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("txtName");
			String pass = request.getParameter("txtPass");
			String message = null;
			
			HttpSession session = request.getSession();
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			String answer = request.getParameter("answer");
			
			if (name != null && pass != null) {
				DangNhapAdminBO bo = new DangNhapAdminBO();
				String check = bo.kiemTraDangNhap(name, pass);
				if (check != null && (captcha == null || captcha.isCorrect(answer))) {
					session.setAttribute("loginAdmin", check);
					response.sendRedirect("uploadFileController");
					return;
				}
				if (session.getAttribute("loginCount") == null) {
					session.setAttribute("loginCount", 1);
				} else {
					int count = (Integer) session.getAttribute("loginCount");
					session.setAttribute("loginCount", ++count);
				}
				message = "Thông tin đăng nhập không đúng!";					
			}
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("dangNhapAdmin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
