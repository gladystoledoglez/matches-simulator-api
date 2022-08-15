package com.example.matchessimulatorapp.extensions

import androidx.fragment.app.FragmentManager
import com.example.matchessimulatorapp.R
import com.example.matchessimulatorapp.presenter.fragments.MatchesFragment

fun FragmentManager.transitionTo(fragment: MatchesFragment, isBackStack: Boolean = true) {
    val transition = beginTransaction().replace(R.id.fcvContainer, fragment)
    if (isBackStack) {
        transition.addToBackStack(fragment.javaClass.simpleName)
    }
    transition.commit()

}