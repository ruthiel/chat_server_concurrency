package org.academia;

import java.io.*;
import java.net.Socket;

/**
 * Created by codecadet on 11/11/16.
 */
public class ClientHandler implements Runnable {

    Socket socket;
    Server server;

    BufferedReader in;
    DataOutputStream out;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
    }


    @Override
    public void run() {
        String message = "";

        while (true) {

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new DataOutputStream(socket.getOutputStream());

                message = in.readLine();
                server.sendAll(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) throws IOException {
        out.write(message.getBytes());
        out.write("\n".getBytes());
        out.flush();

    }
}
