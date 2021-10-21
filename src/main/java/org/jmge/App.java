package org.jmge;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "PicoCliSample", mixinStandardHelpOptions = true, version = "v1.0", description = "This is a sample how to use PicoCli")
class PicoCliSample implements Runnable {

    @Option(names = { "-a", "--a-parameter" }, required = true, description = "Parameter A")
    private String a = "Parameter A";
    @Option(names = { "-b", "--b-parameter" }, required = false, description = "Parameter B")
    private String b;

    public static void main(String... args) {
        System.out.println("Processing args...");
        int exitCode = new CommandLine(new PicoCliSample()).execute(args);
        System.out.println("Processed args");
        System.exit(exitCode);
    }

    @Override
    public void run() {
        System.out.println("Parameter A: " + a);
        if (b != null) {
            System.out.println("Parameter B: " + b);
        }
    }
}
