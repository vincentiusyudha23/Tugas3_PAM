package com.example.pam

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam.model.SkillModel

class SkillAdapter (
    var data: ArrayList<SkillModel>,
    var context: Activity?,
    var onItemClick: (String) -> Unit
    ): RecyclerView.Adapter<SkillAdapter.MyViewHolder>(){


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val namaSkill = view.findViewById<TextView>(R.id.tv_skill)
    }

    fun setfilteredList(data: ArrayList<SkillModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_skill_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val skillName = data[position].namaSkill

        holder.namaSkill.text = skillName

        holder.itemView.setOnClickListener{
            holder.itemView.setBackgroundColor(Color.BLUE)
            if (skillName != null) {
                onItemClick(skillName)
            }
        }
    }
}