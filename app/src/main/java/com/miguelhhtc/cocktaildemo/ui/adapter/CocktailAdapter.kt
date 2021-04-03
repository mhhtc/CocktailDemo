package com.miguelhhtc.cocktaildemo.ui.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelhhtc.cocktaildemo.model.DrinkItem
import com.miguelhhtc.cocktaildemo.ui.main.viewHolder.ListViewHolder
import com.miguelhhtc.cocktaildemo.ui.main.viewHolder.GridViewHolder
import kotlinx.android.synthetic.main.item_grid_cocktail.view.*
import kotlinx.android.synthetic.main.item_grid_cocktail.view.drink_image
import kotlinx.android.synthetic.main.item_list_cocktail.view.*
import java.util.*

private const val TAG = "CocktailAdapter"
class CocktailAdapter(private val interaction: Interaction? = null,
                      private val layoutManager: GridLayoutManager? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var cocktailList = mutableListOf<DrinkItem>()

    enum class ViewType {
        LIST,
        GRID
    }

    fun setCocktailList(data:MutableList<DrinkItem>){
        cocktailList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.GRID.ordinal -> GridViewHolder(parent)
            else -> ListViewHolder(parent)
        }
    }

    private fun loadGlideImage(itemView: View, urlImage: String){
        Glide.with(itemView)
                .load(urlImage)
                .centerInside()
                .into(itemView.drink_image)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val drinkItem: DrinkItem = cocktailList[position]

        when (holder.itemViewType) {
            ViewType.GRID.ordinal -> {
                Log.i(TAG, "onBindViewHolder -> ViewType.GRID.ordinal")
                holder.itemView.drink_name_grid.text = drinkItem.strDrink?.capitalize(Locale.ROOT)
                loadGlideImage(holder.itemView, drinkItem.strDrinkThumb!!)
            }

            ViewType.LIST.ordinal -> {
                Log.i(TAG, "onBindViewHolder -> ViewType.LIST.ordinal")
                holder.itemView.drink_name_list.text = drinkItem.strDrink?.capitalize(Locale.ROOT)
                loadGlideImage(holder.itemView, drinkItem.strDrinkThumb!!)
            }

        }

        holder.itemView.setOnClickListener {
            interaction?.onItemSelected(holder.adapterPosition, drinkItem)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (layoutManager?.spanCount == 1) ViewType.LIST.ordinal
        else ViewType.GRID.ordinal
    }

    override fun getItemCount(): Int {
        return if(cocktailList.size > 0){ cocktailList.size}else{ 0 }
    }

}


interface Interaction {
    fun onItemSelected(position: Int, item: DrinkItem)
}
