package org.example.unit_test;

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

         assertEquals(result, v.sum(u));
     }

     @Test
     public void mustSubtractionTwoVector3() {
         Vec3 v = new Vec3(10.0, -20.0, 30.0);
         Vec3 u = new Vec3(2.0, -10.0, -20.0);
         Vec3 result = new Vec3(8.0, -10.0, 50.0);

         assertEquals(result, v.subtraction(u));
     }

     @Test
     public void mustMultiplyTwoVector3() {
         Vec3 v = new Vec3(10, 20, 30);
         Vec3 u = new Vec3(100, 200, 300);
         Vec3 result = new Vec3(1000, 4000, 9000);

         assertEquals(result, v.multiplication(u));
     }

     @Test
     public void mustMultiplyAVector3For5() {
         Vec3 v = new Vec3(10.10, 20.25, -30.20);
         Vec3 result = new Vec3(50.5, 101.25, -151.00);
         assertEquals(result, v.multiplicationByScalar(5));
     }

     @Test
     public void mustToMakeTheDotOperation() {
         Vec3 v = new Vec3(0.25, 0.5, 0.1);
         Vec3 u = new Vec3(0.1, 0.1, -0.0033333333333332993);
         assertEquals(0.074667, v.dot(u), 4);
     }

     @Test
     public void mustToMakeTheCrossOperation() {
         Vec3 v = new Vec3(10, 2, 3);
         Vec3 u = new Vec3(19, 30, 2);
         Vec3 vxu = new Vec3(-86, 37, 262);
         assertEquals(vxu, v.cross(u));
     }

}
