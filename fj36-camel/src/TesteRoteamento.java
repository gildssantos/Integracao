import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;


public class TesteRoteamento {

	
	public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				errorHandler(deadLetterChannel("file:falha")
						.useOriginalMessage()
						.maximumRedeliveries(15)
						.redeliveryDelay(2000)
						.retryAttemptedLogLevel(LoggingLevel.ERROR)
						);
			
				from("file:entrada?delay=5s")
				.to("validator:file:xsd/pedido.xsd")
				.log(LoggingLevel.INFO,"Enviado ${id}")
				.to("file:saida");
				
				
			}
		});
		
		context.start();
		Thread.sleep(30*1000);
		context.stop();
		
	}
}
