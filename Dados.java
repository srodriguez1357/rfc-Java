import java.util.concurrent.ThreadLocalRandom; //Utilizada para generar lso pseudoaleatorios
import javax.swing.JOptionPane;	//Utilizada para generar los popups

public class Dados {

	public static void main(String[] args) {
		int suma = 0;
		
		int dado_1 = ThreadLocalRandom.current().nextInt(1, 7); //Giro del primer dado
		int dado_2 = ThreadLocalRandom.current().nextInt(1, 7); //Giro del segundo dado 
		suma = dado_1 + dado_2; //Suma de ambos dados, usada para determinar resultado
		
		switch(suma) { //Usar suma para determinar si ganaste, perdiste u obtienes un punto
		case 11:			
		case 7:
			JOptionPane.showMessageDialog(null, "("+dado_1+","+dado_2+")"+"\n"+"Obtuviste "+suma+" puntos"+"\n"+" Ganaste la Apuesta" );
			break;
		case 2:
		case 3:
		case 12:
			JOptionPane.showMessageDialog(null, "("+dado_1+","+dado_2+")"+"\n"+"Obtuviste "+suma+" puntos"+"\n"+" Pierdes la Apuesta: Craps" );
			break;
		default:
			JOptionPane.showMessageDialog(null, "("+dado_1+","+dado_2+")"+"\n"+"Obtuviste "+suma+" puntos"+"\n"+" Obtienes un Punto" );
			break;
		}
	}

}
