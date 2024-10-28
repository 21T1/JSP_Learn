package tam;

public class Hang {
	private String maSach;
	private String tenSach;
	private long gia;
	private long soLuong;
	private long thanhTien;
	
	public Hang(String maSach, String tenSach, long gia, long soLuong) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhTien = gia * soLuong;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}
}
