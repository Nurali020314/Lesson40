package uz.gita.lesson40.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.lesson40.R
import uz.gita.lesson40.domain.entity.CardEntity
import uz.gita.lesson40.domain.entity.getResponse.Data

class CardAdapter : ListAdapter<Data, CardViewHolder>(CharacterComparator){
    private var onClickListener: ((Int) -> Unit)? = null
        private var onItemClickListener: OnItemClickListener? = null
        fun setOnItemClickListener(listener: OnItemClickListener) {
            onItemClickListener = listener
        }

    fun setOnClickClickListener(clickListener: (Int) -> Unit) {
        onClickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view, onItemClickListener!!)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val character = getItem(position)
        character?.let { holder.bind(it) }
    }

    object CharacterComparator : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}

class CardViewHolder(val view: View, val onItemClickListener: OnItemClickListener ) :
    RecyclerView.ViewHolder(view) {
    init {
        val findViewById = view.findViewById<CardView>(R.id.laout)
        findViewById.setOnClickListener { onItemClickListener.onItemClick(bindingAdapterPosition) }
    }
    private val name: TextView = view.findViewById(R.id.balance)

    fun bind(card: Data) {
        name.setText("$ " + card.amount)
    }
}
interface OnItemClickListener {
    fun onItemClick(position: Int)
}