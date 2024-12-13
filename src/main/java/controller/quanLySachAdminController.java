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
import sachModal.SachBO;

/**
 * Servlet implementation class suaXoaSachController
 */
@WebServlet("/quanLySachAdminController")
public class quanLySachAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanLySachAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
			if (session.getAttribute("loginAdmin") != null) {
				LoaiBO loaiBO = new LoaiBO();
				request.setAttribute("dsLoai", loaiBO.getLoai());
				
				String maSach = request.getParameter("maSach");
				String action = request.getParameter("submit");
				
				SachBO sachBO = new SachBO();
				
				if (action == null) {
					RequestDispatcher rd = request.getRequestDispatcher("themSuaSachAdmin.jsp");
					rd.forward(request, response);
				}
				
				if (action.equalsIgnoreCase("Sửa")) {
					request.setAttribute("sachSua", sachBO.getThongTinSach(maSach));
					RequestDispatcher rd = request.getRequestDispatcher("themSuaSachAdmin.jsp");
					rd.forward(request, response);
				}
				
				if (action.equalsIgnoreCase("Xóa")) {
					sachBO.xoa(maSach);
					response.sendRedirect("sachAdminController");
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
