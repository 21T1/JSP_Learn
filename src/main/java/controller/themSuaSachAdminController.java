package controller;

import java.io.Console;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import loaiModal.LoaiBO;
import sachModal.Sach;
import sachModal.SachBO;

/**
 * Servlet implementation class themSachAdminController
 */
@WebServlet("/themSuaSachAdminController")
public class themSuaSachAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themSuaSachAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			String maSachSua = request.getParameter("maSachSua");
			String action = null;

			HttpSession session = request.getSession();
			if (session.getAttribute("loginAdmin") != null) {
				LoaiBO loaiBO = new LoaiBO();
				request.setAttribute("dsLoai", loaiBO.getLoai());

				DiskFileItemFactory factory = new DiskFileItemFactory();
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				String dirUrl1 = request.getServletContext().getRealPath("") + File.separator
						+ session.getAttribute("loginAdmin");

				// Lấy về các đối tượng gửi lên
				List<FileItem> fileItems = upload.parseRequest(request);
				// duyệt qua các đối tượng gửi lên từ client gồm file và các control
				String maSach = null;
				String tenSach = null;
				String tacGia = null;
				long soLuong = (long) -1;
				long gia = (long) -1;
				String anh = null;
				String maLoai = null;

				for (FileItem fileItem : fileItems) {
					// Nếu ko phải các control=>upfile lên
					if (!fileItem.isFormField()) {
						// xử lý file
						String nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = request.getServletContext().getRealPath("") + File.separator + "image_sach";
							File dir = new File(dirUrl);
							if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);// tạo file
							try {
								fileItem.write(file);// lưu file
								anh = "image_sach" + '\\' + nameimg;
								System.out.println(anh);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						// Neu la control
					} else {

						String fieldName = fileItem.getFieldName();
						if (fieldName.equals("txtMaSach")) {
							maSach = fileItem.getString("UTF-8");
						}
						if (fieldName.equals("txtTenSach")) {
							tenSach = fileItem.getString("UTF-8");
						}
						if (fieldName.equals("txtSl")) {
							soLuong = Long.parseLong(fileItem.getString());
						}
						if (fieldName.equals("txtGia")) {
							gia = Long.parseLong(fileItem.getString());
						}
						if (fieldName.equals("txtMaLoai")) {
							maLoai = fileItem.getString("UTF-8");
						}
						if (fieldName.equals("txtTacGia")) {
							tacGia = fileItem.getString("UTF-8");
						}

						if (fieldName.equals("btnSubmitSach")) {
							action = fileItem.getString("UTF-8");
						}
					}
				}

				if (maSach == null || tenSach == null || tacGia == null || maLoai == null || soLuong <= 0 || gia <= 0
						|| (action.equalsIgnoreCase("Xác nhận") && anh == null)) {
					request.setAttribute("message", "Vui lòng nhập thông tin đầy đủ và hợp lệ");
					RequestDispatcher rd = request.getRequestDispatcher("themSuaSachAdmin.jsp");
					rd.forward(request, response);
				}

				Sach sach = new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
				SachBO sachBO = new SachBO();

				System.out.println("Action: " + action);
				if (action.equalsIgnoreCase("Cập nhật")) {
					if (anh == null) {
						System.out.println("Sửa: " + maSachSua);
						sach.setAnh(sachBO.getThongTinSach(maSachSua).getAnh());
					}
					sachBO.sua(sach, maSachSua);
					response.sendRedirect("sachAdminController");
				} else {
					sachBO.them(sach);
					response.sendRedirect("sachAdminController");
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("dangNhapAdmin.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Không thể thêm sách");
			RequestDispatcher rd = request.getRequestDispatcher("themSuaSachAdmin.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
