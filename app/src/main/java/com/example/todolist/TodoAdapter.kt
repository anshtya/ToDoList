package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemViewBinding
import com.example.todolist.viewmodel.TodoViewmodel

class TodoAdapter(private val listener: TodoViewmodel) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val itemViewHolder = ItemViewHolder(binding)
        itemViewHolder.btnDelete.setOnClickListener {
            listener.onTodoDelete(itemViewHolder.adapterPosition)
            notifyItemRemoved(itemViewHolder.adapterPosition)
        }
        return itemViewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.tvItem.text = todoList[position]
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

}
class ItemViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    val tvItem = binding.tvItem
    val btnDelete = binding.btnDelete
}
interface TodoDelete{
    fun onTodoDelete(position: Int)
}