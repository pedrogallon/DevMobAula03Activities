package br.usjt.devmob.devmobaula03activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import br.usjt.devmob.devmobaula03activities.util.StatusTracker
import br.usjt.devmob.devmobaula03activities.util.Utils

/**
 * Created by Pedro on 05/03/2018.
 */
class ActivityAKotlin: Activity(){

    private var mActivityName: String? = null
    private var mStatusView: TextView? = null
    private var mStatusAllView: TextView? = null
    private val mStatusTracker = StatusTracker.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        System.out.print("Está na parte de Kotlin")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        mActivityName = getString(R.string.activity_a)
        mStatusView = findViewById<View>(R.id.status_view_a) as TextView
        mStatusAllView = findViewById<View>(R.id.status_view_all_a) as TextView
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onStart() {
        super.onStart()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_start))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onRestart() {
        super.onRestart()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onResume() {
        super.onResume()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onPause() {
        super.onPause()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onStop() {
        super.onStop()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop))
    }

    override fun onDestroy() {
        super.onDestroy()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy))
        mStatusTracker.clear()
    }

    fun startDialog(v: View) {
        val intent = Intent(this@ActivityAKotlin, DialogActivity::class.java)
        startActivity(intent)
    }

    fun startActivityB(v: View) {
        val intent = Intent(this@ActivityAKotlin, ActivityB::class.java)
        startActivity(intent)
    }

    fun startActivityC(v: View) {
        val intent = Intent(this@ActivityAKotlin, ActivityC::class.java)
        startActivity(intent)
    }

    fun finishActivityA(v: View) {
        this@ActivityAKotlin.finish()
    }


}