package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loaiModal.LoaiBO;

/**
 * Servlet implementation class quanLyLoaiAdminController
 */
@WebServlet("/quanLyLoaiAdminController")
public class quanLyLoaiAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanLyLoaiAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
			if (session.getAttribute("loginAdmin") != null) {
				String maLoai = request.getParameter("maLoai");
				String action = request.getParameter("submitLoai");
				LoaiBO loaiBO = new LoaiBO();
				
				if (action == null) {
					RequestDispatcher rd = request.getRequestDispatcher("themSuaLoaiAdmin.jsp");
					rd.forward(request, response);
				}
				
				if (action.equalsIgnoreCase("Sửa")) {
					request.setAttribute("loaiSua", loaiBO.getThongTinLoai(maLoai));
					RequestDispatcher rd = request.getRequestDispatcher("themSuaLoaiAdmin.jsp");
					rd.forward(request, response);
				}
				
				if (action.equalsIgnoreCase("Xóa")) {
					loaiBO.xoa(maLoai);
					response.sendRedirect("loaiAdminController");
				}
			}
				
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
