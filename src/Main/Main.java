package Main;

import javax.swing.JOptionPane;

import Clases.Biblioteca;
import Clases.Libro;
import Clases.MaterialBiblioteca;
import Clases.Revista;

public class Main {
	public static Biblioteca biblioteca=new Biblioteca("biblioteca");

	public static void main(String[] args) {
		String menuPrincipal = "Menu principal\n"+
		"Ingrese la opcion correspondiente:\n"+
		"1.Agregar material\n"+
		"2.prestar material\n"+
		"3.devolver material\n"+
		"4.muestre los detalles de los materiales\n"+
		"5.multas totales acumuladas\n"+
		"6.multas de un usuario\n"+
		"7.salir";
		int opcionSeleccionada = 0;	
		
		do {
			opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null,menuPrincipal));
			opcionMenu(opcionSeleccionada);
		} while (opcionSeleccionada <7);
		
	}

	private static void opcionMenu(int opcionSeleccionada) {
		switch (opcionSeleccionada) {
		case 1:
			agregarMaterial();
			break;
		case 2:
			prestarMaterial();
			break;
		case 3:
			devolverMaterial();
			break;
		case 4:
			mostrarDetalleMateriales();
			break;
		case 5:
			multasTotalesAcumuladas();
			break;
		case 6:
			multasDeUnUsuario();
			break;
		case 7:
			break;
		}
	}

	private static void agregarMaterial() {
		boolean agregado=false;
		int tipoMaterial=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el material que desea agregar\n 1.Revista\n2.Libro"));
		if(tipoMaterial==1) {
			String titulo=JOptionPane.showInputDialog("Ingrese el titulo de la revista");
			int añoPublicacion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicacion de la revista"));
			int numeroPaginas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de paginas de la revista"));
			int numeroEdicion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de edicion de la revista"));
			Revista r=new Revista(titulo,añoPublicacion,numeroPaginas,numeroEdicion);
			agregado=biblioteca.agregarMaterial(r);
		}else if(tipoMaterial==2) {
			String titulo=JOptionPane.showInputDialog("Ingrese el titulo de la libro");
			int añoPublicacion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicacion de la libro"));
			int numeroPaginas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de paginas de la libro"));
			String autor=JOptionPane.showInputDialog("Ingrese el autor del libro");
			Libro l=new Libro(titulo,añoPublicacion,numeroPaginas,autor);
			agregado=biblioteca.agregarMaterial(l);
		}
		JOptionPane.showMessageDialog(null,agregado?"El material fue agregado":"El material no fue agregado");
	}
	private static void prestarMaterial() {
		int tipoMaterial=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el material que desea prestar\n 1.Revista\n2.Libro"));
		String nombrePrestado=JOptionPane.showInputDialog("Ingrese el nombre del usuario que fue prestado el libro");
		if(tipoMaterial==1) {
			String titulo=JOptionPane.showInputDialog("Ingrrse el titulo del titulo");
			int numeroRevista=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de edicion de la revista"));
			Revista material=(Revista)biblioteca.buscarRevista(titulo, numeroRevista);
			boolean prestado=biblioteca.prestarMaterial(material, nombrePrestado);
			JOptionPane.showMessageDialog(null,prestado?"la revista fue prestada"+material.getTitulo():"La revista ya esta prestado");
			
		}else if(tipoMaterial==2) {
			String titulo=JOptionPane.showInputDialog("Ingrese el titulo del libro");
			String autor=JOptionPane.showInputDialog("Ingrese el autor del libro");
			Libro material=(Libro) biblioteca.buscarLibro(titulo, autor);
			boolean prestado=biblioteca.prestarMaterial(material, nombrePrestado);
			JOptionPane.showMessageDialog(null,prestado?"El libro fue prestado"+material.getTitulo():"El libro ya esta prestado");
		}
	}
	//El metodo devolver matrial, devuelve un entero del precio que tiene de multa
	private static void devolverMaterial () {
		int tipoMaterial=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el material que desea prestar\n 1.Revista\n2.Libro"));
		if(tipoMaterial==1) {
			String titulo=JOptionPane.showInputDialog("Ingrrse el titulo del titulo");
			int numeroRevista=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de edicion de la revista"));
			Revista material=(Revista)biblioteca.buscarRevista(titulo, numeroRevista);
			int precioMulta=biblioteca.devolverMaterial(material);
			JOptionPane.showMessageDialog(null,"El material fue devuelto  y tiene una multa de"+precioMulta);
		}else if(tipoMaterial==2) {
			String titulo=JOptionPane.showInputDialog("Ingrese el titulo del libro");
			String autor=JOptionPane.showInputDialog("Ingrese el autor del libro");
			Libro material=(Libro) biblioteca.buscarLibro(titulo, autor);
			int precioMulta=biblioteca.devolverMaterial(material);
			JOptionPane.showMessageDialog(null,"El material fue devuelto  y tiene una multa de"+precioMulta);
		}
	}
	private static void mostrarDetalleMateriales() {
		String detallesMateriales=biblioteca.detallesMateriales();
		JOptionPane.showMessageDialog(null, detallesMateriales);
	}
	private static void multasTotalesAcumuladas() {
		String listaMultas=biblioteca.multasDelMomento();
		JOptionPane.showMessageDialog(null, listaMultas);
	}
	private static void multasDeUnUsuario() {
		String nombreUsuario=JOptionPane.showInputDialog("Ingrese el nombre del usuario que desea saber las multas");
		String listaMultas=biblioteca.listaMultasUsuario(nombreUsuario);
		JOptionPane.showMessageDialog(null, listaMultas);
	}
}
