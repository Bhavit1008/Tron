package com.example.envento.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.envento.MainActivity
import com.example.envento.R
import com.example.envento.model.Event
import com.example.envento.ui.user.RegistrationActivity
import kotlinx.android.synthetic.main.event_item_layout.view.*

class EventListAdapter (val eventList :List<Event> , val context: Context) :RecyclerView.Adapter<EventListAdapter.EventViewHolder>()
{

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return  EventViewHolder(LayoutInflater.from(context).inflate(R.layout.event_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.itemView.txt_event_name.text = eventList.get(position).eventName
        holder.itemView.txt_event_date.text = eventList.get(position).date
        holder.itemView.txt_event_venue.text = eventList.get(position).venue
        holder.itemView.txt_event_type.text = eventList.get(position).eventType
        val con = holder.itemView.btn_intrested.context
        holder.itemView.btn_intrested.setOnClickListener{
            val i = Intent(context,RegistrationActivity::class.java)
            i.putExtra("eventId",eventList[position]._id)
            context.startActivity(i)
        }
    }
}