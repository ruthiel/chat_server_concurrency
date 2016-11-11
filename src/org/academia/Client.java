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
    Socket clientSocket;

    BufferedReader in;
    DataOutputStream out;

    public Client(int portNumber, String hostName) throws IOException {
        this.portNumber = portNumber;
        this.hostName = hostName;
        keyboardInput = new Scanner(System.in);
        clientSocket = new Socket(hostName, portNumber);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new DataOutputStream(clientSocket.getOutputStream());

        Thread thread = new Thread(new ReadThread(clientSocket));
        thread.start();
    }

    public void start() throws IOException {

        while (clientSocket.isBound()) {

            message = keyboardInput.nextLine();
            out.write(message.getBytes());
            out.write("\n".getBytes());
            out.flush();
        }
    }
}


