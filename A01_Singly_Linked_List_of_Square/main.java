import java.util.Date;

class Square {
    private double sideLength;
    private Date creationDateTime;

    // Non-parameterized constructor
    public Square() {
        this.sideLength = 1.0; // Default side length
        this.creationDateTime = new Date();
    }

    // Parameterized constructor
    public Square(double sideLength) {
        this.sideLength = sideLength;
        this.creationDateTime = new Date();
    }

    // Getter and Setter for side length
    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    // Get the area of the square
    public double getArea() {
        return sideLength * sideLength;
    }

    // Override toString method to display square details
    @Override
    public String toString() {
        return "Square [Side Length: " + sideLength + ", Area: " + getArea() + ", Created at: " + creationDateTime + "]";
    }
}

class SquareNode {
    private Square square;
    private SquareNode next;

    public SquareNode(Square square) {
        this.square = square;
        this.next = null;
    }

    public Square getSquare() {
        return square;
    }

    public SquareNode getNext() {
        return next;
    }

    public void setNext(SquareNode next) {
        this.next = next;
    }
}

class SquareLinkedList {
    private SquareNode head;

    // Add a square to the linked list
    public void addSquare(Square square) {
        SquareNode newNode = new SquareNode(square);
        if (head == null) {
            head = newNode;
        } else {
            SquareNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Print the squares in the linked list
    public void displaySquares() {
        SquareNode current = head;
        while (current != null) {
            System.out.println(current.getSquare());
            current = current.getNext();
        }
    }
}

public class SquareLinkedListExample {
    public static void main(String[] args) {
        SquareLinkedList squareList = new SquareLinkedList();

        Square square1 = new Square(4.0);
        Square square2 = new Square(5.0);
        Square square3 = new Square(3.0);

        squareList.addSquare(square1);
        squareList.addSquare(square2);
        squareList.addSquare(square3);

        squareList.displaySquares();
    }
}