package com.example.tastevin.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tastevin.MainActivity
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)

        binding.searchToolbar.inflateMenu(R.menu.search_menu)
        binding.searchToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.searchToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search_menu_search -> {
                    val action =
                        SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment()
                    view.findNavController().navigate(action)
                    true
                }

                else -> false
            }
        }

        binding.searchOcrButton.setOnClickListener {
            val action = SearchFragmentDirections.actionNavigationSearchToCameraFragment()
            view.findNavController().navigate(action)
        }
    }
}