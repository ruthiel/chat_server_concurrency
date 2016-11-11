package org.academia;

import java.io.IOException;

/**
 * Created by codecadet on 11/11/16.
 */
public class MainClient {
    public static void main(String[] args) throws IOException {

        Client myClient = new Client(5000, "localhost");
        myClient.start();

    }
}
