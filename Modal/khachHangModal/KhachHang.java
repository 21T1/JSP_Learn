package khachHangModal;

public class KhachHang {
	private int maKH;
	private String hoTen;
	private String diaChi;
	private String soDT;
	private String email;
	private String tenDN;
	private String pass;
	
	public KhachHang(int maKH, String hoTen, String diaChi, String soDT, String email, String tenDN, String pass) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
		this.tenDN = tenDN;
		this.pass = pass;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
