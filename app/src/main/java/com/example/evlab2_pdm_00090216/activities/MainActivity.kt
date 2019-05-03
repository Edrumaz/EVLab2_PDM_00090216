package com.example.evlab2_pdm_00090216.activities

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.evlab2_pdm_00090216.R
import com.example.evlab2_pdm_00090216.fragments.ButtonsFragment
import com.example.evlab2_pdm_00090216.fragments.FirstFragment
import com.example.evlab2_pdm_00090216.fragments.SecondFragment
import com.example.evlab2_pdm_00090216.fragments.ThirdFragment

class MainActivity : AppCompatActivity(),
    ButtonsFragment.OnFragmentInteractionListener,
    FirstFragment.OnFragmentInteractionListener,
    SecondFragment.OnFragmentInteractionListener,
    ThirdFragment.OnFragmentInteractionListener{


    lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecondFragment
    lateinit var thirdFragment: ThirdFragment
    var currentFragment = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPrevious : Button = findViewById(R.id.btn_previous)
        var btnNext : Button = findViewById(R.id.btn_next)

        btnPrevious.setOnClickListener { view ->
            previousPicture(currentFragment)
        }
        btnNext.setOnClickListener { view ->
            nextPicture(currentFragment)
        }
        startFirstFragment()
    }

    fun startFirstFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, firstFragment)
            .addToBackStack(firstFragment.toString())
            .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    fun previousPicture(position: Int) {
        when (true) {
            position == 1 -> {
                currentFragment = 3
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, thirdFragment)
                    .addToBackStack(thirdFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            position == 3 -> {
                currentFragment = 2
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, secondFragment)
                    .addToBackStack(secondFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            position == 2 -> {
                currentFragment = 1
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, firstFragment)
                    .addToBackStack(firstFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }
    }

    fun nextPicture(position: Int){
        when (true) {
            position == 1 -> {
                currentFragment = 2
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, secondFragment)
                    .addToBackStack(secondFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            position == 2 -> {
                currentFragment = 3
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, thirdFragment)
                    .addToBackStack(thirdFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            position == 3 -> {
                currentFragment = 1
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, firstFragment)
                    .addToBackStack(firstFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }
    }

    override fun onFragmentInteraction(uri: Uri){}

}
