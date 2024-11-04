package hoaDonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import ketNoiModal.KetNoi;

public class HoaDonDAO {
	
	public int them(long maKH, Date ngayMua) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "insert into hoadon(makh, NgayMua, damua) values (?, ?, 0)";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setLong(1, maKH);
		pstmt.setDate(2, new java.sql.Date(ngayMua.getTime()));
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		ketNoi.cn.close();
		return result;
	}
	
	public long maxHoaDon() throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "select MAX(MaHoaDon) from hoadon";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		long result = rs.getLong(1);
		
		pstmt.close();
		ketNoi.cn.close();
		return result;
	}
}
