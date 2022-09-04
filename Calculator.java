package com.onlinecourse;

import java.util.Scanner;

interface Object{
    Number add(Number a, Number c);
    Number sub(Number a, Number c);
    Number mul(Number a, Number c);
    Number div(Number a, Number c) throws ZeroDivisionError;

}

class ZeroDivisionError extends Exception
{
    public ZeroDivisionError(String error){
        super(error);
    }
}

class OperatorError extends Exception{
    public OperatorError(String error){
        super(error);
    }
}

class Perform implements Object
{
    private Number a, c;
    private Integer b;
    public Number perform() throws OperatorError, ZeroDivisionError {
        if (b == 1) return add(a, c);
        else if (b == 2) return sub(a, c);
        else if (b == 3) return mul(a, c);
        else if (b == 4) return div(a, c);
        else throw new OperatorError("You are using unknown operator");
    }
    public Perform(Number a, Integer b, Number c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Number add(Number a, Number c){
        return a.longValue() + c.longValue();
    }
    public Number sub(Number a, Number c){
        return a.longValue() - c.longValue();
    }
    public Number mul(Number a, Number c){
        return a.longValue() * c.longValue();
    }
    public Number div(Number a, Number c) throws ZeroDivisionError
    {
        if (c.longValue() == 0) throw new ZeroDivisionError("You cannot divide any number to zero");
        return a.doubleValue() / c.doubleValue();

    }


}

public class Calculator {
    public static void main(String[] args){
        System.out.println(
                "\t\t****\tWelcome To Simple Calculator\t***\n"
        );
        int a, c;
        int b = 1;
        while (b != 0){
            try {
                System.out.print("Enter the first number: ");
                Scanner rec = new Scanner(System.in);
                a = rec.nextInt();
                System.out.println("Select Operator\n1: + \t 2: - \t 3: * \t 4: /");
                Scanner rec2 = new Scanner(System.in);
                b = rec2.nextInt();
                System.out.print("Enter the second number: ");
                Scanner rec3 = new Scanner(System.in);
                c = rec3.nextInt();
                Perform result = new Perform(a, b, c);
                System.out.println(result.perform());
            }
            catch (ZeroDivisionError | OperatorError e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.err.println(e);
            }

        }
    }
}
