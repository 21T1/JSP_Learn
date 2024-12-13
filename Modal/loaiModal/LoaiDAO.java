package loaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

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
	
	public int themLoai(Loai loai) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "insert into loai values (?, ?)";
		
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setString(1, loai.getMaLoai());
		pstmt.setString(2, loai.getTenLoai());
	
		int n = pstmt.executeUpdate();
		
		ketNoi.cn.close();
		return n;
	}
	
	public int suaLoai(Loai loai, String maLoai) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "update loai"
				+ " set maloai = ?,"
				+ "	tenloai = ?"
				+ " where maloai = ?";
		
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setString(1, loai.getMaLoai());
		pstmt.setString(2, loai.getTenLoai());
		pstmt.setString(3, maLoai);
		
		int n = pstmt.executeUpdate();
		
		ketNoi.cn.close();
		return n;
	}
	
	public int xoaLoai(String maLoai) throws Exception {
		var ketNoi = new KetNoi();
		ketNoi.ketNoi();
		
		String sql = "delete from loai where maloai = ?";
		
		PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
		pstmt.setString(1, maLoai);
		
		int n = pstmt.executeUpdate();
		
		ketNoi.cn.close();
		return n;
	}
	
}
