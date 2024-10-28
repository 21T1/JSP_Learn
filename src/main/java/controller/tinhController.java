package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class tinhController
 */
@WebServlet("/tinhController")
public class tinhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tinhController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tA = request.getParameter("txtA");
		String tB = request.getParameter("txtB");
		
		if (tA != null && tB != null) {
			int a = Integer.parseInt(tA);
			int b = Integer.parseInt(tB);
			int kq = 0;
			
			String cal = request.getParameter("submit");
			switch(cal){
				case "+": kq = a + b; break; 
				case "-": kq = a - b; break; 
				case "x": kq = a * b; break; 
				case "/": 
					if (b != 0){
						kq = a / b; break; 
					}
				default: kq = 0;
			}
			request.setAttribute("a", tA);
			request.setAttribute("b", tB);
			request.setAttribute("result", String.valueOf(kq));
		}
		RequestDispatcher rd = request.getRequestDispatcher("mt.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
