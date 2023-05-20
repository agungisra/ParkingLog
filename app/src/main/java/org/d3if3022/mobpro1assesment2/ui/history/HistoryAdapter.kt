package org.d3if3022.mobpro1assesment2.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import org.d3if3022.mobpro1assesment2.R
import org.d3if3022.mobpro1assesment2.databinding.ItemHistoryBinding
import org.d3if3022.mobpro1assesment2.db.BiayaEntity
import org.d3if3022.mobpro1assesment2.model.hitungBiaya
import java.text.SimpleDateFormat
import java.util.*

class HistoryAdapter :
    ListAdapter<BiayaEntity, HistoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<BiayaEntity>() {
                override fun areItemsTheSame(
                    oldData: BiayaEntity, newData: BiayaEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: BiayaEntity, newData: BiayaEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    class ViewHolder(
        private val binding: ItemHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: BiayaEntity) = with(binding) {
            val hasilBiaya = item.hitungBiaya()

            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))

            noPolTextView.text = item.nopol

            brandTextView.text = item.merk + " - " + item.warna

            timeTextView.text = root.context.getString(
                R.string.waktu_x,
                item.waktu
            )

            priceTextView.text = root.context.getString(
                R.string.rupiah_x,
                hasilBiaya.biaya)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
