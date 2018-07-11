package com.shurik.gym.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shurik.gym.R
import com.shurik.gym.database.GymEntity

class ExercisesAdapter : RecyclerView.Adapter<ExercisesAdapter.ViewHolder>() {

    private var exercises : List<GymEntity>? = null

    fun ExercisesAdapter ( exercises : List<GymEntity>) {
        this.exercises = exercises
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var card : CardView
        var exerciseTV : TextView

        init {
            card = itemView.findViewById(R.id.card)
            exerciseTV = itemView.findViewById(R.id.exerciseTV)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var setsData = ""
        var exercise : String = exercises!!.component1().exerciseType
        var sets : Array<Int> = exercises!!.component2().countSets
        var repeats : Array<Int> = exercises!!.component3().countRepeats
        var weight : Array<Double> = exercises!!.component4().weight
        var adapterData = "$exercise\n Sets/repeats/weight:\n"
        for (i in sets.indices) {
            var set: String = sets[i].toString()
            var repeat: String = repeats[i].toString()
            var wght: String = weight[i].toString()
            setsData = "$adapterData$set/$repeat/$wght\n"
        }
        holder.exerciseTV.text = setsData
    }

    override fun getItemCount(): Int {
        return exercises!!.size
    }

}