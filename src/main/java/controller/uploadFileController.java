package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class uploadFileController
 */
@WebServlet("/uploadFileController")
public class uploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadFileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginAdmin") != null) {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1= request.getServletContext().getRealPath("") +  File.separator + "abc";
			response.getWriter().println(dirUrl1);
			
			if(request.getContentLength()<=0) {//Chay lan dau chua co du lieu
				RequestDispatcher rd=request.getRequestDispatcher("uploadFile.jsp");
				rd.forward(request, response);
			}else {
				try {
					//Lấy về các đối tượng gửi lên
					List<FileItem> fileItems = upload.parseRequest(request);
					//duyệt qua các đối tượng gửi lên từ client gồm file và các control
					for (FileItem fileItem : fileItems) {
						//Nếu ko phải các control=>upfile lên
						if (!fileItem.isFormField()) {
						// xử lý file
							String nameimg = fileItem.getName();
							if (!nameimg.equals("")) {
						           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
								String dirUrl = request.getServletContext().getRealPath("") +  File.separator + session.getAttribute("loginAdmin");
								File dir = new File(dirUrl);
								if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
									dir.mkdir();
								}
							    String fileImg = dirUrl + File.separator + nameimg;
							    File file = new File(fileImg);//tạo file
							    try {
							    	fileItem.write(file);//lưu file
							    	System.out.println("UPLOAD THÀNH CÔNG...!");
							        System.out.println("Đường dẫn lưu file là: "+dirUrl);
							    } catch (Exception e) {
							    	e.printStackTrace();
							    }
							}
						//Neu la control
						} else{
							String tentk=fileItem.getFieldName();
							if(tentk.equals("txtHoTen"))
								response.getWriter().println(fileItem.getString());
							//response.getWriter().println(fileItem.getString("UTF-8"));//Hiển thị tiếng Việt
							if(tentk.equals("txtDiaChi"))
								response.getWriter().println(fileItem.getString());
						}
					}
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			}
		} else {
			response.sendRedirect("dangNhapAdminController");
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
