package lichSuModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import ketNoiModal.KetNoi;

public class LichSuDAO {
	
	public ArrayList<LichSu> getChuaThanhToan() throws Exception {
		ArrayList<LichSu> ds = new ArrayList<LichSu>();
		
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "select * from VLichSu where damua = 0";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ds.add(new LichSu(
					rs.getString(1),
					rs.getDate(2),
					rs.getLong(3),
					rs.getLong(4),
					rs.getLong(5),
					rs.getBoolean(6),
					rs.getString(7)
				));
		}
		return ds;
	}

	public ArrayList<LichSu> getLichSuTheoMaKH(int maKH) throws Exception {
		ArrayList<LichSu> dsLichSu = new ArrayList<LichSu>();
		
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "select * from VLichSu where makh = ?";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setInt(1, maKH);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			dsLichSu.add(new LichSu(
					rs.getString(1),
					rs.getDate(2),
					rs.getLong(3),
					rs.getLong(4),
					rs.getLong(5),
					rs.getBoolean(6),
					rs.getString(7)
				));
		}
		return dsLichSu;
	}
}
