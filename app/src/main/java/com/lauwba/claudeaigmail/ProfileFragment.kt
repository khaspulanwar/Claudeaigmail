package com.lauwba.claudeaigmail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup click listeners for profile menu items
        setupProfileClickListeners(view)
    }

    private fun setupProfileClickListeners(view: View) {
        // Close button functionality
        view.findViewById<View>(R.id.profile_close_button)?.setOnClickListener {
            // Close fragment and return to main content
            (activity as? MainActivity)?.onBackPressed()
        }

        // Add other click listeners for profile menu items if needed
        // Example:
        // view.findViewById<View>(R.id.manage_account_button).setOnClickListener {
        //     // Handle manage account click
        // }
    }
}