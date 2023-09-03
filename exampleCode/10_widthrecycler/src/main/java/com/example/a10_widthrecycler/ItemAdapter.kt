package com.example.a10_widthrecycler

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.a10_widthrecycler.databinding.ItemDetailsBinding

class ItemAdapter(private val context: Context, private val itemList: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)

        // 아이템 클릭 이벤트 처리
        holder.itemView.setOnClickListener {
            // 해당 아이템에 따라 다른 레이아웃 파일을 열기
            Log.d("Item Test", item)
            when (item) {
                "Item 1" -> openLayoutActivity("layout_1.xml")
                "Item 2" -> openLayoutActivity("layout_2.xml")
                "Item 3" -> openLayoutActivity("layout_3.xml")
                else -> {
                    // 처리할 레이아웃이 없을 경우 예외 처리
                    Toast.makeText(context, "No layout found for item $item", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemTextView: TextView = itemView.findViewById(R.id.itemTextView)

        fun bind(item: String) {
            itemTextView.text = item
        }
    }

    private fun openLayoutActivity(layoutFileName: String) {
        // 해당 레이아웃 파일을 열기 위한 액티비티 시작
        val intent = Intent(context, LayoutActivity::class.java)
        intent.putExtra("layoutFileName", layoutFileName)
        context.startActivity(intent)
    }

}