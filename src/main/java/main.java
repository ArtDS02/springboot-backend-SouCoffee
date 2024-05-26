import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
	
	private static final String servername = "DESKTOP-5EKHCDV";
    private static final String dbName = "TestSQL";
    private static final String portNumber = "1433";
    private static final String instance = "";
    private static final String userID = "sa";
    private static final String password = "sa";

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:sqlserver://" + servername + ":" + portNumber + "\\" + instance + ";databaseName="
                    + dbName + ";encrypt=true;trustServerCertificate=true";
            if (instance == null || instance.trim().isEmpty()) {
                url = "jdbc:sqlserver://" + servername + ":" + portNumber + ";databaseName=" + dbName
                        + ";encrypt=true;trustServerCertificate=true";
            }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection connection = DriverManager.getConnection(url, userID, password);
			String sql = "select * from SanPham";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getInt(3));
			}
			
			System.out.println("connect successfully");
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}

	}

}