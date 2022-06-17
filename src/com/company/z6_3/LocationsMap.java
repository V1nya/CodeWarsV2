package com.company.z6_3;

public class LocationsMap {
    private int[][] adjoinMatrix = new int[0][0];
    private int numOfScenes;

    public LocationsMap(int[][] matrix, int numOfScenes) {
        this.adjoinMatrix = matrix;
        this.numOfScenes = numOfScenes;
    }

    public void addRoad(int src, int dest, int distance) {

        adjoinMatrix[src-1][dest-1] = distance;
        adjoinMatrix[dest-1][src-1] = distance;

    }


    public int[][] getAdjoinMatrix() {

        return adjoinMatrix;
    }

    public void setAdjoinMatrix(int[][] adjoinMatrix) {
        this.adjoinMatrix = adjoinMatrix;
    }

    public int getNumOfScenes() {
        return numOfScenes;
    }

    public void setNumOfScenes(int numOfScenes) {
        this.numOfScenes = numOfScenes;
    }

}
