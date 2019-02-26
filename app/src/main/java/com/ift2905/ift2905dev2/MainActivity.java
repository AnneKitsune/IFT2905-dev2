package com.ift2905.ift2905dev2;

import android.content.Intent;
import android.graphics.Color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    Button btn;

    static int screen_width, screen_height;
    static int btn_size;
    static int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(btn_listener);
    }



    View.OnClickListener btn_listener = new View.OnClickListener() {
        public void onClick(View v) {

            if (i == 0) {
                btn.setBackgroundColor(Color.WHITE);
                // by using removeView, we need to clear the screen, maybe......
                btn.setText("");
            }


            btn_size = getButtonSize();
            System.out.println(btn_size);



            btn.getLayoutParams().width = btn_size;
            btn.getLayoutParams().height = btn_size;
            btn.setWidth(btn_size);
            btn.setHeight(btn_size);


            int x = screen_width /3;
            int y = screen_height /3;
            btn.setX(x); btn.setY(y);


            btn.setBackgroundColor(Color.RED);
            btn.setText("button");

            //System.out.println("X : " + btn.getRawX());
            //System.out.println("Y : " + btn.getRawY());



            if (i == 5) {      // quand i == 20, on doit calculer le resultat et afficher le resultat dans autre ecran.
                // pour tester, j'ai mis 5. sinon, je dois cliquer 20 fois.
                openActivity2();
            }

            i++;
            System.out.println(i);


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


    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

}
