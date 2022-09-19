package com.example.githubuserapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val listUser: ArrayList<User>
): RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_tamplate, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, company, location, photo) = listUser[position]

        holder.photo.setImageResource(photo)
        holder.name.text        = name
        holder.company.text     = company
        holder.location.text    = location

        //click template
        holder.template.setOnClickListener{
           onItemClickCallback.onItemclicked(listUser[position])
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var photo       : ImageView = itemView.findViewById(R.id.img_user)
        var name        : TextView  = itemView.findViewById(R.id.name_user)
        var company     : TextView  = itemView.findViewById(R.id.company_user)
        var location    : TextView  = itemView.findViewById(R.id.location_user)

        //template for area click
        var template: ConstraintLayout = itemView.findViewById(R.id.tamplate_list)
    }

    interface OnItemClickCallback{
        fun onItemclicked(data: User)
    }
}