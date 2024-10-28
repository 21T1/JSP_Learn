package sachModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class SachDAO {
	public ArrayList<Sach> getSach() throws Exception {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		KetNoi ketNoi = new KetNoi();
		ketNoi.ketNoi();
		String sql = "select * from sach";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ds.add(new Sach(
					rs.getString("masach"),
					rs.getString("tensach"),
					rs.getString("tacgia"),
					rs.getLong("soluong"),
					rs.getLong("gia"),
					rs.getString("anh"),
					rs.getString("maloai")
				));
		}
		
		ketNoi.cn.close();
		return ds;
	}
}
