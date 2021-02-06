import javax.swing.JOptionPane;	//Utilizada para generar los pop-ups

public class RFC {

	public static void main(String[] args) {
		int cantidad = 0;
		String letrasfinal = null; //Almacena la parte de letras del RFC
		String nombrefin = null; //Almacena el nombre que se mostrar� al final
		String rfc = null; //Almacena el RFC
		cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de RFCs que desea contruir "));
		String[] rfcs = new String[cantidad]; //Almacena todos los RFCs creados
		
		for(int i=0;i<cantidad;i++) {
			String nombre = JOptionPane.showInputDialog("Nombre:").toUpperCase().strip();
			
			nombrefin = nombre; 
			
			//Eliminar espacios que no est�n al principio ni al final
			nombre = nombre.replaceAll("\\s+","");
			
			//Eliminar acentos sin usar librer�as, funciones o herramientas externas
			nombre = nombre.replaceAll("[�����]","E");
			nombre = nombre.replaceAll("[���]","U");
			nombre = nombre.replaceAll("[���]","I");
			nombre = nombre.replaceAll("[���]","A");
			nombre = nombre.replaceAll("[��]","O");
			
			
			String paterno = JOptionPane.showInputDialog("Apellido Paterno:").toUpperCase().strip();
			nombrefin = nombrefin + " " +paterno;
			//Eliminar preposiciones
			//Se agrega un espacio al principio para poder indentificar las preposiciones
			paterno = " " + paterno;
			
			paterno = paterno.replaceAll(" Y "," ");
			paterno = paterno.replaceAll(" DE "," ");
			paterno = paterno.replaceAll(" LA "," ");
			paterno = paterno.replaceAll(" LAS "," ");
			paterno = paterno.replaceAll(" EL "," ");
			paterno = paterno.replaceAll(" LOS "," ");
			
			//Eliminar espacios 
			paterno = paterno.replaceAll("\\s+","");
			
			paterno = paterno.replaceAll("[�����]","E");
			paterno = paterno.replaceAll("[���]","U");
			paterno = paterno.replaceAll("[���]","I");
			paterno = paterno.replaceAll("[���]","A");
			paterno = paterno.replaceAll("[��]","O");
			
			String materno = JOptionPane.showInputDialog("Apellido Materno:").toUpperCase().strip();
			nombrefin = nombrefin + " " + materno;
			
			materno = " " + materno;
			materno = materno.replaceAll(" Y "," ");
			materno = materno.replaceAll(" DE "," ");
			materno = materno.replaceAll(" LA "," ");
			materno = materno.replaceAll(" LAS "," ");
			materno = materno.replaceAll(" EL "," ");
			materno = materno.replaceAll(" LOS "," ");
			
			materno = materno.replaceAll("\\s+","");
			
			materno = materno.replaceAll("[�����]","E");
			materno = materno.replaceAll("[���]","U");
			materno = materno.replaceAll("[���]","I");
			materno = materno.replaceAll("[���]","A");
			materno = materno.replaceAll("[��]","O");
			
			//Agrega el 0 si el usuario no lo hace
			String dia = JOptionPane.showInputDialog("D�a de Nacimiento (01-31):").replaceAll("\\s+","");
			if(dia.length() < 2) {
				dia = '0' + dia;
			}
			
			//Ver si el d�a se encuentra en el rango solicitado
			int dianum =Integer.parseInt(dia);
			if(dianum<1||dianum>31) {
				dia = "01";
			}
			
			String mes = JOptionPane.showInputDialog("Mes de Nacimiento (01-12):").replaceAll("\\s+","");
			if(mes.length() < 2) {
				mes = '0' + mes;
			}
			
			int mesnum =Integer.parseInt(mes);
			if(mesnum<1||mesnum>12) {
				mes = "01";
			}
			
			String anio = JOptionPane.showInputDialog("A�o de Nacimiento (1920-2000):").replaceAll("\\s+","");
			int anionum =Integer.parseInt(anio);
			if(anionum<1920||anionum>2000) {
				anio = "1920";
			}
			
			//Obtener el d�gito del a�o por posici�n
			String anio1 = Character.toString(anio.charAt(2));
			String anio2 = Character.toString(anio.charAt(3));
			String anioF = anio1+anio2;
	
			//Concatenar los d�gitos del a�o, con los del mes y del d�a
			String numerosfinal = anioF + mes + dia;
			
			String paterno1 = Character.toString(paterno.charAt(0));
			String paterno2 = Character.toString(paterno.charAt(1));
			String paternoF = paterno1 + paterno2;
			
			if(materno.isEmpty()==false) {
				letrasfinal = paternoF + materno.charAt(0)+ nombre.charAt(0);
			}
			else {
				String nombre1 = Character.toString(nombre.charAt(0));
				String nombre2 = Character.toString(nombre.charAt(1));
				letrasfinal = paternoF + nombre1 + nombre2;
			}
			
			//Concatenar todo para crear el RFC
			rfc = letrasfinal+numerosfinal;
			
			//Agregar el RFC reci�n creado al arreglo
			rfcs[i] = rfc;
			
			//Mostrar el RFC final
			JOptionPane.showMessageDialog(null, "El RFC de "+nombrefin+" es "+rfc);
		}
		

	}

}
