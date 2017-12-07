package com.lafacilita;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	
	/*
	 Defina un rango de hasta 25 números usando dos variables.
Puede usar números negativos.
Debe usar valores de simple coma flotante (float).
Defina un valor de intervalo, es decir, cada cuanto se va a realizar la
operación, ejemplo: números del 1 al 25 pero la operación se hará cada
incremento de 0.3 al contador.
float inicio
float final
donde inicio < final, (final – inicio) <=25
float intervalo
donde 0.3 > intervalo <= 0.8
float x valor de sustitución de la función donde
inicio<=x<=final
	 */
	
	static float inicio;
	static float fin;
	static float intervalo;
	static float x;
	static String informacion;
	static String ruta = "/home/catarino/Documentos/mi_archivo2.txt";
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String cad = "";
		Scanner lector = new Scanner(System.in);
		boolean bandera = false;
		
		
		do {
			try {
				System.out.println("Defina inicio: ");
				//Capturar desde teclado
				cad = lector.nextLine();
				//Convertir de cadena a flotante
				inicio = Float.valueOf(cad);
				System.out.println("Defina intervalo: ");
				//Capturar desde teclado
				cad = lector.nextLine();
				intervalo = Float.valueOf(cad);
				operarFuncion3();
				
				
			}catch(NumberFormatException ex)
			{
				/*
				 * Manejar la posible excepción para asegurarse
				 * de que estamos ingresando un número
				 */
				
				System.out.println("Valor no válido, vuelva a intentar...");
				//Ir a la siguiente iteración
				continue;
				
			}
			bandera = true;
		}while(!bandera);
		
		
		
		
		
	}
	
	public static void operarFuncion() 
	{
		double y = 0;
		int cont = 0;
		x = inicio;
		informacion = "";
		do
		{
			y=(Math.pow(x, 2))+1;
			
			x += intervalo;
			System.out.println("X: "+String.format("%.4f", x)+" Y: "+String.format("%.4f", y));
			informacion += "X: "+String.format("%.4f", x)+" Y: "+String.format("%.4f", y)+"\n";
			cont++;
			
		}while(cont < 25);
	}
	
	public static void operarFuncion2() 
	{
		double y = 0;
		//int cont = 0;
		x = inicio;
		do
		{
			y=(Math.pow(x, 2))+1;
			
			
			System.out.println("X: "+String.format("%.4f", x)+" Y: "+String.format("%.4f", y));
			x += intervalo;
			//cont++;
			
		}while(x < 25);
	}
	
	public static void operarFuncion3() 
	{
		double y = 0;
		int cont = 0;
		x = inicio;
		informacion = "";
		float r = inicio + 25;
		while(x < r)
		{
			y=(Math.pow(x, 2))+1;
			
			
			System.out.println(cont+" - "+"X: "+String.format("%.4f", x)+" Y: "+String.format("%.4f", y));
			informacion += cont+" X: "+String.format("%.4f", x)+" Y: "+String.format("%.4f", y)+"\n";
			x += intervalo;
			cont++;
			
		}
		
		
		//Manejar el archivo
		if(FileManager.fileExists(ruta))
		{
			FileManager.writeFile(ruta, informacion);
		}
		else 
		{
			FileManager.createFile(ruta);
			FileManager.writeFile(ruta, informacion);
		}
		
		
	}
	
	//Forma simple
	public static void guardarArchivo()
	{
		//Clase archivo
		File file;
		//Clase buffer de escritura
		FileOutputStream fop;
		//Instanciar a File con una ruta de archivo
		file = new File("/home/catarino/Documentos/mi_archivo.txt");
		
		//Controlar la posible excepción de E/S
		try {
			//Instanciar al buffer de escritura y pasarle el archivo
			fop = new FileOutputStream(file);
			//Verificar que el archivo exista, y si no crearlo
			if(!file.exists())
			{
				//Crear el archivo en la ruta indicada
				file.createNewFile();
			}
			//Convertir la información a escribir en bytes
			byte[] misBytes = informacion.getBytes();
			//Escribir esos bytes en el archivo
			fop.write(misBytes);
			//Limpiar el buffer
			fop.flush();
			//Cerrar el buffer
			fop.close();
		
			System.out.println("Archivo guardado...");
			
		} catch ( IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
