package finalProyect.proyect.DBconnection;

import java.sql.*;

public class ConexionDB {

	private Connection conexion;
	private Statement stm;

	public ConexionDB() {
		conexion = null;
	}

	private void estabelcerConexion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/BucketList", "root", "ramon");
	}

	public Connection getConexion() {
		return conexion;
	}

	public void update(String query) throws SQLException, ClassNotFoundException {
		estabelcerConexion();
		stm = getConexion().createStatement();
		stm.executeUpdate(query);
		conexion.close();
	}

	public ResultSet Consulta(String query) throws SQLException, ClassNotFoundException {
		estabelcerConexion();
		stm = getConexion().createStatement();
		return stm.executeQuery(query);
	}

}
