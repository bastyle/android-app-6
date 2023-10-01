package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2

import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseItemViewHolderBinding

class HouseItemViewHolder(private val binding: HouseItemViewHolderBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(text: String) {
        binding.textItemViewHolderTextView.text = text
    }
}