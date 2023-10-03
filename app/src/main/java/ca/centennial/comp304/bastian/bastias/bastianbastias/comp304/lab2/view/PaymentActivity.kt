package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.R

class PaymentActivity:AppCompatActivity() {

    companion object{
        const val PAYMENT_METHOD_KEY="payment_method"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val radioGroupPayment = findViewById<RadioGroup>(R.id.radioGroupPayment)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val selectedPaymentOptionId = radioGroupPayment.checkedRadioButtonId

            if (selectedPaymentOptionId == -1) {
                // No payment option selected
                Toast.makeText(this, "Please select a payment option", Toast.LENGTH_SHORT).show()
            } else {
                val selectedPaymentOption = findViewById<RadioButton>(selectedPaymentOptionId)
                val selectedOptionText = selectedPaymentOption.text.toString()

                // Handle the selected payment option (e.g., start the payment process)
                //Toast.makeText(this, "Selected Payment Option: $selectedOptionText", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, PaymentDetailsActivity::class.java)
                intent.putExtra(PAYMENT_METHOD_KEY,selectedOptionText)
                startActivity(intent)
            }
        }

    }
}