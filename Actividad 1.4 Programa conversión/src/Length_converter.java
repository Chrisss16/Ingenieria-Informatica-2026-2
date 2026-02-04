import java.util.Scanner;

public class Length_converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int feet,inches;
		double cm;
		
		Scanner input = new Scanner(System.in); 
		System.out.println("Ingrese los pies: ");
		feet = input.nextInt();
		System.out.println("Ingrese las pulgadas: ");
		inches = input.nextInt();
		
		cm= ((feet*12)+inches)*2.54;
		
		System.out.println("El total fue: ");
	}

}
