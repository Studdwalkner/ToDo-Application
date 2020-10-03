package com.symb.task.todo;

public class todo_object
{
    public todo_object(String todo, String timestamp) {
        this.todo = todo;
        this.timestamp = timestamp;
    }

    String todo;
String timestamp;

public todo_object(){}
    public String getTodo() {

        return todo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
