package com.truedigital.navigation.episode

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_episode.*

class EpisodeFragment : Fragment(R.layout.fragment_episode) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        episodeButton.setOnClickListener {
            findNavController().popBackStack(R.id.episodeFragment, true)
            findNavController().navigate(
                R.id.accountFragment
            )
        }
    }

}