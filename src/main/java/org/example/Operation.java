package org.example;

import java.io.Serializable;

public class Operation implements Serializable {

    // Declare serialVersionUID
    private static final long serialVersionUID = 1L;

    private double operand1;
    private double operand2;
    private String operator;

    // Constructor
    public Operation(double operand1, double operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    // Getters
    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public String getOperator() {
        return operator;
    }
}
