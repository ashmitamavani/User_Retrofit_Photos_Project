package com.example.user_retrofit_photos_project;

public class Model_Class {
       String id;

       String title;
       String body;

    public Model_Class(String id, String title,String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Model_Class{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
