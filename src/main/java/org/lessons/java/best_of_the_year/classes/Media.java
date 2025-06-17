package org.lessons.java.best_of_the_year.classes;

import java.util.ArrayList;
import java.util.Random;

public abstract class Media {

  private int id;
  private String title;
  private String author;
  private ArrayList<String> genres;
  private int rating;

  // ; Constructor

  public Media(int id, String title, String author, ArrayList<String> genres, int rating) {

    this.id = id;
    this.title = title;
    this.author = author;
    this.genres = genres;
    this.rating = rating;

  }

  // , Getters

  public int getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public ArrayList<String> getGenres() {
    return this.genres;
  }

  public int getRating() {
    return rating;
  }

  // > Setters

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setGenres(ArrayList<String> genres) {
    this.genres = genres;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  // < Methods

  @Override
  public String toString() {

    return String.format("ID: %d \nTitle: %s\nAuthor: %s \nGenres: %s \nRating: %d", this.id, this.title, this.author,
        this.genres,
        this.rating);
  }
}
