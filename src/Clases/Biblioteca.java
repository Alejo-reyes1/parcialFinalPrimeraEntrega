package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
	private String nombre;
	private ArrayList<MaterialBiblioteca>invetario;
	private ArrayList<Usuario>usuario;
	public Biblioteca(String nombre) {
		super();
		this.nombre = nombre;
		this.invetario =new ArrayList<>();
		this.usuario=new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<MaterialBiblioteca> getInvetario() {
		return invetario;
	}
	public void setInvetario(ArrayList<MaterialBiblioteca> invetario) {
		this.invetario = invetario;
	}
	public boolean agregarMaterial(MaterialBiblioteca material) {
		this.invetario.add(material);
		return true;
	}
	public MaterialBiblioteca buscarLibro(String titulo, String autor) {
		for(MaterialBiblioteca m:this.invetario) {
			if(m.getTitulo().equalsIgnoreCase(titulo)&&((Libro)m).getAutor().equalsIgnoreCase(autor)) {
				return m;
			}
		}
		return null;
	}
	public MaterialBiblioteca buscarRevista(String titulo, int numeroEdicion) {
		for(MaterialBiblioteca m:this.invetario) {
			if(m.getTitulo().equalsIgnoreCase(titulo)&&((Revista)m).getNumeroEdicion()==numeroEdicion) return m;
		}
		return null;
	}
	private Usuario buscarUsuario(String nombreUsuario) {
		for(Usuario u:this.usuario) {
			if(u.getNombre().equalsIgnoreCase(nombreUsuario))return u;
		}
		return null;
	}
	public boolean prestarMaterial(Libro material, String nombreUsuario) {
		Boolean prestado=material.isPrestado();
		if(!prestado) {
			material.prestar(nombreUsuario);
			return true;
		}
		return false;
	}
	public boolean prestarMaterial(Revista material, String nombreUsuario) {
		Boolean prestado=material.isPrestado();
		if(!prestado) {
			material.prestar(nombreUsuario);
			material.setDiaPrestado(LocalDate.now());
			return true;
		}
		return false;
	}
	public int devolverMaterial(Libro material) {
		boolean prestado=material.isPrestado();
		int precioMulta=0;
		int diaPrestado=(int)material.getDiaPrestado().getDayOfYear();
		if(prestado) {
			precioMulta=material.calcularMulta(LocalDate.now().getDayOfYear()-diaPrestado);
			material.devolver();
		}
		return precioMulta;
	}
	public int devolverMaterial(Revista material) {
		boolean prestado=material.isPrestado();
		int precioMulta=0;
		int diaPrestado=(int)material.getDiaPrestado().getDayOfYear();
		if(prestado) {
			precioMulta=material.calcularMulta(LocalDate.now().getDayOfYear()-diaPrestado);
			material.devolver();
		}
		return precioMulta;
	}
	public String detallesMateriales() {
		String detalles="";
		for(MaterialBiblioteca material:this.invetario) {
			if(material instanceof Revista) {
				detalles+=((Revista)material).getResumen()+"\n";
			}else if(material instanceof Libro) {
				detalles+=((Libro)material).getResumen()+"\n";
			}
		}
		return detalles;
	}
	public String multasDelMomento() {
		String listaMultas="Las multas del momento son\n";
		for(MaterialBiblioteca material:this.invetario) {
			if(material instanceof Revista && material.isPrestado()!=false) {
				listaMultas=material.getTitulo()+"y su multa es de"+
				material.calcularMulta(LocalDate.now().getDayOfYear()-material.getDiaPrestado().getDayOfYear())+"\n";
			}else if (material instanceof Libro && material.isPrestado()!=false) {
				listaMultas=material.getTitulo()+"y su multa es de"+
				material.calcularMulta(LocalDate.now().getDayOfYear()-material.getDiaPrestado().getDayOfYear())+"\n";
			}
		}
		return listaMultas;
	}
	public String listaMultasUsuario(String usuario) {
		String listaMultas="Las multas del usuario son\n";
		for(MaterialBiblioteca material:this.invetario) {
			if(material instanceof Revista && material.getNombrePrestado().equalsIgnoreCase(usuario)) {
				listaMultas=material.getTitulo()+"y su multa es de"+
				material.calcularMulta(LocalDate.now().getDayOfYear()-material.getDiaPrestado().getDayOfYear())+"\n";
			}else if(material instanceof Libro && material.getNombrePrestado().equalsIgnoreCase(usuario)) {
				listaMultas=material.getTitulo()+"y su multa es de"+
				material.calcularMulta(LocalDate.now().getDayOfYear()-material.getDiaPrestado().getDayOfYear())+"\n";
			}
		}
		return listaMultas;
	}
}
