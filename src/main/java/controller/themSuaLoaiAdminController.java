package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loaiModal.Loai;
import loaiModal.LoaiBO;

/**
 * Servlet implementation class themSuaLoaiAdminController
 */
@WebServlet("/themSuaLoaiAdminController")
public class themSuaLoaiAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themSuaLoaiAdminController() {
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
				String maLoaiSua = request.getParameter("maLoaiSua");
				String maLoai = request.getParameter("txtMaLoai");
				String tenLoai = request.getParameter("txtTenLoai");
				
				if (maLoai.trim() == "" || tenLoai.trim() == "") {
					request.setAttribute("message", "Vui lòng nhập đầy đủ thông tin");
					RequestDispatcher rd = request.getRequestDispatcher("themSuaLoaiAdmin.jsp");
					rd.forward(request, response);
				}
				
				Loai loai = new Loai(maLoai, tenLoai);
				String action = request.getParameter("btnSubmitLoai");
				LoaiBO loaiBO = new LoaiBO();
				
				System.out.println(action);
				if (action.equalsIgnoreCase("Cập nhật")) {
					System.out.println("here");
					loaiBO.sua(loai, maLoaiSua);
				} else {
					loaiBO.them(loai);					
				}
				response.sendRedirect("loaiAdminController");
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
