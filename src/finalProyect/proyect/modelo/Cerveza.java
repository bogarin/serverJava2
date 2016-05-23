package finalProyect.proyect.modelo;

public class Cerveza {
	private int clienteId=0;
	private String nombreCerveza="";
	private String companyCerveza="";
	private String estiloCerveza="";
	private String provieneCerveza="";
	private double volAlcCerveza=0;
	private double precioUnitCerveza=0;
	private String urlImgCerveza="";
	private String descripcionCerveza="";
	private String urlImgCervezaPrincipal="";
	
	//principal
	public Cerveza(int clienteId,String nombreCerveza, double volAlcCerveza, double precioUnitCerveza, String urlImgCervezaPrincipal) {
		this.clienteId=clienteId;
		this.nombreCerveza = nombreCerveza;
		this.volAlcCerveza = volAlcCerveza;
		this.precioUnitCerveza = precioUnitCerveza;
		this.urlImgCervezaPrincipal = urlImgCervezaPrincipal;
	}

	//secunadrio
	public Cerveza(int clienteId,String nombreCerveza, String companyCerveza, String estiloCerveza, String provieneCerveza,
			double volAlcCerveza, double precioUnitCerveza, String urlImgCerveza, String descripcionCerveza) {
		this.clienteId=clienteId;
		this.nombreCerveza = nombreCerveza;
		this.companyCerveza = companyCerveza;
		this.estiloCerveza = estiloCerveza;
		this.provieneCerveza = provieneCerveza;
		this.volAlcCerveza = volAlcCerveza;
		this.precioUnitCerveza = precioUnitCerveza;
		this.urlImgCerveza = urlImgCerveza;
		this.descripcionCerveza = descripcionCerveza;
	}
	

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getCompanyCerveza() {
		return companyCerveza;
	}

	public void setCompanyCerveza(String companyCerveza) {
		this.companyCerveza = companyCerveza;
	}

	public String getEstiloCerveza() {
		return estiloCerveza;
	}

	public void setEstiloCerveza(String estiloCerveza) {
		this.estiloCerveza = estiloCerveza;
	}

	public String getProvieneCerveza() {
		return provieneCerveza;
	}

	public void setProvieneCerveza(String provieneCerveza) {
		this.provieneCerveza = provieneCerveza;
	}

	public double getVolAlcCerveza() {
		return volAlcCerveza;
	}

	public void setVolAlcCerveza(double volAlcCerveza) {
		this.volAlcCerveza = volAlcCerveza;
	}

	public double getPrecioUnitCerveza() {
		return precioUnitCerveza;
	}

	public void setPrecioUnitCerveza(double precioUnitCerveza) {
		this.precioUnitCerveza = precioUnitCerveza;
	}

	public String getUrlImgCerveza() {
		return urlImgCerveza;
	}

	public void setUrlImgCerveza(String urlImgCerveza) {
		this.urlImgCerveza = urlImgCerveza;
	}

	public String getDescripcionCerveza() {
		return descripcionCerveza;
	}

	public void setDescripcionCerveza(String descripcionCerveza) {
		this.descripcionCerveza = descripcionCerveza;
	}

	public String getUrlImgCervezaPrincipal() {
		return urlImgCervezaPrincipal;
	}

	public void setUrlImgCervezaPrincipal(String urlImgCervezaPrincipal) {
		this.urlImgCervezaPrincipal = urlImgCervezaPrincipal;
	}
		
}