package test;

import java.nio.charset.Charset;
import java.util.Random;

import javax.swing.JOptionPane;

public class Persona {

	private String nombre = ""; 
	private String NSS = "";
	private int edad  = 0;
	Sexo sexo = Sexo.HOMBRE;
	private double peso = 0;
	private double altura = 0; 
	
	public Persona() {
		
	}
	
	public Persona(String nombre, String NSS, int edad, Sexo sexo, double peso, double altura ) {
		this.nombre = nombre;
		this.edad = edad;
		this.NSS = NSS;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public int calcularIMC(double peso, double altura, Sexo sexo){
		int res = 0;
		
		double calcular = (peso /(Math.pow(altura, 2)));
		
		if(sexo.equals(Sexo.HOMBRE)) {
			if(calcular < 20)
				res = Response.PORDEBAJO.getResponse();
			else if( calcular >= 20 && calcular <= 25)
				res = Response.PESOIDEAL.getResponse();
			else if( calcular > 5)
				res = Response.SOBREPESO.getResponse();
		}else {
			if(calcular < 19)
				res = Response.PORDEBAJO.getResponse();
			else if( calcular >= 19 && calcular <= 24 )
				res = Response.PESOIDEAL.getResponse();
			else if( calcular > 24 )
				res = Response.SOBREPESO.getResponse();
		}
		
		return res;
	}
	
	public boolean esMayorDeEdad(int edad) {
		if(edad >= 18)
			return true;
		
		return false;
	}
	private boolean comprobarSexo(Sexo sexo) {
		if(sexo.equals(Sexo.HOMBRE) || sexo.equals(Sexo.MUJER))
			return true;
		return false;
	}
	public StringBuilder toString(String nombre, int edad, Sexo sexo, double peso, double altura) {
		 StringBuilder Datos = new StringBuilder(); 
		 
		 Datos.append("Datos \n");
		 Datos.append("Nombre: "+ nombre + "\n"); 
		 Datos.append("Edad: "+ edad + "\n"); 
		 Datos.append("NSS: "+ generaNSS() + "\n"); 
		 Datos.append("Sexo: "+ sexo.toString() + "\n"); 
		 Datos.append("Peso: "+ peso + "\n"); 
		 Datos.append("Altura: "+ altura + "\n"); 
		return Datos;
	}
	
	private String generaNSS() {
		 String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	     StringBuilder cadena = new StringBuilder();
	        Random rnd = new Random();
	        while (cadena.length() < 8) { 
	            int index = (int) (rnd.nextFloat() * letras.length());
	            cadena.append(letras.charAt(index));
	        }
	    String NSS = cadena.toString();
	        
		 return NSS;
	}
	
	
	public String getNomber() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public Sexo getSexo() {
		return sexo;
	}
	
	public double getPeso() {
		return peso;
	}
	public double getAltura() {
		return altura;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	

	
	
}
