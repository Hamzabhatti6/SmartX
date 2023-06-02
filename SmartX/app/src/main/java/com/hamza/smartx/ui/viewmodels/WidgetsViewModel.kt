package com.hamza.smartx.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.smartx.R
import com.hamza.smartx.models.WidgetModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class WidgetsViewModel : ViewModel() {

    val widgetList : ArrayList<WidgetModel> = ArrayList()

    fun getWidgetsList(callback: (ArrayList<WidgetModel>?) -> Unit) {
        viewModelScope.launch {
            try {
                widgetList.add(WidgetModel("Air conditioner", R.drawable.ic_ac,100,0,true,""))
                widgetList.add(WidgetModel("Camera", R.drawable.ic_camera,100,0,false,""))
                widgetList.add(WidgetModel("Fan", R.drawable.ic_fan,100,0,false,""))
                widgetList.add(WidgetModel("Iron", R.drawable.ic_iron,100,0,true,""))
                widgetList.add(WidgetModel("Fridge", R.drawable.ic_fridge,100,0,false,""))
                widgetList.add(WidgetModel("LED", R.drawable.ic_lcd,100,0,false,""))
                widgetList.add(WidgetModel("Microwave", R.drawable.ic_microwave,100,0,false,""))
                widgetList.add(WidgetModel("Stove", R.drawable.ic_stove,100,0,false,""))
                widgetList.add(WidgetModel("Home theater", R.drawable.ic_theater,100,0,true,""))
                widgetList.add(WidgetModel("Washing machine", R.drawable.ic_washing_machine,100,0,false,""))

                callback.invoke(widgetList)

            } catch (e: Exception) {
                e.printStackTrace()
                callback.invoke(null)
            }

        }
    }
}