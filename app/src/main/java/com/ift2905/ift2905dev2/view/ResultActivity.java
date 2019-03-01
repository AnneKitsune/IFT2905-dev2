package com.ift2905.ift2905dev2.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ift2905.ift2905dev2.R;
import com.ift2905.ift2905dev2.model.RegressionData;
import com.ift2905.ift2905dev2.model.TestData;
import com.ift2905.ift2905dev2.utils.Regression;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        RegressionData reg = Regression.regression(this, TestActivity.results);

        TextView textA = (TextView) findViewById(R.id.reg_a);
        textA.setText("a "+reg.getA());

        TextView textB = (TextView) findViewById(R.id.reg_b);
        textB.setText("b "+reg.getB());

        TextView textCoeff = (TextView) findViewById(R.id.reg_coeff);
        textCoeff.setText("coefficient "+reg.getCoeff());


        listView = (ListView) findViewById(R.id.list_view);


        ArrayList<String> ls = new ArrayList<String>();

        for (TestData result : TestActivity.results) {
            ls.add("Temps: "+result.getDeltaTime()+" ID: "+result.difficulty());
        }



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                ls );
        listView.setAdapter(adapter);

        Button retryButton = (Button) findViewById(R.id.retry);
        retryButton.setOnClickListener(retryListener);

    }

    View.OnClickListener retryListener = new View.OnClickListener() {
        public void onClick(View v) {
            retry();
        }
    };

    private void retry() {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
}
