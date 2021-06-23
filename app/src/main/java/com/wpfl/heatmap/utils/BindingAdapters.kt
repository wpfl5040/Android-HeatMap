package com.wpfl.heatmap.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("setDays")
    fun setDays(textView: TextView, date: LocalDate) {
         textView.text = date.format(DateTimeFormatter.ofPattern("dd"))
    }

}