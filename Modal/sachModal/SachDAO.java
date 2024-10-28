package sachModal;

import java.util.ArrayList;

public class SachDAO {
	public ArrayList<Sach> getSach() {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		ds.add(new Sach("s1", "CNTT", "Nguyễn A", (long) 1, (long) 1000, "image_sach/a1.jpg", "cntt"));
		ds.add(new Sach("s2", "CSDL", "Văn B", (long) 2, (long) 1000, "image_sach/b2.jpg", "cntt"));
		ds.add(new Sach("s3", "CTDL và GT", "Lê C", (long) 1, (long) 1000, "image_sach/c5.jpg", "cntt"));
		ds.add(new Sach("s4", "Cơ sở toán", "Hoàng A", (long) 1, (long) 1000, "image_sach/h4.jpg", "toan"));
		ds.add(new Sach("s5", "Toán cao cấp", "Lê B", (long) 1, (long) 1000, "image_sach/k12.jpg", "toan"));
		ds.add(new Sach("s6", "Lý 11", "Ngô D", (long) 1, (long) 1000, "image_sach/ly5.jpg", "ly"));
		return ds;
	}
}
