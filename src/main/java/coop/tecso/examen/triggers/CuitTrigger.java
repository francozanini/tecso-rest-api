package coop.tecso.examen.triggers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.api.Trigger;

public class CuitTrigger implements Trigger{

	private String actualTable;
	private String otherTable;
	private int column;
	
	@Override
	public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type)
			throws SQLException 
	{	
		this.setActualTable(tableName.toLowerCase());
		boolean isLegalPersonTable = actualTable.equalsIgnoreCase("legal_person");
		
		this.otherTable =  isLegalPersonTable ? "natural_person" : "legal_person";
		this.column 	=  isLegalPersonTable ? 5 : 4; 
	}

	@Override
	public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException 
	{
		String query = String.format("SELECT cuit "
				+ "FROM %s otherTable "
				+ "WHERE otherTable.cuit = %s ", 
				this.otherTable,  
				newRow[column]);

		Statement statement = conn.createStatement();
		ResultSet res = statement.executeQuery(query); 

		if (res.next())
		{
			throw new SQLException("That cuit is repeated somewhere");
		}	
	}

	@Override
	public void close() throws SQLException 
	{}

	@Override
	public void remove() throws SQLException 
	{
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
