package com.hamza.smartx.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hamza.smartx.R
import com.hamza.smartx.adapters.GenericRecyclerViewInteraction
import com.hamza.smartx.adapters.WidgetsAdapter
import com.hamza.smartx.databinding.FragmentHomeBinding
import com.hamza.smartx.models.WidgetModel
import com.hamza.smartx.ui.viewmodels.WidgetsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), GenericRecyclerViewInteraction {

    @Inject
    lateinit var widgetsAdapter: WidgetsAdapter
    lateinit var binding: FragmentHomeBinding
    private val widgetsViewModel: WidgetsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        widgetsAdapter.setConfig(this)
        binding.gridWidgets.adapter = widgetsAdapter

        init()
        return binding.root
    }

    private fun init(){

        widgetsViewModel.getWidgetsList { list ->
            widgetsAdapter.updateList(list!!)
        }

    }

    override fun onItemClicked(position: Int) {
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, Bundle().apply {
            putInt("position", position)
        })
    }
}