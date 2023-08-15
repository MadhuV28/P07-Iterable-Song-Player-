/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: SongPlayer
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
 * This is the SongPlayer Class which imlements Iterable<Song> and has the needed constructor and
 * mutators
 * 
 * @author mvuyyuru
 *
 */
public class SongPlayer implements Iterable<Song> {
  private int size; // size of the list
  private LinkedNode<Song> head; // head of this doubly linked list
  private LinkedNode<Song> tail; // tail of this doubly linked list
  private boolean playingBackward; // true if this song player is reading the list backward

  /**
   * Adds a Song as Last Song
   * 
   * @param oneSong - the song that is going to be added to the tail of this doubly linked list of
   *                songs
   * 
   * 
   */
  public void addLast​(Song oneSong) {
    LinkedNode<Song> newNode = new LinkedNode<Song>(tail, oneSong, null);
    if (tail == null) {
      tail = head = newNode;
    } else {
      tail.setNext​(newNode);
      tail = newNode;
    }
    size++;

  }



  /**
   * add Song as First Song
   * 
   * @param oneSong - the song that is going to be added to the head of this doubly linked list of
   *                songs
   * @throws NullPointerException - with a descriptive error message if the passed oneSong is null
   */
  public void addFirst​(Song oneSong) throws NullPointerException {
    if (oneSong == null) {
      throw new NullPointerException("passed oneSong is null");
    }
    LinkedNode<Song> newNode = new LinkedNode<Song>(null, oneSong, head);
    if (head == null) {
      head = tail = newNode;
    } else {
      head.setPrev​(newNode);
      head = newNode;
    }
    size++;
  }

  /**
   * adds Song at a given position/order within this collection of songs
   * 
   * @param index   - the given index where the new song will be added
   * 
   * @param oneSong - the song that is going to be added
   * @throws NullPointerException      - with a descriptive error message if the passed oneSong is
   *                                   null
   * @throws IndexOutOfBoundsException - with a descriptive error message if index is out of the 0
   *                                   .. size() range
   */
  public void add​(int index, Song oneSong) throws NullPointerException, IndexOutOfBoundsException {
    if (oneSong == null) {
      throw new NullPointerException("oneSong is null");
    }
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException(" index is out of the size() range");
    }
    if (index == 0) {
      addFirst​(oneSong);
      return;
    }
    LinkedNode<Song> temp = head;
    for (int i = 0; i < index - 1; i++) {
      temp = temp.getNext();
    }
    LinkedNode<Song> newNode = new LinkedNode<Song>(temp, oneSong, temp.getNext());
    temp.setNext​(newNode);
    newNode.getNext().setPrev​(newNode);
    size++;
  }


  /**
   * Returns the first Song in this list.
   * 
   * @return the Song at the head of this list
   * @throwsNoSuchElementException - with a descriptive error message if this list is empty
   */
  public Song getFirst() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException("the list is empty");
    }
    return head.getData();
  }

  /**
   * Returns the last Song in this list.
   * 
   * @return the Song at the tail of this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public Song getLast() throws NoSuchElementException {
    if (tail == null) {
      throw new NoSuchElementException("the list is empty");
    }
    return tail.getData();
  }

  /**
   * Returns the song at the specified position in this list.
   * 
   * @param index - index of the song to return
   * 
   * @return the song at the specified position in this list
   * @throws IndexOutOfBoundsException - with a descriptive error message if index is out of the 0
   *                                   .. size()-1 range
   */
  public Song get(int index) throws IndexOutOfBoundsException {
    if (index > size() - 1) {
      throw new IndexOutOfBoundsException("index is out of range");
    }
    LinkedNode<Song> temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getData();
  }

  /**
   * Removes and returns the first song from this list.
   * 
   * @return the first song from this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public Song removeFirst() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException(" the list is empty");
    }
    Song temp1 = head.getData();
    if (head.getNext() != null) {
      head = head.getNext();
      head.setNext​(null);
      size--;
    } else {
      clear();
    }
    return temp1;
  }

  /**
   * Removes and returns the last song from this list.
   * 
   * @return the last song from this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public Song removeLast() throws NoSuchElementException {
    if (tail == null) {
      throw new NoSuchElementException(" the list is empty");
    }
    Song temp1 = tail.getData();
    if (tail.getPrev() != null) {
      tail = tail.getPrev();
      tail.setNext​(null);
      size--;
    } else {
      clear();
    }
    return temp1;
  }

  /**
   * Removes the song at the specified position in this list and returns the song that was removed
   * from the list. The order of precedence of the other songs in the list should not be modified.
   * 
   * @param index - the index of the song to be removed
   * 
   * @return the song previously at the specified position
   * @throws IndexOutOfBoundsException - with a descriptive error message if index is out of the 0
   *                                   .. size()-1 range
   */
  public Song remove(int index) throws IndexOutOfBoundsException, NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException(" There is no elements to remove");
    }

    if (index < 0 || index > size() - 1) {
      throw new IndexOutOfBoundsException("index is out of range");
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == size - 1) {
      return removeLast();
    }
    if (index == 0) {
      removeFirst();


    }
    LinkedNode<Song> temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    // LinkedNode<Song> next = temp.getNext();
    Song s = temp.getData();

    temp.getPrev().setNext​(temp.getNext());
    if (temp.getNext() != null)
      temp.getNext().setPrev​(temp.getPrev());
    size--;
    return s;
  }

  /**
   * Returns true if this list contains a match with the specified song. More formally, returns true
   * if and only if this list contains at least one song e such that Objects.equals(o, e).
   * 
   * @param o - song whose presence in this list is to be tested
   * 
   * @return true if this list contains the specified song
   * 
   */
  public boolean contains(Song o) {
    LinkedNode<Song> temp = head;
    while (temp != null) {
      if (temp.getData().equals(o)) {
        return true;
      }
      temp = temp.getNext();
    }
    return false;
  }

  /**
   * Removes all of the songs from this list. The list will be empty after this call returns.
   * 
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Returns true if this list is empty.
   * 
   * @return true if this list is empty
   * 
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns the number of songs in this list.
   * 
   * @param newNode
   * @return the number of songs in this list
   * 
   */
  private LinkedNode<Song> setNext(LinkedNode<Song> newNode) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Returns the number of songs in this list.
   * 
   * @return the number of songs in this list
   * 
   */
  int size() {
    // TODO Auto-generated method stub
    return size;
  }

  /**
   * Returns an iterator to iterate through the songs in this list with respect to current playing
   * direction of this song player (either in the forward or in the backward direction). specified
   * by iterator in interface java.lang.Iterable<Song>
   * 
   * 
   * @return an Iterator to traverse the list of songs in this SongPlayer with respect to the
   *         current playing direction specified by the playingBackward data field.
   * 
   */
  @Override
  public Iterator<Song> iterator() {
    // TODO Auto-generated method stub
    if (playingBackward == false) {
      ForwardSongIterator iteratorforward = new ForwardSongIterator(head);
      return iteratorforward;
    } else {
      BackwardSongIterator iteratorbackward = new BackwardSongIterator(tail);
      return iteratorbackward;
    }
  }

  /**
   * Mutator of the playingDirection of this song player. It switches the playing direction by
   * setting playingBackward to its opposite value.
   * 
   */
  public void switchPlayingDirection() {
    playingBackward = !playingBackward;
  }

  /**
   * Plays the songs in this song player in the current playing direction. This method MUST be
   * implemented using an enhanced for-each loop.
   * 
   * @return a String representation of the songs in this song player. String representations of
   *         each song are separated by a newline. If this song player is empty, this method returns
   *         an empty string.
   * 
   */
  public String play() {
    String output = "";
    for (Iterator<Song> i = iterator(); i.hasNext();) {
      output += i.next().toString() + "\n";

    }

    return output;
  }
}
