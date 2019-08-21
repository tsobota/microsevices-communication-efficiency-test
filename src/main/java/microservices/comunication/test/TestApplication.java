package microservices.comunication.test;

import java.io.IOException;

import microservices.comunication.test.services.http.receiver.HttpServiceReceiver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import microservices.comunication.test.services.http.transmitter.HttpServiceTransmitter;
import microservices.comunication.test.services.registration.RegistrationServer;

public class TestApplication {

    public static void main(String[] args) {
        String serverName = "NO-VALUE";

        switch (args.length) {
            case 2:
                // Optionally set the HTTP port to listen on, overrides
                // value in the <server-name>-server.yml file
                System.setProperty("server.port", args[1]);
                // Fall through into ..

            case 1:
                serverName = args[0].toLowerCase();
                break;

            default:
                usage();
                return;
        }

        if (serverName.equals("registration") || serverName.equals("reg")) {
            RegistrationServer.main(args);
        } else if (serverName.equals("http_transmitter")) {
            HttpServiceTransmitter.main(args);
        } else if (serverName.equals("http-receiver")) {
            HttpServiceReceiver.main(args);
        } else if (serverName.equals("all")) {
            runAll();
        } else {
            System.out.println("Unknown server type: " + serverName);
            usage();
        }
    }

    protected static void usage() {
        System.out.println("Usage: java -jar ... <server-name> [server-port]");
        System.out.println(
                "     where server-name is 'reg', 'registration', " + "'http_transmitter' or 'http-receiver' and server-port > 1024");
    }

    private static void runAll() {
        try {
            Runtime.getRuntime().exec("java -jar C:\\Users\\tkso\\private\\idea-projects\\microsevices-communication-efficiency-test\\targettest-0.0.1-SNAPSHOT.jar reg");
            Runtime.getRuntime().exec("java -jar C:\\Users\\tkso\\private\\idea-projects\\microsevices-communication-efficiency-test\\targettest-0.0.1-SNAPSHOT.jar http_transmitter");
            Runtime.getRuntime().exec("java -jar C:\\Users\\tkso\\private\\idea-projects\\microsevices-communication-efficiency-test\\targettest-0.0.1-SNAPSHOT.jar http-receiver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
