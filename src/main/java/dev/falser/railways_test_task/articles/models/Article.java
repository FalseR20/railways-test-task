package dev.falser.railways_test_task.articles.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String text;
    private Integer likesCount;
    private LocalDateTime createdAt;
    @Column(length = 1024 * 1024)
    @Lob
    private byte[] image;

    public String getCreatedAtFormatted() {
        DateTimeFormatter formFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return createdAt.format(formFormat);
    }

    public void setCreatedAtFormatted(String createdAtFormatted) {
        setCreatedAt(LocalDateTime.parse(createdAtFormatted));
    }
}