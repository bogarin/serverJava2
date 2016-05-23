package finalProyect.proyect.modelo;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import finalProyect.proyect.DBconnection.ConexionDB;


public class UsuariosComments {
	private ConexionDB conectando;
	private String query;
	private ResultSet registro;

	public UsuariosComments() {
		conectando = new ConexionDB();
		query = "";
	}

	
	public boolean insertarUsuario(String user, String username, String pasword) {
		query = "INSERT INTO tbl_user VALUES(NULL, '" + user + "', '" + username + "', '" + pasword + "')";
		try {
			conectando.update(query);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	
	private String consultaUsuario(String username) {
		String resultado = "";
		query = "select user_pasword From tbl_user where user_username = '" + username + "';";
		try {
			registro = conectando.Consulta(query);
			while (registro.next()) {
				resultado = registro.getString(1);
			}
			;
			conectando.getConexion().close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	
	public boolean verificarUsuario(String username, String password) {
		return consultaUsuario(username).equals(password);
	}

	
	public boolean comentarios(String titulo, String descripcion, String usuario) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String fecha = dateFormat.format(cal.getTime());
		System.out.println(fecha);
		query = "INSERT INTO tbl_comment VALUES(NULL, '" + titulo + "', '" + descripcion + "','" + usuario + "','"
				+ fecha + "')";
		try {
			conectando.update(query);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
