package tpclient;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import fr.afcepf.atod19.soa.service.CalculTva;
import fr.afcepf.atod19.soa.service.CalculTvaImplService;
/*
set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_25
set WSDL_URL=http://localhost:8080/tpws/services/CalculTva?wsdl
cd /d "%~dp0"
"%JAVA_HOME%/bin/wsimport" -keep -d src/main/java    %WSDL_URL%
pause
REM + refresh eclipse
 */

public class TestWSApp {
	//a lancer via run as /java application
	//lorsque le serveur n'est pas arrêté !
	public static void main(String[] args) {
		// InterfaceWS proxyWS = (new ...Service()).get....Port()
		// selon code généré par wsimport
		CalculTva proxyWS = 
				(new CalculTvaImplService()).getCalculTvaImplPort();
		
		javax.xml.ws.BindingProvider bp = (javax.xml.ws.BindingProvider) proxyWS;
		
		Map<String,Object> context = bp.getRequestContext();
		/*context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
		"http://localhost:1234/myWebApp/services/calculateur");*/
		context.put(BindingProvider.USERNAME_PROPERTY,"user1");
		context.put(BindingProvider.PASSWORD_PROPERTY, "pwd1");
		
		System.out.println("tva="+proxyWS.tva(250.0, 20.0));
	}
}
