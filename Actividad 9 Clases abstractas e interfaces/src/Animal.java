
public abstract class Animal {
	private String nombre;
	private int edad;
	private float peso;
	private String habitat;
	private String cuidador;
	
	public abstract void hacerSonido(); // método abstracto
	void mostrarInfo() { // método que muestre la información del animal
		System.out.println("Nombre: " +nombre);
		System.out.println("Edad: " +edad);
		System.out.println("Peso: " +peso);
		System.out.println("Habitad: " +habitat);
		System.out.println("Cuidador: " +cuidador);
	} 
}
