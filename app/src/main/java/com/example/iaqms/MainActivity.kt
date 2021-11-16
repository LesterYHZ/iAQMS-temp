package com.example.iaqms

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.button)
        startButton.text = "START"
        var state: Int = 0
        val sensor1TextView: TextView = findViewById(R.id.textView_S1)
        val sensor2TextView: TextView = findViewById(R.id.textView_S2)
        val sensor3TextView: TextView = findViewById(R.id.textView_S3)
        sensor1TextView.text = "0"
        sensor2TextView.text = "0"
        sensor3TextView.text = "0"

        val graph: GraphView = findViewById(R.id.idGraphView)
        graph.title = "Illuminance Plot";

        val series = LineGraphSeries<DataPoint>()
        var sTime: Double = 0.0
        var sIlluminance: Double = 0.0

        /**
         * Update graphView
         */
        series.appendData(DataPoint(sTime,sIlluminance), true, 500)
        sTime = 2.5
        sIlluminance = 4.6
        series.appendData(DataPoint(sTime,sIlluminance), true, 500)
        series.appendData(DataPoint(6.0,5.0), true, 500)
        series.appendData(DataPoint(8.0,7.0), true, 500)
        series.title = "Sensor 1"
        series.color = Color.RED
        graph.addSeries(series)

        val series2 = LineGraphSeries<DataPoint>()
        series2.appendData(DataPoint(0.0,0.0), true, 500)
        series2.appendData(DataPoint(2.0,3.0), true, 500)
        series2.appendData(DataPoint(6.0,2.0), true, 500)
        series2.appendData(DataPoint(8.0,9.0), true, 500)
        series2.title = "Sensor 2"
        series2.color = Color.GREEN
        graph.addSeries(series2)

        graph.legendRenderer.isVisible = true
        graph.legendRenderer.align = LegendRenderer.LegendAlign.TOP



        startButton.setOnClickListener {
            if (state == 0) {
                startButton.text = "END"
                state = 1

                sensor1TextView.text = "545"
                sensor2TextView.text = "656"
                sensor3TextView.text = "767"
            }
            else if (state == 1) {
                startButton.text = "START"
                state = 0

                sensor1TextView.text = "0"
                sensor2TextView.text = "0"
                sensor3TextView.text = "0"
            }
        }
    }
}