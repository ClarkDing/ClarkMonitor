package top.clarkding.oom.jvm.monitor

import java.io.File

interface OOMReportUploader {
  /**
   * 注意：外部调用完upload后，切记自行删除
   */
  fun upload(file: File, content: String)
}