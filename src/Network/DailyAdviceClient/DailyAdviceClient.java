import java.io.*;
import java.net.*; // class Socket is in java.net

public class DailyAdviceClient {
    public void go() {
        try { // a lot can go wrong here
            Socket s = new Socket("127.0.0.1", 4242); // make a Socket connection to whatever is running on port 4242,
                                                      // on the same host this code is running on.(The 'localhost')

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            // Chain a BufferedReader to an InputStreamReader to the input stream from the
            // Socket
            BufferedReader reader = new BufferedReader(streamReader);

            /**
             * this realine() is exactly the same as if you were using a BufferedReader
             * chained to a FILE.
             * 
             * In otherwords, by the time you call a BufferedReader mehtod, the reader
             * doesn't know or care where the characters came from
             * 
             */
            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);

            // this close All the streams
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
