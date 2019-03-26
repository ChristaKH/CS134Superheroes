package chatch.cs134.cs134superheroes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import chatch.cs134.cs134superheroes.Model.Settings;

public class SettingsActivity extends AppCompatActivity {

    private ListView settingsListView;
    private List<Settings> settingsList;
    private final CharSequence[] values = {" Superhero Name ", " Superpower ", " One Thing "};
    private Intent intent;
    private AlertDialog settingsDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        settingsListView = findViewById(R.id.settingsListView);
        intent = new Intent(this, MainActivity.class);

        settingsList = new ArrayList<Settings>();
        settingsList.add( new Settings("Quiz Type","Choose superhero name, superpower, or one thing about them"));

        SettingsListAdapter adapter = new SettingsListAdapter(this, R.layout.setting_detail, settingsList);
        settingsListView.setAdapter(adapter);
        settingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);

                builder.setTitle("Quiz Type");

                builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {

                        switch(item)
                        {
                            case 0:

                                intent.putExtra("Setting", "Name");
                                break;
                            case 1:
                                intent.putExtra("Setting", "Superpower");
                                break;
                            case 2:
                                intent.putExtra("Setting", "OneThing");
                                break;
                        }
                        settingsDialog.dismiss();
                    }
                });
                settingsDialog = builder.create();
                settingsDialog.show();
            }
        });

        Toolbar settingsToolbar = findViewById(R.id.settingsToolbar);
        setSupportActionBar(settingsToolbar);
        getSupportActionBar().setTitle("Settings");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.return_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // If item is selected, inflate the main activity
        // Only 1 menu option item to click
        startActivity(intent);
        return true;
    }

}
