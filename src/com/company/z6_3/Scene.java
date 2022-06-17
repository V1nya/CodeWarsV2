package com.company.z6_3;

public class Scene {
    public  SceneSpecification sceneSpecification;
    public Event event;

    public Scene(SceneSpecification sceneSpecification,Event event){
        this.event=event;
        this.sceneSpecification=sceneSpecification;
    }

    @Override
    public String toString() {
        return "Scene ~ "+sceneSpecification.name()+
                (" ".repeat(8-sceneSpecification.name().length()))+" #"+
                (sceneSpecification.ordinal()+1)+event.toString();
    }
}
