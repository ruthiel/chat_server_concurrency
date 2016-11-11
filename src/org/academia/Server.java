package org.academia;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by codecadet on 11/11/16.
 */
public class Server {


    private int portNumber;
    private boolean connected = true;
    ServerSocket serverSocket;
    private ArrayList<ClientHandler> container;
    ClientHandler clientHandler;

    public Server(int portNumber) throws IOException {
        this.portNumber = portNumber;
        connected = true;
    }


    public void start() throws IOException {

        serverSocket = new ServerSocket(portNumber);
        container = new ArrayList<>();

        while (serverSocket.isBound()) {

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client: " + clientSocket.getRemoteSocketAddress() + " get in!\n");

            ClientHandler clientHandler = new ClientHandler(clientSocket, this);
            Thread thread = new Thread(clientHandler);
            thread.start();

            container.add(clientHandler); //add clientHandler to ArrayList
        }


    }

    public void sendAll(String message) throws IOException {
        for (int i = 0; i < container.size(); i++) {
            container.get(i).sendMessage(message);
        }
    }

}
