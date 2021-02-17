package ar.com.sancorsalud.api.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ar.com.sancorsalud.api.exception.CamelCustomException;

public class MiProcesador implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String nombre = exchange.getIn().getBody(String.class);
		System.out.println("Hola "+nombre);
		
		if(nombre.equalsIgnoreCase("test"))
			throw new CamelCustomException();
	}

}
