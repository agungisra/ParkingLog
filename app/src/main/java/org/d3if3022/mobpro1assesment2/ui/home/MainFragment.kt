package org.d3if3022.mobpro1assesment2.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if3022.mobpro1assesment2.R
import org.d3if3022.mobpro1assesment2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.carBtn.setOnClickListener{
            it.findNavController().navigate(R.id.action_mainFragment_to_mobilFragment)
        }

        binding.motorcyclesBtn.setOnClickListener{
            it.findNavController().navigate(R.id.action_mainFragment_to_motorFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_history -> {
                findNavController().navigate(R.id.action_mainFragment_to_historyFragment)
                return true
            }

            R.id.menu_about -> {
                findNavController().navigate(R.id.action_mainFragment_to_aboutFragment)
                return true
            }

            R.id.daftar_kendaraann -> {
                findNavController().navigate(R.id.action_mainFragment_to_kendaraanFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}