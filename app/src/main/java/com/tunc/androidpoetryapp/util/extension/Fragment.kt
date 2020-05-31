package com.tunc.androidpoetryapp.util.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.tunc.androidpoetryapp.R

fun Fragment.safeController(): NavController? {
    this.view?.let {
        return findNavController()
    }
    return null
}

fun Fragment.findController(): NavController? {
    this.view?.let {
        return Navigation.findNavController(requireActivity(), R.id.fragment_tab_nav_host_fragment)
    }
    return null
}