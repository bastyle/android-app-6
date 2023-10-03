package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.view
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.lab2.R

class PaymentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_details)

        val editTextFullName = findViewById<EditText>(R.id.editTextFullName)
        val editTextCardNumber = findViewById<EditText>(R.id.editTextCardNumber)
        val editTextFavoriteSport = findViewById<EditText>(R.id.editTextFavoriteSport)
        val btnSubmitDetails = findViewById<Button>(R.id.btnSubmitDetails)

        btnSubmitDetails.setOnClickListener {
            val fullName = editTextFullName.text.toString()
            val cardNumber = editTextCardNumber.text.toString()
            val favoriteSport = editTextFavoriteSport.text.toString()

            // Validate user inputs (e.g., check if fields are not empty)
            if (fullName.isEmpty() || cardNumber.isEmpty() || favoriteSport.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Perform further actions (e.g., process payment and store user preferences)
                // Display a success message or navigate to the next screen
                Toast.makeText(this, "Payment details submitted successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}