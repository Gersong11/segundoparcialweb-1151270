package co.empresa.pruebaweb.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.pruebaweb.modelo.Pais;

public interface PaisDao {

	
	
	public void insert(Pais pais) throws SQLException;
	public void delete(String id) throws SQLException;
	public void update(Pais pais) throws SQLException;
	public List<Pais> selecAll();
	public Pais selec(String id);
	
	
	
	
}
