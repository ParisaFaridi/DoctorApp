package com.example.doctorapp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

typealias ClickHandler = (Int) -> Unit

class DoctorAdapter(private var clickHandler: ClickHandler) :
    ListAdapter<Doctor, DoctorAdapter.ViewHolder>(DoctorDiffCallback) {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_doc_name)
        val tvId: TextView = view.findViewById(R.id.tv_doc_id)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.doctor_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = getItem(position).name
        holder.tvId.text = getItem(position).id.toString()
        holder.tvName.setOnClickListener {
            clickHandler.invoke(getItem(position).id)
        }
    }
}

object DoctorDiffCallback : DiffUtil.ItemCallback<Doctor>() {

    override fun areItemsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
        return oldItem.id == newItem.id
    }
}
