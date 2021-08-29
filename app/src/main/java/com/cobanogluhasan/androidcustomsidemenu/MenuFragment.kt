package com.cobanogluhasan.androidcustomsidemenu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.cobanogluhasan.androidcustomsidemenu.databinding.FragmentMenuBinding

class MenuFragment : Fragment(), MenuAdapter.OnOptionClick {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initialize recyclerview
        initRecycler()
    }

    private fun initRecycler() {
        Log.i("staryed", "initRecycler: ")
        //get the strings and add to list
        val list = mutableListOf<String>()
        list.add(getString(R.string.option_1))
        list.add(getString(R.string.option_2))
        list.add(getString(R.string.option_3))
        list.add(getString(R.string.option_4))
        list.add(getString(R.string.option_5))

        binding.optionMenu.apply {
            //create new adapter instance and apply it to our recyclerview.
            menuAdapter = MenuAdapter(this@MenuFragment)
            val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            layoutManager = manager
            adapter = menuAdapter
        }
        //send our menu to the adapter.
        menuAdapter.submitData(list)
    }

    override fun onOptionClick(position: Int, option: String) {
        Toast.makeText(requireContext(), option, Toast.LENGTH_LONG).show()
        //hide menu
        //accesing the parent activity's method.
        (activity as MainActivity).hideMenu()
    }
}