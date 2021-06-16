package rainagan.simongamendroid;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

/**
 * Created by Raina on 2017-11-29.
 */

public class chooseButtonActivity extends AppCompatActivity {
    // private vars
    private Model model;
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button main;
    private gameModel gm;
    private int diff;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Set View Content
        setContentView(R.layout.activity_choose_button);

        // Set button ref
        but1 = (Button) findViewById(R.id.choose_button1);
        but2 = (Button) findViewById(R.id.choose_button2);
        but3 = (Button) findViewById(R.id.choose_button3);
        but4 = (Button) findViewById(R.id.choose_button4);
        but5 = (Button) findViewById(R.id.choose_button5);
        but6 = (Button) findViewById(R.id.choose_button6);
        main = (Button) findViewById(R.id.main);

        // get difficulty level, store it in an arraylist
        Intent i = getIntent();
        int diff = i.getIntExtra("Diff",0);
        final int[] options = new int[2];
        options[0] = diff;

        // Create onClick Listener for Button, if button is click,
        // pass difficulty and number of buttons to init model
        but1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                options[1] = 1;
                startActivity(new Intent(chooseButtonActivity.this, oneButtonActivity.class).putExtra("Option", options));
            }
        });
        but2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                options[1] = 2;
                startActivity(new Intent(chooseButtonActivity.this, twoButtonActivity.class).putExtra("Option", options));

            }
        });
        but3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                options[1] = 3;
                startActivity(new Intent(chooseButtonActivity.this, threeButtonActivity.class).putExtra("Option", options));

            }
        });
        but4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                options[1] = 4;
                startActivity(new Intent(chooseButtonActivity.this, fourButtonActivity.class).putExtra("Option", options));

            }
        });
        but5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                options[1] = 5;
                startActivity(new Intent(chooseButtonActivity.this, fiveButtonActivity.class).putExtra("Option", options));

            }
        });
        but6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                options[1] = 6;
                startActivity(new Intent(chooseButtonActivity.this, sixButtonActivity.class).putExtra("Option", options));

            }
        });
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chooseButtonActivity.this, welcomeActivity.class));
            }
        });
    }


}
