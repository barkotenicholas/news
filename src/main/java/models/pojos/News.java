package models.pojos;

import java.util.Objects;

public class News {

    private int id;
    private String content;
    private String author;

    public News(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && Objects.equals(content, news.content) && Objects.equals(author, news.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, author);
    }
}
