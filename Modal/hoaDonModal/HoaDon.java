package hoaDonModal;

import java.util.Date;

public class HoaDon {
	private long maHoaDon;
	private long maKhachHang;
	private Date ngayMua;
	private boolean daMua;
	
	public HoaDon() {
		
	}

	public HoaDon(long maHoaDon, long maKhachHang, Date ngayMua, boolean daMua) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
	}

	public long getMaHoaDon() {
		return maHoaDon;
	}
	
	public void setMaHoaDon(long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	
	public long getMaKhachHang() {
		return maKhachHang;
	}
	
	public void setMaKhachHang(long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	
	public boolean isDaMua() {
		return daMua;
	}
	
	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}
}	
