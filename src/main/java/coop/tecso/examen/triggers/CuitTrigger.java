package coop.tecso.examen.triggers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.api.Trigger;

public class CuitTrigger implements Trigger {

	private String actualTable;
	private String otherTable;
	
	@Override
	public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type)
			throws SQLException 
	{	
		this.setActualTable(tableName);
		this.otherTable = getActualTable() == "legal_person" ? "natural_person" : "legal_person";
		

	}

	@Override
	public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
		Statement statement = conn.createStatement();
		
		String query = String.format("SELECT cuit "
				+ "FROM %s otherTable "
				+ "WHERE otherTable.cuit = %s", this.otherTable, (String) newRow[3]);
		
		ResultSet res = statement.executeQuery(query); 
		
		if (res.first())
		{
			throw new SQLException("That cuit is repeated somewhere");
		}
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() throws SQLException {
		// TODO Auto-generated method stub

	}


	public String getOtherTable() {
		return otherTable;
	}

	public void setOtherTable(String otherTable) {
		this.otherTable = otherTable;
	}

	public String getActualTable() {
		return actualTable;
	}

	public void setActualTable(String actualTable) {
		this.actualTable = actualTable;
	}

}
