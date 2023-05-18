package org.d3if3022.mobpro1assesment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import org.d3if3022.mobpro1assesment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener { saveDataVehicle() }
    }

    private fun saveDataVehicle() {

        val plateVehicle = binding.polNumberInp.text.toString()
        if (TextUtils.isEmpty(plateVehicle)) {
            Toast.makeText(this, R.string.pol_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val brandVehicle = binding.brandNameInp.text.toString()
        if (TextUtils.isEmpty(brandVehicle)) {
            Toast.makeText(this, R.string.brand_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val colorVehicle = binding.colorInp.text.toString()
        if (TextUtils.isEmpty(colorVehicle)) {
            Toast.makeText(this, R.string.color_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val parkingTime = binding.parkingTimeInp.text.toString()
        if (TextUtils.isEmpty(parkingTime)) {
            Toast.makeText(this, R.string.time_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val hitungBiaya = parkingTime.toInt() * 5000

        binding.rpTitle.text = getString(R.string.rupiah_x, hitungBiaya)


        Log.d("MainActivity", "Data Berhasil!")
    }
}