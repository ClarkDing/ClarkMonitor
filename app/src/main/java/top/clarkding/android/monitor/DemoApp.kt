package top.clarkding.android.monitor

import android.app.Application
import android.os.Build
import top.clarkding.oom.base.CommonConfig
import top.clarkding.oom.base.MonitorManager

class DemoApp: Application() {

    override fun onCreate() {
        super.onCreate()

        val config = CommonConfig.Builder()
            .setApplication(this) // Set application
            .setVersionNameInvoker { "1.0.0" } // Set version name, java leak feature use it
            .setSdkVersionMatch(
                Build.VERSION.SDK_INT <= Build.VERSION_CODES.S
            )  // Set if current sdk version is supported
            .build()

        MonitorManager.initCommonConfig(config)
            .apply { onApplicationCreate() }
    }
}