package org.lessons.java.best_of_the_year.classes;

import java.util.ArrayList;

public class Movie extends Media {

  private String description;
  private ArrayList<String> cast;

  // ; Constructor

  public Movie(int id, String title, String author, ArrayList<String> genres, int rating, String description,
      ArrayList<String> cast) {
    super(id, title, author, genres, rating);
    this.description = description;
    this.cast = cast;

  }

  // , Getters

  public String getDescritpion() {
    return this.description;
  }

  public ArrayList<String> getCast() {
    return this.cast;
  }

  // > Setters

  public void setDescritpion(String description) {
    this.description = description;
  }

  public void setCast(ArrayList<String> cast) {
    this.cast = cast;
  }

  // < Methods

  @Override
  public String toString() {

    return super.toString() + "\n" + String.format("Description: %s \nCast: %s", this.description, this.cast);
  }

}
