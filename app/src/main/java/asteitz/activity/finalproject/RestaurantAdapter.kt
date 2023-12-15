package asteitz.activity.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter<Restaurant> : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    // List to hold restaurant data
    private var restaurantList: List<Restaurant> = emptyList()

    // ViewHolder class
    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)

    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurantList[position]

        // Bind data to the ViewHolder
        // You may set the restaurant name, location, and images here

        // Implement item click listener
        holder.itemView.setOnClickListener {
            // Handle item click, navigate to the Restaurant screen
            // You can use the Navigation component for navigation
        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    // Update the restaurant list when data changes
    fun updateData(newList: List<Restaurant>) {
        restaurantList = newList
        notifyDataSetChanged()
    }
}

