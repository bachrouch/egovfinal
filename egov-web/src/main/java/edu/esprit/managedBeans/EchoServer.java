/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.managedBeans;
import java.io.IOException;
import java.util.Collections; 
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


 
/** 
 * @ServerEndpoint gives the relative name for the end point
 * This will be accessed via ws://localhost:8080/EchoChamber/echo
 * Where "localhost" is the address of the host,
 * "EchoChamber" is the name of the package
 * and "echo" is the address to access this class from the server
 */

/**
 *
 * @author MED
 */
@ServerEndpoint("/echo")
public class EchoServer {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
     /**
     * @OnOpen allows us to intercept the creation of a new session.
     * The session class allows us to send data to the user.
     * In the method onOpen, we'll let the user know that the handshake was 
     * successful.
     */
    private void sendMessageToAll(String message){
        for(Session s : sessions){
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
   @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " has opened a connection"); 
        sendMessageToAll("*Notification* : An onther member has just Joinded us !!! ");
        try {
            session.getBasicRemote().sendText("Your are now connected =D ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sessions.add(session);
    }
    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. For now the message is read as a String.
     */
     @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
        sendMessageToAll( " Dear Client: " + message);
    }
 
    /**
     * The user closes the connection.
     * 
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
        System.out.println("Session " +session.getId()+" has ended");
        sendMessageToAll("one of the members has just disconnected");
    }
}
