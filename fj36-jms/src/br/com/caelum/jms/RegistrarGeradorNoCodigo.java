package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistrarGeradorNoCodigo {
	
	
	public static void main(String[] args) throws NamingException {
		
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		
		Topic topico = (Topic) ic.lookup("jms/TOPICO.LIVRARIA");
		
		try(JMSContext context = factory.createContext("jms","jms2")) {
			
			context.setClientID("GeradorEbook");
			
			JMSConsumer consumer = context.createDurableConsumer(topico, "AssinaturaEbook","formato='ebook'",false);
			consumer.setMessageListener(new TratadorDeMessagem());
			
			context.start();
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Gerador esperando as mensagens do topico");
			System.out.println("Aperte enter para fechar a conexao");
			
			teclado.nextLine();
			teclado.close();
			context.stop();
			
			
		}
	}

}
