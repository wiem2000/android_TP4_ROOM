package com.gl4.tp4_room





import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.gl4.tp4_room.database.entities.Schedule
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


class BusStopAdapter(private var busStops: List<Schedule>, private val onItemClick: (Schedule) -> Unit) :

    RecyclerView.Adapter<BusStopAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stopText: TextView
        val arrivalText: TextView

        init {
            stopText = itemView.findViewById(R.id.textStopName)
            arrivalText = itemView.findViewById(R.id.textArrival)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bus_stop_item, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: BusStopAdapter.ViewHolder, position: Int) {
        val stop = busStops[position]

        holder.stopText.text = stop.stopName

        val instant = Instant.ofEpochSecond(stop.arrivalTime).minus(Duration.ofHours(7))

        // Specify the desired time zone
        val zoneId = ZoneId.systemDefault()

        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val formattedTime = instant.atZone(zoneId).format(formatter)


        holder.arrivalText.text = formattedTime+ " AM"
        holder.itemView.setOnClickListener {
            onItemClick(stop)
        }
    }


    override fun getItemCount(): Int {
        return busStops.size

    }

    fun updateList(list: List<Schedule>){
        busStops = list
        notifyDataSetChanged()

    }
}

/*

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gl4.tp4.database.entities.Schedule
import java.text.SimpleDateFormat
import java.util.*


class BusStopAdapter(
    private var schedules: List<Schedule>,
    private val onItemClicked: (Schedule) -> Unit
) : RecyclerView.Adapter<BusStopAdapter.BusStopViewHolder>() {

    class BusStopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stopNameTextView: TextView = itemView.findViewById(R.id.textStopName)
        val arrivalTimeTextView: TextView = itemView.findViewById(R.id.textArrival)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusStopViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.bus_stop_item, parent, false)

        val viewHolder = BusStopViewHolder(itemView)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(schedules[position])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: BusStopViewHolder, position: Int) {
        val schedule = schedules[position]
        holder.stopNameTextView.text = schedule.stopName
        holder.arrivalTimeTextView.text = SimpleDateFormat("h:mm a").format(Date(schedule.arrivalTime.toLong() * 1000))
    }

    override fun getItemCount(): Int {
        return schedules.size
    }

    fun updateList(list: List<Schedule>){
        schedules = list
        notifyDataSetChanged()

    }
}

*/
