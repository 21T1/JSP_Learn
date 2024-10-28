package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tam.GioHangBO;

/**
 * Servlet implementation class hienThiGioHangController
 */
@WebServlet("/gioHangController")
public class gioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSach = request.getParameter("maSach");
		String tenSach = request.getParameter("tenSach");
		String gia = request.getParameter("gia");
		
		if (maSach != null && tenSach != null && gia != null) {
			GioHangBO gio = new GioHangBO();
			HttpSession session = request.getSession();
			
			if (session.getAttribute("gioHang") == null) {
				session.setAttribute("gioHang", gio);
			}
			
			gio = (GioHangBO) session.getAttribute("gioHang");
			gio.them(maSach, tenSach, Long.parseLong(gia), (long) 1);
			
			session.setAttribute("gioHang", gio);
			response.sendRedirect("hienThiGioHangController");
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
