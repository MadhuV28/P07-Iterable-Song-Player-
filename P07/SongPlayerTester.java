/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: SongPlayerTester
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
import java.util.Iterator;

/**
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 *
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method, overridden
   * method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    Song testSong = new Song("TestSong", "TestArtist", "01:15");
    // tests if the getSongName method works
    if (!(testSong.getSongName().equals("TestSong"))) {
      return false;
    }
    // tests if the getArtistName method works
    if (!(testSong.getArtist().equals("TestArtist"))) {
      return false;
    }
    // tests if the getDuration method works
    if (!(testSong.getDuration().equals("01:15"))) {
      return false;
    }
    // tests if the toString method works
    if (!(testSong.toString().equals("TestSong---TestArtist---01:15"))) {
      return false;
    }
    // tests if the equals method works with true input
    Song other = new Song("testSong", "TestArtist", "01:15");
    if (testSong.equals(other) != true) {
      return false;
    }
    // tests if the equals method works with true input
    Song other1 = new Song("testSong2", "TestArtist2", "04:36");
    if (testSong.equals(other1) != false) {
      return false;
    }
    // tests that the correct erros are thrown when an invalid song is created
    try {
      Song testSong2 = new Song("", "", "");
      return false;
    } catch (IllegalArgumentException iae) {
    }
    // test that the correct errors are thrown when the duration is incorrectly formatted
    try {
      Song testSong3 = new Song("TestSong3", "TestArtist3", "1234z");
      return false;
    } catch (IllegalArgumentException iae) {
    }
    return true;
  }

  /**
   * This method test and make use of the LinkedNode constructor, an accessor (getter) method, and a
   * mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {
    LinkedNode<String> ln1 = new LinkedNode<>(null, "FirstNode", null);
    LinkedNode<String> ln2 = new LinkedNode<>(ln1, "SecondNode", null);
    LinkedNode<String> ln3 = new LinkedNode<>(ln2, "ThirdNode", null);
    ln1.setNext​(ln2);
    ln2.setNext​(ln3);

    if (!ln2.getPrev().equals(ln1)) {
      System.out.println("ERROR: getPrev() does not provide correct output");
      return false;
    }
    if (!ln2.getNext().equals(ln3)) {
      System.out.println("ERROR: getNext() does not provide correct output");
      return false;
    }
    ln2.setPrev​(ln3);
    if (!ln2.getPrev().equals(ln3)) {
      System.out.println("ERROR: setPrev() does not provide correct output");
      return false;
    }
    ln2.setNext​(ln1);
    if (!ln2.getNext().equals(ln1)) {
      System.out.println("ERROR: setNext() does not provide correct output");
      return false;
    }
    if (!ln2.getData().equals("SecondNode")) {
      System.out.println("ERROR: getData() does not provide correct output");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {
    SongPlayer sp = new SongPlayer();
    sp.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    sp.add​(0, new Song("Out of Time", "The Weeknd", "3:34"));
    sp.addLast​(new Song("Oh My God", "Adele", "3:45"));
    sp.add​(1, new Song("Levitating", "Dua Lipa", "3:23"));
    if (sp.size() != 4 || (!(sp.get(0).getSongName().equals("Out of Time")))
        || (!(sp.get(1).getSongName().equals("Levitating"))
            || (!(sp.get(2).getSongName().equals("Mojito"))
                || (!(sp.get(3).getSongName().equals("Oh My God")))))) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {
    SongPlayer sp = new SongPlayer();
    sp.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    sp.addFirst​(new Song("Out of Time", "The Weeknd", "3:34"));
    sp.addFirst​(new Song("Oh My God", "Adele", "3:45"));
    sp.addFirst​(new Song("Levitating", "Dua Lipa", "3:23"));
    if ((!(sp.getFirst().getSongName().equals("Levitating")))
        || (!(sp.getLast().getSongName().equals("Mojito"))
            || (!(sp.get(1).getSongName().equals("Oh My God"))))) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {
    SongPlayer sp = new SongPlayer();
    sp.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    sp.addFirst​(new Song("Out of Time", "The Weeknd", "3:34"));
    sp.addFirst​(new Song("Oh My God", "Adele", "3:45"));
    sp.addFirst​(new Song("Levitating", "Dua Lipa", "3:23"));
    if ((!(sp.removeFirst().getSongName().equals("Levitating")))
        || (!(sp.removeLast().getSongName().equals("Mojito")))
        || (!(sp.remove(1).getSongName().equals("Out of Time"))) || sp.size() != 1) {
      System.out.println("poo");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and String
   * play() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {
    SongPlayer sp = new SongPlayer();
    sp.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    sp.addFirst​(new Song("Out of Time", "The Weeknd", "3:34"));
    sp.addFirst​(new Song("Oh My God", "Adele", "3:45"));
    sp.addFirst​(new Song("Levitating", "Dua Lipa", "3:23"));
    Iterator<Song> iterator = sp.iterator();
    if ((!(iterator.next().getSongName().equals("Levitating"))
        || (!(iterator.next().getSongName().equals("Oh My God"))
            || (!(iterator.next().getSongName().equals("Out of Time"))
                || (!(iterator.next().getSongName().equals("Mojito"))))))) {
      return false;
    }
    sp.switchPlayingDirection();
    String ex = "Mojito---Jay Chou---3:05\n" + "Out of Time---The Weeknd---3:34\n"
        + "Oh My God---Adele---3:45\n" + "Levitating---Dua Lipa---3:23\n";
    if (!sp.play().equals(ex)) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of contains(Object song), clear(), isEmpty()and size()
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {
    SongPlayer sp = new SongPlayer();
    sp.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    sp.addFirst​(new Song("Out of Time", "The Weeknd", "3:34"));
    sp.addFirst​(new Song("Oh My God", "Adele", "3:45"));
    sp.addFirst​(new Song("Levitating", "Dua Lipa", "3:23"));
    if (sp.size() != 4 || sp.isEmpty()
        || (!(sp.contains(new Song("Levitating", "Dua Lipa", "3:23"))))
        || (!(sp.contains(new Song("Out of Time", "The Weeknd", "3:34"))))
        || (!(sp.contains(new Song("Oh My God", "Adele", "3:45"))))
        || (!(sp.contains(new Song("Mojito", "Jay Chou", "3:05"))))) {
      // System.out.println("gay");
      return false;
    }
    sp.clear();
    if (sp.size() != 0 || !sp.isEmpty()) {
      // System.out.println("lesbian");

      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {
    Song s1 = new Song("Mojito", "Jay Chou", "3:05");
    Song s2 = new Song("Out of Time", "The Weeknd", "3:34");
    Song s3 = new Song("Oh My God", "Adele", "3:45");
    LinkedNode<Song> node1 = new LinkedNode<Song>(null, s1, null);
    LinkedNode<Song> node2 = new LinkedNode<Song>(node1, s2, null);
    LinkedNode<Song> node3 = new LinkedNode<Song>(node2, s3, null);
    node1.setNext​(node2);
    node2.setNext​(node3);
    ForwardSongIterator iterator = new ForwardSongIterator(node1);
    if ((!(iterator.next().getSongName().equals("Mojito")))
        || (!(iterator.next().getSongName().equals("Out of Time")))
        || (!(iterator.next().getSongName().equals("Oh My God")))) {
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {
    Song s1 = new Song("Mojito", "Jay Chou", "3:05");
    Song s2 = new Song("Out of Time", "The Weeknd", "3:34");
    Song s3 = new Song("Oh My God", "Adele", "3:45");
    LinkedNode<Song> node1 = new LinkedNode<Song>(null, s1, null);
    LinkedNode<Song> node2 = new LinkedNode<Song>(node1, s2, null);
    LinkedNode<Song> node3 = new LinkedNode<Song>(node2, s3, null);
    node1.setNext​(node2);
    node2.setNext​(node3);
    BackwardSongIterator iterator = new BackwardSongIterator(node3);
    if ((!(iterator.next().getSongName().equals("Oh My God")))
        || (!(iterator.next().getSongName().equals("Out of Time")))
        || (!(iterator.next().getSongName().equals("Mojito")))) {
      return false;
    }
    return true;
  }

  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    if (testSong() && testLinkedNode() && testSongPlayerAdd() && testSongPlayerGet()
        && testSongPlayerRemove() && testSongPlayerIterator() && testSongPlayerCommonMethod()
        && testForwardSongIterator() && testBackwardSongIterator()) {
      return true;
    }
    return false;
  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {

    System.out.println(runAllTests());

  }
}
