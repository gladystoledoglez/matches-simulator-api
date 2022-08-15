package com.example.matchessimulatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.matchessimulatorapp.databinding.ActivityMainBinding
import com.example.matchessimulatorapp.extensions.transitionTo
import com.example.matchessimulatorapp.presenter.fragments.MatchesFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.transitionTo(MatchesFragment.newInstance(), isBackStack = false)
    }
}