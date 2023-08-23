package com.example.tastevin.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tastevin.MainActivity
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchEditText: EditText
    private var savedEditTextContent: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        //binding.toolbarSearch.title = "Search"
        binding.toolbarSearch.inflateMenu(R.menu.search_menu)
        binding.toolbarSearch.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

        binding.toolbarSearch.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search_menu_search -> {
                    val action =
                        SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment()
                    findNavController().navigate(action)
                    true
                }

                else -> false
            }
        }


        binding.cameraButton.setOnClickListener {
            val action = SearchFragmentDirections.actionNavigationSearchToCameraFragment()
            findNavController().navigate(action)
        }


        return binding.root
    }
}