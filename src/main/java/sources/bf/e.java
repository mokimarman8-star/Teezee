package bf;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.meituan.android.walle.SignatureNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class e {
    public static byte[] a(File file, int i) {
        ByteBuffer byteBuffer;
        Map b = b(file);
        if (b == null || (byteBuffer = (ByteBuffer) b.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return c(byteBuffer);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r1 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Map b(File file) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        Map map = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
                try {
                    fileChannel = randomAccessFile.getChannel();
                    try {
                        map = a.f((ByteBuffer) a.b(fileChannel).a());
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException unused2) {
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (IOException unused5) {
                            throw th;
                        }
                    }
                } catch (IOException unused6) {
                    fileChannel = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (SignatureNotFoundException | IOException unused7) {
            }
        } catch (IOException unused8) {
            fileChannel = null;
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            randomAccessFile = null;
        }
        randomAccessFile.close();
        return map;
    }

    private static byte[] c(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static String d(File file, int i) {
        byte[] a = a(file, i);
        if (a == null) {
            return null;
        }
        try {
            return new String(a, C.UTF8_NAME);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
