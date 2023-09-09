package procesamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;

import modelo.Pedido;
import modelo.Combo;
import modelo.Ingrediente;
import modelo.ProductoMenu;


public class restaurante
{
	private ArrayList<Pedido> pedidos;
	private ArrayList<Combo> combos;
	private boolean pedidoEnProceso;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<HashMap<String, String>> pedidosPorId;
	
	
	public restaurante() throws FileNotFoundException  
	{
		
		CargarArchivosRest();
		pedidos = new ArrayList<Pedido>();
		this.pedidoEnProceso = false;
		pedidosPorId = new ArrayList<HashMap<String, String>>();
		
	}
	
		
	
	public ArrayList<Pedido> getPedidos()
	{
		return pedidos;
	}



	public void setPedidos(ArrayList<Pedido> pedidos)
	{
		this.pedidos = pedidos;
	}



	public ArrayList<Combo> getCombos()
	{
		return combos;
	}



	public void setCombos(ArrayList<Combo> combos)
	{
		this.combos = combos;
	}



	public boolean isPedidoEnProceso()
	{
		return pedidoEnProceso;
	}



	public void setPedidoEnProceso(boolean pedidoEnProceso)
	{
		this.pedidoEnProceso = pedidoEnProceso;
	}



	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}



	public void setIngredientes(ArrayList<Ingrediente> ingredientes)
	{
		this.ingredientes = ingredientes;
	}



	public ArrayList<ProductoMenu> getMenuBase()
	{
		return menuBase;
	}



	public void setMenuBase(ArrayList<ProductoMenu> menuBase)
	{
		this.menuBase = menuBase;
	}



	public ArrayList<HashMap<String, String>> getPedidosPorId()
	{
		return pedidosPorId;
	}



	public void setPedidosPorId(ArrayList<HashMap<String, String>> pedidosPorId)
	{
		this.pedidosPorId = pedidosPorId;
	}

	@Override
	public String toString() 
	{
		return "Numero pedidos=" + pedidos + ", combos=" + combos + ", Pedido en proceso=" + pedidoEnProceso
				+ ", ingredientes=" + ingredientes + ", menuBase=" + menuBase;
	}


	public void CargarArchivosRest() throws FileNotFoundException
	{
		String Menu = "data/menu.txt";
		String Combos = "data/combos.txt";
		String Ingredientes = "data/ingredientes.txt";
		
		cargaMenu(Menu);
		cargaCombos(Combos);
		cargaIngredientes(Ingredientes);
		
	}
	
	public void cargaMenu(String archivom) throws FileNotFoundException
	{
		try (BufferedReader buffer = new BufferedReader(new FileReader(archivom)))
		{
		ArrayList<ProductoMenu> menuBase = new ArrayList<>();
		String linea = buffer.readLine();
		while (linea != null)
		{
			String[] info = linea.split(";");
			String nombre = info[0];
			int PrecioBase = Integer.parseInt(info[1]);
			ProductoMenu nuevo = new ProductoMenu(nombre, PrecioBase);
			menuBase.add(nuevo);
			
			linea = buffer.readLine();
			
		}
		this.menuBase = menuBase;
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
	}
	
	public void cargaCombos(String archivoc) throws FileNotFoundException
	{
		try (BufferedReader buffer = new BufferedReader(new FileReader(archivoc)))
		{
			ArrayList<Combo> combos = new ArrayList<>();
			String linea = buffer.readLine();
			while (linea != null)
			{
				String[] info = linea.split(";");
				String nombreCombo = info[0];
				String por_des = info[1];
				por_des.replace("%", "");
				double descuento = Double.parseDouble(por_des);
				Combo nuevo = new Combo(descuento, nombreCombo);
				combos.add(nuevo);
				
				linea = buffer.readLine();
				
			}
			this.combos = combos;
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
		
		
	}
	
	public void cargaIngredientes(String archivoi) throws FileNotFoundException
	{
		try (BufferedReader buffer = new BufferedReader(new FileReader(archivoi)))
		{
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		String linea = buffer.readLine();
		while (linea != null)
		{
			String[] info = linea.split(";");
			String nombre = info[0];
			int PrecioBase = Integer.parseInt(info[1]);
			Ingrediente nuevo = new Ingrediente(nombre, PrecioBase);
			ingredientes.add(nuevo);
			
			linea = buffer.readLine();
			
		}
		this.ingredientes = ingredientes;
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
	}
	
	
	
	public HashMap<String, Integer> AgregarProductoAlPedido(int codigo_pr)
	{
		HashMap<String, Integer> mapa = new HashMap<>();
		
		if (codigo_pr >= 0 | codigo_pr <= 21) 
		{
			
			ProductoMenu producto = getMenuBase().get(codigo_pr);
			int precioBase = producto.getPrecioBase();
			String nombre = producto.getNombre();
			mapa.put(nombre, precioBase);
			
		}
		
		return mapa;
		
	}
	
	
	public HashMap<String, Integer> AgregarIngredienteAlPedido (int codigo_in) 
	{
		
		HashMap<String, Integer> mapa = new HashMap<>();
		
		if (codigo_in >= 0 | codigo_in <= 14) 
		{
			Ingrediente ingrediente = getIngredientes().get(codigo_in);
			int precio = ingrediente.getCostoAdicional();
			String nombre = ingrediente.getNombre();
			mapa.put(nombre, precio);
			
		}
		return mapa;
	
	
	
	}
	
	public HashMap<String, Integer> AgregarComboPedido (int codigo_com) 
	{
		
		HashMap<String, Integer> mapa = new HashMap<>();
		
		if (codigo_com == 0) {
			Combo cmb = getCombos().get(0);
			double preciocombo = 24500 - (24500*0.10);
			String nombrecombo = cmb.getNombreCombo();
			mapa.put(nombrecombo, (int) preciocombo);
		}
		
		if (codigo_com == 1) {
			Combo cmb = getCombos().get(1);
			double preciocombo = 26500 - (26500*0.10);
			String nombrecombo = cmb.getNombreCombo();
			mapa.put(nombrecombo, (int) preciocombo);
		}
		
		if (codigo_com == 2) {
			Combo cmb = getCombos().get(2);
			double preciocombo = 36900 - (36900*0.07);
			String nombrecombo = cmb.getNombreCombo();
			mapa.put(nombrecombo,(int) preciocombo);
		}
		
		if (codigo_com == 3) {
			Combo cmb = getCombos().get(3);
			double preciocombo = 34500 - (34500*0.07);
			String nombrecombo = cmb.getNombreCombo();
			mapa.put(nombrecombo,(int) preciocombo);
		}
		
		
		return mapa;
	}
	
	
	public void GuardarFacturaPedido (String factura, String nombre) 
	{
		try {
            
			String path = "data/" + nombre + ".txt";
			File file = new File(path);
			
			if (!file.exists()) 
			{
				file.createNewFile();
			}
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(factura);
            bufferedWriter.close();
            System.out.println("El archivo " + nombre + " se ha creado con éxito.");

        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
		
    }
	
	public String obtenerFactura(int id) 
	{
	    String IdPedido = Integer.toString(id);
	    File archivo = new File("data/" + IdPedido + ".txt");

	    if (!archivo.exists()) {
	        System.out.println("El archivo " + archivo.getName() + " no existe.");
	        return null;
	    }

	    try (FileInputStream inputStream = new FileInputStream(archivo);
	         Scanner scanner = new Scanner(inputStream)) 
	    {

	        System.out.println("Contenido de " + archivo.getName() + ":");

	        while (scanner.hasNextLine()) {
	            String linea = scanner.nextLine();
	            System.out.println(linea); 
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return IdPedido;
	}
	
	
	
	
	
}
