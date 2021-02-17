package ar.com.sancorsalud.api.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import ar.com.sancorsalud.api.exception.CamelCustomException;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	         
		onException(CamelCustomException.class).process(new Processor() {
			public void process(Exchange exchange) {
				System.out.println("Manejando excepciones");
			}
		}).redeliveryPolicyRef("testRedeliveryPolicyProfile").log("Received body ").handled(true);;
		
		from("file:/Users/jggomez/Desktop/MensajePrueba/Mensaje1").process(new MiProcesador())
			.to("file:/Users/jggomez/Desktop/MensajePrueba/Mensaje2");
	    }

}
