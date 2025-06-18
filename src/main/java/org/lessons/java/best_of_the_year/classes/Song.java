package org.lessons.java.best_of_the_year.classes;

import java.util.HashSet;

public class Song extends Media {

  private String album;

  // ; Constructor

  public Song(int id, String title, String author, HashSet<String> genres, int rating, String album) {
    super(id, title, author, genres, rating);
    this.album = album;
  }

  // , Getters

  public String getAlbum() {
    return this.album;
  }

  // > Setters

  public void setAlbum(String album) {
    this.album = album;
  }

  // < Methods

  @Override
  public String toString() {
    return super.toString() + "\n" + String.format("Album: %s", this.album);
  }
}
