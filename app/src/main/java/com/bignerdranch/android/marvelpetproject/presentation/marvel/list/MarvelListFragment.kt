package com.bignerdranch.android.marvelpetproject.presentation.marvel.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.*
import com.bignerdranch.android.marvelpetproject.databinding.FragmentMarvelListBinding
import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import com.bignerdranch.android.marvelpetproject.presentation.marvel.detail.MarvelInfoFragment
import com.bignerdranch.android.marvelpetproject.presentation.utils.replace
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelListFragment : Fragment(), MarvelListAdapter.OnHeroClickListener {

    companion object {

        fun newInstance() = MarvelListFragment()
    }

    private lateinit var binding: FragmentMarvelListBinding

    private val viewModel: MarvelListViewModel by viewModels()

    private val adapter = MarvelListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMarvelListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            heroListRV.layoutManager = LinearLayoutManager(
                requireContext(), RecyclerView.VERTICAL, false)
            heroListRV.adapter = adapter
        }

        with(viewModel) {
            getHeroesList()
            heroesListLiveData.observe(viewLifecycleOwner) { list ->
                adapter.setItems(list)
            }
            resultErrorLiveData.observe(viewLifecycleOwner) { error ->
                Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onHeroClick(hero: MarvelData) {
        replace(MarvelInfoFragment.newInstance(hero))
    }
}