/*
 -EQUIPO MC-PAM
 Para compilar
  javac -classpath jfuzzylite-6.0.jar HiloAccion.java
 Para ejecutar
  java -classpath jfuzzylite-6.0.jar;. casoA
*/
  	import com.fuzzylite.Engine;
public class HiloAccion extends Thread
{
	  private int tamano;
	private HiloPercepcion percepcion;
	private int velocidad12;
   private double dificultad,velocidad;
   Engine engine;
	casoA casoa;


	public HiloAccion(HiloPercepcion percepcion)
	{
		 
      this.percepcion=percepcion;	 
	}
	
	public void realizaAjuste()
	{

	
	Condiciones c=percepcion.getCondiciones();
	  	  
	 casoa=new casoA();
	   engine=casoa.getEngine();
	    engine.setInputValue("Tamano",tamano);
	    engine.process();
	     engine.setInputValue("Velocidad",velocidad);
	     engine.process();

	
	  tamano=c.getTamano();
	  velocidad=c.getPorcentajeVelocidad();
         dificultad=engine.getOutputValue("Dificultad");
	   
	  
	  /* Reglas para el ajuste */
	  if(velocidad>=1 &&velocidad<=50)
	   velocidad12=0;
	   
	  else if(velocidad>= 51 && velocidad<=79)
	   velocidad12=1;

	   else
	   velocidad12=2;
	    
	   
	   despliegaStatus(tamano, velocidad,dificultad);
	   
	  
	}
	
	public void despliegaStatus(int tamano, double velocidad,double dificultad)
	{
		
		

	
//Uso del sistema

	   
	   System.out.println("CONDICIONES ACTUALES--Cuando la serpiente tiene un  tamano  de "+
	   String.valueOf(tamano) + " mm ,  y va a  una velocidad de "+ String.valueOf(velocidad) + " %  la dificultad es de:  " + dificultad );
	   
	   System.out.println();
	}
	
  public void run()
  {    
	
    try{
		while(true)
		{
			realizaAjuste();
			sleep(2000);
		}
	}catch(InterruptedException e){
	  System.out.println(e.getMessage());
	}
  }
}