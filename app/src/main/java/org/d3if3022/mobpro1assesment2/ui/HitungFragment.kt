package org.d3if3022.mobpro1assesment2.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3022.mobpro1assesment2.R
import org.d3if3022.mobpro1assesment2.databinding.FragmentHitungBinding
import org.d3if3022.mobpro1assesment2.model.HasilBiaya

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.saveBtn.setOnClickListener{ hitungBiaya() }
        viewModel.getHasilBiaya().observe(requireActivity()){ showResult(it)}
    }

    private fun hitungBiaya() {

        val plateVehicle = binding.polNumberInp.text.toString()
        if (TextUtils.isEmpty(plateVehicle)) {
            Toast.makeText(context, R.string.pol_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val brandVehicle = binding.brandNameInp.text.toString()
        if (TextUtils.isEmpty(brandVehicle)) {
            Toast.makeText(context, R.string.brand_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val colorVehicle = binding.colorInp.text.toString()
        if (TextUtils.isEmpty(colorVehicle)) {
            Toast.makeText(context, R.string.color_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val parkingTime = binding.parkingTimeInp.text.toString()
        if (TextUtils.isEmpty(parkingTime)) {
            Toast.makeText(context, R.string.time_invalid, Toast.LENGTH_LONG).show()
            return
        }

        viewModel.hitungBiaya(
            parkingTime.toInt()
        )

    }

    private fun showResult(result: HasilBiaya?) {
        binding.rpTitle.text = getString(R.string.rupiah_x, result?.biaya)
    }
}