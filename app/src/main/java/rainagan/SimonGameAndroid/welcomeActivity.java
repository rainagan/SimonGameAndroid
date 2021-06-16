package rainagan.simongamendroid;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class welcomeActivity extends AppCompatActivity {
    // private vars
    private Button start;
    private Button setting;
    private gameModel gm;
    private Model model;
    private int[] option = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set view content
        setContentView(R.layout.activity_welcome);

        // set button ref
        start = (Button) findViewById(R.id.view1_start);
        setting = (Button) findViewById(R.id.view1_setting);

        // Create onClick Listener for Button
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // default, normal level, 4 buttons
                option[0] = 3;
                option[1] = 4;
                startActivity(new Intent(welcomeActivity.this, fourButtonActivity.class).putExtra("Option",option));
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update view model
                startActivity(new Intent(welcomeActivity.this, chooseDiffActivity.class));
            }
        });
    }
}
