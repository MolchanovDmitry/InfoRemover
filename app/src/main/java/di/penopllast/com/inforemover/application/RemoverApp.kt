package di.penopllast.com.inforemover.application

import android.app.Application
import com.di.penopllast.vklikesremover.di.ComponentsHolder

class RemoverApp : Application() {

    override fun onCreate() {
        super.onCreate()
        componentsHolder = ComponentsHolder(this)
        componentsHolder?.init()
    }

    companion object {
        var componentsHolder: ComponentsHolder? = null
            private set
    }
}