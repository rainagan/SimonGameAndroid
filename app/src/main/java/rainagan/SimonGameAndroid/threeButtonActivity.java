package rainagan.simongamendroid;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Raina on 2017-11-29.
 */

public class threeButtonActivity extends AppCompatActivity {
    // private vars
    private Model model;
    private TextView scoreView;
    private TextView msg;
    private Button c1;
    private Button c2;
    private Button c3;
    private Button play;
    private Button main;
    private final Handler handler = new Handler();
    private int delay;
    private ArrayList<Integer> sequence = new ArrayList<Integer>();
    private ArrayList<Integer> uSequence = new ArrayList<Integer>();
    private int length;
    private boolean win;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_but3);

        Intent i = getIntent();
        int[] options = i.getIntArrayExtra("Option");

        // set model
        model = new Model(options[0], options[1]);
        length = 1;
        win = true;

        // set circle text ref
        scoreView = findViewById(R.id.but1_scoreView);
        c1 = (Button) findViewById(R.id.but1_cb1);
        c2 = (Button) findViewById(R.id.but1_cb2);
        c3 = (Button) findViewById(R.id.but1_cb3);
        main = (Button) findViewById(R.id.main);
        msg = findViewById(R.id.but1_msg);
        play = findViewById(R.id.play);

        // press main button to go back to welcome page
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(threeButtonActivity.this, welcomeActivity.class));
            }
        });

        // press play button to start game
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }

    // a method to let computer show sequence
    public void startGame() {
        // disable buttons while computer is playing
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        play.setEnabled(false);

        model.initSeq();

        for (int i = 0; i < model.getLength(); i++) {
            delay = (i + 1) * 2000 / model.getIDiff();
            int b = model.getSeq(i);
            if (b == 1) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // pressed button look
                        c1.setBackgroundResource(R.drawable.solidcircle);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // released button lock
                                c1.setBackgroundResource(R.drawable.circleshape);
                            }
                        }, 1000 / model.getIDiff());
                    }
                }, delay);
            } else if (b==2) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // pressed button look
                        c2.setBackgroundResource(R.drawable.solidcircle);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // released button lock
                                c2.setBackgroundResource(R.drawable.circleshape);
                            }
                        }, 1000 / model.getIDiff());
                    }
                }, delay);
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // pressed button look
                        c3.setBackgroundResource(R.drawable.solidcircle);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // released button lock
                                c3.setBackgroundResource(R.drawable.circleshape);
                            }
                        }, 1000 / model.getIDiff());
                    }
                }, delay);
            }
        }
        // show user message
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                msg.setText("It's your turn!");
                // enable buttons
                c1.setEnabled(true);
                c2.setEnabled(true);
                c3.setEnabled(true);
            }
        }, 1000 + delay);

        // call this method to let user play
        userGame();
    }

    // a method that allow user to play
    public void userGame() {
        // handle click event
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if press, add to user sequence
                uSequence.add(1);
                // if user press enough buttons
                if (uSequence.size() == model.getLength()) {
                    // check if user sequence is correct
                    for (int i = 0; i < model.getLength(); i++) {
                        // if not correct, show user message and reset game
                        if (model.getSeq(i) != uSequence.get(i)) {
                            win = false;
                        }
                    }
                    // verify user sequence
                    verify();
                }

                // Update pressed button view
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        c1.setBackgroundResource(R.drawable.solidcircle);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                c1.setBackgroundResource(R.drawable.circleshape);
                            }
                        }, 1000 / model.getIDiff());
                    }
                }, 0);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if press, add to user sequence
                uSequence.add(2);
                // if user press enough buttons
                if (uSequence.size() == model.getLength()) {
                    // check if user sequence is correct
                    for (int i = 0; i < model.getLength(); i++) {
                        // if not correct, show user message and reset game
                        if (model.getSeq(i) != uSequence.get(i)) {
                            win = false;
                        }
                    }

                    verify();
                }
                // Update pressed button view
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        c2.setBackgroundResource(R.drawable.solidcircle);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                c2.setBackgroundResource(R.drawable.circleshape);
                            }
                        }, 1000 / model.getIDiff());
                    }
                }, 0);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if press, add to user sequence
                uSequence.add(3);
                // if user press enough buttons
                if (uSequence.size() == model.getLength()) {
                    // check if user sequence is correct
                    for (int i = 0; i < model.getLength(); i++) {
                        // if not correct, show user message and reset game
                        if (model.getSeq(i) != uSequence.get(i)) {
                            win = false;
                        }
                    }

                    verify();
                }
                // Update pressed button view
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        c3.setBackgroundResource(R.drawable.solidcircle);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                c3.setBackgroundResource(R.drawable.circleshape);
                            }
                        }, 1000 / model.getIDiff());
                    }
                }, 0);
            }
        });
        // if user click play button, start a new round
        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // show user message
                msg.setText("Follow the sequence to play");
                startGame();
            }
        });
    }

    public void verify() {
        // disable buttons while computer is playing
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
        play.setEnabled(false);
        if (win) {
            // if user sequence is correct, show user message and increment sequence length
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    msg.setGravity(Gravity.CENTER);
                    msg.setText("You won! Press Play button to start next level");
                    model.incrementScore();
                    scoreView.setText(Integer.toString(model.getScore()));

                    // let user to press play button to start new round
                    play.setEnabled(true);
                }
            }, 1000 / model.getIDiff());
            // after one round, clear stored sequence
            model.clearSeq();
            uSequence.clear();
            // increment sequence length
            model.incrementLength();
        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    msg.setGravity(Gravity.CENTER);
                    msg.setText("You lose! Press Play button to restart game");
                    scoreView.setText(Integer.toString(0));
                    model.setScore(0);

                    // let user to press play button to start new round
                    play.setEnabled(true);
                }
            }, 500);

            // after one round, clear stored sequence
            model.clearSeq();
            uSequence.clear();
            // reset game
            model.resetLength();
            win = true;
        }
    }
}
