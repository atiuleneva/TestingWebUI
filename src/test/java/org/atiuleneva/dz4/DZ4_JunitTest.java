package org.atiuleneva.dz4;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DZ4_JunitTest {
    DZ4_Junit dz4junit = new DZ4_Junit();
    public static Logger logger = LoggerFactory.getLogger(DZ4_JunitTest.class);

    @BeforeAll
    public static void beforeAllTests() {
        logger.trace("Trace Before all tests");
        logger.info("Before all tests");
    }

    @Test
    public void testScaleneTriangle_triangleSquare_thenSqr() throws DZ4_Junit.ImpossibleTriangleException, DZ4_Junit.ImpossibleTriangleHugeSideException {
        double sqr = dz4junit.triangleSquare(2,3,4);
        Assertions.assertEquals(2.904738, sqr, 0.000001);
    }

    @Test
    public void testScaleneTriangleWithFloat_triangleSquare_thenSqr() throws DZ4_Junit.ImpossibleTriangleException, DZ4_Junit.ImpossibleTriangleHugeSideException {
        double sqr = dz4junit.triangleSquare(3.544,3.7446454654,0.4);
        Assertions.assertEquals(0.629584, sqr, 0.000001);
        logger.trace("Trace Before all tests");
    }

    @Test
    public void testImpossibleTriangle_triangleSquare_thenImpossibleTriangleException(){
        Assertions.assertThrows(DZ4_Junit.ImpossibleTriangleException.class,
                () -> {
                    dz4junit.triangleSquare(2,-3,4);
                });

        Assertions.assertThrows(DZ4_Junit.ImpossibleTriangleException.class,
                () -> {
                    dz4junit.triangleSquare(-2,-3,-4);
                });

        Assertions.assertThrows(DZ4_Junit.ImpossibleTriangleException.class,
                () -> {
                    dz4junit.triangleSquare(0,0,0);
                });
    }

    @Test
    public void testImpossibleHugeSideTriangle_triangleSquare_thenImpossibleTriangleHugeSideException() {
        Assertions.assertThrows(DZ4_Junit.ImpossibleTriangleHugeSideException.class,
                () -> {
                    dz4junit.triangleSquare(2, 3, 8);
                });

        Assertions.assertThrows(DZ4_Junit.ImpossibleTriangleHugeSideException.class,
                () -> {
                    dz4junit.triangleSquare(2, 3, 5);
                });
    }

    @Test
    public void testNaN_triangleSquare_thenIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    dz4junit.triangleSquare(Double.NaN, 3, 8);
                });
    }
}
