package com.rein.exploraplan

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.rein.exploraplan.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the toolbar
        setSupportActionBar(binding.appBarHome.toolbar)

        /*binding.appBarHome.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }*/

        // Set up Navigation Controller for Drawer and Bottom Navigation
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        /*val bottomNavView: BottomNavigationView = binding.navView2*/

        val navController = findNavController(R.id.nav_host_fragment_content_home)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        // Define AppBarConfiguration with top-level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_itinerary, R.id.navigation_location, R.id.navigation_budget,R.id.navigation_announcement, // Bottom Navigation Destinations
                R.id.nav_plan, R.id.nav_profile, R.id.nav_bookmarks // Side Navigation Destinations
            ), drawerLayout
        )

        // Link Navigation Controller with the Toolbar and Navigation Views
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController) // Drawer navigation
        /*bottomNavView.setupWithNavController(navController) // Bottom navigation*/

        // Set up NavigationView item click listener for the side navigation (drawer)
        /*navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_plan -> {
                    navController.navigate(R.id.nav_plan)
                }
                R.id.nav_profile -> {
                    navController.navigate(R.id.nav_profile)
                }
                R.id.nav_bookmarks -> {
                    navController.navigate(R.id.nav_bookmarks)
                }
                else -> {
                    Toast.makeText(this, "Unknown Item Selected", Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener false
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START) // Close the drawer after item selection
            true
        }*/

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "This will show the settings of the app", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.logout -> {
                val logoutDialog = AlertDialog.Builder(this)

                logoutDialog.setMessage("Are you sure you?")
                logoutDialog.setTitle("Log - out")
                logoutDialog.setCancelable(false)
                logoutDialog.setPositiveButton("Yes") {_,_ ->

                    /*Firebase.auth.signOut()*/

                    val intent2 = Intent(this, SigninActivity::class.java)
                    startActivity(intent2)

                    finish()

                }

                logoutDialog.setNegativeButton("No"){_,_ ->
                    Toast.makeText(this, "Clicked No",Toast.LENGTH_SHORT).show()
                }

                logoutDialog.setNegativeButton("Cancel"){_,_ ->
                    Toast.makeText(this, "Clicked Cancel",Toast.LENGTH_SHORT).show()
                }

                val alertDialogBox = logoutDialog.create()
                alertDialogBox.show()

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}