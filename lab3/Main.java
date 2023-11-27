import javax.swing.*;

interface BinaryOperation {
    void printOperationName();
    void printOperationSign();
    int performOperation(int operand1, int operand2);
}

class AdditionOperation implements BinaryOperation {
    @Override
    public void printOperationName() {
        System.out.println("Addition Operation");
    }

    @Override
    public void printOperationSign() {
        System.out.println("+");
    }

    @Override
    public int performOperation(int operand1, int operand2) {
        return operand1 + operand2;
    }
}

class SubtractionOperation implements BinaryOperation {
    @Override
    public void printOperationName() {
        System.out.println("Subtraction Operation");
    }

    @Override
    public void printOperationSign() {
        System.out.println("-");
    }

    @Override
    public int performOperation(int operand1, int operand2) {
        return operand1 - operand2;
    }
}

class MultiplicationOperation implements BinaryOperation {
    @Override
    public void printOperationName() {
        System.out.println("Multiplication Operation");
    }

    @Override
    public void printOperationSign() {
        System.out.println("*");
    }

    @Override
    public int performOperation(int operand1, int operand2) {
        return operand1 * operand2;
    }
}

class MaxOperation implements BinaryOperation {
    @Override
    public void printOperationName() {
        System.out.println("Max Operation");
    }

    @Override
    public void printOperationSign() {
        System.out.println("max");
    }

    @Override
    public int performOperation(int operand1, int operand2) {
        return Math.max(operand1, operand2);
    }
}

class MinOperation implements BinaryOperation {
    @Override
    public void printOperationName() {
        System.out.println("Min Operation");
    }

    @Override
    public void printOperationSign() {
        System.out.println("min");
    }

    @Override
    public int performOperation(int operand1, int operand2) {
        return Math.min(operand1, operand2);
    }
}

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(LogicalOperationsGUI::new);
    }
}