package com.aequilibrium;


import java.util.Arrays;

public class Main {
    public enum State{ ASCENDING, DESCENDING}

    public static void main(String[] args) {
        int[] arr = {};
        try {
             arr = Arrays.stream(args[0].substring(1, args[0].length() - 1).split(","))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray();
        } catch(Exception e) {
            System.out.println("Error formatting string. Please follow format '[#,#,#]' ie. [1,5,2,3]");
        }

        System.out.println("Number Of Castles: " + getNumberOfCastles(arr));
    }

    public static int getNumberOfCastles(int[] terrain) {
        int numOfCastles = 0;
        int i = 0;
        int j = 1;
        State state;

        //Ensure terrain is not empty & 2 or more elements in length
        if(terrain.length == 0) {
            return 0;
        } else if(terrain.length < 2) {
            return 1;
        }

        //If we start on a extended peak or valley, find first non equal element
        while(terrain[i] == terrain[j]) {
            j++;
            //If we reach the end of the array then it is a series of identical values
            if(j == terrain.length) {
                return 1;
            }
        }

        //Determine state
        if(terrain[i] < terrain[j]) {
            state = State.ASCENDING;
        } else {
            state = State.DESCENDING;
        }

        //The first element will be a castle
        i = j++;
        numOfCastles++;

        while(j < terrain.length) {
            //Determine if there is a change in state, will indicate a peak or valley
            if(terrain[i] < terrain[j] && state == State.DESCENDING) {
                state = State.ASCENDING;
                numOfCastles++;
            } else if(terrain[i] > terrain[j] && state == State.ASCENDING) {
                state = State.DESCENDING;
                numOfCastles++;
            }

            //Move indexes forward
            i = j++;
        }

        return numOfCastles;
    }
}
