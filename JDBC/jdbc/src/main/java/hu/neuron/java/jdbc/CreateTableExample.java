package hu.neuron.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.util.DriverInfo;

public class CreateTableExample {

	public void createTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			
			statement = connection.createStatement();
			StringBuilder sql = new StringBuilder("CREATE TABLE REGISTRATION( ");
			if (connection.getClientInfo("ApplicationName").equals(DriverInfo.DRIVER_NAME)) {
				sql.append(" ID  SERIAL PRIMARY KEY, ");

			} else {
				sql.append("ID int GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, ");
			}
			sql.append("first VARCHAR(255), " + " last VARCHAR(255), ");
			sql.append(" age INTEGER ");
			if (connection.getClientInfo("ApplicationName").equals(DriverInfo.DRIVER_NAME)) {
				sql.append(") ");

			} else {
				sql.append(", PRIMARY KEY ( id )) ");
			}
			statement.execute(sql.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
