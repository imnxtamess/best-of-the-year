package org.lessons.java.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.Comparator;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {

    model.addAttribute("name", "Davide");

    return "home";
  }

  // Genres

  ArrayList<String> inceptionGenres = new ArrayList<>();
  ArrayList<String> interstellarGenres = new ArrayList<>();
  ArrayList<String> tenetGenres = new ArrayList<>();
  ArrayList<String> badMovieGenres = new ArrayList<>();
  ArrayList<String> paradiseCityGenres = new ArrayList<>();
  ArrayList<String> boysDontCryGenres = new ArrayList<>();
  ArrayList<String> backInBlackGenres = new ArrayList<>();
  ArrayList<String> terribleSongGenres = new ArrayList<>();

  // Cast

  ArrayList<String> inceptionCast = new ArrayList<>();
  ArrayList<String> interstellarCast = new ArrayList<>();
  ArrayList<String> tenetCast = new ArrayList<>();
  ArrayList<String> badMovieCast = new ArrayList<>();

  // Movies and Songs instantiation

  Movie inception = new Movie(1, "Inception", "Christopher Nolan", inceptionGenres, 9,
      "lorem ipsum about dolor", inceptionCast);
  Movie interstellar = new Movie(2, "Interstellar", "Christoper Nolan", interstellarGenres, 10,
      "Lorem ipsum in the dolor.. ", interstellarCast);
  Movie tenet = new Movie(3, "Tenet", "Dennis Villeneuve", tenetGenres, 8, "lorem ipsum future dolor",
      tenetCast);
  Movie badMovie = new Movie(4, "superbad", "randomguy", badMovieGenres, 1, "lorem bad dolor", badMovieCast);

  Song boysDontCry = new Song(5, "Boys Don't Cry", "The Cure", boysDontCryGenres, 9, "Three Imaginary Boys");

  Song paradiseCity = new Song(6, "Paradise City", "Guns N' Roses", paradiseCityGenres, 10,
      "Appetite For Destruction");

  Song backInBlack = new Song(7, "Back In Black", "AC/DC", backInBlackGenres, 9, "Back In Black");

  Song terribleSong = new Song(8, "Terrible Song", "Terrible Author", terribleSongGenres, 1,
      "Terrible Album.. to be honest");

  ArrayList<Movie> movieList = new ArrayList<Movie>();

  private ArrayList<Movie> getBestMovies() {
    inceptionGenres.add("Action");
    inceptionGenres.add("Sci-fi");
    interstellarGenres.add("Sci-fi");
    interstellarGenres.add("Thriller");
    tenetGenres.add("Action");
    tenetGenres.add("Sci-fi");
    badMovieGenres.add("Terribad");
    inceptionCast.add("Leonardo di Caprio");
    inceptionCast.add("Cillian Murphy");
    interstellarCast.add("Matthew McConaughey");
    interstellarCast.add("Anne Hathaway");
    tenetCast.add("Robert Pattinson");
    tenetCast.add("John David Washington");
    badMovieCast.add("Pierino");

    movieList.add(inception);
    movieList.add(interstellar);
    movieList.add(tenet);
    movieList.add(badMovie);

    ArrayList<Movie> topMovies = new ArrayList<>();
    for (Movie movie : movieList) {

      if (movie.getRating() >= 8) {
        topMovies.add(movie);
      }

    }

    return topMovies;

  }

  ArrayList<Song> songList = new ArrayList<Song>();

  private ArrayList<Song> getBestSongs() {
    boysDontCryGenres.add("Goth");
    boysDontCryGenres.add("Rock");
    paradiseCityGenres.add("Rock");
    paradiseCityGenres.add("Metal");
    backInBlackGenres.add("Rock");
    backInBlackGenres.add("Metal");
    terribleSongGenres.add("Bad one");

    songList.add(boysDontCry);
    songList.add(backInBlack);
    songList.add(paradiseCity);
    songList.add(terribleSong);

    ArrayList<Song> topSongs = new ArrayList<>();

    for (Song song : songList) {

      if (song.getRating() >= 8) {
        topSongs.add(song);
      }
    }

    String songString = topSongs.toString();

    songString.replaceAll("[]", "");

    return topSongs;
  }

  @RequestMapping("/movies")
  public String movies(Model model) {

    model.addAttribute("bestMovies", getBestMovies().toString());

    return "movies";
  }

  @RequestMapping("/songs")
  public String songs(Model model) {

    model.addAttribute("bestSongs", getBestSongs().toString());

    return "songs";
  }

}
