package com.example.inventory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.data.Item
import com.example.inventory.data.getFormattedPrice
import com.example.inventory.databinding.ItemListItemBinding


/**
 * 1. onItemClicked()라는 함수를 Item 객체를 매개변수로 가져오는 생성자 매개변수로 전달합니다.
 * 2. ItemListAdapter 클래스 서명을 변경하여 ListAdapter를 확장합니다. Item과 ItemListAdapter.ItemViewHolder를 매개변수로 전달합니다.
 * 3. 생성자 매개변수 DiffCallback을 추가합니다. ListAdapter는 이를 사용하여 목록에서 변경된 내용을 파악합니다.
 * 4. 필수 메서드 onCreateViewHolder()와 onBindViewHolder()를 재정의합니다.
 * 5. onCreateViewHolder() 메서드는 RecyclerView에 필요할 때 새 ViewHolder를 반환합니다.
 * 6. onCreateViewHolder() 메서드 내에서 새 View를 만들고 자동 생성된 바인딩 클래스 ItemListItemBinding을 사용하여 item_list_item.xml 레이아웃 파일에서 이를 확장합니다.
 * 7. onBindViewHolder() 메서드를 구현합니다. getItem() 메서드를 사용하여 현재 항목을 가져와 위치를 전달합니다.
 * 8. itemView에서 클릭 리스너를 설정하고 리스너 내에서 onItemClicked() 함수를 호출합니다.
 * 9. ItemViewHolder 클래스를 정의하고 RecyclerView.ViewHolder.에서 확장합니다. bind() 함수를 재정의하고 Item 객체를 전달합니다.
 * 10. 컴패니언 객체를 정의합니다. 컴패니언 객체 내에서 DiffCallback이라는 DiffUtil.ItemCallback<Item>() 유형의 val을 정의합니다. 필수 메서드 areItemsTheSame()과 areContentsTheSame()을 재정의하고 정의합니다.
 */
class ItemListAdapter(private val onItemClicked: (Item) -> Unit) : ListAdapter<Item, ItemListAdapter.ItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    class ItemViewHolder(private var binding: ItemListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item){
            binding.apply {
                itemName.text = item.itemName
                itemPrice.text = item.getFormattedPrice()
                itemQuantity.text = item.quantityInStock.toString()
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.itemName == newItem.itemName
            }

        }
    }
}