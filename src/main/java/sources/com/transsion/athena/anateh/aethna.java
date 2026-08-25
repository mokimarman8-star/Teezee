package com.transsion.athena.anateh;

import android.util.Log;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aethna {
    private static ByteBuffer a;
    private File b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e6 A[Catch: IOException -> 0x00c0, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x00c0, blocks: (B:29:0x00bc, B:51:0x00e6), top: B:7:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100 A[Catch: IOException -> 0x00fc, TRY_LEAVE, TryCatch #12 {IOException -> 0x00fc, blocks: (B:75:0x00f8, B:60:0x0100), top: B:74:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.nio.channels.FileChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public aethna(String str) {
        AbstractInterruptibleChannel abstractInterruptibleChannel;
        Throwable th2;
        RandomAccessFile randomAccessFile;
        Exception e;
        ?? r0;
        RandomAccessFile randomAccessFile2;
        AbstractInterruptibleChannel abstractInterruptibleChannel2;
        FileLock fileLock;
        ?? channel;
        File file = new File(str);
        this.b = file;
        if (!file.exists()) {
            try {
                if (this.b.createNewFile()) {
                    com.transsion.athena.taaneh.aethna.c("EncryptFile created");
                }
            } catch (Exception e2) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
            }
        }
        if (a == null) {
            a = ByteBuffer.allocate(32808);
        }
        FileLock fileLock2 = null;
        try {
            try {
                if (this.b.length() < 8192) {
                    randomAccessFile = new RandomAccessFile(this.b, "rw");
                    try {
                        channel = randomAccessFile.getChannel();
                    } catch (Exception e3) {
                        e = e3;
                        fileLock = null;
                    } catch (Throwable th3) {
                        th2 = th3;
                        abstractInterruptibleChannel = null;
                    }
                    try {
                        fileLock2 = channel.lock();
                        a.putInt(0, 0);
                        a.putInt(4, ((Integer) com.transsion.athena.aethna.athena.c().i().first).intValue());
                        for (int i = 0; i < 8192; i += 4) {
                            a.putInt((i + 10) * 4, i);
                        }
                        randomAccessFile.seek(0L);
                        randomAccessFile.write(a.array());
                        abstractInterruptibleChannel2 = channel;
                    } catch (Exception e4) {
                        e = e4;
                        fileLock = fileLock2;
                        fileLock2 = channel;
                        r0 = fileLock2;
                        fileLock2 = fileLock;
                        randomAccessFile2 = randomAccessFile;
                        try {
                            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                            if (fileLock2 != null) {
                                try {
                                    fileLock2.release();
                                } catch (IOException e5) {
                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e5));
                                    if (randomAccessFile2 == null) {
                                        randomAccessFile2.close();
                                    }
                                    return;
                                }
                            }
                            if (r0 != 0) {
                                r0.close();
                            }
                            if (randomAccessFile2 == null) {
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            RandomAccessFile randomAccessFile3 = randomAccessFile2;
                            abstractInterruptibleChannel = r0;
                            randomAccessFile = randomAccessFile3;
                            if (fileLock2 != null) {
                                try {
                                    fileLock2.release();
                                } catch (IOException e6) {
                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e6));
                                    if (randomAccessFile == null) {
                                    }
                                }
                            }
                            if (abstractInterruptibleChannel != null) {
                                abstractInterruptibleChannel.close();
                            }
                            if (randomAccessFile == null) {
                                throw th2;
                            }
                            try {
                                randomAccessFile.close();
                                throw th2;
                            } catch (IOException e7) {
                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e7));
                                throw th2;
                            }
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        abstractInterruptibleChannel = channel;
                        if (fileLock2 != null) {
                        }
                        if (abstractInterruptibleChannel != null) {
                        }
                        if (randomAccessFile == null) {
                        }
                    }
                } else {
                    randomAccessFile = null;
                    abstractInterruptibleChannel2 = null;
                }
                if (fileLock2 != null) {
                    try {
                        fileLock2.release();
                    } catch (IOException e8) {
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e8));
                    }
                }
                if (abstractInterruptibleChannel2 != null) {
                    abstractInterruptibleChannel2.close();
                }
            } catch (IOException e9) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e9));
                return;
            }
        } catch (Exception e10) {
            e = e10;
            r0 = 0;
            randomAccessFile2 = null;
        } catch (Throwable th6) {
            abstractInterruptibleChannel = null;
            th2 = th6;
            randomAccessFile = null;
        }
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x013f A[Catch: IOException -> 0x013b, TRY_LEAVE, TryCatch #13 {IOException -> 0x013b, blocks: (B:56:0x0137, B:41:0x013f), top: B:55:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0122 A[Catch: IOException -> 0x00e1, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x00e1, blocks: (B:62:0x00dd, B:89:0x0122), top: B:7:0x001c }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0126 -> B:56:0x012d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        FileChannel fileChannel;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel2;
        FileLock fileLock2;
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        List<byte[]> d = com.transsion.athena.aethna.athena.c().d();
        if (com.transsion.athena.config.data.model.anehat.a(d)) {
            com.transsion.athena.taaneh.aethna.a("readBuffer passwords is empty");
            return BuildConfig.FLAVOR;
        }
        RandomAccessFile randomAccessFile2 = null;
        r2 = null;
        FileLock fileLock3 = null;
        r2 = null;
        FileChannel fileChannel3 = null;
        FileChannel fileChannel4 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(this.b, "rw");
                try {
                    fileChannel2 = randomAccessFile.getChannel();
                    try {
                        try {
                            fileLock3 = fileChannel2.lock();
                            randomAccessFile.seek(0L);
                            randomAccessFile.read(a.array(), 0, 32808);
                            byte[] bArr2 = d.get(a.getInt(4));
                            if (bArr2 != null) {
                                athena athenaVar = new athena(bArr2);
                                boolean z = true;
                                for (int i = 0; i < a.getInt(0); i++) {
                                    if (i == 0) {
                                        int i2 = a.getInt((i + 10) * 4);
                                        bArr = new byte[i2];
                                        randomAccessFile.read(bArr, 0, i2);
                                    } else {
                                        int i3 = a.getInt((i + 10) * 4) - a.getInt((i + 9) * 4);
                                        bArr = new byte[i3];
                                        randomAccessFile.read(bArr, 0, i3);
                                    }
                                    String str = new String(athenaVar.a(bArr));
                                    try {
                                        try {
                                            JSONObject jSONObject = new JSONObject(str);
                                            if (jSONObject.has("tid") && jSONObject.has("event")) {
                                                if (!z) {
                                                    sb.append("\n");
                                                }
                                                sb.append(str);
                                                z = false;
                                            }
                                        } catch (Exception e) {
                                            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (fileLock3 != null) {
                                        }
                                        if (fileChannel2 != null) {
                                        }
                                        if (randomAccessFile == null) {
                                        }
                                    }
                                }
                            }
                            if (fileLock3 != null) {
                                try {
                                    fileLock3.release();
                                } catch (IOException e2) {
                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
                                }
                            }
                            fileChannel2.close();
                            randomAccessFile.close();
                        } catch (Exception e3) {
                            e = e3;
                            fileLock = fileLock3;
                            fileChannel4 = fileChannel2;
                            try {
                                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                                if (this.b.delete()) {
                                    com.transsion.athena.taaneh.aethna.c("file deleted");
                                }
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e4));
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                        return sb.toString();
                                    }
                                }
                                if (fileChannel4 != null) {
                                    fileChannel4.close();
                                }
                                if (randomAccessFile != null) {
                                }
                                return sb.toString();
                            } catch (Throwable th3) {
                                th = th3;
                                fileChannel = fileChannel4;
                                randomAccessFile2 = randomAccessFile;
                                randomAccessFile = randomAccessFile2;
                                fileLock3 = fileLock;
                                fileChannel2 = fileChannel;
                                if (fileLock3 != null) {
                                    try {
                                        fileLock3.release();
                                    } catch (IOException e5) {
                                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e5));
                                        if (randomAccessFile == null) {
                                        }
                                    }
                                }
                                if (fileChannel2 != null) {
                                    fileChannel2.close();
                                }
                                if (randomAccessFile == null) {
                                    throw th;
                                }
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (IOException e6) {
                                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e6));
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileLock2 = fileLock3;
                        fileChannel3 = fileChannel2;
                        fileChannel2 = fileChannel3;
                        fileLock3 = fileLock2;
                        if (fileLock3 != null) {
                        }
                        if (fileChannel2 != null) {
                        }
                        if (randomAccessFile == null) {
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileLock = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileLock2 = null;
                }
            } catch (IOException e8) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e8));
            }
        } catch (Exception e9) {
            e = e9;
            randomAccessFile = null;
            fileLock = null;
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
            fileLock = null;
            randomAccessFile = randomAccessFile2;
            fileLock3 = fileLock;
            fileChannel2 = fileChannel;
            if (fileLock3 != null) {
            }
            if (fileChannel2 != null) {
            }
            if (randomAccessFile == null) {
            }
        }
        return sb.toString();
    }
}
