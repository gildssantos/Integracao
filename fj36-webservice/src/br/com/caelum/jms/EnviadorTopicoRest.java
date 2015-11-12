package br.com.caelum.jms;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;



public class EnviadorTopicoRest {

	@Resource(lookup="jms/RemoteConnectionFactory")
	ConnectionFactory factory;
	
	@Resource(lookup="jms/TOPICO.LIVRARIA")
	Destination topico;
	
	public void send(String msg) {
		
		JMSContext ctx = factory.createContext();
		ctx.createProducer().send(topico, msg);
		
	}
}
