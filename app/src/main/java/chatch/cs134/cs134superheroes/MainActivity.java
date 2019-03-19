package chatch.cs134.cs134superheroes;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chatch.cs134.cs134superheroes.Model.JSONLoader;
import chatch.cs134.cs134superheroes.Model.Superhero;

public class MainActivity extends AppCompatActivity {

    private TextView questionNumberTextView;
    private ImageView personImageView;
    private TextView guessSubjectTextView;
    private Button[] mButtons = new Button[4];
    private TextView answerTextView;
    private static final int HEROES_IN_QUIZ = 10;

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

        questionNumberTextView = findViewById(R.id.questionNumberTextView);
        personImageView = findViewById(R.id.personImageView);
        guessSubjectTextView = findViewById(R.id.guessSubjectTextView);
        answerTextView = findViewById(R.id.answerTextView);
        mButtons[0] = findViewById(R.id.choice1Button);
        mButtons[1] = findViewById(R.id.choice2Button);
        mButtons[2] = findViewById(R.id.choice3Button);
        mButtons[3] = findViewById(R.id.choice4Button);

        mQuizSuperheroList = new ArrayList<Superhero>(HEROES_IN_QUIZ);
        rng = new SecureRandom();
        handler = new Handler();

        questionNumberTextView.setText(getString(R.string.question, 1, HEROES_IN_QUIZ));
        try {
            allSuperheroesList = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("CS 134 Superheroes", e.getMessage());
        }

        resetQuiz();
    }

    /**
     * Sets up and starts a new quiz.
     */
    public void resetQuiz() {

        // DONE: Reset the number of correct guesses made
        mCorrectGuesses = 0;
        // DONE: Reset the total number of guesses the user made
        mTotalGuesses = 0;
        // DONE: Clear list of quiz superheroes (for prior games played)
        mQuizSuperheroList.clear();
        // DONE: Randomly add HEROES_IN_QUIZ (10) superheroes from the allSuperheroesList into the mQuizSuperheroesList
        int size = allSuperheroesList.size();
        int randomPosition;
        Superhero randomHero;
        while(mQuizSuperheroList.size() <= HEROES_IN_QUIZ)
        {
            randomPosition = rng.nextInt(size);
            randomHero = allSuperheroesList.get(randomPosition);
            // Check for duplicates (contains)
            // If quiz list DOESNT contain random hero, add it!
            if (!mQuizSuperheroList.contains(randomHero))
                mQuizSuperheroList.add(randomHero);
        }

        // Let's set the text of the 4 buttons to the first 4 superhero names
        for (int i = 0; i < mButtons.length; i++)
            mButtons[i].setText(mQuizSuperheroList.get(i).getName());

        // DONE: Ensure no duplicate countries (e.g. don't add a country if it's already in mQuizCountriesList)

        // DONE: Start the quiz by calling loadNextFlag
        loadNextHero();
    }

    /**
     * Method initiates the process of loading the next superhero for the quiz, showing
     * the person's image and then 4 buttons, one of which contains the correct answer.
     */
    private void loadNextHero() {
        // DONE: Initialize the mCorrectSuperhero by removing the item at position 0 in the mQuizSuperheroes
        mCorrectSuperhero = mQuizSuperheroList.get(0);
        mQuizSuperheroList.remove(0);

        // DONE: Clear the mAnswerTextView so that it doesn't show text from the previous question
        answerTextView.setText("");
        // DONE: Display current question number in the questionNumberTextView
        questionNumberTextView.setText(getString(R.string.question, mCorrectGuesses + 1, HEROES_IN_QUIZ));

        // DONE: Use AssetManager to load next image from assets folder
        AssetManager am = getAssets();

        try {
            InputStream stream = am.open(mCorrectSuperhero.getImageName());
            Drawable image = Drawable.createFromStream(stream, mCorrectSuperhero.getName());
            personImageView.setImageDrawable(image);

        } catch (IOException e) {
            Log.e("CS 134 Superheroes", e.getMessage());
        }

        // DONE: Get an InputStream to the asset representing the next superhero
        // DONE: and try to use the InputStream to create a Drawable
        // DONE: The file name can be retrieved from the correct hero's file name.
        // DONE: Set the image drawable to the correct superhero.

        // DONE: Shuffle the order of all the superheroes (use Collections.shuffle)
        do{
            Collections.shuffle(allSuperheroesList);

        }while(allSuperheroesList.subList(0, mButtons.length).contains(mCorrectSuperhero));

        // DONE: Loop through all 4 buttons, enable them all and set them to the first 4 superheroes
        for( int i = 0; i< mButtons.length; i++){
            mButtons[i].setEnabled(true);
            mButtons[i].setText(allSuperheroesList.get(i).getName());
        }
        // DONE: in the all superheroes list


        // DONE: After the loop, randomly replace one of the 4 buttons with the name of the correct superhero
        mButtons[rng.nextInt(mButtons.length)].setText(mCorrectSuperhero.getName());

    }
}
