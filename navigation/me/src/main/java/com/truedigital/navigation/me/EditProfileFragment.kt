package com.truedigital.navigation.me

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_edit_profile.*

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backToMeButton.setOnClickListener {
            findNavController().navigate(EditProfileFragmentDirections.actionPopToMe())
        }
    }
}