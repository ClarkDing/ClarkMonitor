package top.clarkding.android.monitor

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import top.clarkding.andorid.monitor.R
import top.clarkding.andorid.monitor.databinding.ActDemoBinding
import top.clarkding.oom.base.MonitorLog
import top.clarkding.oom.base.MonitorManager
import top.clarkding.oom.jvm.monitor.OOMHprofUploader
import top.clarkding.oom.jvm.monitor.OOMMonitorConfig
import top.clarkding.oom.jvm.monitor.OOMReportUploader
import java.io.File

class DemoActivity: Activity() {

    private lateinit var mBinding: ActDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this,
            R.layout.act_demo)

        init()
    }

    private fun init() {
        val config = OOMMonitorConfig.Builder()
            .setThreadThreshold(50) //50 only for test! Please use default value!
            .setFdThreshold(300) // 300 only for test! Please use default value!
            .setHeapThreshold(0.9f) // 0.9f for test! Please use default value!
            .setVssSizeThreshold(1_000_000) // 1_000_000 for test! Please use default value!
            .setMaxOverThresholdCount(1) // 1 for test! Please use default value!
            .setAnalysisMaxTimesPerVersion(3) // Consider use default value！
            .setAnalysisPeriodPerVersion(15 * 24 * 60 * 60 * 1000) // Consider use default value！
            .setLoopInterval(5_000) // 5_000 for test! Please use default value!
            .setEnableHprofDumpAnalysis(true)
            .setHprofUploader(object : OOMHprofUploader {
                override fun upload(file: File, type: OOMHprofUploader.HprofType) {
                    MonitorLog.e("OOMMonitor", "todo, upload hprof ${file.name} if necessary")
                }
            })
            .setReportUploader(object : OOMReportUploader {
                override fun upload(file: File, content: String) {
                    MonitorLog.i("OOMMonitor", content)
                    MonitorLog.e("OOMMonitor", "todo, upload report ${file.name} if necessary")
                }
            })
            .build()

        MonitorManager.addMonitorConfig(config)
    }
}