package com.shurik.gym

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RecentExercisesFragment : Fragment() {

    companion object {
        fun newInstance() : RecentExercisesFragment {
            return RecentExercisesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recent_exercises,container,false)
    }
}