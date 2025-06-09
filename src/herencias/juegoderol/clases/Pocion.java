package herencias.juegoderol.clases;

public class Pocion {
	
	private enum Tipo{VIDA, MANA};
	
	private Tipo tipoPocion;
	
	private int cantidad;
	
	public Pocion(String tipo, int cantidad) {
		
		switch (tipo) {
		
		case "MANA" ->{
			this.tipoPocion= Tipo.MANA;
		}
		default ->{
			this.tipoPocion= Tipo.VIDA;
		}
		
		}
		
		if(cantidad>0) {
			this.cantidad=cantidad;
		}
		
		
	}
	
	public String getTipoPocion() {
		return String.valueOf(this.tipoPocion);
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		boolean res=false;
		
		Pocion poc= (Pocion) obj;
		
		if(this.cantidad==poc.cantidad && this.tipoPocion== poc.tipoPocion) {
			res=true;
		}
		
		return res;
		
	}
	
	@Override
	public String toString() {
		
		String tipP= tipoPocion == Tipo.MANA? "Mana": "Vida";
		
		return tipP + ": "+ this.cantidad;
		
	}

}
