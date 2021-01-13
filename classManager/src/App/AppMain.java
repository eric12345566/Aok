package App;
import Aok.*;

import java.io.IOException;

public class AppMain {
    public AppMain() throws IOException {
        // Main App
        Aok aok = new Aok(8020);

        // App Defined


        // Start App
        aok.startServer();
    }
}
