package com.shurik.gym.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.shurik.gym.CalendarFragment
import com.shurik.gym.RecentExercisesFragment

class ViewPagerAdapter internal  constructor (fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private val COUNT = 2

    override fun getItem(position: Int): Fragment? {
        var fragment : Fragment? = null
        when (position) {
            0 -> fragment = RecentExercisesFragment()
            1 -> fragment = CalendarFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return COUNT
    }

}