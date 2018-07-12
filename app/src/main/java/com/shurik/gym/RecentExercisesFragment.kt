package com.shurik.gym


import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.shurik.gym.adapters.ExercisesAdapter
import com.shurik.gym.database.AppDatabase
import com.shurik.gym.database.GymEntity

class RecentExercisesFragment : Fragment() {

    lateinit var recentList: RecyclerView

    companion object {
        fun newInstance(): RecentExercisesFragment {
            return RecentExercisesFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recent_exercises, container, false)

        recentList = view.findViewById(R.id.recentList)
        val llm = LinearLayoutManager(context)
        recentList?.layoutManager = llm

        AsyncQuery().execute(context)

        return view
    }

    @SuppressLint("StaticFieldLeak")
    inner class AsyncQuery : AsyncTask<Context, Void, List<GymEntity>>() {

        private lateinit var db: AppDatabase
        @SuppressLint("StaticFieldLeak")

        override fun onPreExecute() {
            super.onPreExecute()
            db = AppDatabase.getInstance(context)!!
        }

        override fun doInBackground(vararg context: Context?): List<GymEntity> {

            var recentExercises: List<GymEntity> = arrayListOf()

            try {
                var exercises: List<GymEntity> = db.gymDao().getGym()
                recentExercises = exercises.takeLast(10)
            } catch (ex: Exception) {
               // val toast = Toast.makeText(context, ex.message, Toast.LENGTH_LONG).show()
            }
            return recentExercises
        }

        override fun onPostExecute(result: List<GymEntity>) {
            recentList.adapter = ExercisesAdapter(result)
        }
    }
}

