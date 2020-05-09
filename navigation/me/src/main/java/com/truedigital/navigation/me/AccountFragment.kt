package com.truedigital.navigation.me

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment(R.layout.fragment_account) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { arguments ->
            val args = AccountFragmentArgs.fromBundle(arguments)
            val message = args.message
            val number = args.number
            val id = args.accountId
            Toast.makeText(context, "id = $id, $message, $number", Toast.LENGTH_SHORT).show()
        }

        editProfileButton.setOnClickListener {
            findNavController().navigate(AccountFragmentDirections.actionAccountFragmentToEditProfileFragment())
        }
    }
}