package com.lauwba.claudeaigmail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HamburgerMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hamburger_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup click listeners for menu items
        setupMenuClickListeners(view)
    }

    private fun setupMenuClickListeners(view: View) {
        // Add click listeners for all menu items here if needed
        // Example:
        // view.findViewById<View>(R.id.menu_all_inbox).setOnClickListener {
        //     // Handle click
        // }

        // For now, they're just visual without specific actions
        // You can add functionality later as needed
    }
}