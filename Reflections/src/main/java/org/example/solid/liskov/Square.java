package org.example.solid.liskov;

public class Square extends Rectangle{
    @Override
    void setWidth(int w) {
        width = height = w;  // Forces both sides to stay equal
    }

    @Override
    void setHeight(int h) {
        width = height = h;
    }
}
