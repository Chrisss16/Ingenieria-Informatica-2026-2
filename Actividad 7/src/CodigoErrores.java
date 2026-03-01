/*
 * import java.util.ArrayList;

public class PruebaLista {

    public static void main(String[] args) {

        ArrayList lista = new ArrayList<String>();  Aunque "sirve" se debe declarar el tipo para que nolo malinterprete 

        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");

        System.out.println("Elemento en posición 3: " + lista.get(3));  Como empieza en cero este indice no existe (3), en realidad es 0,1,2

        for (int i = 0; i <= lista.size(); i++) {  i <= lista.size() es incorrecto, deberia ser <, como la cuenta comienza en cero, i seria amyor que el indice y marca error   
            System.out.println(lista.get(i));
        }

        lista.remove("Cuatro"); No es un error pero como no esta simplemente no borra nada

        System.out.println("Tamaño final: " + lista.length()); No se usa lenght es SIZE
    }
}
 * 
 */
import java.util.ArrayList;

public class CodigoErrores {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList();

        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");

        System.out.println("Elemento en posición 3: " + lista.get(2));

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        lista.remove("Cuatro");

        System.out.println("Tamaño final: " + lista.size());

    }
}