package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loaiModal.LoaiBO;
import sachModal.Sach;
import sachModal.SachBO;

/**
 * Servlet implementation class sachController
 */
@WebServlet("/sachController")
public class sachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sachController() {
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
			
			LoaiBO loaiBO = new LoaiBO();
			request.setAttribute("dsLoai", loaiBO.getLoai());
			
			SachBO sachBO = new SachBO();
			String maLoai = request.getParameter("maLoai");		
			String key = request.getParameter("txtTimKiem");
			
			request.setAttribute("countSach", sachBO.countSach());
			request.setAttribute("countP", sachBO.countP());
			
			String strp = request.getParameter("p");
			int p = 1;
			if (strp != null) {
				p = Integer.parseInt(strp);
			}
			
			ArrayList<Sach> dsSach = sachBO.getSach(p);
			if (maLoai != null) {
				System.out.println(maLoai);
				dsSach = sachBO.timMa(maLoai);
				for (int i = 0; i < dsSach.size(); i++) {
					System.out.println(dsSach.get(i).getMaLoai() + '\n');
				}
			}
			if (key != null) {
				dsSach = sachBO.tim(key);
			}
			
			request.setAttribute("dsSach", dsSach);//chuyen sang tc.jsp
			RequestDispatcher rd = request.getRequestDispatcher("tc.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("Lỗi kết nối");
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
