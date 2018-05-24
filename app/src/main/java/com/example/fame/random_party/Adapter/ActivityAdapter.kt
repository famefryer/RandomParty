package com.example.fame.random_party.Adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import com.example.fame.random_party.R
import com.example.fame.random_party.data.Activity_Data
import kotlinx.android.synthetic.main.activity_list.view.*

/**
 * Created by fame on 24/5/2561.
 */
class ActivityAdapter(val items : ArrayList<Activity_Data>,val context:Context) :  RecyclerView.Adapter<ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_list,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setView(items.get(position))
    }

}

class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
    var tv_topic : TextView
    var tv_date :TextView
    var tv_location:TextView
    var tv_time:TextView
    init {
        tv_topic = view.tvAct_topic
        tv_date = view.tvAct_date
        tv_location = view.tvAct_location
        tv_time = view.tvAct_time

    }
    public fun setView(ad : Activity_Data){
        tv_topic.setText(ad.activity_name)
        tv_date.setText("Date:"+ad.activity_date)
        tv_location.setText("Location:"+ad.activity_location)
        tv_time.setText("Time:"+ad.activity_time)
    }
}