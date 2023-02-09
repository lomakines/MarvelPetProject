package com.bignerdranch.android.marvelpetproject.presentation.marvel.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.marvelpetproject.R
import com.bignerdranch.android.marvelpetproject.presentation.utils.root
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        root(MarvelListFragment.newInstance())
    }
}