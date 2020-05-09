package com.truedigital.navigation.me

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_inbox.*

class InboxFragment : Fragment(R.layout.fragment_inbox) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { arguments ->
            val args = InboxFragmentArgs.fromBundle(arguments)
            val model = args.inboxModel

            messageTextView.text =
                "id = ${model?.id}, title = ${model?.title}, description = ${model?.description}"
        }
    }
}