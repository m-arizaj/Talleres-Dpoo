package modelo;

public class Combo
{
	private double descuento;
	
	private String nombreCombo;
	
	private ProductoMenu itemsCombo;
	

	public Combo(double descuento, String nombreCombo) 
	{
	    this.descuento = descuento;
	    this.nombreCombo = nombreCombo;
	}


	public double getDescuento()
	{
		return descuento;
	}



	public void setDescuento(double descuento)
	{
		this.descuento = descuento;
	}



	public String getNombreCombo()
	{
		return nombreCombo;
	}



	public void setNombreCombo(String nombreCombo)
	{
		this.nombreCombo = nombreCombo;
	}



	public ProductoMenu getItemsCombo()
	{
		return itemsCombo;
	}



	public void setItemsCombo(ProductoMenu itemsCombo)
	{
		this.itemsCombo = itemsCombo;
	}
	
	@Override
	public String toString()
	{
		return "Nombre combo: " + nombreCombo + ", Descuento: " + descuento;
	}
	
	
	
}
