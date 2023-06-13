package org.d3if3022.mobpro1assesment2.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3022.mobpro1assesment2.R
import org.d3if3022.mobpro1assesment2.databinding.ListItemBinding
import org.d3if3022.mobpro1assesment2.network.KendaraanApi

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val data = mutableListOf<Kendaraan>()

    fun updateData(newData: List<Kendaraan>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kendaraan: Kendaraan) = with(binding) {
            namaTextView.text = kendaraan.nama
            merkTextView.text = kendaraan.merk
            Glide.with(imageView.context)
                .load(KendaraanApi.getKendaraanUrl(kendaraan.gambar))
                .error(R.drawable.ic_baseline_broken_image)
                .into(imageView)


            root.setOnClickListener {
                val message = root.context.getString(R.string.message, kendaraan.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

}