package com.company.z6_3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class EventUtil {
    public static final double PRICE_FOR_KM = 2.5;

    public static void main(String[] args) {
        Scene[] scenes = new Scene[]{
                new Scene(SceneSpecification.YELLOW, Event.of(LocalTime.of(16,00),LocalTime.of(18,20),"Iron Maiden",130.0)),
                new Scene(SceneSpecification.PINK,Event.of(LocalTime.of(17,00),LocalTime.of(19,50),"Judas Priest",85.7)),
                new Scene(SceneSpecification.ORANGE,Event.of(LocalTime.of(18,50),LocalTime.of(20,20),"Metallica",110)),
                new Scene(SceneSpecification.BLACK,Event.of(LocalTime.of(19,30),LocalTime.of(22,20),"AC~DC",116)),
                new Scene(SceneSpecification.GREEN,Event.of(LocalTime.of(20,50),LocalTime.of(22,30),"RHCP",99)),
                new Scene(SceneSpecification.PURPLE,Event.of(LocalTime.of(17,00),LocalTime.of(19,30),"Guns N` Roses",78.5))
        };

        LocationsMap locationsMap = new LocationsMap(new int[6][6],6);
        locationsMap.addRoad(1,2,2);
        locationsMap.addRoad(1,5,6);
        locationsMap.addRoad(1,6,3);
        locationsMap.addRoad(2,4,2);
        locationsMap.addRoad(2,5,3);
        locationsMap.addRoad(3,4,3);
        locationsMap.addRoad(3,5,6);
        locationsMap.addRoad(4,5,2);
        locationsMap.addRoad(5,6,2);

        var myPlane =  EventUtil.createConcertPlan(scenes);
        int[] minDist = EventUtil.shortestPathBetweenScenes(locationsMap,myPlane.get(0).sceneSpecification.getId());

        double totalPriceEvent= 0.0;
        double totalPriceTransfer=0.0;
        for (var scene:myPlane) {
            System.out.println(scene.toString());
            totalPriceEvent+=scene.event.getPrice();
            totalPriceTransfer+=minDist[scene.sceneSpecification.getId()]*EventUtil.PRICE_FOR_KM;
        }
        System.out.println("price for all events: "+totalPriceEvent+" $"+
                "\nprice for transfer:  "+totalPriceTransfer+" $"+
                "\ntotal price:         "+(totalPriceEvent+totalPriceTransfer)+" $");

    }

    public static ArrayList<Scene> createConcertPlan(Scene[] scenes) {

        var outScene = new ArrayList<Scene>() {
        };
        outScene.add(scenes[0]);
        LocalTime fin = scenes[0].event.getFinish();
        for (int i = 1; i < scenes.length; i++) {
            if (scenes[i].event.getStart().compareTo(fin) > 0) {
                outScene.add(scenes[i]);
                fin = scenes[i].event.getFinish();
            }
        }

        return outScene;
    }

    public static int[] shortestPathBetweenScenes(LocationsMap map, int src) {


        int[] minDistance = new int[map.getNumOfScenes()];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[map.getNumOfScenes()];
        Arrays.fill(visited, false);

        minDistance[src - 1] = 0;
        for (int i = 0; i < map.getNumOfScenes(); i++) {
            int closest = getClosesLocation(minDistance, visited);
            visited[closest] = true;
            for (int j = 0; j < map.getNumOfScenes(); j++) {
                if (!visited[j]) {
                    if (map.getAdjoinMatrix()[closest][j] != 0) {
                        int d = minDistance[closest] + map.getAdjoinMatrix()[closest][j];
                        if (d < minDistance[j]) minDistance[j] = d;
                    }
                }
            }

        }

        int i = 0;
        return minDistance;
    }


    public static int getClosesLocation(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < min) if (!visited[i]) {
                min = distance[i];
                minIdx = i;
            }
        }

        return minIdx;
    }
}
