package ChiTietHoaDonModal;

import java.sql.PreparedStatement;

import ketNoiModal.KetNoi;

public class ChiTietDAO {

	public int them(String maSach, long soLuongMua, long maHoaDon) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "insert into ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon)"
				+ " values (?, ?, ?)";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setString(1, maSach);
		pstmt.setLong(2, soLuongMua);
		pstmt.setLong(3, maHoaDon);
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		ketNoi.cn.close();
		return result;
	}
}
