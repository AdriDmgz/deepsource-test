
//Import the necessary libraries
import java.io.*;
import java.net.*;

public class Server {

    /*
     * It represents the server side of the application.
     * The protocol used is TCP.
     * It contains a matrix of 10x9, which represents the seats of the train.
     * It receives a string from the client, which contains the seat's row and
     * column.
     * It checks if the seat is available, and if it is, it reserves it.
     * It sends a string to the client, which contains the seat's row and column,
     * and the status of the reservation.
     * The status can be: "Seat reserved", "Seat not available", "Seat not found"
     * if the row or column is not valid and "Train is full" if all the seats are
     * reserved.
     */

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String inputLine;
        String outputLine;
        String[] seat;
        int row;
        int column;
        int count = 0;
        int[][] seats = new int[10][9];
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while (count < 90) {
            inputLine = in.readLine();
            seat = inputLine.split(" ");
            row = Integer.parseInt(seat[0]);
            column = Integer.parseInt(seat[1]);
            if (row < 0 || row > 9 || column < 0 || column > 8) {
                outputLine = "Seat not found";
            } else if (seats[row][column] == 1) {
                outputLine = "Seat not available";
            } else {
                seats[row][column] = 1;
                outputLine = "Seat reserved";
                count++;
            }
            out.println(outputLine);
            if (count == 90) {
                outputLine = "Train is full";
                out.println(outputLine);
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }

}
