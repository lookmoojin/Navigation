package com.truedigital.navigation.me

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.truedigital.navigation.me.model.InboxModel
import kotlinx.android.synthetic.main.fragment_me.*

class MeFragment : Fragment(R.layout.fragment_me) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        accountButton.setOnClickListener {
            findNavController().navigate(
                MeFragmentDirections.actionMeFragmentToAccountFragment(
                    message = "Account Page",
                    number = 10
                )
            )
        }

        inboxButton.setOnClickListener {
            findNavController().navigate(
                MeFragmentDirections.actionMeFragmentToInboxFragment(
                    inboxModel = InboxModel().apply {
                        id = "123"
                        title = "inbox 1"
                        description = "inbox description"
                    }
                )
            )
        }

        episodeButton.setOnClickListener {
            findNavController().navigate(
                MeFragmentDirections.actionMeFragmentToEpisodeFragment()
            )
        }

        articleButton.setOnClickListener {
            findNavController().navigate(
                MeFragmentDirections.actionMeFragmentToArticleFragment()
            )
        }
    }
}