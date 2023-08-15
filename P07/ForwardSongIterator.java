/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ForwardSongIterator
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
import java.util.NoSuchElementException;

/**
 * this has the ForwardSongIterator which implements Iterator<Song> with the constructors and
 * methods
 * 
 * @author mvuyyuru
 *
 */
public class ForwardSongIterator implements Iterator<Song> {
  private LinkedNode<Song> next; // reference to the next linked node in a list of nodes.

  /**
   * Creates a new iterator which iterates through songs in front/head to back/tail order
   * 
   * @param first - reference to the head of a doubly linked list of songs
   * 
   */
  public ForwardSongIterator(LinkedNode<Song> first) {
    next = first;
  }

  /**
   * Checks whether there are more songs to return
   * 
   * @return true if there are more songs to return and false otherwise
   */
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return next != null;
  }

  /**
   * Returns the next song in the iteration
   * 
   * @throws NoSuchElementException - with a descriptive error message if there are no more songs to
   *                                return in the reverse order (meaning if this.hasNext() returns
   *                                false)
   */
  @Override
  public Song next() throws NoSuchElementException {
    // TODO Auto-generated method stub
    if (!hasNext()) {
      throw new NoSuchElementException("There are no more songs to return");
    }
    Song curr = next.getData();
    next = next.getNext();
    return curr;
  }
}
