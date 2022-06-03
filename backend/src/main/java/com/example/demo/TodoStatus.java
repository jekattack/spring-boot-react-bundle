package com.example.demo;

public enum TodoStatus {
    OPEN("OPEN"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE");

    private String status;

    TodoStatus(String status) {
        this.status = status;
    }

    public TodoStatus progressNext(){
        switch(status){
            case "OPEN" -> {
                return TodoStatus.IN_PROGRESS;
            }
            case "IN_PROGRESS" -> {
                return TodoStatus.DONE;
            }
            default -> {
                return this;
            }
        }
    }

    public TodoStatus progressPrev(){
        switch(status){
            case "DONE" -> {
                return TodoStatus.IN_PROGRESS;
            }
            case "IN_PROGRESS" -> {
                return TodoStatus.OPEN;
            }
            default -> {
                return this;
            }
        }
    }
}
