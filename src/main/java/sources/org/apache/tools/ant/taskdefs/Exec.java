package org.apache.tools.ant.taskdefs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.tools.ant.u;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class Exec extends u {
    protected PrintWriter g = null;
    private boolean h = false;

    class StreamPumper extends Thread {
        private static final int SLEEP_TIME = 5;
        private BufferedReader din;
        private boolean endOfStream = false;
        private int messageLevel;

        public StreamPumper(InputStream inputStream, int i) {
            this.din = new BufferedReader(new InputStreamReader(inputStream));
            this.messageLevel = i;
        }

        public void pumpStream() throws IOException {
            if (this.endOfStream) {
                return;
            }
            String readLine = this.din.readLine();
            if (readLine != null) {
                Exec.this.u(readLine, this.messageLevel);
            } else {
                this.endOfStream = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.endOfStream) {
                try {
                    try {
                        pumpStream();
                        Thread.sleep(5L);
                    } catch (IOException unused) {
                        return;
                    }
                } catch (InterruptedException unused2) {
                }
            }
            this.din.close();
        }
    }

    public Exec() {
        PrintStream printStream = System.err;
        printStream.println("As of Ant 1.2 released in October 2000, the Exec class");
        printStream.println("is considered to be dead code by the Ant developers and is unmaintained.");
        printStream.println("Don't use it!");
    }

    protected void u(String str, int i) {
        PrintWriter printWriter = this.g;
        if (printWriter == null) {
            log(str, i);
        } else {
            printWriter.println(str);
        }
    }
}
