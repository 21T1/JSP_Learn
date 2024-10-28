package loaiModal;

import java.util.ArrayList;

public class LoaiDAO {
	public ArrayList<Loai> getLoai() {
		ArrayList<Loai> ds = new ArrayList<Loai>();
		ds.add(new Loai("cntt", "Cong nghe thong tin"));
		ds.add(new Loai("toan", "Toan ung dung"));
		ds.add(new Loai("ly", "Vat ly"));
		ds.add(new Loai("hoa", "Hoa hoc"));
		ds.add(new Loai("sinh", "Cong nghe sinh hoc"));
		return ds;
	}
}
