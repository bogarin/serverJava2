package finalProyect.proyect.DBconnection;
import java.sql.*;

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
               


}
