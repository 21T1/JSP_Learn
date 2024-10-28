package loaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class LoaiDAO {
	public ArrayList<Loai> getLoai() throws Exception {
		ArrayList<Loai> ds = new ArrayList<Loai>();
		KetNoi ketNoi = new KetNoi();
		ketNoi.ketNoi();
		String sql = "select * from loai";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ds.add(new Loai(
					rs.getString("maloai"),
					rs.getString("tenloai")
				));
		}
		
		rs.close();
		ketNoi.cn.close();
		return ds;
	}
}
