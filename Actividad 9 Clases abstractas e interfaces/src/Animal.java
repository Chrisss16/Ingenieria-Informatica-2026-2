
public abstract class Animal {
	private String name;
	private int age;
	private float weight;
	private String habitat;
	private String keeper;
	
	public Animal() {
		name = "Null";
		age = 0;
		weight = 0;
		habitat = "Null";
		keeper = "Null";
	}
	public Animal(String name1,int age1,float weight1,String habitat1,String keeper1) {
		name = name1;
		age = age1;
		weight = weight1;
		habitat = habitat1;
		keeper = keeper1;
	}
	
	public abstract void hacerSonido(); // método abstracto
	void mostrarInfo() { // método que muestre la información del animal
		System.out.println("Nombre: " +name);
		System.out.println("Edad: " +age);
		System.out.println("Peso: " +weight);
		System.out.println("Habitad: " +habitat);
		System.out.println("Cuidador: " +keeper);
	} 
}
