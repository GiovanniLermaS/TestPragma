package com.example.testpragma.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testpragma.R
import com.example.testpragma.databinding.ViewCatBinding
import com.example.testpragma.model.Cat
import com.example.testpragma.model.Image

open class CatAdapter(
    private val listCats: ArrayList<Cat>
) :
    RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    private var count = 0

    fun addImage(image: Image) {
        listCats[count].imageId = image.url
        count++
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewCatBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_cat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cat = listCats[position]
        holder.binding.textNameBreed.text = cat.name
        holder.binding.textOriginCountry.text = cat.origin
        holder.binding.textIntelligence.text = StringBuilder().append("${cat.intelligence}")
        cat.imageId?.let {
            Glide.with(holder.itemView).load(it)
                .apply(RequestOptions().override(800, 800))
                .into(holder.binding.imageCat)
        }
    }

    override fun getItemCount() = listCats.size
}