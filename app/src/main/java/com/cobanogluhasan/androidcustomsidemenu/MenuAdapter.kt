package com.cobanogluhasan.androidcustomsidemenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cobanogluhasan.androidcustomsidemenu.databinding.MenuListItemBinding

class MenuAdapter(private val listener: OnOptionClick) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    private val TAG = "MenuAdapter"
    private var optionList = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate the layout file with viewbinding
        return ViewHolder(
            MenuListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //bind the data to the view by calling bind function and pass the option string
        holder.bind(optionList[position])
    }

    override fun getItemCount(): Int = optionList.size

    inner class ViewHolder(private val binding: MenuListItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(option: String) {
            // bind the data -> to textview in that case
            binding.textView.text = option
        }

        init {
            binding.textView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val option = optionList[position]
            listener.onOptionClick(position, option)
        }
    }

    //send the data list to adapter from the fragment/activity by calling adapter.submitData()
    fun submitData(list: List<String>) {
        optionList = list
    }

    interface OnOptionClick {
        fun onOptionClick(position: Int, option: String)
    }
}