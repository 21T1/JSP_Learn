package dangNhapAdminModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ketNoiModal.KetNoi;

public class DangNhapAdminDAO {

	public String kiemTraDangNhap(String tenDN, String pass) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		String sql = "select * from DangNhap"
				+ " where TenDangNhap = ? and MatKhau = ?";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setString(1, tenDN);
		pstmt.setString(2, pass);
		ResultSet rs = pstmt.executeQuery();
		
		String kq = null;
		if (rs.next()) {
			kq = tenDN;
		}
		
		rs.close();
		ketNoi.cn.close();
		return kq;
	}
}
