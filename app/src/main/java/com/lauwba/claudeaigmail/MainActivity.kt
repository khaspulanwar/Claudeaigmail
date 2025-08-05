package com.lauwba.claudeaigmail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var mailIconBackground: View
    private lateinit var searchBar: View
    private lateinit var fragmentContainer: View
    private var isMailSelected = false
    private var currentFragment: Fragment? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        mailIconBackground = findViewById(R.id.mail_icon_background)
        searchBar = findViewById(R.id.search_bar)
        fragmentContainer = findViewById(R.id.fragment_container)

        // Initially hide fragment container
        fragmentContainer.visibility = View.GONE
        mailIconBackground.visibility = View.GONE
    }

    private fun setupClickListeners() {
        // Profile circle click - show profile fragment
        findViewById<View>(R.id.profile_circle).setOnClickListener {
            showFragment(ProfileFragment())
        }

        // Hamburger menu click - show navigation fragment
        findViewById<View>(R.id.iv_hamburger).setOnClickListener {
            showFragment(HamburgerMenuFragment())
        }

        // Mail icon click - show background highlight
        findViewById<View>(R.id.iv_mail_bottom).setOnClickListener {
            toggleMailSelection()
        }
    }

    private fun showFragment(fragment: Fragment) {
        // Hide search bar and show fragment container
        searchBar.visibility = View.GONE
        fragmentContainer.visibility = View.VISIBLE

        currentFragment = fragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun showMainContent() {
        // Show search bar and hide fragment container
        searchBar.visibility = View.VISIBLE
        fragmentContainer.visibility = View.GONE

        // Remove fragment if exists
        currentFragment?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
        }
        currentFragment = null
    }

    private fun toggleMailSelection() {
        isMailSelected = !isMailSelected
        mailIconBackground.visibility = if (isMailSelected) View.VISIBLE else View.GONE
    }

    override fun onBackPressed() {
        if (currentFragment != null) {
            showMainContent()
        } else {
            super.onBackPressed()
        }
    }
}
//package com.lauwba.claudeaigmail
//
//import android.animation.ObjectAnimator
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.view.View
//import android.view.animation.DecelerateInterpolator
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var profileMenu: View
//    private lateinit var navigationDrawer: View
//    private lateinit var mailIconBackground: View
//    private var isProfileMenuVisible = false
//    private var isNavigationDrawerVisible = false
//    private var isMailSelected = false
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        initViews()
//        setupClickListeners()
//    }
//
//    private fun initViews() {
//        profileMenu = findViewById(R.id.profile_menu_overlay)
//        navigationDrawer = findViewById(R.id.navigation_drawer_overlay)
//        mailIconBackground = findViewById(R.id.mail_icon_background)
//
//        // Initially hide overlays
//        profileMenu.translationX = resources.displayMetrics.widthPixels.toFloat()
//        navigationDrawer.translationX = -resources.displayMetrics.widthPixels.toFloat()
//        mailIconBackground.visibility = View.GONE
//    }
//
//    private fun setupClickListeners() {
//        // Profile circle click - slide profile menu from right
//        findViewById<View>(R.id.profile_circle).setOnClickListener {
//            toggleProfileMenu()
//        }
//
//        // Hamburger menu click - slide navigation drawer from left
//        findViewById<View>(R.id.iv_hamburger).setOnClickListener {
//            toggleNavigationDrawer()
//        }
//
//        // Mail icon click - show background highlight
//        findViewById<View>(R.id.iv_mail_bottom).setOnClickListener {
//            toggleMailSelection()
//        }
//
//        // Close profile menu when clicking outside
//        findViewById<View>(R.id.profile_menu_background).setOnClickListener {
//            hideProfileMenu()
//        }
//
//        // Close navigation drawer when clicking outside
//        findViewById<View>(R.id.navigation_drawer_background).setOnClickListener {
//            hideNavigationDrawer()
//        }
//
//        // Profile menu close button
//        findViewById<View>(R.id.profile_close_button).setOnClickListener {
//            hideProfileMenu()
//        }
//    }
//
//    private fun toggleProfileMenu() {
//        if (isProfileMenuVisible) {
//            hideProfileMenu()
//        } else {
//            showProfileMenu()
//        }
//    }
//
//    private fun showProfileMenu() {
//        profileMenu.visibility = View.VISIBLE
//
//        val animator = ObjectAnimator.ofFloat(profileMenu, "translationX",
//            resources.displayMetrics.widthPixels.toFloat(), 0f)
//        animator.duration = 300
//        animator.interpolator = DecelerateInterpolator()
//        animator.start()
//
//        isProfileMenuVisible = true
//    }
//
//    private fun hideProfileMenu() {
//        val animator = ObjectAnimator.ofFloat(profileMenu, "translationX",
//            0f, resources.displayMetrics.widthPixels.toFloat())
//        animator.duration = 300
//        animator.interpolator = DecelerateInterpolator()
//        animator.start()
//
//        animator.addListener(object : android.animation.AnimatorListenerAdapter() {
//            override fun onAnimationEnd(animation: android.animation.Animator) {
//                profileMenu.visibility = View.GONE
//            }
//        })
//
//        isProfileMenuVisible = false
//    }
//
//    private fun toggleNavigationDrawer() {
//        if (isNavigationDrawerVisible) {
//            hideNavigationDrawer()
//        } else {
//            showNavigationDrawer()
//        }
//    }
//
//    private fun showNavigationDrawer() {
//        navigationDrawer.visibility = View.VISIBLE
//
//        val animator = ObjectAnimator.ofFloat(navigationDrawer, "translationX",
//            -resources.displayMetrics.widthPixels.toFloat(), 0f)
//        animator.duration = 300
//        animator.interpolator = DecelerateInterpolator()
//        animator.start()
//
//        isNavigationDrawerVisible = true
//    }
//
//    private fun hideNavigationDrawer() {
//        val animator = ObjectAnimator.ofFloat(navigationDrawer, "translationX",
//            0f, -resources.displayMetrics.widthPixels.toFloat())
//        animator.duration = 300
//        animator.interpolator = DecelerateInterpolator()
//        animator.start()
//
//        animator.addListener(object : android.animation.AnimatorListenerAdapter() {
//            override fun onAnimationEnd(animation: android.animation.Animator) {
//                navigationDrawer.visibility = View.GONE
//            }
//        })
//
//        isNavigationDrawerVisible = false
//    }
//
//    private fun toggleMailSelection() {
//        isMailSelected = !isMailSelected
//        mailIconBackground.visibility = if (isMailSelected) View.VISIBLE else View.GONE
//    }
//
//    override fun onBackPressed() {
//        when {
//            isProfileMenuVisible -> hideProfileMenu()
//            isNavigationDrawerVisible -> hideNavigationDrawer()
//            else -> super.onBackPressed()
//        }
//    }
//}