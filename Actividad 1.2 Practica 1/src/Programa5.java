import java.util.Scanner;

public class Programa5 {

    public static void main(String[] args) {

        float x1, y1, h1, w1;
        float x2, y2, h2, w2;

        Scanner input = new Scanner(System.in);

        System.out.println("Programa 5");
        System.out.println("Dos rectangulos en el espacio");

        System.out.print("Ingrese x1: ");
        x1 = input.nextFloat();
        System.out.print("Ingrese y1: ");
        y1 = input.nextFloat();
        System.out.print("Ingrese h1: ");
        h1 = input.nextFloat();
        System.out.print("Ingrese w1: ");
        w1 = input.nextFloat();

        System.out.print("Ingrese x2: ");
        x2 = input.nextFloat();
        System.out.print("Ingrese y2: ");
        y2 = input.nextFloat();
        System.out.print("Ingrese h2: ");
        h2 = input.nextFloat();
        System.out.print("Ingrese w2: ");
        w2 = input.nextFloat();

        float r1_xmin = x1 - w1 / 2;
        float r1_xmax = x1 + w1 / 2;
        float r1_ymin = y1 - h1 / 2;
        float r1_ymax = y1 + h1 / 2;

        float r2_xmin = x2 - w2 / 2;
        float r2_xmax = x2 + w2 / 2;
        float r2_ymin = y2 - h2 / 2;
        float r2_ymax = y2 + h2 / 2;

        System.out.println("\nRectangulo 1:");
        System.out.println("(" + r1_xmin + "," + r1_ymax + ")");
        System.out.println("(" + r1_xmax + "," + r1_ymax + ")");
        System.out.println("(" + r1_xmax + "," + r1_ymin + ")");
        System.out.println("(" + r1_xmin + "," + r1_ymin + ")");

        System.out.println("\nRectangulo 2:");
        System.out.println("(" + r2_xmin + "," + r2_ymax + ")");
        System.out.println("(" + r2_xmax + "," + r2_ymax + ")");
        System.out.println("(" + r2_xmax + "," + r2_ymin + ")");
        System.out.println("(" + r2_xmin + "," + r2_ymin + ")");

        if (r1_xmin <= r2_xmin &&
            r1_xmax >= r2_xmax &&
            r1_ymin <= r2_ymin &&
            r1_ymax >= r2_ymax) {

            System.out.println("\nRectangulo 1 contiene totalmente a Rectangulo 2");

        } else if (r1_xmax > r2_xmin &&
                   r1_xmin < r2_xmax &&
                   r1_ymax > r2_ymin &&
                   r1_ymin < r2_ymax) {

            System.out.println("\nRectangulo 1 intersecta parcialmente a Rectangulo 2");

        } else {
            System.out.println("\nNo hay interseccion entre los rectangulos");
        }
    }
}
