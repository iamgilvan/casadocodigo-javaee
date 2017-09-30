package br.com.casadocodigo.loja.websockets;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/channel/sales")
public class SalesEndpoint {
	
	private ConnectedUsers connectedUsers;
	
	@OnOpen
	public void onNewUser(Session session){
		System.out.println("Principal "  + session.getUserPrincipal());
		System.out.println("Adicionou? " + connectedUsers.add(session));
	}
}
