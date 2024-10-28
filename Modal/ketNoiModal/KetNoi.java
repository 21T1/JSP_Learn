package ketNoiModal;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection cn;
	public void ketNoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://Duckyy:1433;databaseName=QlSach;user=sa;password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("Đã kết nối");
	}
}
