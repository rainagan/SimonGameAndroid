package rainagan.simongamendroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Raina on 2017-11-29.
 */

public class chooseDiffActivity extends AppCompatActivity {
    // private vars
    private Button easy;
    private Button normal;
    private Button hard;
    private Button main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set view content
        setContentView(R.layout.activity_choose_diff);

        // set button ref
        easy = (Button) findViewById(R.id.choose_easy);
        normal = (Button) findViewById(R.id.choose_normal);
        hard = (Button) findViewById(R.id.choose_hard);
        main = (Button) findViewById(R.id.main);

        // Create onClick Listener for Button
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set game to be easy
                startActivity(new Intent(chooseDiffActivity.this, chooseButtonActivity.class).putExtra("Diff",1));
            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set game to be normal
                startActivity(new Intent(chooseDiffActivity.this, chooseButtonActivity.class).putExtra("Diff",3));
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set game to be hard
                startActivity(new Intent(chooseDiffActivity.this, chooseButtonActivity.class).putExtra("Diff",5));
            }
        });
        // press this and go back to welcome page
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chooseDiffActivity.this, welcomeActivity.class));
            }
        });
    }
}
