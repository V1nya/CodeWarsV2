package com.company.z6_3;

import java.time.Duration;
import java.time.LocalTime;

public class Event {
    private LocalTime start;
    private LocalTime finish;
    private String title;
    private double price;

    public  Event(){}
    private Event(LocalTime start, LocalTime finish,
                  String title, double price) {
        this.start = start;
        this.finish = finish;
        this.price = price;
        this.title = title;
    }

    public Duration getDuration() {
        return Duration.between(start, finish);
    }

    public static Event of(LocalTime start, LocalTime finish,
                    String title, double price) {

        return new Event(start, finish, title, price);
    }

    @Override
    public String toString() {
        return
                " -- band <** " +
                        title + (" ".repeat(12 - title.length())) + "  **> price " +
                        price + ", start - " +
                        start + ", finish - " +
                        finish + ", duration: " +
                        getDuration().toMinutes() + " min ***"
                ;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
