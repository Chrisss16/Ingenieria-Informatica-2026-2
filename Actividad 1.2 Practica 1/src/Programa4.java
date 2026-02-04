import java.util.Scanner; //para funciones tipo input.nextInt();
import java.lang.Math;

public class Programa4{

	public static void main(String[] args) {
		int num1,num2,num3,num4;
		double rand1,rand2,rand3;

		
		Scanner input=new Scanner(System.in); 
		System.out.println("Programa 4");
		System.out.println("Suma de tres numeros aleatorios de un solo digito");
		System.out.println("Teclee 0 para salir");
		while (true)
		{
			rand1 = Math.random();
			num1 =(int) (rand1*10);	
			rand2 = Math.random();
			num2 =(int) (rand2*10);
			rand3 = Math.random();
			num3 =(int) (rand3*10);
			System.out.println("Cuanto es "+num1 +"+" +num2 +"+" +num3 +"?"); 
			num4 = input.nextInt();
			if (num4==0)
			{
				System.out.println("Adios");
				break;
			}
			else if (num4==num1+num2+num3)
			{
				System.out.println("Bien");
			}
			else
			{
				System.out.println("Todo wey");
			}
		}
		
	}

}