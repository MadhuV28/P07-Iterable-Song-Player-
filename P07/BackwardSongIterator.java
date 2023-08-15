/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: BackwardSongIterator
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
 * this has the BackwardSongIterator which implements Iterator<Song> with the constructors and
 * methods
 * 
 * @author mvuyyuru
 *
 */
public class BackwardSongIterator implements Iterator<Song> {
  private LinkedNode<Song> next; // reference to the next linked node in a list of nodes

  /**
   * Creates a new iterator which iterates through songs in back/tail to front/head order
   * 
   * @param last - reference to the tail of a doubly linked list of songs
   * 
   */
  public BackwardSongIterator(LinkedNode<Song> last) {
    next = last;
  }

  /**
   * Checks whether there are more songs to return in the reverse order
   * 
   * @return true if there are more songs to return in the reverse order
   * 
   */
  @Override
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
  public Song next() {
    // TODO Auto-generated method stub
    if (this.hasNext() == false) {
      throw new NoSuchElementException("there are no more songs to return in the reverse order");
    }
    Song temp = next.getData();
    next = next.getPrev();
    return temp;
  }
}
