package com.sanstwy27.designpattern.principle.ocp.after;

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
        graphicEditor.drawShape(new OtherGraphic());

        /**
         *  draw Rectangle
         *  draw Circle
         *  draw Triangle
         *  draw OtherGraphic
         */
    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }


}

abstract class Shape {
    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
    }

    @Override
    public void draw() {
        System.out.println(" draw Rectangle ");
    }
}

class Circle extends Shape {
    Circle() {
    }

    @Override
    public void draw() {
        System.out.println(" draw Circle ");
    }
}

class Triangle extends Shape {
    Triangle() {
    }

    @Override
    public void draw() {
        System.out.println(" draw Triangle ");
    }
}

class OtherGraphic extends Shape {
    OtherGraphic() {
    }

    @Override
    public void draw() {
        System.out.println(" draw OtherGraphic ");
    }
}