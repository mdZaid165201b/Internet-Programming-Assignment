import java.util.Date;

abstract class Shape {
    private Date creationDateTime;

    // Non-parameterized constructor
    public Shape() {
        this.creationDateTime = new Date();
    }

    // Getter for creationDateTime
    public Date getCreationDateTime() {
        return creationDateTime;
    }

    // Abstract method for drawing the shape
    public abstract void draw();

    // Override toString method to display shape details
    @Override
    public String toString() {
        return "Shape [Created at: " + creationDateTime + "]";
    }
}

class Square extends Shape {
    private double sideLength;

    // Parameterized constructor
    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    // Getter and Setter for side length
    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    // Override the draw method for Square
    @Override
    public void draw() {
        System.out.println("Drawing a Square with side length: " + sideLength);
    }

    // Override toString method to display square details
    @Override
    public String toString() {
        return "Square [Side Length: " + sideLength + ", Created at: " + getCreationDateTime() + "]";
    }
}

class ShapeNode {
    private Shape shape;
    private ShapeNode next;

    public ShapeNode(Shape shape) {
        this.shape = shape;
        this.next = null;
    }

    public Shape getShape() {
        return shape;
    }

    public ShapeNode getNext() {
        return next;
    }

    public void setNext(ShapeNode next) {
        this.next = next;
    }
}

class ShapeLinkedList {
    private ShapeNode head;

    // Add a shape to the linked list
    public void addShape(Shape shape) {
        ShapeNode newNode = new ShapeNode(shape);
        if (head == null) {
            head = newNode;
        } else {
            ShapeNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Print the shapes in the linked list
    public void displayShapes() {
        ShapeNode current = head;
        while (current != null) {
            current.getShape().draw();
            System.out.println(current.getShape());
            current = current.getNext();
        }
    }
}

public class ShapeLinkedListExample {
    public static void main(String[] args) {
        ShapeLinkedList shapeList = new ShapeLinkedList();

        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                shapeList.addShape(new Square(5.0));
            } else if (i % 3 == 1) {
                shapeList.addShape(new Rectangle(4.0, 6.0));
            } else {
                shapeList.addShape(new Triangle(3.0, 7.0));
            }
        }

        shapeList.displayShapes();
    }
}