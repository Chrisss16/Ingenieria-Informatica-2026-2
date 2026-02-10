import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); 
		int num,ad=-1;
		num = (int)(Math.random()*100.0);
		//System.out.println(num);
		System.out.println("Adivinar el numero");
		while(ad != num)
		{
			System.out.println("Ingrese un valor entre 1 y 100");
			ad = input.nextInt();
			if(ad > num)
			{
				System.out.println("El numero es menor que " +ad);
			}
			if(ad < num)
			{
				System.out.println("El numero es mayor que " +ad);
			}
		}
		System.out.println("Felicidades acertaste");
	}

}
