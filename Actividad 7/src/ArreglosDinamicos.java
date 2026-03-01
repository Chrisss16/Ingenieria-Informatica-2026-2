import java.util.ArrayList;

public class ArreglosDinamicos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<String> frutas = new ArrayList<>();
		 ArrayList<Integer> numeros = new ArrayList<>();
	        frutas.add("Manzana");
	        frutas.add("Plátano");
	        frutas.add("Naranja");
	        frutas.add("Fresa");
	        frutas.add("Mango");

	        System.out.println("Tamaño del ArrayList: " + frutas.size());

	        for (int i = 0; i < frutas.size(); i++) 
	        {
	            System.out.println(frutas.get(i));
	        }
	        for (String fruta : frutas) 
	        {
	            System.out.println(fruta);
	        }
	        
	        
	        for (int i = 1; i <= 10; i++) {
	            numeros.add(i);
	        }
	        
	        System.out.println("Valores:");
	        for (Integer num : numeros) {
	            System.out.println(num);
	        }
	        
	        numeros.set(4, 100);
	        numeros.remove(2);
	        System.out.println("Valores modificados:");
	        for (Integer num : numeros) {
	            System.out.println(num);
	        }
	}

}
/*
¿Qué sucede con los índices después de eliminar un elemento?
	se recorren
¿Cómo cambia el tamaño del ArrayList?
	es dinamico, se hace mas fgrande o mas pequeño 
*/