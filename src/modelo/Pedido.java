package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Pedido 
{
	private ArrayList<HashMap<String, Integer>> mapa;
	
	private Producto itemsPedido;
	
	private static int numeroPedidos;
	
	private int idPedido;
	
	private String nombreCliente;
	
	private String direccionCliente;
	

	public Pedido(String nombreCliente, String direccionCliente, ArrayList<HashMap<String, Integer>> mapa)
	{
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.mapa = mapa;
		Pedido.numeroPedidos = numeroPedidos + 1;
		this.idPedido = (int) (Math.random() * 1001);
	}
	
	
	

	public ArrayList<HashMap<String, Integer>> getMapa()
	{
		return mapa;
	}




	public void setMapa(ArrayList<HashMap<String, Integer>> mapa)
	{
		this.mapa = mapa;
	}




	public Producto getItemsPedido()
	{
		return itemsPedido;
	}




	public void setItemsPedido(Producto itemsPedido)
	{
		this.itemsPedido = itemsPedido;
	}




	public static int getNumeroPedidos()
	{
		return numeroPedidos;
	}




	public static void setNumeroPedidos(int numeroPedidos)
	{
		Pedido.numeroPedidos = numeroPedidos;
	}




	public int getIdPedido()
	{
		return idPedido;
	}




	public void setIdPedido(int idPedido)
	{
		this.idPedido = idPedido;
	}




	public String getNombreCliente()
	{
		return nombreCliente;
	}




	public void setNombreCliente(String nombreCliente)
	{
		this.nombreCliente = nombreCliente;
	}




	public String getDireccionCliente()
	{
		return direccionCliente;
	}




	public void setDireccionCliente(String direccionCliente)
	{
		this.direccionCliente = direccionCliente;
	}


    public String generarTextoFactura(Pedido pedido)
    {
    	int precio = 0;
    	ArrayList<HashMap<String, Integer>> listado = pedido.getMapa();
    	
    	for (HashMap<String, Integer> Mapa : listado)
    	{
    		for (Integer numero: Mapa.values())
    		{
    			precio = precio + numero;
    		}
    	}
    	
    	double valorConIVA = precio * 1.19;
    	double precioIVA = precio * 0.19;
        String factura = "Número de Pedido: " + idPedido + "\n";
        factura += "Nombre del Cliente: " + nombreCliente + "\n";
        factura += "Dirección del Cliente: " + direccionCliente + "\n";
        factura += "Precio neto: " + precio + "\n";
        factura += "Precio total: " + valorConIVA + "\n";
        factura += "Precio neto: " + precioIVA + "\n";
        
        
        return factura;
    }
	
    
    
	
	
	

}
