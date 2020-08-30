package com.sanstwy27.designpattern.principle.ocp.before;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 */

public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());

        /**
         *  draw Rectangle
         *  draw Circle
         *  draw Triangle
         */
    }
}

/**
 * [User] -><- Close principle
 */
class GraphicEditor {
    public void drawShape(Shape s) {
        // need modification if adding new type
        if (s.mType == 1)
            drawRectangle(s);
        else if (s.mType == 2)
            drawCircle(s);
        else if (s.mType == 3)
            drawTriangle(s);
    }

    public void drawRectangle(Shape r) {
        System.out.println(" draw Rectangle ");
    }

    public void drawCircle(Shape r) {
        System.out.println(" draw Circle ");
    }

    public void drawTriangle(Shape r) {
        System.out.println(" draw Triangle ");
    }
}

/**
 * [Provider] -> Open principle
 */
class Shape {
    int mType;
}

class Rectangle extends Shape {
    Rectangle() {
        super.mType = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.mType = 2;
    }
}

class Triangle extends Shape {
    Triangle() {
        super.mType = 3;
    }
}