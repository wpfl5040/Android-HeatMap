package com.wpfl.heatmap

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wpfl.heatmap.databinding.ActivityMainBinding
import com.wpfl.heatmap.model.testData
import org.threeten.bp.LocalDate


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = HeatMapAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


        binding.recyclerHeatMap.adapter = adapter.apply {
            submitList(testData())
        }

        setMonth()

    }


    private fun setMonth() {

        (1..12).forEach {
            val monthText = TextView(this).apply {
                LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
                )
                text = "${it}월"
                id = it
                setTextColor(Color.BLACK)
                textSize = 18F
                gravity = Gravity.CENTER
            }
            binding.lytMonth.addView(monthText)
        }

    }

}