package com.example.ZTP_PROJ6.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name="Photos")
public class Photo {
    @Id
    @Column(
            name="id",
            updatable = false
    )
    private String id;
    @Column(
            name="url",
            length = 1200
    )
    private String url;

    public Photo(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public Photo() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
    public static String idCreator() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }
}
