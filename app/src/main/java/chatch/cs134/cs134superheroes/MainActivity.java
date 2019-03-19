package chatch.cs134.cs134superheroes;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.List;

import chatch.cs134.cs134superheroes.Model.Superhero;

public class MainActivity extends AppCompatActivity {

    private TextView questionNumberTextView;
    private ImageView personImageView;
    private TextView guessSubjectTextView;
    private Button[] mButtons = new Button[4];

    private List<Superhero> allSuperheroesList;  // all the heroes loaded from JSON
    private List<Superhero> mQuizSuperheroList; // superheroes in current quiz (just 10 of them)
    private Superhero mCorrectSuperhero; // correct superhero for the current question
    private int mTotalGuesses; // number of total guesses made
    private int mCorrectGuesses; // number of correct guesses
    private SecureRandom rng; // used to randomize the quiz
    private Handler handler; // used to delay loading next superhero



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
