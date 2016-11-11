package org.academia;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by codecadet on 11/11/16.
 */
public class Server {

    private Vector<ClientHandler> container;
    private ServerSocket serverSocket;

    private int portNumber;
    ClientHandler clientHandler;

    public Server(int portNumber) throws IOException {
        this.portNumber = portNumber;
    }


    public void start() throws IOException {

        serverSocket = new ServerSocket(portNumber);
        container = new Vector<>();

        while (serverSocket.isBound()) {

            Socket clientSocket = serverSocket.accept();
            System.out.println("Welcome to 'Ruthi'Chat!!!\nBe Happy!");

            ClientHandler clientHandler = new ClientHandler(clientSocket, this);
            Thread thread = new Thread(clientHandler);
            thread.start();

            container.add(clientHandler); //add clientHandler to ArrayList
        }


    }

    public synchronized void sendAll(String message) throws IOException {
        for (int i = 0; i < container.size(); i++) {
            container.get(i).sendMessage(message);
        }
    }

}
