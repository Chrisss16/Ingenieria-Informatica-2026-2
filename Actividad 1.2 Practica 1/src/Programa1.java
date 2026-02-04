import java.util.Scanner;

public class Programa1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,lenght,la=0,lb=0, f=0;
		double x1,x2,det,aux;
		
		String polinomio,aa,bb,cc;
		Scanner input = new Scanner(System.in); 
		System.out.println("Programa 1");
		System.out.println("Ingrese un polinomio de la forma ax^2+bx+c");
		polinomio = input.nextLine();
		lenght = polinomio.length();
		System.out.println("Polinomio ingresado: "+polinomio);
		//System.out.println("Tamaño: "+lenght);
		for(int i=0;i<lenght;i++)
		{
			//System.out.println(polinomio.charAt(i)+"m");
			if(polinomio.charAt(i) == '^')
			{
				la = i-2; 
				f=1;
			}
			if(polinomio.charAt(i) == 'x' && f==1)
			{
				lb = i-1; 
			}
		}
		
		//System.out.println("posicioon a= "+la);
		//System.out.println("posicioon b= "+lb);
		aa = polinomio.substring(0, la+1);
		//System.out.println(aa);
		bb = polinomio.substring(la+4,lb+1);
		//System.out.println(bb);
		cc = polinomio.substring(lb+2,lenght);
		//System.out.println(cc);
		a= Integer.parseInt(aa);
		b= Integer.parseInt(bb);
		c= Integer.parseInt(cc);
		System.out.println("Los valores son a="+a+" b="+b+" c="+c );
		aux = (b*b)-(4*a*c);
		//System.out.println("Aux="+aux );
		if (aux > 0) 
		{
			det = Math.pow(aux, 0.5);
			x1 = (-b+det)/(2*a);
			x2 = (-b-det)/(2*a);
			System.out.println("x1 = " +x1);
			System.out.println("x2 = " +x2);
		}
		else if (aux < 0) 
		{
			System.out.println("Sin solucion real");
		}
		else if (aux == 0) 
		{
			x1 = (-b)/(2*a);
			System.out.println("x = " +x1);
		}
		
	}

}
