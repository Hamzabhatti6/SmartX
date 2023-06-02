package com.hamza.smartx.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WidgetModel(
    val name : String,
    val image : Int,
    val maxTemp : Int,
    val minTemp : Int,
    val enable : Boolean,
    val userId : String
): Parcelable
