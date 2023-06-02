package com.hamza.smartx.ui.fragments.widgetDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hamza.smartx.R
import com.hamza.smartx.adapters.ControlAdapter
import com.hamza.smartx.adapters.WidgetsAdapter
import com.hamza.smartx.databinding.FragmentDetailBinding
import com.hamza.smartx.databinding.FragmentHomeBinding
import com.hamza.smartx.models.ControlsModel
import com.hamza.smartx.models.WidgetModel
import com.hamza.smartx.ui.viewmodels.WidgetsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment() {
    @Inject
    lateinit var adapter: ControlAdapter
    lateinit var binding: FragmentDetailBinding
    val controlsList : ArrayList<ControlsModel> = ArrayList()
    private val widgetsViewModel: WidgetsViewModel by viewModels()
    lateinit var widget : WidgetModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.run {
            getInt("position").let {
                widget =  widgetsViewModel.widgetList[it]
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)

        binding.gridControls.adapter = adapter

        init()
        return binding.root
    }

    private fun init(){
        binding.tvWidget.text = widget.name



        controlsList.add(ControlsModel("Air(L)",true,R.drawable.ic_ac))
        controlsList.add(ControlsModel("Air(R)",false,R.drawable.ic_fan))
        controlsList.add(ControlsModel("L n R(L)",false,R.drawable.ic_camera))
        controlsList.add(ControlsModel("L n R(R)",true,R.drawable.ic_microwave))
        controlsList.add(ControlsModel("Heating",false,R.drawable.ic_fridge))
        controlsList.add(ControlsModel("Health",false,R.drawable.ic_lcd))
        controlsList.add(ControlsModel("Mute",false,R.drawable.ic_stove))
        controlsList.add(ControlsModel("Sleep",true,R.drawable.ic_stove))

        adapter.updateList(controlsList)

    }

}