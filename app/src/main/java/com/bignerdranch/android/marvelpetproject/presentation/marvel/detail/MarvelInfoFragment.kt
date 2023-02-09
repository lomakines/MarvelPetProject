package com.bignerdranch.android.marvelpetproject.presentation.marvel.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bignerdranch.android.marvelpetproject.R
import com.bignerdranch.android.marvelpetproject.databinding.FragmentMarvelInfoBinding
import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import com.squareup.picasso.Picasso

class MarvelInfoFragment : Fragment(R.layout.fragment_marvel_info) {

    private lateinit var binding: FragmentMarvelInfoBinding

    companion object {

        private const val HERO_ARG = "hero"

        fun newInstance(heroModel: MarvelData) =
            MarvelInfoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(HERO_ARG, heroModel)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMarvelInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hero = requireArguments().getSerializable(HERO_ARG) as MarvelData

        with(binding) {

            bioTV.text = hero.bio
            realNameTV.text = hero.realName
            teamTV.text = hero.team
            createdByTV.text = hero.createdBy
            firstAppearanceTV.text = hero.firstAppearance
            Picasso.get()
                .load(hero.imageUrl)
                .into(heroImage)
        }
    }
}