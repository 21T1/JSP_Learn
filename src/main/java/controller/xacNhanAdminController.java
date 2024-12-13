package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hoaDonModal.HoaDon;
import hoaDonModal.HoaDonBO;
import khachHangModal.KhachHang;
import lichSuModal.LichSuBO;

/**
 * Servlet implementation class xacNhanAdminController
 */
@WebServlet("/xacNhanAdminController")
public class xacNhanAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacNhanAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("loginAdmin") != null) {
				HoaDonBO hoaDonBO = new HoaDonBO();
				request.setAttribute("dsChuaThanhToan", hoaDonBO.getChuaThanhToan());
				RequestDispatcher rd = request.getRequestDispatcher("xacNhan.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("dangNhapAdminController");
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi xacNhanAdminController");
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
