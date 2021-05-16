import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PrestoTest {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		Class.forName("com.facebook.presto.jdbc.PrestoJDriver");
		String url = "jdbc:presto://example.net:8080/hive/sales";
		Properties properties = new Properties();
		properties.setProperty("user", "test");
		properties.setProperty("password", "secret");
		properties.setProperty("SSL", "true");
		Connection connection = DriverManager.getConnection(url, properties);
	}
}
