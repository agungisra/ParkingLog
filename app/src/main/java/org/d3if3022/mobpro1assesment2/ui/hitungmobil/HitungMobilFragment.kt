package org.d3if3022.mobpro1assesment2.ui.hitungmobil

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if3022.mobpro1assesment2.R
import org.d3if3022.mobpro1assesment2.databinding.FragmentHitungMobilBinding
import org.d3if3022.mobpro1assesment2.db.BiayaDb
import org.d3if3022.mobpro1assesment2.model.HasilBiaya

class HitungMobilFragment : Fragment() {

    private lateinit var binding: FragmentHitungMobilBinding

    private val viewModel: HitungMobilViewModel by lazy {
        val db = BiayaDb.getInstance(requireContext())
        val factory = HitungMobilViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HitungMobilViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungMobilBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.saveBtn.setOnClickListener{ hitungBiaya() }
        viewModel.getHasilBiaya().observe(requireActivity()){ showResult(it)}
//        viewModel.data.observe(viewLifecycleOwner, {
//            if (it == null) return@observe
//            Log.d("HitungFragment", "Data tersimpan. ID = ${it.id}")
//        })
        binding.shareBtn.setOnClickListener { shareData() }
    }

    private fun shareData() {
        val message = getString(R.string.bagikan_template,
            binding.polNumberInp.text,
            binding.brandNameInp.text,
            binding.colorInp.text,
            binding.rpTitle.text
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
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
            plateVehicle,
            brandVehicle,
            colorVehicle,
            parkingTime.toInt()
        )

    }

    private fun showResult(result: HasilBiaya?) {
        binding.rpTitle.text = getString(R.string.rupiah_x, result?.biaya)
        binding.shareBtn.visibility = View.VISIBLE
    }
}