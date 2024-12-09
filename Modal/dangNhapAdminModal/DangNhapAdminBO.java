package dangNhapAdminModal;

public class DangNhapAdminBO {
	
	DangNhapAdminDAO dao = new DangNhapAdminDAO();

	public String kiemTraDangNhap(String tenDN, String pass) throws Exception {
		return dao.kiemTraDangNhap(tenDN, pass);
	}
}
