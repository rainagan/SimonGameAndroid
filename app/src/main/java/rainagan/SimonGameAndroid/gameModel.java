package rainagan.simongamendroid;

import java.util.Observable;
import java.util.Observer;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Raina on 2017-11-29.
 */

public class gameModel extends ViewModel implements Observer {
    //    private int numButton;
    private Model model;
    private MutableLiveData<String> score;

    // initialize data
    public void init(int diff, int but) {
        if (score == null) {
            score = new MutableLiveData<String>();
        }
        model = new Model(diff, but);
//        if (model == null) {
//            model = Model.getInstance();
//            model.addObserver(this);
//        }
        model.initObservers();
    }

    // get score
    public MutableLiveData<String> getScore() {
        return score;
    }

    // set score
    public void setScore(int i) {
        model.setScore(i);
    }

    public void update(Observable o, Object arg) {
        // update textview
        score.setValue(Integer.toString(model.getScore()));
    }
}
