package org.academia;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by codecadet on 11/11/16.
 */
public class Client {

    private int portNumber = 4000;
    private String hostName = "localHost";
    private Scanner keyboardInput;
    private String message;
    private boolean connected = true;
    Socket clientSocket;

    public Client(int portNumber, String hostName) throws IOException {
        this.portNumber = portNumber;
        this.hostName = hostName;
        connected = true;
        keyboardInput = new Scanner(System.in);
        clientSocket = new Socket(hostName, portNumber);
    }

    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream());


    public void start() {

        while (connected)

        {
            System.out.println("User : " + clientSocket.getRemoteSocketAddress() + " says:\n");
            message = keyboardInput.nextLine();
            out.write(message);
            out.flush();
        }
    }

}
