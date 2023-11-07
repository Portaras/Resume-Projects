package in.obs.util;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBCUtil {
	public static Connection connection = null;

	@SuppressWarnings("resource")
	public static Connection getConnection() {
		Connection connection = null;
		HikariDataSource dataSource=null;

		String configFile = "/Volumes/WorkSpace/INTERNSHIP_PROJECT_PWSKILLS/OnlineBookShop/OBS/src/main/java/application.properties";
		HikariConfig config = new HikariConfig(configFile);

		

		try {
			dataSource = new HikariDataSource(config);
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public static void destroy(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (connection != null)
				connection.close();
			if (statement!=null)
				statement.close();
			if (resultSet!=null)
				resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}