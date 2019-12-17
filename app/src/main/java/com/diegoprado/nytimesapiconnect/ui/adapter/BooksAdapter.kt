package com.diegoprado.nytimesapiconnect.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diegoprado.nytimesapiconnect.R
import com.diegoprado.nytimesapiconnect.ui.model.BooksModel

class BooksAdapter(val books: List<BooksModel>): RecyclerView.Adapter<BooksAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemLista = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_design_list, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val book = books!![position]

        holder.titleBook?.setText(book.toString())
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        internal var titleBook: TextView? = null
        internal var nameAuthor: TextView? = null

        init {
            titleBook = itemView.findViewById(R.id.nameBook)
            nameAuthor = itemView.findViewById(R.id.nameAuthor)
        }
    }


}