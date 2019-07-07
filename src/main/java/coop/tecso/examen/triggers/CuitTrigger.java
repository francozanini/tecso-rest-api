package coop.tecso.examen.triggers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.api.Trigger;

public class CuitTrigger implements Trigger {

	String tableName;
	
	@Override
	public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type)
			throws SQLException {
		this.tableName = tableName;

	}

	@Override
	public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
		/*Statement statement = conn.createStatement();
		String query = String.format("SELECT cuit "
				+ "FROM %s otherTable "
				+ "WHERE otherTable.cuit = %s", this.tableName, newRow.);
		statement.executeQuery(String.fomrat"select cuit from "); 
	*/}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() throws SQLException {
		// TODO Auto-generated method stub

	}

}
