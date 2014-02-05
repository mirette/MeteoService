package com.upsud.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2014-02-04T15:13:45.083+01:00
 * Generated source version: 2.7.0
 * 
 */
@WebServiceClient(name = "WeatherServiceService", 
                  wsdlLocation = "http://localhost:8090/weatherservice?wsdl",
                  targetNamespace = "http://ws.upsud.com/") 
public class WeatherServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.upsud.com/", "WeatherServiceService");
    public final static QName WeatherServicePort = new QName("http://ws.upsud.com/", "WeatherServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8090/weatherservice?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WeatherServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8090/weatherservice?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WeatherServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WeatherServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WeatherServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns WeatherService
     */
    @WebEndpoint(name = "WeatherServicePort")
    public WeatherService getWeatherServicePort() {
        return super.getPort(WeatherServicePort, WeatherService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherService
     */
    @WebEndpoint(name = "WeatherServicePort")
    public WeatherService getWeatherServicePort(WebServiceFeature... features) {
        return super.getPort(WeatherServicePort, WeatherService.class, features);
    }

}
