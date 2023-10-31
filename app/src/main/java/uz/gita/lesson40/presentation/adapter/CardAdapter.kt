package uz.gita.lesson40.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.lesson40.R
import uz.gita.lesson40.domain.entity.CardEntity

class CardAdapter : ListAdapter<CardEntity, CardViewHolder>(CharacterComparator){
    private var onClickListener: ((Int) -> Unit)? = null

    fun setOnClickClickListener(clickListener: (Int) -> Unit) {
        onClickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val character = getItem(position)
        character?.let { holder.bind(it) }
    }

    object CharacterComparator : DiffUtil.ItemCallback<CardEntity>() {
        override fun areItemsTheSame(oldItem: CardEntity, newItem: CardEntity): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: CardEntity, newItem: CardEntity): Boolean {
            return oldItem == newItem
        }
    }
}

class CardViewHolder(val view: View, val onClickListener: ((Int) -> Unit)?) :
    RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.balance)


    fun bind(card: CardEntity) {
        name.setText("$ " + card.balance)
    }
}
