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

class StoreAdapter(var viewModel: MainViewModel): RecyclerView.Adapter<StoreAdapter.StoreViewHolder>(){

    private var mainViewModel: MainViewModel = viewModel

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
        holder.bindViewHolder(differ.currentList[position], position)
    }

    inner class StoreViewHolder(private var itemViewBinding: StoreItemBinding):
            RecyclerView.ViewHolder(itemViewBinding.root) {

        fun bindViewHolder(item: Store, position: Int) {
            itemViewBinding.ivImage.setImageURI(item.cover_img_url)
            itemViewBinding.setVariable(BR.position, position)
            itemViewBinding.setVariable(BR.model, item)
            itemViewBinding.setVariable(BR.viewModel, mainViewModel)
            itemViewBinding.executePendingBindings()
        }
    }
}