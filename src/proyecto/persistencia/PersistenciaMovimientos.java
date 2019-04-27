package proyecto.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import proyecto.validadores.Movimiento;

public class PersistenciaMovimientos {
	
	public boolean guardarMovimiento(String jugador, int initialX, int initialY, int finalX, int finalY) throws IOException {
		
		try {
            File path = new File("./movimientos.txt");
            FileWriter output = new FileWriter(path, true);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write(jugador + "," + initialX + "," + initialY + "," + finalX + "," + finalY);
            writer.newLine();
            writer.close();
            return true;

        } catch (Exception e) {
            e.getStackTrace();
            return false;
    }	
		
}		

	public ArrayList<String> leerMovimientos() throws IOException {
	    		
	    ArrayList<String> data = new ArrayList<>();
	    	try {
	    		File path = new File("movimientos.txt");
	            FileReader reader = new FileReader(path);
	            BufferedReader buffer = new BufferedReader(reader);
	            String datos;
	            while ((datos = buffer.readLine()) != null) {
	            	data.add(datos);
	            }
	            reader.close();
	            return data;

	            } catch (IOException e) {
	                throw e;
	       }	
	            
	   }
}
