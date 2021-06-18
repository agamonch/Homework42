package kg.unicapp.homework42

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate


object Data {

    val items = listOf<Item>(
        Item(1, "Java", R.drawable.ic_baseline_anchor_24),
        Item(2, "Kotlin", R.drawable.ic_baseline_android_24),
        Item(3, "Dart", R.drawable.ic_baseline_flight_takeoff_24)
    )

//    val itemdetails = listOf<Item>(
//        itemdetails(1, "Java", R.drawable.ic_baseline_anchor_24, "Sun MacroSystems")
//    )

    fun getLongListOfItems(): MutableList<Item>{
        val list = mutableListOf<Item>()
        for (i in 0..50) {
            list.addAll(items)
        }
        return list

    }
}

