package com.workdev.launcher


import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.Color.parseColor
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.workdev.launcher.databinding.ItemBinding


class AdapterColor( private val apps: List<ResolveInfo>,
    private val packageManager: PackageManager,
                   private val onAppClicked: (ResolveInfo) -> Unit ) : RecyclerView.Adapter<AdapterColor.ViewHolder>()  {

    private lateinit var binding: ItemBinding






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val app = apps.get( position)

         binding.appName.text = apps.get(position).loadLabel(packageManager)
         binding.appIcon.setImageDrawable( apps.get(position).loadIcon(packageManager))
         binding.root.setOnClickListener { onAppClicked(app) }

        holder.setIsRecyclable(false)





    }

    override fun getItemCount(): Int {
        return  apps.size
    }



    inner class ViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView)





}