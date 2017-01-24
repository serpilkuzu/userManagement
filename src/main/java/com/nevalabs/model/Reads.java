package com.nevalabs.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by serpilkuzu on 23/01/2017.
 */
@Entity(name = "READ_INFO")
public class Reads implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private int userId;

    @Column
    private int bookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Reads{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", bookId=").append(bookId);
        sb.append('}');
        return sb.toString();
    }
}
