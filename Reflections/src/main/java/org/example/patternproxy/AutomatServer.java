package org.example.patternproxy;

import java.io.*;
import java.net.*;

public class AutomatServer implements Runnable, AutomatInterface {
    State waitingState;
    State gotApplicationState;
    State apartmentRentedState;
    State fullyRentedState;
    State state;
    int count;
    private Thread thread;
    ServerSocket socket;
    PrintWriter out;
    Socket communicationSocket;
    public static void main(String args[])
    {
        AutomatServer d = new AutomatServer();
    }
    public AutomatServer()
    {
        count = 9;
        waitingState = new WaitingState(this);
        gotApplicationState = new GotApplicationState(this);
        apartmentRentedState = new ApartmentRentedState(this);
        waitingState = new WaitingState(this);
        state = waitingState;
        try {
            socket = new ServerSocket(8765);
            communicationSocket = socket.accept();
            out = new PrintWriter(communicationSocket.getOutputStream(), true);
            thread = new Thread(this);
            thread.start();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    public void run()
    {
        String incomingString;
        try {
            BufferedReader in = new BufferedReader (new
                InputStreamReader(communicationSocket.getInputStream()));
            while((incomingString = in.readLine()) != null){
                if (incomingString.equals("gotApplication")){
                    gotApplication();
                } else if (incomingString.equals("checkApplication")) {
                    checkApplication();
                } else if (incomingString.equals("rentApartment")) {
                    rentApartment();
                }
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void gotApplication() {

    }

    @Override
    public void checkApplication() {

    }

    @Override
    public void rentApartment() {

    }

    @Override
    public void setState(State s) {

    }

    @Override
    public State getWaitingState() {
        return null;
    }

    @Override
    public State getGotApplicationState() {
        return null;
    }

    @Override
    public State getApartmentRentedState() {
        return null;
    }

    @Override
    public State getFullyRentedState() {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void setCount(int n) {

    }
}
