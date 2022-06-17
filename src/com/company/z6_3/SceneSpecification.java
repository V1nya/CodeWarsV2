package com.company.z6_3;

public enum SceneSpecification {
    YELLOW(1), PINK(2), ORANGE(3), BLACK(4), GREEN(5), PURPLE(6);

    private final int id;

    SceneSpecification(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
