import java.util.Scanner;

public class RollDice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); 
		int x=0;
		while(x<2 || x>13)
		{
			System.out.println("Ingrese un valor entre 2 y 12");
			System.out.println("Ingrese x: ");
			x = input.nextInt();
		}
		System.out.println("Numero de tiros: " +rollDice(x));
		
		
	}
	public static int rollDice(int x) {
		int c=0,d1=0,d2=0;
		while(d1+d2 != x)
		{
			c=c+1;
			d1 = (int)(Math.random()*100%6+1.0);
			d2 = (int)(Math.random()*100%6+1.0);
			//System.out.println("Intento " +c +" d1:" +d1+" d2:" +d2);
		}
		return c; 
	}

}