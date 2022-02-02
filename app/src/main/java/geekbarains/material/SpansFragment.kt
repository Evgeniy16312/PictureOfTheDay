package geekbarains.material

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import android.text.style.BulletSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment


class SpansFragment : Fragment() {

    private val textView: TextView by lazy {
        view?.findViewById<TextView>(R.id.text_span) ?: throw IllegalStateException()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spans, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.text = "Test"

//        spanOne()
//        spanTwo()
        spanThree()
//        spanFour()
    }

    private fun spanOne() {
        val text = "My text <ul><li>bullet one</li><li>bullet two</li></ul>"
        textView.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    private fun spanTwo() {
        val spannable = SpannableString("My text \nbullet one\nbullet two")

        requireContext().resources.getColor(R.color.colorAccent)
        spannable.setSpan(
            BulletSpan(8, ContextCompat.getColor(requireContext(), R.color.colorAccent)),
            /* начало элемента списка */ 9, /* конец элемента списка */ 18,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            BulletSpan(8, ContextCompat.getColor(requireContext(), R.color.colorAccent)),
            /* начало элемента списка */ 20, /* конец элемента списка */ spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            BackgroundColorSpan(
                ContextCompat.getColor(
                    requireContext(),
                    android.R.color.holo_red_dark
                )
            ),
            20,
            26,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        SpannableStringBuilder()
        textView.text = spannable
    }

    private fun spanThree() {
        val spannable = SpannableString("Tet styling")
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.colorAccent)),
            0, 4,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannable
    }

    private fun spanFour() {
        val spannable = SpannableStringBuilder("Text is spantastic!")
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            /* начальный индекс */ 8, /* конечный индекс */ 12,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable.insert(12, "(& fon)")
    }
}