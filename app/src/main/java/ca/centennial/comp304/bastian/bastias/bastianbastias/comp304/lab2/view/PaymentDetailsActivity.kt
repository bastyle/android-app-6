package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.R

class PaymentDetailsActivity : AppCompatActivity() {
    private var isCashTrx = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_details)

        val editTextFullName = findViewById<EditText>(R.id.editTextFullName)
        val editTextCardNumber = findViewById<EditText>(R.id.editTextCardNumber)
        val editTextExpirationYear = findViewById<EditText>(R.id.editTextExpirationYear)
        val editTextExpirationMonth = findViewById<EditText>(R.id.editTextExpirationMonth)
        val editTextFavoriteSport = findViewById<EditText>(R.id.editTextFavoriteSport)
        val editTextFavoriteMusix = findViewById<EditText>(R.id.editTextFavoriteMusic)
        val btnSubmitDetails = findViewById<Button>(R.id.btnSubmitDetails)
        val paymentMethod = intent.getStringExtra(PaymentActivity.PAYMENT_METHOD_KEY)

        if("cash".equals(paymentMethod, ignoreCase = true)){
            isCashTrx=true
            editTextCardNumber.isEnabled=false
            editTextExpirationYear.isEnabled=false
            editTextExpirationMonth.isEnabled=false
        }

        btnSubmitDetails.setOnClickListener {
            val fullName = editTextFullName.text.toString()
            val cardNumber = editTextCardNumber.text.toString()
            val favoriteSport = editTextFavoriteSport.text.toString()

            // Validate user inputs (e.g., check if fields are not empty)
            if (fullName.isEmpty() || favoriteSport.isEmpty() || editTextFavoriteMusix.text.isEmpty()
                || (!isCashTrx && (editTextExpirationYear.text.isEmpty() || editTextExpirationMonth.text.isEmpty()))
            ) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Perform further actions (e.g., process payment and store user preferences)
                // Display a success message or navigate to the next screen
                Toast.makeText(this, "Payment details submitted successfully", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}