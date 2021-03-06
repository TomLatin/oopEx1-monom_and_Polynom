package Tests;

import Ex1.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomTest {

    static  Monom[] arrMonomsFromString =new Monom[15];
    static  Polynom[] arrPolynomsFromString =new Polynom[15];


    //Here we will create all the Monoms and Polynoms for testing the methods
    @Before
    public void BeforeEach() {
        //Build the Monoms with the help of the Monom string constructor
        arrMonomsFromString[0] = new Monom("0");
        arrMonomsFromString[1] = new Monom("15");
        arrMonomsFromString[2] = new Monom("15.5");
        arrMonomsFromString[3] = new Monom("x");
        arrMonomsFromString[4] = new Monom("-x");
        arrMonomsFromString[5] = new Monom("+x");
        arrMonomsFromString[6] = new Monom("4.5x");
        arrMonomsFromString[7] = new Monom("2.5x");
        arrMonomsFromString[8] = new Monom("-4.5x");
        arrMonomsFromString[9] = new Monom("-2.5x");
        arrMonomsFromString[10] = new Monom("2x^2");
        arrMonomsFromString[11] = new Monom("6.7x^5");
        arrMonomsFromString[12] = new Monom("-9x^7");
        arrMonomsFromString[13] = new Monom("8x^7");
        arrMonomsFromString[14] = new Monom("0X^90");

        //Build the Polynoms with the help of the Polynom string constructor
        arrPolynomsFromString[0] = new Polynom("-89");
        arrPolynomsFromString[1] = new Polynom("4x");
        arrPolynomsFromString[2] = new Polynom("-5x^2+6x-17");
        arrPolynomsFromString[3] = new Polynom("4x^4");
        arrPolynomsFromString[4] = new Polynom("3x^5+5x^3+4x+23");
        arrPolynomsFromString[5] = new Polynom("2x^4-6X^2-7");
        arrPolynomsFromString[6] = new Polynom("-x^2");
        arrPolynomsFromString[7] = new Polynom("777");
        arrPolynomsFromString[8] = new Polynom("x^6-x^5-x^4-x^3-x^2-x");
        arrPolynomsFromString[9] = new Polynom("x^3+x^2");
        arrPolynomsFromString[10] = new Polynom("77x^4");
        arrPolynomsFromString[11] = new Polynom("3x");
        arrPolynomsFromString[12] = new Polynom("9x^7");
        arrPolynomsFromString[13] = new Polynom("-14x^5+15x^4");
        arrPolynomsFromString[14] = new Polynom("x^4-X^3+x^2-2x^2");
    }

    /**
     *Tests the constructor that receives string for building polynom
     */
    @Test
    public void Polynom() {
        /*
        Create new polynoms in order to compare them with the polynoms in the array
         */
        Polynom[] expected = {new Polynom("-89"), new Polynom("4x"), new Polynom("-5x^2+6x-17"), new Polynom("4x^4"), new Polynom("3x^5+5x^3+4x+23"), new Polynom("2x^4-6X^2-7"), new Polynom("-x^2"), new Polynom("777"), new Polynom("x^6-x^5-x^4-x^3-x^2-x"), new Polynom("x^3+x^2"), new Polynom("77x^4"), new Polynom("3x"), new Polynom("9x^7"), new Polynom("15x^4-14X^5"), new Polynom("x^2+x^4-X^3-2x^2")};
        /*
        Create new strings in order to compare them with the polynoms in the array
         */
        String[] StringExpected = {"-89.0", "4.0x", "-5.0x^2+6.0x-17.0", "4.0x^4", "3.0x^5+5.0x^3+4.0x+23.0", "2.0x^4-6.0x^2-7.0", "-1.0x^2", "777.0", "1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x", "1.0x^3+1.0x^2", "77.0x^4", "3.0x", "9.0x^7", "-14.0x^5+15.0x^4", "1.0x^4-1.0x^3-1.0x^2"};
        for (int i = 0; i <expected.length ; i++) {
            assertEquals(expected[i],arrPolynomsFromString[i]);
            assertEquals(StringExpected[i],arrPolynomsFromString[i].toString());
        }

        /*Errors must be thrown errString.length times.
        In this test, we check that representatives of all the wrong inputs actually return an error
        */
        String[] errString = {"(89)","4.0x ^5","4.0x^ 5","(3x^2+1)","(3x^2+1)*(9x+11)","-(7x+7x^5)","9x^-7+15"};
        int counter=0;
        for (int i = 0; i < errString.length; i++) {
            try{
                Polynom p=new Polynom(errString[i]);
            }
            catch ( RuntimeException e)
            {
                counter++;
                continue;

            }
        }
        assertEquals(errString.length,counter);

    }

    /**
     * Checks whether connection between array monomers and array polynomials is made as expected
     */
    @Test
    public void addMonom() {
        Polynom m1 = new Polynom("-89");
        Polynom m2 = new Polynom("4x+15");
        Polynom m3 = new Polynom("-5x^2+6x-1.5");
        Polynom m4 = new Polynom("4x^4+1x");
        Polynom m5 = new Polynom("3x^5+5x^3+3x+23");
        Polynom m6 = new Polynom("2x^4-6x^2+1x-7");
        Polynom m7 = new Polynom("-1x^2+4.5x");
        Polynom m8 = new Polynom("2.5x+777");
        Polynom m9 = new Polynom("1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-5.5x");
        Polynom m10 = new Polynom("1.0x^3+1.0x^2-2.5x");
        Polynom m11 = new Polynom("77.0x^4+2.0x^2");
        Polynom m12 = new Polynom("6.7x^5+3.0x");
        Polynom m13 = new Polynom("0.0x^7");
        Polynom m14 = new Polynom("8.0x^7-14.0x^5+15.0x^4");
        Polynom m15 = new Polynom("1.0x^4-1.0x^3-1.0x^2");

        Polynom [] expected = {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            arrPolynomsFromString[i].add(arrMonomsFromString[i]);
            assertEquals(expected[i],arrPolynomsFromString[i]);
        }

    }

    /**
     * Checks whether a polynomial-polynomial add is made correctly.
     * Please note that we add a polynomial with another polynomial in place (i + 3)% 15, ie when we reach, for example,
     * place 12, The connected polynomial will be a polynomial at position 0,which the add action has already been done
     * at the polynomial 0 and will therefore be different from what is written in the array created initially.
     */
    @Test
    public void addPolynom() {
        Polynom m1 = new Polynom("4.0x^4-89.0");
        Polynom m2 = new Polynom("3.0x^5+5.0x^3+8.0x+23.0");
        Polynom m3 = new Polynom("2.0x^4-11.0x^2+6.0x-24.0");
        Polynom m4 = new Polynom("4.0x^4-1.0x^2");
        Polynom m5 = new Polynom("3.0x^5+5.0x^3+4.0x+800.0");
        Polynom m6 = new Polynom("1.0x^6-1.0x^5+1.0x^4-1.0x^3-7.0x^2-1.0x-7.0");
        Polynom m7 = new Polynom("1.0x^3");
        Polynom m8 = new Polynom("77.0x^4+777.0");
        Polynom m9 = new Polynom("1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2+2.0x");
        Polynom m10 = new Polynom("9.0x^7+1.0x^3+1.0x^2");
        Polynom m11 = new Polynom("-14.0x^5+92.0x^4");
        Polynom m12 = new Polynom("1.0x^4-1.0x^3-1.0x^2+3.0x");
        Polynom m13 = new Polynom("9.0x^7+4.0x^4-89.0");
        Polynom m14 = new Polynom("-11.0x^5+15.0x^4+5.0x^3+8.0x+800.0");
        Polynom m15 = new Polynom("2.0x^4-1.0x^3-12.0x^2+6.0x-24.0");

        Polynom [] expected = {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            arrPolynomsFromString[i].add(arrPolynomsFromString[(i+3)%15]);
            assertEquals(expected[i],arrPolynomsFromString[i]);
        }
    }

    /**
     * Checks whether the print function is working properly
     */
    @Test
    public void toStringTest()
    {
        String[] StringExpected = {"-89.0", "4.0x", "-5.0x^2+6.0x-17.0", "4.0x^4", "3.0x^5+5.0x^3+4.0x+23.0", "2.0x^4-6.0x^2-7.0", "-1.0x^2", "777.0", "1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x", "1.0x^3+1.0x^2", "77.0x^4", "3.0x", "9.0x^7", "-14.0x^5+15.0x^4", "1.0x^4-1.0x^3-1.0x^2"};

        for (int i = 0; i <arrPolynomsFromString.length ; i++) {
            assertEquals(StringExpected[i],arrPolynomsFromString[i].toString());
        }

        for (int i = 0; i <arrPolynomsFromString.length ; i++) {
            assertNotEquals("100",arrPolynomsFromString[i].toString());
        }

    }

    /**
     *Checks that new function-type objects are created from the string
     */
    @Test
    public void initFromString()
    {
        String[] s = {"-89.0", "4.0x", "-5.0x^2+6.0x-17.0", "4.0x^4", "3.0x^5+5.0x^3+4.0x+23.0", "2.0x^4-6.0x^2-7.0", "-1.0x^2", "777.0", "1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x", "1.0x^3+1.0x^2", "77.0x^4", "3.0x", "9.0x^7", "-14.0x^5+15.0x^4", "1.0x^4-1.0x^3-1.0x^2"};

        /*
        Creating an function array from the array of the strings
         */
        function[] arrf = new function[15];
        for (int i = 0; i < s.length; i++) {
            arrf[i] = (arrPolynomsFromString[i].initFromString(s[i]));
        }

        /*
        Checks whether each cell in the array is a function instance.
        Checks whether each function is equal to the polynom According to the cell number*/
        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            assertTrue(arrf[i] instanceof function);
            assertTrue(arrf[i] instanceof Polynom);
            assertTrue(arrPolynomsFromString[i].equals((Polynom)(arrf[i])));

        }

        /*Errors must be thrown errString.length times.
        In this test, we check that representatives of all the wrong inputs actually return an error
        */
        String[] errString = {"(89)","4.0x ^5","4.0x^ 5","(3x^2+1)","(3x^2+1)*(9x+11)","-(7x+7x^5)","9x^-7+15"};
        function[] arrf1 = new function[7];
        int counter=0;
        for (int i = 0; i < errString.length; i++) {
            try
            {
                for (int j = 0; j < errString.length; j++) {
                    arrf1[j] = (arrPolynomsFromString[0].initFromString(errString[i]));
                }
            }
            catch (RuntimeException e) {
                counter++;
                continue;
            }
        }
        assertEquals(errString.length,counter);
    }

    /**
     * Checks whether the copy function properly Copying polynom to function
     */
    @Test
    public void copy() {
        function[] copied = new Polynom_able[15];

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            copied[i]=arrPolynomsFromString[i].copy();
            assertTrue(arrPolynomsFromString[i] instanceof function);
            assertTrue(arrPolynomsFromString[i] instanceof Polynom);
            assertEquals(copied[i],arrPolynomsFromString[i]);
        }
    }

    /**
     *Checks whether function f returns the correct Y value to X values
     */
    @Test
    public void f() {

        //Checks the point value at x=1
        double[] expectedFor1 ={-89.0,4,-16,4,35,-11.0,-1,777,-4,2,77,3,9.0,1,-1};

        for (int i = 0; i <arrPolynomsFromString.length ; i++) {
            assertEquals(expectedFor1[i],arrPolynomsFromString[i].f(1),Monom.EPSILON);
        }

        //Checks the point value at x=5
        double[] expectedFor5 ={-89.0,20,-112,2500,10043,1093,-25,777,11720,150,48125,15,703125,-34375,475};

        for (int i = 0; i <arrPolynomsFromString.length ; i++) {
            assertEquals(expectedFor5[i],arrPolynomsFromString[i].f(5),Monom.EPSILON);
        }

        //Checks the point value at x=5.55
        double[] expectedFor5_55 ={-89.0,22.2,-137.71249999999998,3795.1760249999993,16697.3895790625,1705.7730124999996,-30.8025,777.0,22803.320261578123,201.756375,73057.13848124999,16.65,1459800.1075069052,-59489.38419187499,747.0376312499998};

        for (int i = 0; i <arrPolynomsFromString.length ; i++) {
            assertEquals(expectedFor5_55[i],arrPolynomsFromString[i].f(5.55),Monom.EPSILON);
        }

        //Checks the point value at x=-5.55
        double[] expectedForMinus5_55 ={-89.0,-22.2,-204.3125,3795.1760249999993,-16651.3895790625,1705.7730124999996,-30.8025,777.0,33687.94148095313,-140.15137499999997,73057.13848124999,-16.65,-1459800.1075069052,87953.20437937498,1088.9453812499999};

        for (int i = 0; i <arrPolynomsFromString.length ; i++) {
            assertEquals(expectedForMinus5_55[i],arrPolynomsFromString[i].f(-5.55),Monom.EPSILON);
        }

    }

    /**
     Checks whether the multipy between polynom and monom is performed properly
     */
    @Test
    public void multiplyMonom() {
        Monom toMulm = new Monom("x^2");

        Polynom m1 = new Polynom("-89x^2");
        Polynom m2 = new Polynom("4x^3");
        Polynom m3 = new Polynom("-5x^4+6x^3-17x^2");
        Polynom m4 = new Polynom("4x^6");
        Polynom m5 = new Polynom("3x^7+5x^5+4x^3+23x^2");
        Polynom m6 = new Polynom("2x^6-6X^4-7x^2");
        Polynom m7 = new Polynom("-X^4");
        Polynom m8 = new Polynom("777x^2");
        Polynom m9 = new Polynom("x^8-x^7-x^6-x^5-x^4-x^3");
        Polynom m10 = new Polynom("X^5+x^4");
        Polynom m11 = new Polynom("77x^6");
        Polynom m12 = new Polynom("3X^3");
        Polynom m13 = new Polynom("9X^9");
        Polynom m14 = new Polynom("15x^6-14X^7");
        Polynom m15 = new Polynom("x^6-X^5-x^4");

        Polynom [] expected = {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            arrPolynomsFromString[i].multiply(toMulm);
            assertEquals(arrPolynomsFromString[i],expected[i]);
        }

    }

    /**
     Checks whether the multipy between polynom and polynom is performed properly
     */
    @Test
    public void multiplyPolynom() {
        Polynom toMulP = new Polynom("x^2-2x");

        Polynom m1 = new Polynom("-89.0x^2+178.0x");
        Polynom m2 = new Polynom("4x^3-8x^2");
        Polynom m3 = new Polynom("-5.0x^4+16.0x^3-29.0x^2+34.0x");
        Polynom m4 = new Polynom("4x^6-8.0x^5");
        Polynom m5 = new Polynom("3.0x^7-6.0x^6+5.0x^5-10.0x^4+4.0x^3+15.0x^2-46.0x");
        Polynom m6 = new Polynom("2.0x^6-4.0x^5-6.0x^4+12.0x^3-7.0x^2+14.0x");
        Polynom m7 = new Polynom("-X^4+2.0x^3");
        Polynom m8 = new Polynom("777x^2-1554x");
        Polynom m9 = new Polynom("1.0x^8-3.0x^7+1.0x^6+1.0x^5+1.0x^4+1.0x^3+2.0x^2");
        Polynom m10 = new Polynom("1.0x^5-1.0x^4-2.0x^3");
        Polynom m11 = new Polynom("77x^6-154.0x^5");
        Polynom m12 = new Polynom("3X^3-6.0x^2");
        Polynom m13 = new Polynom("9X^9-18.0x^8");
        Polynom m14 = new Polynom("-14.0x^7+43.0x^6-30.0x^5");
        Polynom m15 = new Polynom("1.0x^6-3.0x^5+1.0x^4+2.0x^3");

        Polynom [] expected = {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            arrPolynomsFromString[i].multiply(toMulP);
            assertEquals(expected[i],arrPolynomsFromString[i]);
        }
    }

    /**
     Checks whether the substract between polynom and polynom is performed properly
     */
    @Test
    public void substract() {
        Polynom m1 = new Polynom("-4.0x^4-89.0");
        Polynom m2 = new Polynom("-3.0x^5-5.0x^3-23.0");
        Polynom m3 = new Polynom("-2.0x^4+1.0x^2+6.0x-10.0");
        Polynom m4 = new Polynom("4.0x^4+1.0x^2");
        Polynom m5 = new Polynom("3.0x^5+5.0x^3+4.0x-754.0");
        Polynom m6 = new Polynom("-1.0x^6+1.0x^5+3.0x^4+1.0x^3-5.0x^2+1.0x-7.0");
        Polynom m7 = new Polynom("-1.0x^3-2.0x^2");
        Polynom m8 = new Polynom("-77.0x^4+777.0");
        Polynom m9 = new Polynom("1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-4.0x");
        Polynom m10 = new Polynom("-9.0x^7+1.0x^3+1.0x^2");
        Polynom m11 = new Polynom("14.0x^5+62.0x^4");
        Polynom m12 = new Polynom("-1.0x^4+1.0x^3+1.0x^2+3.0x");
        Polynom m13 = new Polynom("9.0x^7+4.0x^4+89.0");
        Polynom m14 = new Polynom("-11.0x^5+15.0x^4+5.0x^3+23.0");
        Polynom m15 = new Polynom("3.0x^4-1.0x^3-2.0x^2-6.0x+10.0");

        Polynom [] expected = {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            arrPolynomsFromString[i].substract(arrPolynomsFromString[(i+3)%15]);
            assertEquals(expected[i],arrPolynomsFromString[i]);
        }
    }

    /**
     * Checks whether the Equals properly compares polynom and function
     */
    @Test
    public void Equals() {

        Polynom notEqualsP = new Polynom("8.0x^3-12.0x");
        Monom notEqualsM = new Monom("777777x");
        function fl=new Monom("50");
        function fr=new Monom("50");
        ComplexFunction notEqualForComplexFunction=new ComplexFunction("plus",fl,fr);

        String[] StringExpected = {"-89.0", "4.0x", "-5.0x^2+6.0x-17.0", "4.0x^4", "3.0x^5+5.0x^3+4.0x+23.0", "2.0x^4-6.0x^2-7.0", "-1.0x^2", "777.0", "1.0x^6-1.0x^5-1.0x^4-1.0x^3-1.0x^2-1.0x", "1.0x^3+1.0x^2", "77.0x^4", "3.0x", "9.0x^7", "-14.0x^5+15.0x^4", "1.0x^4-1.0x^3-1.0x^2"};
        Polynom[] fromToString = new Polynom[15];

        //**Compare two polynoms comparison**
        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            fromToString[i]= new Polynom(arrPolynomsFromString[i].toString());
            assertTrue(fromToString[i].equals(arrPolynomsFromString[i]));

            fromToString[i]= new Polynom(StringExpected[i]);
            assertTrue(fromToString[i].equals(arrPolynomsFromString[i]));
        }

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            fromToString[i]= new Polynom(arrPolynomsFromString[i].toString());
            assertFalse(fromToString[i].equals(notEqualsP));
            assertFalse(fromToString[i].equals(notEqualsM));
        }

        //**Compare polynom and monom comparison**
        Polynom[] expected = new Polynom[15];

        for (int i = 0; i <arrMonomsFromString.length ; i++) {
            expected[i]=new Polynom(arrMonomsFromString[i].toString());
            assertTrue(expected[i].equals(arrMonomsFromString[i]));
        }


        for (int i = 0; i <arrPolynomsFromString.length ; i++) {
            assertFalse(arrPolynomsFromString[i].equals(arrMonomsFromString[i]));
        }

        //**Compare polynom and complex function comparison**

        ComplexFunction c=new ComplexFunction();
        function f0=c.initFromString("-89");
        function f1=c.initFromString("mul(4,x)");
        function f2=c.initFromString("plus(plus(-5x^2,6x),-17)");
        function f3=c.initFromString("mul(4,x^4)");
        function f4=c.initFromString("plus(plus(3x^5,5x^3),plus(4x,23))");
        function f5=c.initFromString("plus(plus(2x^4,-6X^2),-7)");
        function f6=c.initFromString("mul(-x,x)");
        function f7=c.initFromString("plus(100,677)");
        function f8=c.initFromString("plus(plus(plus(x^6,-x^5),plus(-x^4,-x^3)),plus(-x^2,-x))");
        function f9=c.initFromString("plus(x^3,x^2)");
        function f10=c.initFromString("mul(77x^3,x)");
        function f11=c.initFromString("mul(3,x)");
        function f12=c.initFromString("mul(9,x^7)");
        function f13=c.initFromString("plus(mul(-14,x^5),15x^4)");
        function f14=c.initFromString("plus(plus(x^4,-X^3),plus(x^2,-2x^2))");

        function[] expectedC={new ComplexFunction(f0),f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14};

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            assertTrue(arrPolynomsFromString[i].equals(expectedC[i]));
        }

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            assertFalse(arrPolynomsFromString[i].equals(notEqualForComplexFunction));

        }
    }

    /**
     * Tests the function whether iszero working properly,
     * That is, the function can detect whether the polynom is zero or not.
     */
    @Test
    public void isZero() {
        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            arrPolynomsFromString[i].substract(arrPolynomsFromString[i]);
            assertTrue(arrPolynomsFromString[i].isZero());
        }
    }

    /**
     * For x that specifies a root of a polynomial, we will check whether the value for x in this polynomial is smaller than Epsilon
     */
    @Test
    public void root() {
        Polynom toRoot = new Polynom("x+4");
        double x = toRoot.root(-6,1,0.00001);
        boolean isroot = false;
        if (toRoot.f(x)<=Monom.EPSILON) isroot=true;
        assertTrue(isroot);
    }

    /**
     * Checks whether the derivative returns the correct derivative for the polynom
     */
    @Test
    public void derivative() {
        /*
        Create new polynoms in order to compare them with The result of the function derivative
         */
        Polynom m1 = new Polynom("0");
        Polynom m2 = new Polynom("4");
        Polynom m3 = new Polynom("-10x+6");
        Polynom m4 = new Polynom("16.0x^3");
        Polynom m5 = new Polynom("15.0x^4+15.0x^2+4.0");
        Polynom m6 = new Polynom("8.0x^3-12.0x");
        Polynom m7 = new Polynom("-2.0x");
        Polynom m8 = new Polynom("0");
        Polynom m9 = new Polynom("6.0x^5-5.0x^4-4.0x^3-3.0x^2-2.0x-1.0");
        Polynom m10 = new Polynom("3.0x^2+2.0x");
        Polynom m11 = new Polynom("308.0x^3");
        Polynom m12 = new Polynom("3");
        Polynom m13 = new Polynom("63.0x^6");
        Polynom m14 = new Polynom("-70.0x^4+60.0x^3");
        Polynom m15 = new Polynom("4.0x^3-3.0x^2-2.0x");

        Polynom [] expected = {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};

        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            assertEquals(arrPolynomsFromString[i].derivative(),expected[i]);
        }
    }

    /**
     * Checks whether the area returns the correct area for the polynom
     */
    @Test
    public void area() {
        double start = 0, end = 1;
        double[]expected = {0,2,0,0.8,26.75,0,0,777,0,0.583333,15.4,1.5,1.125,0.66666,0};
        for (int i = 0; i < arrPolynomsFromString.length; i++) {
            assertEquals(expected[i],arrPolynomsFromString[i].area(start,end,Monom.EPSILON),0.0001);
        }
    }

    /**
     * Checks whether the deleteSpace returns the correct string without spaces valid
     */
    @Test
    public void deleteSpace()
    {
        String [] goodSpaces={"4 x^2 +5","4 + 6","6 - 7x + 8"};
        String [] BadSpaces={"4x ^2+5","46x^ 6"};
        Polynom [] p=new Polynom[3];
        String [] expected={"4.0x^2+5.0","10.0","-7.0x+14.0"};
        for (int i = 0; i <goodSpaces.length ; i++) {
            p[i]=new Polynom(goodSpaces[i]);
            assertEquals(expected[i],p[i].toString());
        }

        int count=0;
        for (int j = 0; j < 2; j++) {
            try {
                for (int i = 0; i < BadSpaces.length; i++) {
                    p[i] = new Polynom(BadSpaces[i]);
                }
            } catch (RuntimeException e) {
                count++;
                continue;
            }
        }

        assertEquals(BadSpaces.length,count);
    }
}