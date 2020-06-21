package fr.bowser.sample.constraintlayout.utils

import android.widget.SeekBar

open class SeekBarChangeListener : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        // nothing to do
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {
        // nothing to do
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {
        // nothing to do
    }
}