package di.penopllast.com.inforemover.entities

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import di.penopllast.com.inforemover.R
import kotlinx.android.synthetic.main.item_app.view.*
import di.penopllast.com.inforemover.application.Utils.Util


class ApplicationAdapter(private val appList: List<ApplicationInfo>)
    : RecyclerView.Adapter<ApplicationAdapter.ViewHolder>() {

    init {
        Log.i("test", "size = " + appList.size)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val icon = view.icon_image!!
        val name = view.name_text!!
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
        holder.view.setOnClickListener { Util.print("Нажали на ${appInfo.name}")}
    }

    override fun getItemCount(): Int {
        return appList.size
    }
}
