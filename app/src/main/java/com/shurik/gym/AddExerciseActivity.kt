package com.shurik.gym

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.shurik.gym.database.AppDatabase
import com.shurik.gym.database.ExerciseEntity

class AddExerciseActivity : AppCompatActivity() {

    val EXTRA_ID: String = "extra"
    lateinit var spinner: Spinner
    var list_of_sets = arrayOf(1..5)
    var list_of_repeats = arrayOf(1..20)
    var context : Context = this
    lateinit var exercise : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_add)
        supportActionBar?.setTitle(R.string.toolbar_add_subtitle)

        val date = intent.getStringExtra(EXTRA_ID)

        var exerciseName: EditText = findViewById(R.id.exercise_field)
        exerciseName.visibility = EditText.INVISIBLE

        spinner = findViewById(R.id.spinner)
        AsyncExercise().execute(context)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                exercise = spinner.selectedItem.toString()
            }
        }

        val revert = findViewById<TextView>(R.id.revert)
        val noExercise = findViewById<TextView>(R.id.not_in_list)

        noExercise.setOnClickListener { spinner.visibility = Spinner.INVISIBLE
            exerciseName.visibility = EditText.VISIBLE
            revert.visibility = TextView.VISIBLE
            exercise = ""}

        revert.setOnClickListener {spinner.visibility = Spinner.VISIBLE
            exerciseName.visibility = EditText.INVISIBLE
            revert.visibility = TextView.INVISIBLE }

        val addSet = findViewById<Button>(R.id.add_field)
        addSet.setOnClickListener {  }
    }



    @SuppressLint("StaticFieldLeak")
    inner class AsyncExercise : AsyncTask<Context, Void, List<ExerciseEntity>>() {

        private lateinit var db: AppDatabase
        @SuppressLint("StaticFieldLeak")

        override fun onPreExecute() {
            super.onPreExecute()
            db = AppDatabase.getInstance(context)!!
        }

        override fun doInBackground(vararg context: Context?): List<ExerciseEntity> {

            var exercises: List<ExerciseEntity> = arrayListOf()

            try {
                exercises = db.exerciseDao().getExercise()
            } catch (ex: Exception) {
                // val toast = Toast.makeText(context, ex.message, Toast.LENGTH_LONG).show()
            }
            return exercises
        }

        override fun onPostExecute(result: List<ExerciseEntity>) {

            spinner.adapter = ArrayAdapter(context,R.layout.support_simple_spinner_dropdown_item,result)
        }
    }
}


