package com.aequilibrium;

import org.junit.Assert;

import static org.junit.Assert.*;


public class MainTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void getNumberOfCastles() throws Exception {
        int[] testNone = {};
        int[] testOne = {1};
        int[] testPlateau = {1,1,1,1,1};
        int[] testA = {1,1,3,4,5};
        int[] testB = {10,4,7,3,11,11,3,2,4,5,6,5};

        Assert.assertEquals(0,Main.getNumberOfCastles(testNone));
        Assert.assertEquals(1,Main.getNumberOfCastles(testOne));
        Assert.assertEquals(1,Main.getNumberOfCastles(testPlateau));
        Assert.assertEquals(1,Main.getNumberOfCastles(testA));
        Assert.assertEquals(7,Main.getNumberOfCastles(testB));
    }

}