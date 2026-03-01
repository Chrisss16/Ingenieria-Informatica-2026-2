import java.util.ArrayList;
import java.util.Scanner;
public class MiniInventario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> producto = new ArrayList(); 
		Scanner input = new Scanner(System.in); 
		int R=0;
		while (true)
		{
			System.out.println("\n\n");
			System.out.println("Mini Inventario");
			System.out.println("Ingrese una opcion: ");
			System.out.println("1) Agregar producto");
			System.out.println("2) Eliminar producto");
			System.out.println("3) Ver productos");
			System.out.println("4) Ver cantidad de productos");
			System.out.println("5) Salir");
			R = input.nextInt();
			input.nextLine();
			if (R == 5)
			{
				System.out.println("ADIOS");
        		System.out.println("\n\n");
				break;
			}
			else 
			{
				switch (R) 
				{
	            	case 1:
	            		System.out.print("Ingrese el producto: ");
	            		String productoN = input.nextLine();
	            		producto.add(productoN);
	            		System.out.println("Producto agregado");
	            		System.out.println("\n\n");
	            		break;

	            	case 2:
	            		System.out.print("Producto a eliminar: ");
	            		String productoE = input.nextLine();

	            		if (producto.contains(productoE)) 
	            		{
	            			producto.remove(productoE);
	            			System.out.println("Producto eliminado");
	            			System.out.println("\n\n");
	            		} 
	            		else 
	            		{
	                    System.out.println("No existe el producto");
	                    System.out.println("\n\n");
	            		}
	            		break;

		            case 3:
		                System.out.println("Lista de productos:");
		                for (String p : producto) 
		                {
		                    System.out.println(p);
		                }
		                break;

		            case 4:
		            	System.out.println("Cantidad de productos: " +producto.size());
		            	System.out.println("\n\n");
		            	break;
		            default:
		            	System.out.println("Opcion no valida");
		            	System.out.println("\n\n");
	                	break;
				}
			}
			
		}
		
	}

}
