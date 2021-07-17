
public class Condiciones
{
  private int tamano, velocidad;
  private double cantidadVelocidad;



  
  public Condiciones(int tamanoInicial)
  {
  	
    actualizaCondiciones(tamanoInicial);
  }
  
  //Metodo para generar un numero aleatorio dentro de un rango
  public int generaNumAleatorio(int limInf,int limSup)
  {
	  double valor;
	  Double resultado;
	  
	  valor=Math.floor(Math.random()*(limSup-limInf+1)) + limInf;
	  
	  resultado=new Double(valor);
	  
	  return resultado.intValue();
  }
  
  public void actualizaCondiciones(int tamano)
  {
	 int aleatorio;
	   
	
		
		
    this.tamano=generaNumAleatorio(5,50);
     

	
	if(tamano>=5  && tamano<=15)                               
	  cantidadVelocidad=generaNumAleatorio(5,45);
	  
	else if(tamano>10  && tamano<=35) 
		cantidadVelocidad=generaNumAleatorio(5,45);
		
	else if(tamano>=36  && tamano<=45) 
		cantidadVelocidad=generaNumAleatorio(5,45);
		
	
	

    this.velocidad=generaNumAleatorio(1,100);
     

	
	if(velocidad>=1  && velocidad<=50)                               
	  cantidadVelocidad=generaNumAleatorio(1,90);
	  
	else if(velocidad>51  && velocidad<=79) 
		cantidadVelocidad=generaNumAleatorio(1,90);
		
	else if(velocidad>=80  && velocidad<=85)
		cantidadVelocidad=generaNumAleatorio(1,90);
		
	
	aleatorio=generaNumAleatorio(0,1);
	 
  }
  
  
  public int getTamano()
  {
	  return tamano;
  }
    

  public double getPorcentajeVelocidad()
  {
	  return cantidadVelocidad;
	  
  }
}