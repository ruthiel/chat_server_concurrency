package org.academia;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by codecadet on 11/11/16.
 */
public class ReadThread implements Runnable {

    Socket socket;
    BufferedReader in;

    public ReadThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }


    @Override
    public void run() {

        String message = "";

        while (socket.isBound()) {
            try {
                message = in.readLine();
                System.out.println(message);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
