package di.penopllast.com.inforemover

import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        app_list_button.setOnClickListener {
            startActivity(Intent(this, AppListActivity::class.java))
        }
        Handler().postDelayed({ app_list_button.performClick() }, 100)
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
