package com.andromeda.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<UserModel>, private val listener: OnAdapterListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.user_name)
        val desc = view.findViewById<TextView>(R.id.user_desc)
        val image = view.findViewById<ImageView>(R.id.user_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]

        holder.name.text = user.name
        holder.desc.text = user.desc
        holder.image.setImageResource(user.image)

        holder.itemView.setOnClickListener {
            listener.onClick(user)
        }
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    interface OnAdapterListener {
        fun onClick(user: UserModel)
    }
}