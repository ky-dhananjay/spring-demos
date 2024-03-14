package org.example.patternproxy;

import java.io.PrintWriter;

public class Automat implements AutomatInterface {
    State waitingState;
    State gotApplicationState;
    State apartmentRentedState;
    State fullyRentedState;
    State state;
    int count;
    PrintWriter out;
    public Automat(int n)
    {
        count = n;
        waitingState = new WaitingState(this);
        gotApplicationState = new GotApplicationState(this);
        apartmentRentedState = new ApartmentRentedState(this);
        waitingState = new WaitingState(this);
        state = waitingState;
    }
    public void gotApplication()
    {
        out.println(state.gotApplication());
    }
    public void checkApplication()
    {
        out.println(state.checkApplication());
    }
    public void rentApartment()
    {
        out.println(state.rentApartment());
        out.println(state.dispenseKeys());
    }
    @Override
    public State getWaitingState() {
        return waitingState;
    }
    @Override
    public State getGotApplicationState() {
        return gotApplicationState;
    }
    public State getApartmentRentedState()
    {
        return apartmentRentedState;
    }
    public State getFullyRentedState()
    {
        return fullyRentedState;
    }
    public int getCount()
    {
        return count;
    }
    public void setCount(int n)
    {
        count = n;
    }
    public void setState(State s)
    {
        state = s;
    }
    public State getState()
    {
        return state;
    }

}
