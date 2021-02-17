package ar.com.sancorsalud.api;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import ar.com.sancorsalud.api.routes.SimpleRouteBuilder;

public class CamelRestIntegration {

	public static void main(String[] args) {
		SimpleRouteBuilder ruta = new SimpleRouteBuilder();
		CamelContext ctx = new DefaultCamelContext();
		try {
			ctx.addRoutes(ruta);
			ctx.start();
			Thread.sleep(5 * 60 * 1000);
			ctx.stop();
		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

}
