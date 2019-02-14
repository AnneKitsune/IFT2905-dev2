package com.ift2905.ift2905dev2;

/////pour test////////////
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    Button btn;

    static int screen_width, screen_height;
    static int btn_size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(btn_listener);
    }



    View.OnClickListener btn_listener = new View.OnClickListener() {
        public void onClick(View v) {

            btn.setBackgroundColor(Color.WHITE);
            btn.setText("");

            Handler timer = new Handler();
            timer.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_size = getButtonSize();
                    System.out.println(btn_size);

                    btn.getLayoutParams().width = btn_size;
                    btn.getLayoutParams().height = btn_size;
                    btn.setWidth(btn_size);
                    btn.setHeight(btn_size);

                    // je ne sais pas exactement comment utiliser setX et setY.
                    // pour tester, j'ai mis 0 pour x, y. mais la location de bouton change tout le temps dans la secteur haut gauche..
                    int x = 0;//screen_width - btn_size;
                    int y = 0;//screen_height - btn_size ;
                    btn.setX(x); btn.setY(y);

                    btn.setBackgroundColor(Color.RED);
                    btn.setText("button");

                }
            }, 2000);


        }

    };

    private int getButtonSize(){
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        screen_width = dm.widthPixels;
        screen_height = dm.heightPixels;
        //System.out.println("screen width = " + width);
        //System.out.println("screen height = " + height);

        int screen_min = getMin(screen_width, screen_height);
        btn_size = (int)(Math.random() * (screen_min/2 - screen_min/25 + 1)) + screen_min/25;
        System.out.println("Button size =" + btn_size);
        return btn_size;
    }

    public static int getMin(int num1, int num2) {
        if(num1 > num2) {
            return num2;
        } else {
            return num1;
        }
    }




}
