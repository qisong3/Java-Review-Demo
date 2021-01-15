package cn.errison.feature.demo.process;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class Demo {

    private void getProcessInfo(){

        ProcessHandle self = ProcessHandle.current();
        ProcessHandle.Info procInfo = self.info();

        Optional<String[]> args = procInfo.arguments();
        Optional<String> cmd =  procInfo.commandLine();
        Optional<Instant> startTime = procInfo.startInstant();
        Optional<Duration> cpuUsage = procInfo.totalCpuDuration();



    }

    public static void main(String[] args) {

    }
}
