package geekbarains.material.ui.picture

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import geekbarains.material.AnimationsActivityBonus
import geekbarains.material.R
import geekbarains.material.ui.AnimationsActivity
import geekbarains.material.ui.apibottom.ApiBottomActivity
import kotlinx.android.synthetic.main.bottom_navigation_layout.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_one -> activity?.let { startActivity(Intent(it, AnimationsActivity::class.java)) }
                R.id.navigation_two -> activity?.let { startActivity(Intent(it, AnimationsActivityBonus::class.java)) }
            }
            true
        }
    }
}
