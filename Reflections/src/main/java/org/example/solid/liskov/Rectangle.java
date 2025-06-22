package org.example.solid.liskov;

public class Rectangle {
    int width, height;

    void setWidth(int w) { width = w; }
    void setHeight(int h) { height = h; }

    int getArea() { return width * height; }
}
