package di.penopllast.com.inforemover.presentation.presenters.impl

import javax.inject.Inject

import di.penopllast.com.inforemover.application.RemoverApp
import di.penopllast.com.inforemover.data.repositories.RepositoryDb
import di.penopllast.com.inforemover.presentation.presenters.AppListPresenter
import di.penopllast.com.inforemover.presentation.screen.AppListView

class AppListPresenterImpl : AppListPresenter {

    var repositoryDb: RepositoryDb? = null
        @Inject set

    init {
        RemoverApp.componentsHolder?.appComponent?.inject(this)
    }

    override fun onCheckboxClick(packageName: String, name: String, f: Boolean) {
        if (f) {
            repositoryDb?.insertApp(packageName, name)
        } else {
            repositoryDb?.deleteApp(packageName, name)
        }
    }

    override fun printAppsFromDb() {
        repositoryDb?.printData()
    }
}
