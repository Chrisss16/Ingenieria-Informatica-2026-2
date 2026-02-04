import java.util.Scanner; //para funciones tipo input.nextInt();
import java.lang.Math;

public class Programa3{

	public static void main(String[] args) {
		int num1,num2,num3;
		double rand1,rand2;

		
		Scanner input=new Scanner(System.in); 
		System.out.println("Programa 3");
		System.out.println("Suma de dos numeros aleatorios");
		System.out.println("Teclee 0 para salir");
		while (true)
		{
			rand1 = Math.random();
			num1 =(int) (rand1*100);	
			rand2 = Math.random();
			num2 =(int) (rand2*100);
			System.out.println("Cuanto es "+num1 +"+" +num2 +"?"); 
			num3 = input.nextInt();
			if (num3==0)
			{
				System.out.println("Adios");
				break;
			}
			else if (num3==num1+num2)
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
