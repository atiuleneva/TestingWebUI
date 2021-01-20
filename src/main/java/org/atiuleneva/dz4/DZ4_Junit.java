package org.atiuleneva.dz4;

public class DZ4_Junit {
    public static void main( String[] args ) throws ImpossibleTriangleException, ImpossibleTriangleHugeSideException {
        DZ4_Junit obj = new DZ4_Junit();
        double tsqr = obj.triangleSquare(2, 3, 4);
        System.out.println(tsqr);
    }

    public double triangleSquare(double a, double b, double c) throws ImpossibleTriangleException, ImpossibleTriangleHugeSideException {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)){
            throw new IllegalArgumentException();
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new ImpossibleTriangleException();
        }

        if (a+b<=c || b+c<=a || a+c<=b){
            throw new ImpossibleTriangleHugeSideException();
        }

        double p = (a+b+c)/2;
        double sqr = Math.sqrt(p*(p-a)*(p-b)*(p-c));

        return sqr;
    }

    public class ImpossibleTriangleException extends Exception {
    }

    public class ImpossibleTriangleHugeSideException extends Exception {
    }
}
