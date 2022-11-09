package com.example.roomdatabasepractice.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasepractice.R
import com.example.roomdatabasepractice.data.User

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private var list = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val oneUser = list[position]

        holder.myId.text = oneUser.id.toString()
        holder.firstName.text = oneUser.firstName
        holder.lastName.text = oneUser.lastName
        holder.age.text = oneUser.age.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(user: List<User>) {
        this.list = user
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val myId = itemView.findViewById<TextView>(R.id.id_txt)
        val firstName = itemView.findViewById<TextView>(R.id.firstName_txt)
        val lastName = itemView.findViewById<TextView>(R.id.lastName_txt)
        val age = itemView.findViewById<TextView>(R.id.age_txt)
    }

}