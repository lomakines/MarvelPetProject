package com.bignerdranch.android.marvelpetproject.presentation.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bignerdranch.android.marvelpetproject.R

fun AppCompatActivity.root(fragment: Fragment) {

    supportFragmentManager
        .beginTransaction()
        .add(R.id.container, fragment)
        .commit()
}

fun Fragment.replace(fragment: Fragment) {

    parentFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment)
        .addToBackStack(null)
        .commit()
}