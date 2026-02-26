
public class Principal {

	public static void main(String[] args) throws InterruptedException {

	    int sec0 = -1, sec1 = 0;

	    Clock reloj;

	    while (true) {

	        reloj = new Clock(); 

	        sec1 = reloj.getSeconds();

	        if (sec0 != sec1) {
	            System.out.print("Hora actual: ");
	            reloj.printTime();
	            System.out.println();
	            sec0 = sec1;
	        }
	        Thread.sleep(500);
	    }
	}
}
