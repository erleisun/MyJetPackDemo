import android.app.Application

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        baseApp = this
    }

    companion object {

        private lateinit var baseApp: BaseApp

        fun getContext(): BaseApp {
            return baseApp
        }
    }

}