package com.example.javier.proyectoemilio;


class Idea {
    String date;
    String status;
    String content;
    int photoId;
    String ownerID;


    Idea(String date, String status, int photoId, String ownerID, String content) {
        this.date = date;
        this.status = status;
        this.photoId = photoId;
        this.ownerID = ownerID;
        this.content = content;
    }


}
