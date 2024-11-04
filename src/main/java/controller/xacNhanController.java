package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ChiTietHoaDonModal.ChiTietBO;
import hoaDonModal.HoaDonBO;
import khachHangModal.KhachHang;
import tam.GioHangBO;
import tam.Hang;

/**
 * Servlet implementation class xacNhanController
 */
@WebServlet("/xacNhanController")
public class xacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacNhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			KhachHang khachHang = (KhachHang) session.getAttribute("login");
			GioHangBO gioHangBO = (GioHangBO) session.getAttribute("gioHang");
			if (gioHangBO != null) {
				HoaDonBO hoaDonBO = new HoaDonBO();
				Date ngayMua = new Date();
				hoaDonBO.them(khachHang.getMaKH(), ngayMua);
				
				long maHoaDon = hoaDonBO.maxHoaDon();
				ChiTietBO chiTietBO = new ChiTietBO();
				for (Hang hang : gioHangBO.ds) {
					chiTietBO.them(hang.getMaSach(), hang.getSoLuong(),  maHoaDon);
				}
				
				session.removeAttribute("gioHang");
				response.sendRedirect("lichSuController");
			}
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
