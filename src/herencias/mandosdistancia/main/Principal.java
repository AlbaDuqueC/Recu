package herencias.mandosdistancia.main;

import herencias.mandosdistancia.clases.AireAcondicionado;
import herencias.mandosdistancia.clases.Aspiradora;
import herencias.mandosdistancia.clases.Minicadena;
import herencias.mandosdistancia.clases.Television;
import herencias.mandosdistancia.excepciones.DimensionNegativaException;
import herencias.mandosdistancia.excepciones.PrecioNegativoException;

public class Principal {

	public static void main(String[] args) {
		
		try {
			Television mandoTele = new Television("TCL", 10, 30, 10.5);
			Minicadena mandoMinicadena = new Minicadena("LG", 5, 20, 7.8);
			Aspiradora mandoAspiradora = new Aspiradora("Syson", 5, 10, 6);
			AireAcondicionado mandoAireAcondicionado = new AireAcondicionado("Daikin", 4, 6, 5.6) ;
			
			System.out.println("1. Antes de encender: ");
			System.out.println((mandoTele.isEncendido()) ? "Encendido" : "Apagado");
			mandoTele.encenderApagar();
			System.out.println((mandoTele.isEncendido()) ? "Encendido" : "Apagado");
			
			System.out.println("\n\n2. Si es de televisión:");
			System.out.println("\ta. Cambiar el canal.");
			mandoTele.cambiarCanal(3);
			System.out.println("\t\t" +mandoTele.getCanal());
			System.out.println("\tb. Subir el volumen.");
			mandoTele.subirVolumen();
			System.out.println("\t\t" +mandoTele.getVolumen());
			mandoTele.subirVolumen();
			System.out.println("\t\t" +mandoTele.getVolumen());
			
			System.out.println("\tc. Bajar el volumen.");
			mandoTele.bajarVolumen();
			System.out.println("\t\t" +mandoTele.getVolumen());
			
			System.out.println("3. Si es de minicadena:");
			System.out.println("\tb. Subir el volumen.");
			mandoMinicadena.subirVolumen();
			System.out.println("\t\t" +mandoMinicadena.getVolumen());
			mandoMinicadena.subirVolumen();
			System.out.println("\t\t" +mandoMinicadena.getVolumen());
			
			System.out.println("\tc. Bajar el volumen.");
			mandoMinicadena.bajarVolumen();
			System.out.println("\t\t" +mandoMinicadena.getVolumen());
			
			System.out.println("4. Si es de aspiradora:");
			System.out.println("\ta. Subir velocidad.");
			mandoAspiradora.subirVelocidad();
			System.out.println("\t\t" + mandoAspiradora.getVelocidad());
			mandoAspiradora.subirVelocidad();
			System.out.println("\t\t" + mandoAspiradora.getVelocidad());
			mandoAspiradora.subirVelocidad();
			System.out.println("\t\t" + mandoAspiradora.getVelocidad());
			mandoAspiradora.subirVelocidad();
			System.out.println("\t\t" + mandoAspiradora.getVelocidad());
			
			System.out.println("\tb. Bajar velocidad.");
			mandoAspiradora.bajarVelocidad();
			System.out.println("\t\t" + mandoAspiradora.getVelocidad());
			
			System.out.println("5. Si es de aire acondicionado:");
			System.out.println("\ta. Cambiar el modo.");
			System.out.println("\t\t" +mandoAireAcondicionado.getModoAire());
			mandoAireAcondicionado.cambiarModoAire();
			System.out.println("\t\t" +mandoAireAcondicionado.getModoAire());
			
			System.out.println("\tb. Cambiar la temperatura.");
			System.out.println("\t\t" +mandoAireAcondicionado.getTemperatura());
			mandoAireAcondicionado.subirTemperatura();
			mandoAireAcondicionado.subirTemperatura();
			System.out.println("\t\t" +mandoAireAcondicionado.getTemperatura());
			mandoAireAcondicionado.bajarTemperatura();
			
			System.out.println("\tc. Subir velocidad.");
			System.out.println("\t\t" +mandoAireAcondicionado.getVelocidad());
			mandoAireAcondicionado.subirVelocidad();
			mandoAireAcondicionado.subirVelocidad();
			System.out.println("\t\t" +mandoAireAcondicionado.getVelocidad());
			
			
			System.out.println("\td. Bajar velocidad.");
			mandoAireAcondicionado.bajarVelocidad();
			System.out.println("\t\t" +mandoAireAcondicionado.getVelocidad());
			
			
		} catch (DimensionNegativaException | PrecioNegativoException e) {
			
			System.out.println(e.getMessage());
		}

	}

}
