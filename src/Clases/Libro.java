package Clases;

public class Libro extends MaterialBiblioteca implements Prestamo{
	private String autor;
	public Libro(String titulo, int añoPublicacion, int numeroDePaginas, String autor) {
		super(titulo, añoPublicacion, numeroDePaginas);
		this.autor = autor;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getResumen() {
		String resumen="Los atributos relevantes del libro es el autor "+"el numero de edicion de la revista"+getTitulo()+" son "+autor;
		return resumen;
	}
	@Override
	public int calcularMulta(int diasRetraso) {
		int precioMulta=2000*diasRetraso;
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
