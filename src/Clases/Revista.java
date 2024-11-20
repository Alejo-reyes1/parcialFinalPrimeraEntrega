package Clases;

public class Revista extends MaterialBiblioteca implements Prestamo {
	private int numeroEdicion;

	public Revista(String titulo, int añoPublicacion, int numeroDePaginas, int numeroEdicion) {
		super(titulo, añoPublicacion, numeroDePaginas);
		this.numeroEdicion = numeroEdicion;
	}

	public int getNumeroEdicion() {
		return numeroEdicion;
	}

	public void setNumeroEdicion(int numeroEdicion) {
		this.numeroEdicion = numeroEdicion;
	}
	public String getResumen() {
		String resumen="Los atributos relevantes de la revista son numero de edicion "+"el numero de edicion de la revista"+getTitulo()+" son "+numeroEdicion;
		return resumen;
	}

	@Override
	public int calcularMulta(int diasRetraso) {
		int precioMulta=0;
		
		if(diasRetraso>10) {
			precioMulta=1000*10+diasRetraso*1500*(diasRetraso-10);
		}else {
			precioMulta=1000*diasRetraso;
		}
		return precioMulta;
	}

	@Override
	public boolean prestar(String nombreUsuario) {
		setNombrePrestado(nombreUsuario);
		setPrestado(true);
		return true;
	}

	@Override
	public boolean devolver() {
		setNombrePrestado("");
		setPrestado(false);
		setDiaPrestado(null);
		return true;
	}
	
	
	

}
