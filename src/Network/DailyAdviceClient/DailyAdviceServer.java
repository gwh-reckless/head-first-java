import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;

public class DailyAdviceServer {
    String[] adviceList = { "Take smaller bites", "Go for the tight jeans. No they do NOT  make you look fat.",
            "One word:inappropriate", "Just for today, be honest. Tell your boss what you*really*think",
            "You might want to rethink that haircut." };

    public void go() {
        try {
            // ServerSocket make this server application 'listen' for the client requests on
            // port 4242 on the machine this code is running
            ServerSocket serverSock = new ServerSocket(4242);
            while (true) {
                // the accept method blocks (just sits there) until a request comes in, and then
                // the method returns a socket (on some anonymous port) for communicating with
                // the client
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } // close go

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
