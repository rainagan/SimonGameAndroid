package rainagan.simongamendroid;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Created by Raina on 2017-11-29.
 */

public class Model extends Observable {
    // private variable
    private int score;
    // number of possible buttons
    private int numButton;
    // level of difficulty
    private int difficulty;
    // length of sequence
    private int length;
    // the sequence of buttons
    private ArrayList<Integer> sequence = new ArrayList<Integer>();

    // Model constructor
    Model(int diff, int but) {
        score = 0;
        difficulty = diff;
        numButton = but;
        length = 1;
    }

    // get difficulty (int)
    public int getIDiff() {
        return difficulty;
    }

    // get score
    public int getScore() {
        return score;
    }
    // increment score
    public void incrementScore() {
        score++;
        // observable API
        initObservers();
    }
    // set score
    public void setScore(int i) {
        this.score = i;
        // observable API
        initObservers();
    }

    // create random sequence with certain length
    public void initSeq() {
        // generate random sequence
        Random rand = new Random();
        for (int i=0; i<length; i++) {
            int b = rand.nextInt(numButton) + 1;
            sequence.add(b);
        }
    }

    // return sequence at index i
    public int getSeq(int i) {
        return sequence.get(i);
    }
    // clear current sequence
    public void clearSeq() {
        sequence.clear();
    }

    // return length
    public int getLength() {return length;}
    // increment length
    public void incrementLength() {length++;}
    // reset length to 1
    public void resetLength() {length = 1;}
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Observable Methods
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Helper method to make it easier to initialize all observers
     */
    public void initObservers() {
        setChanged();
        notifyObservers();
    }

    /**
     * Deletes an observer from the set of observers of this object.
     * Passing <CODE>null</CODE> to this method will have no effect.
     *
     * @param o the observer to be deleted.
     */
    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    /**
     * Adds an observer to the set of observers for this object, provided
     * that it is not the same as some observer already in the set.
     * The order in which notifications will be delivered to multiple
     * observers is not specified. See the class comment.
     *
     * @param o an observer to be added.
     * @throws NullPointerException if the parameter o is null.
     */
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    /**
     * Clears the observer list so that this object no longer has any observers.
     */
    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }

    /**
     * If this object has changed, as indicated by the
     * <code>hasChanged</code> method, then notify all of its observers
     * and then call the <code>clearChanged</code> method to
     * indicate that this object has no longer changed.
     * <p>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and <code>null</code>. In other
     * words, this method is equivalent to:
     * <blockquote><tt>
     * notifyObservers(null)</tt></blockquote>
     *
     * @see Observable#clearChanged()
     * @see Observable#hasChanged()
     * @see Observer#update(Observable, Object)
     */
    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}
