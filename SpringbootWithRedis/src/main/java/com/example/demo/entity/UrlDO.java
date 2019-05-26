package com.example.demo.entity;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class UrlDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(length = 10240)
    String longUrl;

    public void setId(long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.longUrl = url;
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return longUrl;
    }
}
