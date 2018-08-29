package di.penopllast.com.inforemover.entities

import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

import di.penopllast.com.inforemover.R
import kotlinx.android.synthetic.main.item_app.view.*
import di.penopllast.com.inforemover.application.Utils.Util
import di.penopllast.com.inforemover.presentation.screen.impl.AdapterCallback


class AppListAdapter(
        private val appList: List<ApplicationInfo>,
        private val callback: AdapterCallback)
    : RecyclerView.Adapter<AppListAdapter.ViewHolder>() {

    init {
        Log.i("test", "size = " + appList.size)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.icon_image
        val name: TextView = view.name_text
        val checkbox: CheckBox = view.checkbox
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_app, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("test", "position = $position")
        val appInfo = appList[position]
        holder.name.text = appInfo.name
        holder.icon.setImageDrawable(appInfo.icon)
        holder.checkbox.setOnClickListener {
            callback.onClick(appInfo.packageName, appInfo.name, holder.checkbox.isChecked)
        }
    }

    override fun getItemCount(): Int {
        return appList.size
    }
}
