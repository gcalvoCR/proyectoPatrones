package proyecto.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import proyecto.jugador.Jugador;

public class PersistenciaMovimientos extends Plataforma{
	
	ArrayList<String>memoriaTemporal;
	
	public PersistenciaMovimientos() throws IOException {
		 File path = new File("./movimientos.txt");
		 memoriaTemporal = leerDato();
		 path.delete();
	}
		
	public boolean guardarDato(String movimientos)  {
		
		try {
            File path = new File("./movimientos.txt");
            FileWriter output = new FileWriter(path, true);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write(movimientos);
            writer.newLine();
            writer.close();
            return true;

        } catch (Exception e) {
            e.getStackTrace();
            return false;
    }	
		
}	
	
	
	public void guardarDatoDamas(String movimientos)  {
		
		try {
            File path = new File("./movimientosDamas.txt");
            FileWriter output = new FileWriter(path, true);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write(movimientos);
            writer.newLine();
            writer.close();
         

        } catch (Exception e) {
            e.getStackTrace();
        
    }	
		
}

	
	public ArrayList<String> leerDato() throws IOException {
	    		
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
	
	public ArrayList<String> leerDatoDamas() throws IOException {
	    		
	    ArrayList<String> data = new ArrayList<>();
	    	try {
	    		File path = new File("movimientosDamas.txt");
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
	
	public ArrayList<String> getMemoriaTemporal(){
		return this.memoriaTemporal;		
	}

	@Override
	protected void openConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void sendData(String Txt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<String> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void closeConnection() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void sendDataJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
	

	
}
