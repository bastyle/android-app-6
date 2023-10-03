package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.view

import android.content.Context
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.databinding.HouseCheckoutViewHolderBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.model.HouseItem


class HouseCheckoutViewHolder(private val binding: HouseCheckoutViewHolderBinding, public var radioButtonSelected:RadioButton): RecyclerView.ViewHolder(binding.root) {
    companion object{
        const val TAG="HouseCheckoutViewHolder"
    }
    fun bind(item: HouseItem, ctx: Context, radioButtonList: ArrayList<RadioButton>) {
        Log.e(TAG," bind item: ".plus(item.id.toString()))
        binding.address.text=item.address
        binding.price.text=item.price
        val imageId = ctx.resources.getIdentifier(item.image,"drawable",ctx.packageName)
        binding.mainImage.setImageResource(imageId)
        //binding.rbutton.id=item.id
        //binding.rbutton.text=item.id.toString()
        //binding.radioButton.id=item.id

        val rButton = binding.radioButton
        rButton.id=item.id
        radioButtonList.add(rButton)
        Log.e(TAG,"radioButtonList.size: "+radioButtonList.size)
        rButton.setOnClickListener {
            // Handle the click event for RadioButton 1
           // Log.e("Holder","it: "+view.id+" isSelected:: " + view.isSelected)
            //Log.e(TAG,"rbutton: "+rButton.id+" isChecked:: " + rButton.isChecked)
            //Log.e(TAG,"radioButtonSelected: "+radioButtonSelected.id+" isChecked:: " + radioButtonSelected.isChecked)
            if (rButton.isChecked) {
                (radioButtonList.filter { item -> (item.isChecked && item.id!=rButton.id) }).forEach{rb->
                    Log.e(TAG,"unchecking radiobutton id: "+item.id)
                    rb.isChecked=false
                }
                radioButtonSelected = rButton
            }
        }
    }
}