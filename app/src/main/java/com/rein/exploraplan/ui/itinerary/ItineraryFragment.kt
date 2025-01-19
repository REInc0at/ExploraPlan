package com.rein.exploraplan.ui.itinerary

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rein.exploraplan.R
import com.rein.exploraplan.databinding.FragmentHomeBinding
import com.rein.exploraplan.databinding.FragmentItineraryBinding

class ItineraryFragment : Fragment() {

    private var _binding: FragmentItineraryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val itineraryViewModel =
            ViewModelProvider(this).get(ItineraryViewModel::class.java)

        _binding = FragmentItineraryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*private val browse_destination = arrayOf(
        R.drawable.arroceros_forest_park,
        R.drawable.intramuros,
        R.drawable.manila_baywalk
    )

    private val browse_games_names = arrayOf(
        R.string.zelda,
        R.string.pokemon,
        R.string.persia
    )

    private val browse_games_description = arrayOf(
        R.string.zelda_description,
        R.string.pokemon_description,
        R.string.persia_description
    )

    private val all_games = arrayOf(
        R.drawable.arroceros_forest_park,
        R.drawable.intramuros,
        R.drawable.manila_baywalk
    )

    private val all_games_names = arrayOf(
        R.string.zelda,
        R.string.pokemon,
        R.string.persia
    )

    private val all_games_description = arrayOf(
        R.string.zelda_description,
        R.string.pokemon_description,
        R.string.persia_description,
    )

    private val imageFileNames = mapOf(
        R.drawable.arroceros_forest_park to "arroceros_forest_park.jpg",
        R.drawable.intramuros to "intramuros.jpg",
        R.drawable.manila_baywalk to "manila_baywalk.jpg"
    )


    private val verticalItemsCount = 4 // Number of items for vertical scroll

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentItineraryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtain the LayoutInflater instance from the current context
        val inflater = LayoutInflater.from(requireContext())

        // Access the LinearLayout for the vertical scrollable layout
        val verticalScrollView = binding.verticalContainer1

        // Set margin between items
        val layoutVerParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutVerParams.setMargins(0, 16.dpToPx(), 0, 16.dpToPx())

        // Inflate and add item views to the imageContainer (horizontal scroll)
        for (i in all_games.indices) {
            val aItemView = inflater.inflate(R.layout.item_list, verticalScrollView, false)
            val aGameImage = aItemView.findViewById<ImageView>(R.id.aDestinationImageView)
            val aGameDescription = aItemView.findViewById<TextView>(R.id.DescriptionText)
            val aGameRate = aItemView.findViewById<TextView>(R.id.rateText)

            aGameImage.setImageResource(all_games[i])
            aGameDescription.setText(all_games_names[i])
            aGameRate.setText(all_games_description[i])

            // Set click listener for the item
            aItemView.setOnClickListener {
                // Navigate to another fragment when item is clicked
                val aName = all_games_names[i]
                val aDescription = all_games_description[i]
                val aImage = all_games[i]
                navigateToFourthFragment(aName, aDescription, aImage)
            }

            // Add item view to the imageContainer
            verticalScrollView.addView(aItemView)

            if (i < all_games.size - 1) {
                // Add margins to all items except the last one
                val aMarginView = View(requireContext())

                aMarginView.layoutParams = layoutVerParams
                verticalScrollView.addView(aMarginView)
            }
        }

        // Access the LinearLayout for the vertical scrollable layout
        val verticalScrollView2 = binding.verticalContainer2

        // Set margin between items
        val layoutVerParams2 = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutVerParams2.setMargins(0, 16.dpToPx(), 0, 16.dpToPx())

        // Inflate and add item views to the imageContainer (horizontal scroll)
        for (i in all_games.indices) {
            val aItemView2 = inflater.inflate(R.layout.item_list, verticalScrollView2, false)
            val aGameImage2 = aItemView2.findViewById<ImageView>(R.id.aDestinationImageView)
            val aGameDescription2 = aGameImage2.findViewById<TextView>(R.id.DescriptionText)
            val aGameRate2 = aGameDescription2.findViewById<TextView>(R.id.rateText)

            aGameImage2.setImageResource(all_games[i])
            aGameDescription2.setText(all_games_names[i])
            aGameRate2.setText(all_games_description[i])

            // Set click listener for the item
            aItemView2.setOnClickListener {
                // Navigate to another fragment when item is clicked
                val aName = all_games_names[i]
                val aDescription = all_games_description[i]
                val aImage = all_games[i]
                navigateToFourthFragment(aName, aDescription, aImage)
            }

            // Add item view to the imageContainer
            verticalScrollView.addView(aItemView2)

            if (i < all_games.size - 1) {
                // Add margins to all items except the last one
                val aMarginView2 = View(requireContext())

                aMarginView2.layoutParams = layoutVerParams
                verticalScrollView.addView(aMarginView2)
            }
        }

    }

    // Extension function to convert dp to pixels
    fun Int.dpToPx(): Int {
        return (this * Resources.getSystem().displayMetrics.density).toInt()
    }

    private fun navigateToFourthFragment(nameID: Int, descID: Int, imgID: Int) {
        val gameName = getString(nameID)
        val gameDescription = getString(descID)

        // Look up the file name based on the image resource ID
        val imageGame = imageFileNames[imgID] ?: "unknown_image.jpg" // Default to a generic file name if not found

        val action = HomeFragmenDirections.actionThirdFragmentToFourthFragment(gameName, gameDescription, imageGame)
        findNavController().navigate(action)

        Toast.makeText(requireContext(), "Game clicked: $gameName", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}