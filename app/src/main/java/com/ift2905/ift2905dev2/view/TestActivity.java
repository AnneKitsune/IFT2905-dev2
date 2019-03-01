package com.ift2905.ift2905dev2.view;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.ift2905.ift2905dev2.R;
import com.ift2905.ift2905dev2.model.TestData;
import com.ift2905.ift2905dev2.utils.Accessor;


public class TestActivity extends AppCompatActivity {

    public static TestData[] results;

    public State state = State.Waiting;
    public int currentTest = 0;

    public int screen_width, screen_height;

    private enum State {
        Waiting,
        Running;
    }

    long lastClickTime = 0;
    int lastX, lastY;
    int currentButtonSize = 0;

    Button startButton;
    Button testButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(startListener);

        testButton = findViewById(R.id.test_button);
        testButton.setOnTouchListener(testListener);
        testButton.setVisibility(View.INVISIBLE);

        updateScreenDimensions();

        results = new TestData[getResources().getInteger(R.integer.tries)];
    }

    public void enableTest() {
        startButton.setVisibility(View.INVISIBLE);
        testButton.setVisibility(View.VISIBLE);
        randomize();
        lastClickTime = System.currentTimeMillis();

        lastX = (int)testButton.getX();
        lastY = (int)testButton.getY();

    }

    View.OnClickListener startListener = new View.OnClickListener() {
        public void onClick(View v) {
            enableTest();
        }
    };

    View.OnTouchListener testListener = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    randomize();


                    TestActivity.results[currentTest] = genTestData();
                    lastClickTime = System.currentTimeMillis();

                    // If we wanted to use the click position instead of the button delta position.
                    //float x = event.getRawX();
                    //float y = event.getRawY();

                    if (currentTest >= getResources().getInteger(R.integer.tries) - 1) {
                        testButton.setVisibility(View.INVISIBLE);
                        openResultActivity();
                    }
                    currentTest++;

                    break;

                default: break;
            }

            return true;
        }
    };

    private TestData genTestData() {
        float dt = (System.currentTimeMillis() - lastClickTime) / 1000f;
        return new TestData(currentTest, lastX - testButton.getX(), lastY - testButton.getY(), dt, currentButtonSize);
    }



    private void updateScreenDimensions(){
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        screen_width = dm.widthPixels;
        screen_height = dm.heightPixels;
    }

    private int randomButtonSize() {
        int screen_min = Math.min(screen_width, screen_height);
        int size = (int)((Math.random() * (screen_min * Accessor.floatFromConf(this, R.dimen.button_size_max_ratio) - screen_min * Accessor.floatFromConf(this, R.dimen.button_size_min_ratio))
                + screen_min * Accessor.floatFromConf(this, R.dimen.button_size_min_ratio)));
        return size;
    }

    private void randomizeButtonSize() {
        int size = randomButtonSize();
        currentButtonSize = size;
        
        testButton.getLayoutParams().width = size;
        testButton.getLayoutParams().height = size;
        testButton.setWidth(size);
        testButton.setHeight(size);
    }

    private void randomizeButtonPosition() {
        int margin = currentButtonSize;

        int x = (int)(Math.random() * (screen_width - margin*2));
        int y = (int)(Math.random() * (screen_height - margin*2));

        testButton.setX(x);
        testButton.setY(y);
    }

    private void randomize() {
        randomizeButtonSize();
        randomizeButtonPosition();
    }


    public void openResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

}
