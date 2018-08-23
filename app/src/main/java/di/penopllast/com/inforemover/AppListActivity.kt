package di.penopllast.com.inforemover

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import java.util.ArrayList

import di.penopllast.com.inforemover.entities.ApplicationAdapter
import di.penopllast.com.inforemover.entities.ApplicationInfo
import kotlinx.android.synthetic.main.activity_app_list.*

class AppListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_list)

        val applicationInfoList = applicationInfoList
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = ApplicationAdapter(applicationInfoList)
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
                                resolveInfo.loadIcon(pm)))
            }
            return applicationInfoList
        }
}
