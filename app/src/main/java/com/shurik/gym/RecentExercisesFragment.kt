package com.shurik.gym


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shurik.gym.adapters.ExercisesAdapter
import com.shurik.gym.database.AppDatabase
import com.shurik.gym.database.GymEntity

class RecentExercisesFragment : Fragment() {

    companion object {
        fun newInstance() : RecentExercisesFragment {
            return RecentExercisesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_recent_exercises,container,false)



        var recentList = view.findViewById<RecyclerView>(R.id.recentList)
        val llm = LinearLayoutManager(context)
        recentList?.layoutManager = llm

        var db = AppDatabase.getInstance(context)

        var exercises : List<GymEntity> = db?.gymDao()!!.getRecentExercises()

        var adapter  = ExercisesAdapter()
        recentList.adapter = adapter

        return view
    }
}