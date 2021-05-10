package com.example.doordashlite.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doordashlite.R
import com.example.doordashlite.BR
import com.example.doordashlite.data.Store
import com.example.doordashlite.databinding.StoreItemBinding

class StoreAdapter: RecyclerView.Adapter<StoreAdapter.StoreViewHolder>(){

    private val diffCallback = object : DiffUtil.ItemCallback<Store>(){
        override fun areItemsTheSame(oldItem: Store, newItem: Store): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Store, newItem: Store): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this,diffCallback)

    fun submitList(list: List<Store>?) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.store_item,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bindViewHolder(differ.currentList[position])
    }

    inner class StoreViewHolder(private var itemViewBinding: StoreItemBinding):
            RecyclerView.ViewHolder(itemViewBinding.root) {

        fun bindViewHolder(item: Store) {
            itemViewBinding.ivImage.setImageURI(item.coverImageUrl)
            itemViewBinding.setVariable(BR.viewModel, item)
            itemViewBinding.executePendingBindings()
        }
    }
}