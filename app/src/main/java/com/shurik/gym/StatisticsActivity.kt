package com.shurik.gym

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class StatisticsActivity :AppCompatActivity() {

    override fun onCreate (savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.stat)
    }

}
