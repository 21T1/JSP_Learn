package sachModal;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class SachDAO {
	
	public int themSach(Sach sach) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "insert into sach(masach, tensach, soluong, gia, maloai, anh, tacgia, NgayNhap) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setString(1, sach.getMaSach());
		pstmt.setString(2, sach.getTenSach());
		pstmt.setLong(3, sach.getSoLuong());
		pstmt.setLong(4, sach.getGia());
		pstmt.setString(5, sach.getMaLoai());
		pstmt.setString(6, sach.getAnh());
		pstmt.setString(7, sach.getTacGia());
		pstmt.setDate(8, new java.sql.Date((new Date()).getTime()));

		int n = pstmt.executeUpdate();
		
		ketNoi.cn.close();
		return n;
	}
	
	public int suaSach(Sach sach, String maSachSua) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "update sach"
				+ " set masach = ?,"
				+ "	tensach = ?,"
				+ "	soluong = ?,"
				+ "	gia = ?,"
				+ "	maloai = ?, "
				+ "	anh = ?, "
				+ "	tacgia = ? "
				+ " where masach = ?";
		
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setString(1, sach.getMaSach());
		pstmt.setString(2, sach.getTenSach());
		pstmt.setLong(3, sach.getSoLuong());
		pstmt.setLong(4, sach.getGia());
		pstmt.setString(5, sach.getMaLoai());
		pstmt.setString(6, sach.getAnh());
		pstmt.setString(7, sach.getTacGia());
		pstmt.setString(8, maSachSua);
		
		int n = pstmt.executeUpdate();
		
		ketNoi.cn.close();
		return n;
	}
	
	public int xoaSach(String maSach) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "delete from sach where masach = ?";
		
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setString(1, maSach);
		
		int n = pstmt.executeUpdate();
		
		ketNoi.cn.close();
		return n;
	}
	
	public ArrayList<Sach> getSach() throws Exception {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		KetNoi ketNoi = new KetNoi();
		ketNoi.ketNoi();
		String sql = "select * from sach order by masach";
		
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
	
	public ArrayList<Sach> getSach(int p) throws Exception {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		KetNoi ketNoi = new KetNoi();
		ketNoi.ketNoi();
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
}
