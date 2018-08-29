package di.penopllast.com.inforemover.presentation.presenters

interface AppListPresenter {
    fun onCheckboxClick(packageName: String, name: String, f: Boolean)
    fun printAppsFromDb()
}