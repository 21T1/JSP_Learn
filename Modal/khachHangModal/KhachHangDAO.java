package khachHangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class KhachHangDAO {
	public ArrayList<KhachHang> getKhachHang() throws Exception{
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "select * from KhachHang";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			dsKhachHang.add(new KhachHang(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7)
				));
		}
		
		rs.close();
		ketNoi.cn.close();
		return dsKhachHang;
	}

	public KhachHang kiemTraDangNhap(String tenDN, String pass) {
		try {
			var ketNoi = new KetNoi();
			ketNoi.ketNoi();
			String sql = "select * from KhachHang"
					+ " where tendn = ? and pass = ?";
			PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
			pstmt.setString(1, tenDN);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return new KhachHang(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						tenDN,
						pass
				);
			}
			
			rs.close();
			ketNoi.cn.close();
		} catch (Exception e) {
			// TODO
		}
		return null;
	}
}

