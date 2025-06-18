package org.lessons.java.best_of_the_year.classes;

import java.util.HashSet;

public class Movie extends Media {

  private String description;
  private HashSet<String> cast;

  // ; Constructor

  public Movie(int id, String title, String author, HashSet<String> genres, int rating, String description,
      HashSet<String> cast) {
    super(id, title, author, genres, rating);
    this.description = description;
    this.cast = cast;

  }

  // , Getters

  public String getDescription() {
    return this.description;
  }

  public HashSet<String> getCast() {
    return this.cast;
  }

  // > Setters

  public void setDescritpion(String description) {
    this.description = description;
  }

  public void setCast(HashSet<String> cast) {
    this.cast = cast;
  }

  // < Methods

  @Override
  public String toString() {

    return super.toString() + "\n" + String.format("Description: %s \nCast: %s", this.description, this.cast);
  }

}
