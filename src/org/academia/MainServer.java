package org.academia;

import java.io.IOException;

/**
 * Created by codecadet on 11/11/16.
 */
public class MainServer {
    public static void main(String[] args) throws IOException {

        Server myServer = new Server(4000);
        myServer.start();

    }
}
