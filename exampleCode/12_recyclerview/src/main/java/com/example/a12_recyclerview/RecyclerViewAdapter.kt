package com.example.a12_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a12_recyclerview.databinding.ItemLayoutBinding

// 5. RecyclerView 어댑터 클래스 정의
class RecyclerViewAdapter : ListAdapter<Item, RecyclerViewAdapter.ViewHolder>(DiffCallback()) {

    // 6. 아이템 뷰를 생성하고 뷰 홀더 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // 7. 아이템 데이터를 뷰 홀더에 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    // 8. 뷰 홀더 클래스 정의
    class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.nameTextView.text = item.name
            binding.contentTextView.text = item.content
        }
    }

    // 10. 아이템 갱신을 위한 콜백 클래스 정의
    private class DiffCallback : DiffUtil.ItemCallback<Item>() {

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            // 아이템이 같은지 여부를 확인
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            // 아이템 내용이 같은지 여부를 확인
            return oldItem == newItem
        }
    }
}
