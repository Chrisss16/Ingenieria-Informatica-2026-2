import java.util.ArrayList;

public class SistemaEstudiantes2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> estudiantes = new ArrayList();
		estudiantes.add("Christofer");
		estudiantes.add("Christofer1");
		estudiantes.add("Christofer2");
		estudiantes.add("Christofer3");
		estudiantes.add("Christofer4");
		estudiantes.add("Christofer5");
		
		for(String est: estudiantes)
		{
			System.out.println(est);
		}
		
		estudiantes.remove((String)"Christofer3");
		
		if (estudiantes.contains("Chris"))
		{
			System.out.println("El nombre existe");
		}
		else 
		{
			System.out.println("El nombre no existe");
		}
		for(String est: estudiantes)
		{
			System.out.println(est);
		}
	}

}
