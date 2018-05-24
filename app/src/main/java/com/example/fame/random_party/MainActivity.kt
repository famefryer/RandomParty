package com.example.fame.random_party

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.fame.random_party.Adapter.ActivityAdapter
import com.example.fame.random_party.data.Activity_Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adList : ArrayList<Activity_Data> = ArrayList()
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText("Latest")
                profile_layout.visibility = View.INVISIBLE
                profile_layout_history.visibility = View.INVISIBLE
                profile_layout_score.visibility = View.INVISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText("Around U")
                profile_layout.visibility = View.INVISIBLE
                profile_layout_history.visibility = View.INVISIBLE
                profile_layout_score.visibility = View.INVISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText("Profile")
                profile_layout.visibility = View.VISIBLE
                profile_layout_history.visibility = View.VISIBLE
                profile_layout_score.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_activity_list.layoutManager = LinearLayoutManager(this)
        rv_activity_list.adapter = ActivityAdapter(adList,this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun addActivity(){

    }
}
