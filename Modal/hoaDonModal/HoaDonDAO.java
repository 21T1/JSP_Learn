package hoaDonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import ketNoiModal.KetNoi;
import lichSuModal.LichSu;

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
	
	public long xacNhan(long maHD) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "update hoadon set damua = 1 where MaHoaDon = ?";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setLong(1, maHD);
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		ketNoi.cn.close();
		return result;
	}
	
	public ArrayList<HoaDon> getChuaThanhToan() throws Exception {
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "select * from HoaDon where damua = 0";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ds.add(new HoaDon(
					rs.getLong(1),
					rs.getLong(2),
					rs.getDate(3),
					rs.getBoolean(4)
				));
		}
		return ds;
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
