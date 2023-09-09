package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Pedido;
import modelo.Combo;
import modelo.Ingrediente;
import modelo.ProductoMenu;
import procesamiento.restaurante;

public class Aplicacion 
{
	private restaurante Restaurante;
	
	
	public Aplicacion () throws FileNotFoundException 
	{
		
		Restaurante = new restaurante();
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
		consola.imprimirMenu();
	}
	
	public void imprimirMenu()
	{
			System.out.println("1. Mostrar el Menú");
			System.out.println("2. Hacer un Pedido");
			System.out.println("3. Consultar un Pedido por Id");
			System.out.println("4. Salir");
		
	}	

	public void ejecutarAplicacion()
	{
		
		System.out.println("Menu\n");
		boolean bandera = true;
		while (bandera == true)
		{
			try
			{
				imprimirMenu();
				Scanner scanner = new Scanner(System.in);
				System.out.println("Escoja una opcion");
				int opcion_seleccionada = scanner.nextInt();
				
				if (opcion_seleccionada == 1) 
				{	
					
					Scanner scanner2 = new Scanner(System.in);
					System.out.println("Escoja a para productos individuales, b para combos y c para ingredientes adicionales");
					String tipo = scanner.nextLine();
					
					int a = 0;
					int b = 0;
					int c = 0;
					if (tipo == "a")
					{
					for (ProductoMenu productos: Restaurante.getMenuBase()) 
					{
						
						System.out.println( a+ ". " + productos);
						a++;
					}
					}
					
					if (tipo == "b")
					{
					for (Combo combos: Restaurante.getCombos()) {
						
						System.out.println( b + ". " + combos);
						b++;
					}
					}
					
					if (tipo == "c")
					{
					for (Ingrediente ingredientes: Restaurante.getIngredientes()) {
						
						System.out.println( c + ". " + ingredientes);
						c++;
					}
					}
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
					
			}
		
		
		
	}	
	}
}
