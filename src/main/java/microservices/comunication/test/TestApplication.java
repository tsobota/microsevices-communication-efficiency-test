package microservices.comunication.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import microservices.comunication.test.http.HttpServiceTransmitter;
import microservices.comunication.test.registration.RegistrationServer;

@SpringBootApplication
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
        } else if (serverName.equals("accounts")) {
            HttpServiceTransmitter.main(args);
        } else {
            System.out.println("Unknown server type: " + serverName);
            usage();
        }
    }

    protected static void usage() {
        System.out.println("Usage: java -jar ... <server-name> [server-port]");
        System.out.println(
                "     where server-name is 'reg', 'registration', " + "'accounts' or 'web' and server-port > 1024");
    }

}
