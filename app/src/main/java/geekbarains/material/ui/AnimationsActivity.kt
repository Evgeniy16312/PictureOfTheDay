package geekbarains.material.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import geekbarains.material.R
import geekbarains.material.SpansFragment
import kotlinx.android.synthetic.main.activity_animations_enlarge.*
import kotlinx.android.synthetic.main.activity_animations_fab.*


class AnimationsActivity : AppCompatActivity() {

    private var isExpanded = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations_fab)
        setFAB()
        scroll_view.setOnScrollChangeListener { _, _, _, _, _ ->
            scroll_view.canScrollVertically(-1)
        }
    }

    private fun setFAB() {
        setInitialState()

        fab.setOnClickListener {
            if (isExpanded) {
                collapseFab()
            } else {
                expandFAB()
            }
        }
    }

    private fun setInitialState() {
        transparent_background.apply {
            alpha = 0f
        }
        option_two_container.apply {
            alpha = 0f
            isClickable = false
        }
        option_one_container.apply {
            alpha = 0f
            isClickable = false
        }
    }

    private fun expandFAB() {
        isExpanded = true
        ObjectAnimator.ofFloat(plus_imageview, "rotation", 0f, 225f).start()
        ObjectAnimator.ofFloat(option_two_container, "translationY", -130f).start()
        ObjectAnimator.ofFloat(option_one_container, "translationY", -250f).start()

        option_two_container.animate()
            .alpha(1f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    option_two_container.isClickable = true
                    option_two_container.setOnClickListener {
                        Toast.makeText(this@AnimationsActivity, "Option 2", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
        option_one_container.animate()
            .alpha(1f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    option_one_container.isClickable = true
                    option_one_container.setOnClickListener {
                        Toast.makeText(this@AnimationsActivity, "Option 1", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
        transparent_background.animate()
            .alpha(0.9f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    transparent_background.isClickable = true
                }
            })
    }

    private fun collapseFab() {
        isExpanded = false
        ObjectAnimator.ofFloat(plus_imageview, "rotation", 0f, -180f).start()
        ObjectAnimator.ofFloat(option_two_container, "translationY", 0f).start()
        ObjectAnimator.ofFloat(option_one_container, "translationY", 0f).start()

        option_two_container.animate()
            .alpha(0f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    option_two_container.isClickable = false
                    option_one_container.setOnClickListener(null)
                }
            })
        option_one_container.animate()
            .alpha(0f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    option_one_container.isClickable = false
                }
            })
        transparent_background.animate()
            .alpha(0f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    transparent_background.isClickable = false
                }
            })
    }
}
