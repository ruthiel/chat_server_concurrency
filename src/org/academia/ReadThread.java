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

    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    BufferedReader in;

    @Override
    public void run() {

        String message = "";

        while (socket.isBound()) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                message = in.readLine();
                System.out.println(message);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
