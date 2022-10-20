package com.fal.dependencyinjection.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fal.dependencyinjection.databinding.ItemListBinding
import com.fal.dependencyinjection.model.DataProductItem

class ProductAdapter(private var list_product : List<DataProductItem>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        Glide.with(holder.itemView.context).load(list_product!![position].imageLink).into(holder.binding.img)
        holder.binding.name.text = list_product!![position].name
        holder.binding.price.text = list_product!![position].price
        holder.binding.category.text = list_product!![position].category
    }

    override fun getItemCount(): Int {
        return list_product.size
    }
}