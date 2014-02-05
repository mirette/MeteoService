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
			System.err.println("Le pays que vous avez demandé n'est pas valide! Le choix par défaut (France) est activé.");
		}
		
		if(!data.getVille().equals(ville)){
			System.err.println("La ville que vous avez demandé n'est pas valide! Le choix par défaut (le capital du pays) est activé.");
		}
		
		//TODO Manipulé les données pour affichage
		System.out.println("Le météo de " + data.getPays() + ", " + data.getVille() + " est demandé par le client: '" + data.getClient()+"'");

	}

	private static String getClient() {
		return "Client java";
	}

}
