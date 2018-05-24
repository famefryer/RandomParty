package com.example.fame.random_party

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.fame.random_party.Adapter.ActivityAdapter
import com.example.fame.random_party.data.Activity_Data
import com.example.fame.random_party.data.Profile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var curPro : Profile = Profile("Pawan Intawongsa","    Hello My name is Pawan (AKA Tent kung) I lived in Bangkok Thailand.","Tent Kung")
    var adList : ArrayList<Activity_Data> = ArrayList()
    var curLocation : String = "Central Param 9"
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText("Latest")
                profile_layout.visibility = View.GONE
                profile_layout_history.visibility = View.GONE
                profile_layout_score.visibility = View.GONE
                rv_activity_list.adapter = ActivityAdapter(adList,this)
                rv_activity_list.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText("Around U : "+curLocation)
                var places : ArrayList<Activity_Data> = getNearPlace(curLocation)
                rv_activity_list.adapter = ActivityAdapter(places,this)

                profile_layout.visibility = View.GONE
                profile_layout_history.visibility = View.GONE
                profile_layout_score.visibility = View.GONE
                rv_activity_list.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText("Profile")
                profile_layout.visibility = View.VISIBLE
                profile_layout_history.visibility = View.VISIBLE
                profile_layout_score.visibility = View.VISIBLE
                rv_activity_list.visibility = View.GONE

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_mockData()
        setProfile()

        rv_activity_list.layoutManager = LinearLayoutManager(this)
        recyclerHistory.layoutManager = LinearLayoutManager(this)
        rv_activity_list.adapter = ActivityAdapter(adList,this)
        recyclerHistory.adapter = ActivityAdapter(curPro.history,this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun getNearPlace(location:String ):ArrayList<Activity_Data>{
        var near_places : ArrayList<Activity_Data> = ArrayList()
        adList.forEach({
           if(location.equals(it.activity_location)){
               near_places.add(it)
           }
        })
        return near_places
    }

    fun setProfile(){
        profile_name.setText(curPro.name)
        profile_about_me.setText(curPro.about_me)
        profile_nickname.setText(curPro.nickname)
        profile_score.setText(curPro.score.toString()+"/10.0")
    }

    fun add_mockData(){
        adList.add(Activity_Data("BB gun war","Central Praram 9","12:00-16.00","The war is begin, If you are the one who love to play fps game. Now it's your chance to prove you are not just the nerd. You are the killer!!","25/05/2561"))
        adList.add(Activity_Data("ROV 48hours","Too Fast Too Sleep","None","If you are the one who always play ROV. We are your family!!. Let's join us and play ROV 2 days without sleep.","27/05/2561"))
        adList.add(Activity_Data("Coding 25 hours","Kasetsart University","8.00-24.00","Kong sama want to invite everyone who fall in love with coding like him to watch and respect his coding skill","20/06/2561"))
        adList.add(Activity_Data("Football Waimun","Sanam Yha Na Barn","14.00-18.00","Come and Play football with us.","01/07/2561"))
        adList.add(Activity_Data("Nerd day","HUBBA Co-working space","10.00-20.00","If you are the one who called nerd. Come and meet your family. We are the king of nerd.","04/08/2561"))
        adList.add(Activity_Data("Rap is now 8","Future Park","19.00-24.00","Rap battle that is the most famous in thailand.","27/09/2561"))
        adList.add(Activity_Data("Country song meeting","Central Param 9","17.00-19.00","The meeting of the person who love country song. Let's meet and sing with us.","05/10/2561"))
        adList.add(Activity_Data("Boxing club","Central Param 9","18.00-20.00","We love boxing. If you love join us.","22/11/2561"))

        curPro.score = 6.9
        curPro.addActivity(Activity_Data("Thammaguy","Wat Thammaguy","6.00-24.00","Release your sin and touch the new hope.","17/12/2560"))
        curPro.addActivity(Activity_Data("PubG Gun mai Ja","Kasetsart University","00.00-18.00","Play pubG forever.","15/05/2561"))
        curPro.addActivity(Activity_Data("Pray for allahu","Muslim comunity","18.00-22.00","Pray for allahu the true god","10/03/2561"))
    }
}
