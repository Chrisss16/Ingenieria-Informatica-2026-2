import java.util.Scanner;

public class Programa2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1,b1,c1,a2,b2,c2,lenght1,lenght2,la1=0,lb1=0,la2=0,lb2=0;;
		double x,y;
		
		String polinomio1,polinomio2,aa1,bb1,cc1,aa2,bb2,cc2;
		Scanner input = new Scanner(System.in); 
		System.out.println("Programa 2");
		System.out.println("Ingrese un polinomio 1 de la forma ax+by=c");
		polinomio1 = input.nextLine();
		lenght1 = polinomio1.length();
		System.out.println("Polinomio ingresado: "+polinomio1);
		//System.out.println("Tamaño: "+lenght);
		for(int i=0;i<lenght1;i++)
		{
			//System.out.println(polinomio.charAt(i)+"m");
			if(polinomio1.charAt(i) == 'x')
			{
				la1 = i; 
			}
			if(polinomio1.charAt(i) == 'y')
			{
				lb1 = i; 
			}

		}
		System.out.println("Ingrese un polinomio de la forma ax+by=c");
		polinomio2 = input.nextLine();
		lenght2 = polinomio2.length();
		System.out.println("Polinomio 2 ingresado: "+polinomio2);
		//System.out.println("Tamaño: "+lenght);
		for(int i=0;i<lenght2;i++)
		{
			//System.out.println(polinomio.charAt(i)+"m");
			if(polinomio2.charAt(i) == 'x')
			{
				la2 = i; 
			}
			if(polinomio2.charAt(i) == 'y')
			{
				lb2 = i; 
			}

		}
		aa1 = polinomio1.substring(0, la1);
		bb1 = polinomio1.substring(la1+1,lb1);
		cc1 = polinomio1.substring(lb1+2,lenght1);
		a1= Integer.parseInt(aa1);
		b1= Integer.parseInt(bb1);
		c1= Integer.parseInt(cc1);
		System.out.println("Los valores del polinomio 1 son a="+a1+" b="+b1+" c="+c1 );
		aa2 = polinomio2.substring(0, la2);
		bb2 = polinomio2.substring(la2+1,lb2);
		cc2 = polinomio2.substring(lb2+2,lenght2);
		a2= Integer.parseInt(aa2);
		b2= Integer.parseInt(bb2);
		c2= Integer.parseInt(cc2);
		System.out.println("Los valores del polinomio 2 son a="+a2+" b="+b2+" c="+c2 );
		if (a1 * b2 - a2 * b1 == 0)
		{
			System.out.println("Sin solucion");
		}
		else 
		{
			x=(double)(c1*b2 - c2*b1)/(double)(a1*b2 - a2*b1);
			y=(double)(a1*c2 - a2*c1 )/(double)(a1*b2 - a2*b1);
			System.out.println("Las soluciones son x="+x+" y="+y);
		}
	}
}