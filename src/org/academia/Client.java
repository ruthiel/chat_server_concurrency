package org.academia;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by codecadet on 11/11/16.
 */
public class Client {

    private int portNumber;
    private String hostName;
    private Scanner keyboardInput;
    private String message;
    Socket clientSocket;

    BufferedReader in;
    DataOutputStream out;

    public Client(String hostName, int portNumber) throws IOException {
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