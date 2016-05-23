package finalProyect.proyect.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import finalProyect.proyect.DBconnection.*;

/*
 *                            Tipo          nulos
| cerveza_id                | int(11)      | NO
| nombre_cerveza            | varchar(30)  | NO    
| company_cerveza           | varchar(45)  | NO     
| estilo_cerveza            | varchar(10)  | NO     
| proviene_cerveza          | varchar(15)  | NO     
| vol_alc_cerveza           | double       | NO     
| precio_unit_cerveza       | double       | NO     
| url_img_cerveza           | varchar(100) | YES    
| descripcion_cerveza       | varchar(150) | YES    
| url_img_cerveza_principal | varchar(150) | YES    
 */

public class ListaCervezas {
	private ConexionDB conexion;
	private ResultSet registro;
	private String query;

	public ListaCervezas() {
		conexion = new ConexionDB();
		query = "";
	}

	public void insertarCerveza(String nombreCerveza, String companyCerveza, String estiloCereza,
			String provieneCerveza, double d, double e, String urlImgCerveza,
			String descripcionCerveza, String urlImgCervezaPrincipal) throws ClassNotFoundException, SQLException {
		query = "INSERT INTO tbl_cervezas VALUES(NULL, '" + nombreCerveza + "', '" + companyCerveza + "', '" + estiloCereza
				+ "', '" + provieneCerveza + "', " + d + "," + e + ",'" + urlImgCerveza
				+ "','" + descripcionCerveza + "','" + urlImgCervezaPrincipal + "')";
			conexion.update(query);
	}

	public ArrayList<Cerveza> consultaCervesasPrincipal() throws ClassNotFoundException, SQLException {
		ArrayList<Cerveza> cervezas = new ArrayList<Cerveza>();
		query = "select cerveza_id,nombre_cerveza,vol_alc_cerveza,precio_unit_cerveza,url_img_cerveza_principal From tbl_cervezas;";
		registro = conexion.Consulta(query);
		while(registro.next()){
			cervezas.add(new Cerveza(registro.getInt(1),registro.getString(2),registro.getFloat(3),registro.getFloat(4), registro.getString(5)));			
		}
		conexion.getConexion().close();
		return cervezas;
	}

	public ArrayList<Cerveza> consultaCervezasSecundaria() throws ClassNotFoundException, SQLException {
		ArrayList<Cerveza> cervezas=new ArrayList<Cerveza>();
		query = "select cerveza_id,nombre_cerveza, company_cerveza,estilo_cerveza,proviene_cerveza,vol_alc_cerveza,precio_unit_cerveza,url_img_cerveza,descripcion_cerveza From tbl_cervezas;";
		registro = conexion.Consulta(query);
		while(registro.next()){
			cervezas.add(new Cerveza(registro.getInt(1),registro.getString(2),registro.getString(3),registro.getString(4),registro.getString(5),registro.getDouble(6),registro.getDouble(7), registro.getString(8), registro.getString(9)));
		}
		conexion.getConexion().close();
		return cervezas;
	}

	public void eliminaCerveza(int cervezaId) throws ClassNotFoundException, SQLException {
		query = "delete from tbl_cervezas where cerveza_id = "+cervezaId+";";
		conexion.update(query);
	}

	public void modificarCerveza(int cervezaId,String campo,String datonuevo) throws ClassNotFoundException, SQLException{
		query = "UPDATE tbl_cervezas SET "+campo+" = "+ datonuevo+" WHERE cerveza_id = "+cervezaId+";";
		conexion.update(query);
	}
}
