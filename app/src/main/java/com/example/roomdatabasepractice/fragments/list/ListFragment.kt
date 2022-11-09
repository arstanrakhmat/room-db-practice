package com.example.roomdatabasepractice.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.roomdatabasepractice.R
import com.example.roomdatabasepractice.data.UserViewModel
import com.example.roomdatabasepractice.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var mUserViewMode: UserViewModel
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        val recyclerView = binding.recyclerView
        val adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        mUserViewMode = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewMode.allWords.observe(
            viewLifecycleOwner,
            Observer { user -> user?.let { adapter.setData(user) } })

        return binding.root
    }

}