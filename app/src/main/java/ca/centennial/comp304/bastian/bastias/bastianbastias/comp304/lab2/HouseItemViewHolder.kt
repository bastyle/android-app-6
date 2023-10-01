package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import android.content.Context
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseItemViewHolderBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem

class HouseItemViewHolder(private val binding: HouseItemViewHolderBinding):RecyclerView.ViewHolder(binding.root) {

    /*fun bind(text: String) {
        binding.textItemViewHolderTextView.text = text
    }*/

    fun bind(item: HouseItem, ctx:Context) {
        binding.type.text = item.type +" id: ".plus("# AF10-0").plus(item.id)
        binding.address.text = item.address
        binding.description.text = item.description
        binding.price.text=item.price
        //binding.mainImage.setImageResource()
        //val uri = Uri.parse("content://drawable/".plus(item.image)) // Replace with your actual URI
        val imageId = ctx.resources.getIdentifier(item.image,"drawable",ctx.packageName)
        binding.mainImage.setImageResource(imageId)
        //val drawable = getDrawable(R.drawable.your_drawable_resource, null)
    }
}