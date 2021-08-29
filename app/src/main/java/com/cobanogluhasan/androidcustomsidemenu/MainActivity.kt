package com.cobanogluhasan.androidcustomsidemenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.cobanogluhasan.androidcustomsidemenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var isMenuShowing = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.setOnClickListener { toggleBtn() }
        //hide the menu on anywhere click
        binding.container.setOnClickListener { hideMenu() }
    }

    private fun toggleBtn() {
        if (!isMenuShowing) {
            //show the menu if is not showing
            binding.fragmentContainerView.visibility = View.VISIBLE
            //prepare and load animation
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left_to_right)
            binding.fragmentContainerView.startAnimation(animation)
            // isMenuShowing = assign reverse of the current state.
            // if it's true it'll be false. if it's false, it will be true
            isMenuShowing = !isMenuShowing
        } else hideMenu()
    }

    //hideMenu should not be private otherwise we can not acces from the child fragment.
    fun hideMenu() {
        if (isMenuShowing) {
            //hide menu if it's showing
            binding.fragmentContainerView.visibility = View.INVISIBLE
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_right_to_left)
            binding.fragmentContainerView.startAnimation(animation)
            isMenuShowing = false
        }
    }
}