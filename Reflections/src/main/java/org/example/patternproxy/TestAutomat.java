package org.example.patternproxy;

public class TestAutomat {
    Automat automat;
    public static void main(String args[])
    {
        TestAutomat t = new TestAutomat();
    }
    public TestAutomat()
    {
        automat = new Automat(9);
        System.out.println("1. " + automat.getState());
        automat.gotApplication();
        System.out.println("2. " + automat.getState());
        automat.checkApplication();
        System.out.println("3. " + automat.getState());
        automat.rentApartment();
        System.out.println("4. " + automat.getState());
    }
}
