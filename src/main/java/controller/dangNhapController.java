package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import khachHangModal.*;


/**
 * Servlet implementation class dangNhapController
 */
@WebServlet("/dangNhapController")
public class dangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name = request.getParameter("txtName");
			String pass = request.getParameter("txtPass");
			String message = null;
			
			if (name != null && pass != null) {
				KhachHangBO khachHangBO = new KhachHangBO();
				KhachHang khachHang = khachHangBO.kiemTraDangNhap(name, pass) ;
				if (khachHang != null) {
					HttpSession session = request.getSession();
					session.setAttribute("login", khachHang);
					response.sendRedirect("sachController");
					return;
				} else {
					message = "Thông tin đăng nhập không đúng!";
				}
			}
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("dangNhap.jsp");
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
