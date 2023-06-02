package com.hamza.smartx.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.hamza.smartx.BR
import com.hamza.smartx.R
import com.hamza.smartx.models.ControlsModel
import java.util.ArrayList
import javax.inject.Inject

class ControlAdapter @Inject constructor() : RecyclerView.Adapter<ControlAdapter.RecyclerViewHolder>() {

    private val listItems = mutableListOf<ControlsModel>()
    private var genericRecyclerViewInteraction: GenericRecyclerViewInteraction? = null

    fun setConfig(
        genericRecyclerViewInteraction: GenericRecyclerViewInteraction,
    ) {
        this.genericRecyclerViewInteraction = genericRecyclerViewInteraction
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_controls,
            parent,
            false
        )
        return RecyclerViewHolder(binding.root, parent.context)
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = listItems[position]
        holder.binding?.setVariable(BR.model, item)
        holder.binding?.executePendingBindings()

        holder.itemView.setOnClickListener {
            item.enable = !item.enable
            notifyItemChanged(position)
        }
    }

    fun updateList(items: ArrayList<ControlsModel>) {
        this.listItems.clear()
        this.listItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listItems.size ?: -1

    inner class RecyclerViewHolder(view: View?, var c: Context) : RecyclerView.ViewHolder(view!!) {
        var binding: ViewDataBinding?

        init {
            binding = DataBindingUtil.bind(view!!)
        }
    }
}