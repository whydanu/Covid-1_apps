package com.whydanu.informasicovid19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whydanu.informasicovid19.R
import com.whydanu.informasicovid19.model.ProvinceResponse
import kotlinx.android.synthetic.main.activity_item_province.view.*

class ProvinceAdapter (private var list : ArrayList<ProvinceResponse>):
    RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    inner class ProvinceViewHolder(itemview : View): RecyclerView.ViewHolder(itemview){
        fun bind(provice: ProvinceResponse){
            with(itemView){
                tvName.text = provice.attributes.province
                tvPositive.text = provice.attributes.positive.toString()
                tvRecover.text =provice.attributes.recover.toString()
                tvDeath.text= provice.attributes.deadth.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_province,parent, false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

