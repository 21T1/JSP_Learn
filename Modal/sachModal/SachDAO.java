package sachModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class SachDAO {
	public ArrayList<Sach> getSach(int p) throws Exception {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		KetNoi ketNoi = new KetNoi();
		ketNoi.ketNoi();
//		String sql = "select * from sach";
		String sql = "select * from sach order by masach offset 9 * (? - 1) rows fetch next 9 rows only";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setInt(1, p);
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
	
	public int countSach() throws Exception {
		KetNoi ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "select count(*) as Count from sach";
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		int count = rs.getInt("Count");
		ketNoi.cn.close();
		return count;
	}
}
