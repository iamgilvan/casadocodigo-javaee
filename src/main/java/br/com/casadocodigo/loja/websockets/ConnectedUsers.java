package br.com.casadocodigo.loja.websockets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

import org.apache.log4j.Logger;

@ApplicationScoped
public class ConnectedUsers {
	
	private Set<Session> remoteUsers = new HashSet<>();
	private Logger       logger      = Logger.getLogger(ConnectedUsers.class);
	
	public boolean add(Session remoteUser){
		return this.remoteUsers.add(remoteUser);
	}
	
	public void send(String message){
		for (Session user : remoteUsers){
			if (user.isOpen()){
				try{
					user.getBasicRemote().sendText(message);					
				} catch (IOException ex){
					logger.error("Não foi possível enviar mensagem para um cliente, {}", ex);
				}
			}
		}
	}
}
