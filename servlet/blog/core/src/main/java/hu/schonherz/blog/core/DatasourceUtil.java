package hu.schonherz.blog.core;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatasourceUtil {

	static synchronized DataSource getDatasource() {
		DataSource ds = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/TestDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
