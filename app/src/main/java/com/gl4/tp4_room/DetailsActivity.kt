package com.gl4.tp4_room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gl4.tp4_room.databinding.ActivityDetailsBinding
import com.gl4.tp4_room.viewModels.BusScheduleViewModel
import com.gl4.tp4_room.viewModels.BusScheduleViewModelFactory

class DetailsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityDetailsBinding

    private val viewModel: BusScheduleViewModel by viewModels {
        BusScheduleViewModelFactory(
            (application as BusScheduleApplication).database.scheduleDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val stopName = intent.getStringExtra("stop_name")!!

        binding.title.text = "Bus Schedule for "+stopName
        Log.d("binding", binding.title.text as String)
        Log.d("stop", stopName)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        val busStopAdapter = BusStopAdapter(emptyList()) { schedule ->
            Log.d("clicked", "clicked")
        }

        recyclerView.adapter = busStopAdapter

        viewModel.scheduleForStopName(stopName).observe(this) {
            busStopAdapter.updateList(it)
        }

        /*
        Thread {
            val  list = viewModel.scheduleForStopName(stopName)
            Handler(Looper.getMainLooper()).post {
                busStopAdapter.updateList(list)

            }
        }.start()
*/


        binding.backIcone.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}