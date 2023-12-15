package asteitz.activity.finalproject

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
//import androidx. rememberCoilPainter

class HomeFragment : Fragment() {

    @Composable
    fun RecentRestaurants() {
        val orderCollection = FirebaseFirestore.getInstance().collection("order")
        val query = orderCollection.orderBy("orderTime", Query.Direction.DESCENDING).limit(5)
        val recentRestaurants = remember(query) {
            mutableStateListOf<Restaurant>()
        }
        LaunchedEffect(query) {
            query.addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.e(TAG, "Error getting recent restaurants", error)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    recentRestaurants.clear()
                    for (document in snapshot.documents) {
                        val restaurant = document.toObject(Restaurant::class.java)
                        if (restaurant != null && !recentRestaurants.contains(restaurant)) {
                            recentRestaurants.add(restaurant)
                        }
                    }
                }
            }
        }

    }
}
