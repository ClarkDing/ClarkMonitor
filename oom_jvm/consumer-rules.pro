# keep fork dump related jni function,   must needed
-keep class top.clarkding.oom.jvm.hprof.* {*;}

# keep heap report json format,          must needed
-keep class top.clarkding.oom.jvm.monitor.analysis.HeapReport { *; }
-keep class top.clarkding.oom.jvm.monitor.analysis.HeapReport$* { *; }
-keep class top.clarkding.oom.jvm.monitor.analysis.HeapReport$*$* { *; }
