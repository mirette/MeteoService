package weatherclient;

import java.io.StringReader;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import com.mirette.weather.Weather;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class WeatherClient {

	public static void main(String [] args) throws JAXBException{

		Scanner lectureClavier  = new Scanner(System.in);

		System.out.print("Veuillez saisir un pays "); 
		String pays = lectureClavier.nextLine();

		System.out.print("Veuillez saisir une ville "); 
		String ville = lectureClavier.nextLine();

		GlobalWeather globalWeather = new GlobalWeather();
		GlobalWeatherSoap globalWeatherSoap = globalWeather.getGlobalWeatherSoap();
		String weatherXML = globalWeatherSoap.getWeather(ville, pays);

		System.out.println(weatherXML);

		JAXBContext context = JAXBContext.newInstance("com.mirette.weather");
		Weather weather = unmarshaller(context, weatherXML);

		System.out.println("Weather :"
				+ "Location : " + weather.getLocation()+"\n"
				+ "Time : " + weather.getTime()+"\n"
				+ "Wind : " + weather.getWind()+"\n"
				+ "Visibility : " + weather.getVisibility()+"\n"
				+ "SkyConditions : " + weather.getSkyConditions()+"\n"
				+ "Temperature : " + weather.getTemperature()+"\n"
				+ "DewPoint : " + weather.getDewPoint()+"\n"
				+ "Relatihttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1139veHumidity : " + weather.getRelativeHumidity()+"\n"
				+ "Pressure : " + weather.getPressure()+"\n"
				+ "Status : " + weather.getStatus());


		marshaller(context);
	}


	private static void marshaller(JAXBContext context) throws JAXBException, PropertyException {
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		Weather weather = new Weather();
		marshaller.marshal(weather, System.out);
	}

	private static Weather unmarshaller(JAXBContext context, String weatherXML) throws JAXBException {
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = new StringReader(weatherXML);
		Weather weather = (Weather) unmarshaller.unmarshal(reader);
		return weather;
	}
}
