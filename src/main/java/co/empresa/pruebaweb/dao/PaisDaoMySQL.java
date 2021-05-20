package co.empresa.pruebaweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.pruebaweb.modelo.Pais;
import co.empresa.pruebaweb.util.ConexionMySQL;

public class PaisDaoMySQL implements PaisDao{


	

private ConexionMySQL conexion;

private final static String INSERT_USUARIO_SQL = "INSERT INTO COUNTRY (id,nombre) VALUES (?,?);";
private final static String DELETE_USUARIO_SQL = "DELETE FROM COUNTRY WHERE id=? ;";
private final static String UPDATE_USUARIO_SQL = "UPDATE COUNTRY SET nombre=? WHERE id=?;";
private final static String SELECT_USUARIO_BY_ID = "SELECT * FROM COUNTRY WHERE id= ?;";
private final static String SELECT_ALL_USUARIO = "SELECT * FROM COUNTRY;";


	public PaisDaoMySQL() {
	this.conexion= ConexionMySQL.getConexion();
				}


public void insert(Pais pais) throws SQLException {

	try {
		PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(INSERT_USUARIO_SQL);
		prepareStatement.setString(1, pais.getId()+"");
		prepareStatement.setString(2, pais.getNombre());
		
		
		conexion.execute();
		
	}catch(SQLException e) {
		
	}

}


public void delete(int id) throws SQLException {
	try {
		PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(DELETE_USUARIO_SQL);
		prepareStatement.setInt(1, id);
		
		
		conexion.execute();
		
	}catch(SQLException e) {
		
	}

}


public void update(Pais pais) throws SQLException {
	try {
		PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(UPDATE_USUARIO_SQL);
		prepareStatement.setString(1, pais.getNombre());
		prepareStatement.setString(2, pais.getId()+"");
	
		
		
		conexion.execute();
		
	}catch(SQLException e) {
		
	}

}


public List<Pais> selecAll() {
	List<Pais>paises = new ArrayList<>();
	
	try {
		PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(SELECT_ALL_USUARIO);
		System.out.println(prepareStatement+"JULIAN");
		ResultSet rs = conexion.query();
		while (rs.next()) {
			String id = rs.getString("id");
			String nombre = rs.getString("nombre");
			paises.add(new Pais(id,nombre));
			
		}
		
	} catch (SQLException e) {
		
	}
	return paises;
}



public Pais selec(String id) {
	Pais pais = null;
	
	try {
		PreparedStatement prepareStatement = conexion.setpreparePreparedStatement(SELECT_USUARIO_BY_ID);
		prepareStatement.setString(1, id);
		ResultSet rs = conexion.query();
		while (rs.next()) {
			
			String nombre = rs.getString("nombre");
			
			pais = new Pais(id,nombre);
			
		}
		
	} catch (SQLException e) {
		
	}
	
	
	return pais;
}

}
