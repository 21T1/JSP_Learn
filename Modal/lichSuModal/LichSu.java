package lichSuModal;

import java.util.Date;

public class LichSu {

	private String tenSach;
	private Date ngayMua;
	private long gia;
	private long soLuongMua;
	private long thanhTien;
	private boolean daMua;
	private String tenKH;
	
	public String getTenSach() {
		return tenSach;
	}
	
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	
	public Date getNgayMua() {
		return ngayMua;
	}
	
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	
	public long getGia() {
		return gia;
	}
	
	public void setGia(long gia) {
		this.gia = gia;
	}
	
	public long getSoLuongMua() {
		return soLuongMua;
	}
	
	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	
	public long getThanhTien() {
		return thanhTien;
	}
	
	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	public boolean isDaMua() {
		return daMua;
	}
	
	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}
	
	public String getTenKH() {
		return tenKH;
	}
	
	public void setMaKH(String tenKH) {
		this.tenKH = tenKH;
	}
	
	public LichSu(String tenSach, Date ngayMua, long gia, long soLuongMua, long thanhTien, boolean daMua, String tenKH) {
		super();
		this.tenSach = tenSach;
		this.ngayMua = ngayMua;
		this.gia = gia;
		this.soLuongMua = soLuongMua;
		this.thanhTien = thanhTien;
		this.daMua = daMua;
		this.tenKH = tenKH;
	}
	
	public LichSu() {
		
	}
}
