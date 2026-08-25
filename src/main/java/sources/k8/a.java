package k8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a extends b {
    private String a;
    private File b;
    private BufferedWriter c;

    @Override // k8.b
    public void a(String str) {
        try {
            this.c.write(str);
            this.c.newLine();
            this.c.flush();
        } catch (Exception e) {
            d8.b.e().g("append log failed: " + e.getMessage());
        }
    }

    @Override // k8.b
    public boolean b() {
        BufferedWriter bufferedWriter = this.c;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.c = null;
        this.a = null;
        this.b = null;
        return true;
    }

    @Override // k8.b
    public File c() {
        return this.b;
    }

    @Override // k8.b
    public String d() {
        return this.a;
    }

    @Override // k8.b
    public boolean e() {
        return this.c != null && this.b.exists();
    }

    @Override // k8.b
    public boolean f(File file) {
        boolean z;
        this.a = file.getName();
        this.b = file;
        if (file.exists()) {
            z = false;
        } else {
            try {
                File parentFile = this.b.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.b.createNewFile();
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
                b();
                return false;
            }
        }
        try {
            this.c = new BufferedWriter(new FileWriter(this.b, true));
            if (z) {
                g(this.b);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            b();
            return false;
        }
    }

    public void g(File file) {
    }
}
