package com.ift2905.ift2905dev2.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.ift2905.ift2905dev2.R;
import com.ift2905.ift2905dev2.model.TestData;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);


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

    }
}
