package com.shurik.gym.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shurik.gym.R
import com.shurik.gym.database.GymEntity

class ExercisesAdapter(val exercises: List<GymEntity>) : RecyclerView.Adapter<ExercisesAdapter.ViewHolder>() {

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
        var exercise : String = exercises!!.component1().exerciseType
        var sets : String = exercises!!.component2().countSets
        var repeats : String = exercises!!.component3().countRepeats
        var weight : String = exercises!!.component4().weight
        var adapterData = "$exercise\nSets: $sets\nRepeats:$repeats\nWeight:$weight"

        holder.exerciseTV.text = adapterData
    }

    override fun getItemCount(): Int {
        return exercises!!.size
    }

}