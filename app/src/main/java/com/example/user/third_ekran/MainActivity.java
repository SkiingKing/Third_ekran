package com.example.user.third_ekran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView advise;
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> data = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result.add(0,8);
        result.add(1,10);
        result.add(2,15);
        result.add(3,20);
        result.add(4,22);


        data.add(0,11);
        data.add(1,11);
        data.add(2,12);
        data.add(3,13);
        data.add(4,14);


        TextView advise = findViewById(R.id.advise_1);


        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(result.get(0), data.get(0)),
                new DataPoint(result.get(1), data.get(1)),
                new DataPoint(result.get(2), data.get(2)),
                new DataPoint(result.get(3), data.get(3)),
                new DataPoint(result.get(4), data.get(4))

        });
        graph.addSeries(series);

        for(int i=0;i<result.size();i++){
            if(result.get(i) <= 10) advise.setText(R.string.advise_1);
            else advise.setText(R.string.advise_1_1);
        }

    }
}
