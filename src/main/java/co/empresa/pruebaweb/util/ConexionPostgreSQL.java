package co.empresa.pruebaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPostgreSQL {

	
	
	private Connection con =null;
	private PreparedStatement preparedStatement;
	
	private static final String url = "jdbc:postgresql://database-2.cr5kiddvokid.us-east-2.rds.amazonaws.com:5432/";
	private static final String dbName = "giro";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "test";
	private static final String password = "Test2021";
	private static ConexionPostgreSQL db;
	
	
	public ConexionPostgreSQL() {
		try {
			Class.forName(driver);
			con = (Connection)DriverManager.getConnection(url+dbName,userName,password);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet query() throws SQLException{
       
        ResultSet res = preparedStatement.executeQuery();
        return res;
    }
	
	public int execute() throws SQLException {
        
        int result = preparedStatement.executeUpdate();
        return result;
 
    }
	public static ConexionPostgreSQL getConexion(){
		if ( db == null ) {
            db = new ConexionPostgreSQL();
        }
		return db;
	}
	public Connection getCon(){
		System.out.println(con+"gerson2");
		return con;
	}
	public PreparedStatement setpreparePreparedStatement(String sql)throws SQLException{
		
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
		
		
		
	}
	
	
	
	
}
