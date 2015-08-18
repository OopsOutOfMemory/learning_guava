package com.shengli.utilities.object;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * Created by shengli on 8/17/15.
 */
public class ToString {
    public static void main(String[] args) {
        String value = MoreObjects.firstNonNull(null,"default value");
        System.out.println(value);
        System.out.println(Objects.hashCode("shengli", "1"));
    }
}


class Book implements Comparable<Book> {
    private Person author;
    private String title;
    private String publisher;
    private String isbn;
    private double price;

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //    public int compareTo(Book o) {
//        int result = this.title.compareTo(o.getTitle());
//        if (result != 0) {
//            return result;
//        }
//        result = this.author.compareTo(o.getAuthor());
//        if (result != 0) {
//            return result;
//        }
//        result = this.publisher.compareTo(o.getPublisher());
//        if(result !=0 ) {
//            return result;
//        }
//        return this.isbn.compareTo(o.getIsbn());
//    }

    @Override
    public int compareTo(Book o) {
        return ComparisonChain.start()
                .compare(this.title, o.getTitle())
                .compare(this.author, o.getAuthor())
                .compare(this.publisher, o.getPublisher())
                .compare(this.isbn, o.getIsbn())
                .compare(this.price, o.getPrice())
                .result();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("title", title)
                .add("author", author)
                .add("publisher", publisher)
                .add("price",price)
                .add("isbn", isbn).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, author, publisher, price, isbn);
    }
}