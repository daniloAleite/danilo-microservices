package br.com.danilo.foo.math;

public class SimpleMath {

    public  Double sum(Double numberOne, Double numberTwo ) {
        return  numberOne + numberTwo;
    }

    public  Double sub(Double numberOne, Double numberTwo ) {
        return  numberOne - numberTwo;
    }

    public  Double mult(Double numberOne, Double numberTwo ) {
        return  numberOne * numberTwo;
    }

    public  Double div(Double numberOne, Double numberTwo ) {
        return  numberOne / numberTwo;
    }

    public  Double square(Double numberOne ) {
        return  Math.sqrt(numberOne);
    }

    public  Double mean(Double numberOne, Double numberTwo ) {
        return  (numberOne + numberTwo) /2;
    }
}
