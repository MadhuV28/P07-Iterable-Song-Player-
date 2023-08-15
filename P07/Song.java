/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Song
// Course: CS 300 Spring 2022
//
// Author: Madhu Vuyyuru
// Email: mvuyyuru@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// pair programming was not used for this assignment
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// no outside source code was used
//
//
///////////////////////////////////////////////////////////////////////////////
/**
 * this has the Song class which extends Object and has needed constructors and Methods
 * 
 * @author mvuyyuru
 *
 */
public class Song extends java.lang.Object {
  private String songName; // name or title of the song
  private String artist; // artist of the song
  private String duration; // duration of the song

  /**
   * Creates a new Song given the song name, the name of the artist, and the duration of the song
   * 
   * @param songName - title of the song
   * @param artist   - name of the artist who performed this song
   * @param duration - duration of the song in the format mm:ss
   * @throws IllegalArgumentException - with a descriptive error message if either of songName, or
   *                                  artist, or duration is null or is blank, or if the duration is
   *                                  not formatted as mm:ss where both mm and ss are in the 0 .. 59
   *                                  range.
   */
  public Song(String songName, String artist, String duration) {
    if (songName == null || artist == null || duration == null || songName.isBlank()
        || artist.isBlank() || duration.isBlank()) {
      throw new IllegalArgumentException(" songName, or artist, or duration is null or is blank");
    }
    if (duration.length() == 5) {
      try {
        if (Integer.parseInt(duration.substring(3)) > 59
            || Integer.parseInt(duration.substring(3)) < 0
            || Integer.parseInt(duration.substring(0, 2)) > 59
            || Integer.parseInt(duration.substring(0, 2)) < 0 || duration.charAt(2) != ':') {
          throw new IllegalArgumentException();
        }
      } catch (Exception e) {
        throw new IllegalArgumentException(
            "The duration string is not properly formatted or mm and or ss are not "
                + "in the correct range");
      }
    }
    if (duration.length() == 4) {
      try {
        if (Integer.parseInt(duration.substring(2)) > 59
            || Integer.parseInt(duration.substring(2)) < 0
            || Integer.parseInt(duration.substring(0, 1)) > 59
            || Integer.parseInt(duration.substring(0, 1)) < 0 || duration.charAt(1) != ':') {
          throw new IllegalArgumentException();
        }
      } catch (Exception e) {
        throw new IllegalArgumentException(
            "The duration string is not properly formatted or mm and or ss are not "
                + "in the correct range");
      }
    }
    this.songName = songName;
    this.duration = duration;
    this.artist = artist;

  }

  /**
   * Returns true when this song's name and artist strings equals to the other song's name and
   * artist strings, and false otherwise. Note that this method takes an Object rather than a Song
   * argument, so that it Overrides Object.equals(Object). If an object that is not an instance of
   * Song is ever passed to this method, it should return false.
   * 
   * @param other - Song object compared to this object
   * @return true when the this song has matching name and artist with respect to another song (case
   *         insensitive comparison)
   * 
   */
  @Override
  public boolean equals(Object other) {
    if (songName == null || artist == null || (!(other instanceof Song))) {
      return false;
    }
    Song other1 = (Song) other;
    if (this.songName.toLowerCase().equals(other1.songName.toLowerCase())
        && this.artist.toLowerCase().equals(other1.artist.toLowerCase())) {
      return true;
    }
    return false;
  }

  /**
   * Gets the title or name of this song
   * 
   * @return songName - the name of the song
   */
  public String getSongName() {
    return songName;
  }

  /**
   * Gets the name of the artist who performed this song
   * 
   * @return artist - the artist who performed this song
   */
  public String getArtist() {
    return artist;
  }

  /**
   * Gets the duration of this song
   * 
   * @return duration - the duration of this song
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Returns a string representation of this song. This string should be formatted as follows.
   * "songName---artist---duration" where songName is the title of the song, artist is the name of
   * the artist, and duration is the duration of the song.
   * 
   * @return output - a string representation of this song
   */
  public String toString() {
    String output = this.songName + "---" + this.artist + "---" + this.duration;
    return output;
  }

}
