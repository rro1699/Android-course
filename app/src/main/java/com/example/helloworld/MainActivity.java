package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

/*import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;*/

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private LineChart chart;
    private ArrayList<Entry> entriesSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = manager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensorList) {
            Log.d("MainActivity",sensor.getName());
        }
        manager.registerListener(listener,manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),SensorManager.SENSOR_DELAY_GAME);

        entriesSecond = new ArrayList<>();
        entriesSecond.add(new Entry(0.5f, 0f));
        entriesSecond.add(new Entry(2.5f, 2f));
        entriesSecond.add(new Entry(3.5f, 1f));
        entriesSecond.add(new Entry(3.6f, 2f));
        entriesSecond.add(new Entry(4f, 0.5f));
        entriesSecond.add(new Entry(5.1f, -0.5f));

        // На основании массива точек создаем вторую линию с названием
        LineDataSet datasetSecond = new LineDataSet(entriesSecond, "График второй");
        // График будет зеленого цвета
        datasetSecond.setColor(Color.GREEN);
        // График будет плавным
        datasetSecond.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        LineData data = new LineData(datasetSecond);
        // Передадим данные для графика в сам график
        chart = findViewById(R.id.chart);
        chart.setData(data);

        // График будет анимироваться 0.5 секунды
        chart.animateY(500);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Timer timer = new Timer();
        timer.schedule(timerTask,5*1000L, 10*1000L);
    }

    private final TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Collections.reverse(entriesSecond);
            LineDataSet datasetSecond = new LineDataSet(entriesSecond, "График второй");
            // График будет зеленого цвета
            datasetSecond.setColor(Color.GREEN);
            // График будет плавным
            datasetSecond.setMode(LineDataSet.Mode.CUBIC_BEZIER);

            LineData data = new LineData(datasetSecond);
            // Передадим данные для графика в сам график
            chart = findViewById(R.id.chart);
            chart.setData(data);

            // График будет анимироваться 0.5 секунды
            chart.animateY(500);
        }
    };
    private final SensorEventListener listener = new SensorEventListener() {
        private final List<Integer> TYPES = List.of(Sensor.TYPE_AMBIENT_TEMPERATURE,
                Sensor.TYPE_PROXIMITY,Sensor.TYPE_PRESSURE,Sensor.TYPE_LIGHT,Sensor.TYPE_RELATIVE_HUMIDITY);
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if(TYPES.contains(sensorEvent.sensor.getType())){
                Log.d(sensorEvent.sensor.getName(), ""+sensorEvent.values[0]);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

}