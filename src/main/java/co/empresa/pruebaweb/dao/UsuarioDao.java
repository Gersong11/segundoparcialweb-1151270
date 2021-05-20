package co.empresa.pruebaweb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.pruebaweb.modelo.Usuario;

public interface UsuarioDao {

	
	public void insert(Usuario usuario) throws SQLException;
	public void delete(int id) throws SQLException;
	public void update(Usuario usuario) throws SQLException;
	public List<Usuario>selecAll();
	public Usuario selec(int id);
	
	
	
	
	
	
}
