package weatherclient;

import java.util.Scanner;

import com.upsud.ws.Data;
import com.upsud.ws.WeatherService;
import com.upsud.ws.WeatherServiceService;



public class MonClient {

	public static void main(String[] args) {
		Scanner lectureClavier = new Scanner(System.in);
		System.out.print("Veuillez rentrer le pays : "); 
		String pays = lectureClavier.nextLine();
		
		System.out.print("Veuillez rentrer la ville : "); 
		String ville = lectureClavier.nextLine();

		WeatherServiceService serv  = new WeatherServiceService();
		WeatherService weatherServicePort = serv.getWeatherServicePort();
		Data data = weatherServicePort.getData(pays, ville, getClient());
		
		if(!data.getPays().equals(pays)){
			System.err.println("Le pays que vous avez demand� n'est pas valide! Le choix par d�faut (France) est activ�.");
		}
		
		if(!data.getVille().equals(ville)){
			System.err.println("La ville que vous avez demand� n'est pas valide! Le choix par d�faut (le capital du pays) est activ�.");
		}
		
		//TODO Manipul� les donn�es pour affichage
		System.out.println("Le m�t�o de " + data.getPays() + ", " + data.getVille() + " est demand� par le client: '" + data.getClient()+"'");

	}

	private static String getClient() {
		return "Client java";
	}

}
