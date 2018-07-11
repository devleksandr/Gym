package com.shurik.gym

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView

class CalendarFragment : Fragment() {
    public val EXTRA_ID : String = "extra"


    companion object {

        fun newInstance() : CalendarFragment {
            return CalendarFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_calendar,container,false)

        var calendar = view.findViewById<CalendarView>(R.id.calendarView)
        calendar.setOnDateChangeListener {view,year,month,dayOfMonth ->
            val intent = Intent (context,AddExerciseActivity::class.java)
            intent.putExtra(EXTRA_ID,"$year-$month-$dayOfMonth")
            startActivity(intent)
        }

        return view
    }
}