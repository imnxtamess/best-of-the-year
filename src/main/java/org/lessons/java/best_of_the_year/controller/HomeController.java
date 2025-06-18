package org.lessons.java.best_of_the_year.controller;

import java.util.HashSet;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  // Genres

  HashSet<String> inceptionGenres = new HashSet<>();
  HashSet<String> interstellarGenres = new HashSet<>();
  HashSet<String> tenetGenres = new HashSet<>();
  HashSet<String> badMovieGenres = new HashSet<>();
  HashSet<String> paradiseCityGenres = new HashSet<>();
  HashSet<String> boysDontCryGenres = new HashSet<>();
  HashSet<String> backInBlackGenres = new HashSet<>();
  HashSet<String> terribleSongGenres = new HashSet<>();

  // Cast

  HashSet<String> inceptionCast = new HashSet<>();
  HashSet<String> interstellarCast = new HashSet<>();
  HashSet<String> tenetCast = new HashSet<>();
  HashSet<String> badMovieCast = new HashSet<>();

  HashSet<Movie> movieList = new HashSet<Movie>();
  HashSet<Movie> topMovies = new HashSet<>();
  HashSet<Song> songList = new HashSet<Song>();
  HashSet<Song> topSongs = new HashSet<>();

  public HomeController() {

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

  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("name", "Davide");
    return "home";

  }

  private HashSet<Movie> getBestMovies() {
    for (Movie movie : movieList) {
      if (movie.getRating() >= 8) {
        topMovies.add(movie);
      }
    }
    return topMovies;

  }

  private HashSet<Song> getBestSongs() {
    for (Song song : songList) {
      if (song.getRating() >= 8) {
        topSongs.add(song);
      }
    }
    return topSongs;
  }

  @RequestMapping("/movies")
  public String movies(Model model) {

    model.addAttribute("bestMovies", getBestMovies());
    model.addAttribute("id", null);

    return "movies";
  }

  @RequestMapping("/songs")
  public String songs(Model model) {

    model.addAttribute("bestSongs", getBestSongs());
    model.addAttribute("id", null);
    return "songs";
  }

  @RequestMapping("/movies/{id}")
  public String movieById(@PathVariable int id, Model model) {
    for (Movie movie : movieList) {
      if (id == movie.getId()) {
        model.addAttribute("singleMovie", movie);
      }
    }
    model.addAttribute("id", id);

    return "movies";
  }

  @RequestMapping("/songs/{id}")
  public String songById(@PathVariable int id, Model model) {
    for (Song song : songList) {
      if (id == song.getId()) {
        model.addAttribute("singleSong", song);
      }
    }
    model.addAttribute("id", id);

    return "songs";
  }

}
