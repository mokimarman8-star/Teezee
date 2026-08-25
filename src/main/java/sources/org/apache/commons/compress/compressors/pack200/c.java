package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class c extends b {
    private final File b;

    c() {
        OutputStream newOutputStream;
        File createTempFile = File.createTempFile("commons-compress", "packtemp");
        this.b = createTempFile;
        createTempFile.deleteOnExit();
        newOutputStream = Files.newOutputStream(f7.b.a(createTempFile), new OpenOption[0]);
        ((FilterOutputStream) this).out = newOutputStream;
    }
}
