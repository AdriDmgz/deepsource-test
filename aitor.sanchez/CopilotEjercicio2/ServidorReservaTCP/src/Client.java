
//Import the necessary libraries
import java.io.*;
import java.net.*;

public class Client {

    /*
     * It represents the client side of the application.
     * The protocol used is TCP.
     * It will ask the user to enter the seat's row and column.
     * It will send a string to the server, which contains the seat's row and
     * column.
     * It will receive a string from the server indicating the status of the
     * reservation.
     * It will ask the user to enter the seat's row and column again if the seat was
     * not found.
     * It wil exit if:
     * - the user enters 3 invalid seats
     * - the train is full
     */

    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        BufferedReader stdIn = null;
        String inputLine;
        String outputLine;
        String[] seat;
        int row;
        int column;
        int count = 0;
        try {
            echoSocket = new Socket("localhost", 4444);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: localhost.");
            System.exit(1);
        }
        out = new PrintWriter(echoSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        while (count < 3) {
            System.out.println("Enter the seat's row and column: ");
            inputLine = stdIn.readLine();
            seat = inputLine.split(" ");
            row = Integer.parseInt(seat[0]);
            column = Integer.parseInt(seat[1]);
            out.println(inputLine);
            outputLine = in.readLine();
            System.out.println(outputLine);
            if (outputLine.equals("Seat not found")) {
                count++;
            } else if (outputLine.equals("Train is full")) {
                break;
            }
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();

    }

}
