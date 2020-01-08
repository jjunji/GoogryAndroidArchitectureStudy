package com.example.studyapplication.ui.main.blog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studyapplication.R
import com.example.studyapplication.data.model.BlogInfo

class BlogAdapter : RecyclerView.Adapter<BlogHolder>() {
    private val arrBlogInfo: MutableList<BlogInfo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_blog, parent, false)

        return BlogHolder(view)
    }

    override fun onBindViewHolder(holder: BlogHolder, position: Int) {
        arrBlogInfo[position].let { item ->
            with(holder) {
                tvTitle.text = item.title
                tvDescription.text = item.description
                tvBloggername.text = item.bloggername
            }
        }
    }

    override fun getItemCount(): Int {
        return arrBlogInfo.size
    }

    fun resetItem(items: ArrayList<BlogInfo>) {
        arrBlogInfo.clear()
        arrBlogInfo.addAll(items)
        notifyDataSetChanged()
    }
}