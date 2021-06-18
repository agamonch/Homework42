package kg.unicapp.homework42

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdaptor: RecyclerView.Adapter<MyViewHolder>() {
    private val items = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.count ()

    fun setItems(newItems: List<Item>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()


    }
}