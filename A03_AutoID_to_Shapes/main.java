import java.util.Date;

class Shape {
    private static int autoID = 1;
    private int id;
    private Date creationDateTime;

    // Non-parameterized constructor
    public Shape() {
        this.id = autoID++;
        this.creationDateTime = new Date();
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for creationDateTime
    public Date getCreationDateTime() {
        return creationDateTime;
    }

    // Override toString method to display shape details
    @Override
    public String toString() {
        return "Shape [ID: " + id + ", Created at: " + creationDateTime + "]";
    }
}

class Square extends Shape {
    private double sideLength;

    // Parameterized constructor
    public Square(double sideLength) {
        super();
        this.sideLength = sideLength;
    }

    // Getter and Setter for side length
    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    // Override toString method to display square details
    @Override
    public String toString() {
        return "Square [ID: " + getId() + ", Side Length: " + sideLength + ", Created at: " + getCreationDateTime() + "]";
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    // Parameterized constructor
    public Rectangle(double length, double width) {
        super();
        this.length = length;
        this.width = width;
    }

    // Getters and Setters for length and width
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Override toString method to display rectangle details
    @Override
    public String toString() {
        return "Rectangle [ID: " + getId() + ", Length: " + length + ", Width: " + width + ", Created at: " + getCreationDateTime() + "]";
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    // Parameterized constructor
    public Triangle(double base, double height) {
        super();
        this.base = base;
        this.height = height;
    }

    // Getters and Setters for base and height
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Override toString method to display triangle details
    @Override
    public String toString() {
        return "Triangle [ID: " + getId() + ", Base: " + base + ", Height: " + height + ", Created at: " + getCreationDateTime() + "]";
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