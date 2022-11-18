# The Movie DB
Simple Android application that displays Movie Data using the [The Movie Database API](https://www.themoviedb.org/).

## Description

The application consists of a single screen. The screen displays the various movies in a list. For each movie in the list the following parts are visible:

- Movie Poster
- Movie Title
- Voting average
- Release date

## Design

The design adopted follows the MVVM with clean architecture design patterns. It is too complex for the simple functionality required, but it was chosen to illustrate the design patterns and best practices followed in larger scale and more demanding applications.

## Libraries

- [Retrofit2](https://square.github.io/retrofit/): Used to call the [The Movie Database API](https://www.themoviedb.org/);
- [Dagger - Hilt](https://dagger.dev/hilt/gradle-setup): Used for dependency injection.
- [Glie](https://github.com/bumptech/glide):  Helped with image display. 
