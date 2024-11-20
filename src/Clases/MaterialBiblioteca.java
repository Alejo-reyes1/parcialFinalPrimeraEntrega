package Clases;

import java.time.LocalDate;

public abstract class MaterialBiblioteca {
	private String titulo;
	private int añoPublicacion;
	private int numeroDePaginas;
	private boolean prestado;
	private String nombrePrestado;
	private LocalDate diaPrestado;
	public MaterialBiblioteca(String titulo, int añoPublicacion, int numeroDePaginas) {
		this.titulo = titulo;
		this.añoPublicacion = añoPublicacion;
		this.numeroDePaginas = numeroDePaginas;
		this.prestado=false;
		this.diaPrestado=null;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAñoPublicacion() {
		return añoPublicacion;
	}
	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}
	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}
	public boolean isPrestado() {
		return prestado;
	}
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	public abstract int calcularMulta(int diasRetraso);
	public String getNombrePrestado() {
		return nombrePrestado;
	}
	public void setNombrePrestado(String nombrePrestado) {
		this.nombrePrestado = nombrePrestado;
	}
	public LocalDate getDiaPrestado() {
		return diaPrestado;
	}
	public void setDiaPrestado(LocalDate diaPrestado) {
		this.diaPrestado = diaPrestado;
	}
	
	
	
	

}
