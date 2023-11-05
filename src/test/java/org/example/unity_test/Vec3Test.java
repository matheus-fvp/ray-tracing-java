package org.example.unity_test;

import org.example.geometry.Vec3;
import org.junit.Test;

import static org.junit.Assert.*;


public class Vec3Test {

    @Test
    public void mustGetAOppositeVec3() {
        Vec3 v = new Vec3(10.0, 15.0, 25.0);
        Vec3 result = new Vec3(-10.0, -15.0, -25.0);
        assertEquals(result, v.opposite());
    }

    @Test
    public void mustSumTwoVector3() {
        Vec3 v = new Vec3(10.0, -20.0, 30.0);
        Vec3 u = new Vec3(2.0, -10.0, -20.0);
        Vec3 result = new Vec3(12.0, -30.0, 10.0);

        assertEquals(result, Vec3.sum(v, u));
    }

    @Test
    public void mustSubtractionTwoVector3() {
        Vec3 v = new Vec3(10.0, -20.0, 30.0);
        Vec3 u = new Vec3(2.0, -10.0, -20.0);
        Vec3 result = new Vec3(8.0, -10.0, 50.0);

        assertEquals(result, Vec3.subtraction(v, u));
    }

    @Test
    public void mustMultiplyTwoVector3() {
        Vec3 v = new Vec3(10, 20, 30);
        Vec3 u = new Vec3(100, 200, 300);
        Vec3 result = new Vec3(1000, 4000, 9000);

        assertEquals(result, Vec3.multiplication(u, v));
    }

    @Test
    public void mustMultiplyAVector3For5() {
        Vec3 v = new Vec3(10.10, 20.25, -30.20);
        Vec3 result = new Vec3(50.5, 101.25, -151.00);
        assertEquals(result, Vec3.multiplicationByScalar(5, v));
    }

    @Test
    public void mustToMakeTheDotOperation() {
        Vec3 v = new Vec3(10.25, 2.15, 3.33);
        Vec3 u = new Vec3(19.1, 30.25, 2.5);
        assertEquals(269.1375, Vec3.dot(v, u), 4);
    }

    @Test
    public void mustToMakeTheCrossOperation() {
        Vec3 v = new Vec3(10, 2, 3);
        Vec3 u = new Vec3(19, 30, 2);
        Vec3 vxu = new Vec3(-86, 37, 262);
        assertEquals(vxu, Vec3.cross(v, u));
    }

}
