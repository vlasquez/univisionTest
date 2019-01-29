package com.example.univisiontest.ui.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class RecyclerViewAdapter<ITEM_T, VIEW_MODEL_T : ItemViewModel<ITEM_T>> :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder<ITEM_T, VIEW_MODEL_T>>() {

    protected val items: ArrayList<ITEM_T> = ArrayList()


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder<ITEM_T, VIEW_MODEL_T>, position: Int) {
        holder.setItem(items[position])
    }


    class ItemViewHolder<T, VT : ItemViewModel<T>>(
        itemView: View,
        private val binding: ViewDataBinding,
        protected val viewModel: VT
    ) : RecyclerView.ViewHolder(itemView) {

        internal fun setItem(item: T) {
            viewModel.setItem(item)
            binding.executePendingBindings()
        }
    }

}