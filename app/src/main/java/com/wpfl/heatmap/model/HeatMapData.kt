package com.wpfl.heatmap.model

import android.util.Log
import org.threeten.bp.LocalDate
import java.lang.Exception


data class HeatMapData(
    val date: LocalDate,
    val timeSec: Int
)


fun testData() : List<HeatMapData> {
    val returnList = mutableListOf<HeatMapData>()
    val monthList = mutableListOf<Int>()

    val minusDays = when(LocalDate.now().dayOfWeek.value) {
        1 -> 365 2 -> 366 3 -> 367 4 -> 368 5 -> 369 6 -> 370 7 -> 371
        else -> throw Exception("DayOfWeek Exception : 없는 요일에 접근하였습니다.")
    }

    (minusDays downTo 0).forEachIndexed { index, day ->
        val date = LocalDate.now().minusDays(day.toLong())

        if(date.dayOfMonth == 1)  Log.d("//index", (index / 7).toString())
        returnList.add(HeatMapData(date, 10))
    }


    return returnList.toList()
}