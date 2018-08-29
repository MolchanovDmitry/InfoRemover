package di.penopllast.com.inforemover.presentation.screen.impl

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.support.v7.widget.LinearLayoutManager
import di.penopllast.com.inforemover.R

import java.util.ArrayList

import di.penopllast.com.inforemover.entities.AppListAdapter
import di.penopllast.com.inforemover.entities.ApplicationInfo
import di.penopllast.com.inforemover.presentation.presenters.AppListPresenter
import di.penopllast.com.inforemover.presentation.presenters.impl.AppListPresenterImpl
import di.penopllast.com.inforemover.presentation.screen.AppListView
import kotlinx.android.synthetic.main.activity_app_list.*

class AppListActivity : AppCompatActivity(), AppListView, AdapterCallback {

    private lateinit var backgroundThread: HandlerThread
    private lateinit var dbHandler: Handler
    private lateinit var presenter: AppListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_list)

        presenter = AppListPresenterImpl()
        setTitle(R.string.choose_apps_for_remove)
        startBackgroundThread()

        val applicationInfoList = applicationInfoList
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = AppListAdapter(applicationInfoList, this)
        save_button.setOnClickListener {
            dbHandler.post { presenter.printAppsFromDb() }
        }
    }

    private fun startBackgroundThread() {
        backgroundThread = HandlerThread("dbThread")
        backgroundThread.start()
        dbHandler = Handler(backgroundThread.looper)
    }

    private val applicationInfoList: List<ApplicationInfo>
        get() {
            val applicationInfoList = ArrayList<ApplicationInfo>()
            val pm = packageManager
            val i = Intent(Intent.ACTION_MAIN)
            i.addCategory(Intent.CATEGORY_LAUNCHER)
            val lst = pm.queryIntentActivities(i, 0)

            for (resolveInfo in lst) {
                applicationInfoList.add(
                        ApplicationInfo(resolveInfo.loadLabel(pm).toString(),
                                resolveInfo.activityInfo.packageName,
                                resolveInfo.loadIcon(pm)))
            }
            return applicationInfoList
        }

    override fun onClick(packageName: String, name: String, f: Boolean) {
        dbHandler.post { presenter.onCheckboxClick(packageName, name, f) }
    }

    override fun onStop() {
        super.onStop()
        dbHandler.removeCallbacksAndMessages(null)
        backgroundThread.quit()
        backgroundThread.join()
    }
}

interface AdapterCallback {
    fun onClick(packageName: String, name: String, f: Boolean)
}