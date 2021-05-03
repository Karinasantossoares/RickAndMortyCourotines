package com.example.rickandmortyandroid.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.rickandmortyandroid.databinding.FragmentListCharactersBinding
import com.example.rickandmortyandroid.ui.adapter.CharactersAdapter
import com.example.rickandmortyandroid.viewModel.RickAndMortyViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class ListCharactersFragment : Fragment() {
    private val viewModel: RickAndMortyViewModel by viewModel()
    private lateinit var binding: FragmentListCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentListCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.successLiveData.observe(viewLifecycleOwner, Observer {
            binding.recylerCharacters.adapter = CharactersAdapter(it)
        })
    }

    companion object{
        fun newInstance()= ListCharactersFragment()
    }


}