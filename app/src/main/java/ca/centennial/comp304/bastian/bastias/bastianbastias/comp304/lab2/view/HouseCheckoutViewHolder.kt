package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.view

import android.content.Context
import android.util.Log
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseCheckoutViewHolderBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem


class HouseCheckoutViewHolder(private val binding: HouseCheckoutViewHolderBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HouseItem, ctx: Context) {
        Log.e("HouseCheckoutViewHolder"," bind item: ".plus(item.id.toString()))
        binding.address.text=item.address
        binding.price.text=item.price
        val imageId = ctx.resources.getIdentifier(item.image,"drawable",ctx.packageName)
        binding.mainImage.setImageResource(imageId)
        binding.rbutton.id=item.id
        binding.rbutton.text=item.id.toString()

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.e("HouseCheckoutViewHolder","checkedId:: "+checkedId)
            //val selectedRadioButton = findViewById<RadioButton>(checkedId)
            //val selectedOption = selectedRadioButton.text.toString()
            //selectedOptionText.text = "Selected Option: $selectedOption"
        }
    }
}