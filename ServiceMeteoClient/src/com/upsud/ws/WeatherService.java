package com.upsud.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2014-02-04T15:13:45.060+01:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://ws.upsud.com/", name = "WeatherService")
@XmlSeeAlso({ObjectFactory.class})
public interface WeatherService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getData", targetNamespace = "http://ws.upsud.com/", className = "com.upsud.ws.GetData")
    @WebMethod
    @ResponseWrapper(localName = "getDataResponse", targetNamespace = "http://ws.upsud.com/", className = "com.upsud.ws.GetDataResponse")
    public com.upsud.ws.Data getData(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );
}