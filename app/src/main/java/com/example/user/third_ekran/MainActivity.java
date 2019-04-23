package com.example.user.third_ekran;



import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;


public class MainActivity extends AppCompatActivity {




    TextView advise;
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> datae = new ArrayList<Integer>();
     LineChartView lineChartView;
    PieChartView pieChartView;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        result.add(0, 34);
        result.add(1, 20);
        result.add(2, 30);
        result.add(3, 25);
        result.add(4, 20);


        datae.add(0, 1);
        datae.add(1, 2);
        datae.add(2, 3);
        datae.add(3, 4);
        datae.add(4, 5);


        TextView advise = findViewById(R.id.advise_1);



        lineChartView = findViewById(R.id.chart);


        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();


        Line line = new Line(yAxisValues).setColor(getResources().getColor(R.color.gold));

        for (int i = 0; i < datae.size(); i++) {
            axisValues.add(i, new AxisValue(i).setLabel(String.valueOf(datae.get(i))));
        }

        for (int i = 0; i < result.size(); i++) {
            yAxisValues.add(new PointValue(i, result.get(i)));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setName(getResources().getString(R.string.data));
        axis.setTextColor(getResources().getColor(R.color.black));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName(getResources().getString(R.string.result));
        yAxis.setTextColor(getResources().getColor(R.color.black));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);



        pieChartView = findViewById(R.id.pieChartView);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(15, getColor(R.color.redd)).setLabel("Math"));
        pieData.add(new SliceValue(25,  getColor(R.color.pieData_second_color)).setLabel("English"));
        pieData.add(new SliceValue(10,  getColor(R.color.pieData_third_color)).setLabel("Physics"));


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setCenterText1(getResources().getString(R.string.subjects));
        pieChartData.setHasCenterCircle(true).setCenterText1FontSize(20).setCenterText1Color(Color.BLACK);
        pieChartView.setPieChartData(pieChartData);






        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) <= 10) advise.setText(R.string.advise_1);
            else advise.setText(R.string.advise_1_1);
        }

    }


}