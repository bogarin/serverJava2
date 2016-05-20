package finalProyect.proyect.DBconnection;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
@WebService
public class Querys {
	private ConexionDB conectando;
	private String query;
	private ResultSet registro;
	public Querys() {
		conectando=new ConexionDB();
		query="";
	}
	
	@WebMethod()
	public boolean insertarUsuario(String user, String username, String pasword){
		query= "INSERT INTO tbl_user VALUES(NULL, '"+user+"', '"+username+"', '"+pasword+"')";
		try {
			conectando.update(query);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	@WebMethod(exclude=true)
	private String consultaUsuario(String username){
		String resultado="";
			query= "select user_pasword From tbl_user where user_username = '"+username+"';";
			try {
				registro =conectando.Consulta(query);
				while(registro.next()){
					resultado = registro.getString(1);
				};
				conectando.getConexion().close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
	}
    
	@WebMethod()
	public boolean verificarUsuario(String username,String password){
		return consultaUsuario(username).equals(password);
	}
	
	@WebMethod()
	public boolean comentarios(String titulo,String descripcion,int idUsuario){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String fecha =dateFormat.format(cal.getTime());
		System.out.println(fecha);
		query= "INSERT INTO tbl_comment VALUES(NULL, '"+titulo+"', '"+descripcion+"',"+idUsuario+",'"+fecha+"')";
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
