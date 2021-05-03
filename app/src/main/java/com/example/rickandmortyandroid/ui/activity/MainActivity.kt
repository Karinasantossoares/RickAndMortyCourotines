package com.example.rickandmortyandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.rickandmortyandroid.R
import com.example.rickandmortyandroid.databinding.ActivityMainBinding
import com.example.rickandmortyandroid.ui.fragment.ListCharactersFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListCharactersFragment.newInstance()).commit()
    }
}