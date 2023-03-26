package com.mustafanarin.artbookkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustafanarin.artbookkotlin.databinding.RecyclerRowBinding

class ArtAdapter(val artList : ArrayList<Arts>) : RecyclerView.Adapter<ArtAdapter.ArtHolder>() {

    class ArtHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArtHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        holder.binding.recyclerViewTextView.text= artList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,ArtAktivity::class.java)
            intent.putExtra("info","old")
            intent.putExtra("id",artList.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return artList.size
    }


}