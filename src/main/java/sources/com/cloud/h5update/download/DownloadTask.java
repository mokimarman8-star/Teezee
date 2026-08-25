package com.cloud.h5update.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.DownloadEntity;
import com.cloud.h5update.utils.h;
import com.cloud.h5update.utils.l;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rf.b;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/cloud/h5update/download/DownloadTask;", "Ljava/lang/Runnable;", "Lcom/cloud/h5update/bean/DownloadEntity;", "downloadEntity", "<init>", "(Lcom/cloud/h5update/bean/DownloadEntity;)V", "", "run", "()V", "cancel", "Lokhttp3/OkHttpClient;", "mClient", "setClient", "(Lokhttp3/OkHttpClient;)V", "Lcom/cloud/h5update/download/a;", "listener", "setListener", "(Lcom/cloud/h5update/download/a;)V", "Lcom/cloud/h5update/bean/DownloadEntity;", "getDownloadEntity", "()Lcom/cloud/h5update/bean/DownloadEntity;", "mListener", "Lcom/cloud/h5update/download/a;", "Lokhttp3/OkHttpClient;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "apph5update_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class DownloadTask implements Runnable {
    private final DownloadEntity downloadEntity;
    private final Handler handler = new a(Looper.getMainLooper());
    private OkHttpClient mClient;
    private com.cloud.h5update.download.a mListener;

    public static final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Intrinsics.h(message, "msg");
            switch (message.what) {
                case 1:
                    com.cloud.h5update.download.a aVar = DownloadTask.this.mListener;
                    if (aVar != null) {
                        aVar.c(DownloadTask.this);
                        break;
                    }
                    break;
                case 2:
                    com.cloud.h5update.download.a aVar2 = DownloadTask.this.mListener;
                    if (aVar2 != null) {
                        aVar2.b(DownloadTask.this);
                        break;
                    }
                    break;
                case 3:
                    com.cloud.h5update.download.a aVar3 = DownloadTask.this.mListener;
                    if (aVar3 != null) {
                        aVar3.a(DownloadTask.this);
                        break;
                    }
                    break;
                case 4:
                    com.cloud.h5update.download.a aVar4 = DownloadTask.this.mListener;
                    if (aVar4 != null) {
                        aVar4.d(DownloadTask.this, 4);
                        break;
                    }
                    break;
                case 5:
                    com.cloud.h5update.download.a aVar5 = DownloadTask.this.mListener;
                    if (aVar5 != null) {
                        aVar5.d(DownloadTask.this, 5);
                        break;
                    }
                    break;
                case 6:
                    com.cloud.h5update.download.a aVar6 = DownloadTask.this.mListener;
                    if (aVar6 != null) {
                        aVar6.e(DownloadTask.this);
                        break;
                    }
                    break;
            }
        }
    }

    public DownloadTask(DownloadEntity downloadEntity) {
        this.downloadEntity = downloadEntity;
    }

    public final void cancel() {
        DownloadEntity downloadEntity = this.downloadEntity;
        if (downloadEntity != null) {
            downloadEntity.setTaskStatus(3);
        }
        l lVar = l.a;
        DownloadEntity downloadEntity2 = this.downloadEntity;
        lVar.c(downloadEntity2 != null ? downloadEntity2.getTaskId() : null);
        this.handler.sendEmptyMessage(3);
    }

    public final DownloadEntity getDownloadEntity() {
        return this.downloadEntity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        String fileName;
        String f;
        BufferedInputStream bufferedInputStream;
        int i = 3;
        int i2 = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                DownloadEntity downloadEntity = this.downloadEntity;
                if (TextUtils.isEmpty(downloadEntity != null ? downloadEntity.getFileName() : null)) {
                    l lVar = l.a;
                    DownloadEntity downloadEntity2 = this.downloadEntity;
                    String url = downloadEntity2 != null ? downloadEntity2.getUrl() : null;
                    Intrinsics.e(url);
                    fileName = lVar.k(url);
                } else {
                    DownloadEntity downloadEntity3 = this.downloadEntity;
                    fileName = downloadEntity3 != null ? downloadEntity3.getFileName() : null;
                    Intrinsics.e(fileName);
                }
                TH5Update.a aVar = TH5Update.c;
                if (aVar.g()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(aVar.f());
                    sb.append(File.separator);
                    DownloadEntity downloadEntity4 = this.downloadEntity;
                    sb.append(downloadEntity4 != null ? downloadEntity4.getTitle() : null);
                    f = sb.toString();
                } else {
                    f = aVar.f();
                }
                if (!TextUtils.isEmpty(this.downloadEntity.getFilePath())) {
                    f = this.downloadEntity.getFilePath();
                    Intrinsics.e(f);
                }
                this.downloadEntity.setFileName(fileName);
                this.downloadEntity.setFilePath(f);
                File file = new File(f);
                if (!file.exists()) {
                    file.mkdirs();
                }
                l lVar2 = l.a;
                DownloadEntity h = lVar2.h(this.downloadEntity.getTaskId());
                File file2 = new File(f, fileName);
                if (h == null && file2.exists() && !file2.delete()) {
                    b.a.b("failed to delete file:" + file2.getAbsolutePath());
                }
                randomAccessFile = new RandomAccessFile(file2, "rwd");
                try {
                    try {
                        this.downloadEntity.setTaskStatus(1);
                        this.handler.sendEmptyMessage(1);
                        if (h != null) {
                            lVar2.t(this.downloadEntity.getTaskId(), this.downloadEntity);
                        }
                        long completedSize = this.downloadEntity.getCompletedSize();
                        try {
                            String url2 = this.downloadEntity.getUrl();
                            if (url2 != null && !StringsKt.q0(url2)) {
                                Request.Builder builder = new Request.Builder();
                                String url3 = this.downloadEntity.getUrl();
                                Intrinsics.e(url3);
                                Request build = builder.url(url3).header("RANGE", "bytes=" + completedSize + '-').build();
                                Intrinsics.g(build, "Builder().url(downloadEn…=$completeSize-\").build()");
                                if (randomAccessFile.length() == 0) {
                                    completedSize = 0;
                                }
                                randomAccessFile.seek(completedSize);
                                OkHttpClient okHttpClient = this.mClient;
                                Intrinsics.e(okHttpClient);
                                Response execute = FirebasePerfOkHttpClient.execute(okHttpClient.newCall(build));
                                if (execute.isSuccessful()) {
                                    ResponseBody body = execute.body();
                                    if (body != null) {
                                        if (lVar2.h(this.downloadEntity.getTaskId()) == null) {
                                            lVar2.t(this.downloadEntity.getTaskId(), this.downloadEntity);
                                            this.downloadEntity.setTotalSize(body.contentLength());
                                        }
                                        this.downloadEntity.setTaskStatus(2);
                                        double totalSize = this.downloadEntity.getTotalSize() / 100;
                                        inputStream = body.byteStream();
                                        try {
                                            bufferedInputStream = new BufferedInputStream(inputStream);
                                        } catch (FileNotFoundException unused) {
                                        } catch (ConnectException unused2) {
                                        } catch (SocketTimeoutException unused3) {
                                        } catch (IOException e) {
                                            e = e;
                                        }
                                        try {
                                            byte[] bArr = new byte[1024];
                                            int i3 = 0;
                                            while (true) {
                                                int read = bufferedInputStream.read(bArr);
                                                Unit unit = Unit.a;
                                                if (read <= 0 || this.downloadEntity.getTaskStatus() == i) {
                                                    break;
                                                }
                                                randomAccessFile.write(bArr, i2, read);
                                                completedSize += read;
                                                i3 += read;
                                                this.downloadEntity.setCompletedSize(completedSize);
                                                if (i3 >= totalSize) {
                                                    l.a.t(this.downloadEntity.getTaskId(), this.downloadEntity);
                                                    this.handler.sendEmptyMessage(2);
                                                    i3 = 0;
                                                }
                                                if (completedSize == this.downloadEntity.getTotalSize()) {
                                                    this.handler.sendEmptyMessage(2);
                                                    this.downloadEntity.setTaskStatus(6);
                                                    this.handler.sendEmptyMessage(6);
                                                    l.a.t(this.downloadEntity.getTaskId(), this.downloadEntity);
                                                }
                                                i = 3;
                                                i2 = 0;
                                            }
                                            bufferedInputStream2 = bufferedInputStream;
                                            h.a.e(bufferedInputStream2, inputStream, randomAccessFile);
                                            return;
                                        } catch (FileNotFoundException unused4) {
                                            bufferedInputStream2 = bufferedInputStream;
                                            DownloadEntity downloadEntity5 = this.downloadEntity;
                                            if (downloadEntity5 != null) {
                                                downloadEntity5.setTaskStatus(5);
                                            }
                                            this.handler.sendEmptyMessage(5);
                                            h.a.e(bufferedInputStream2, inputStream, randomAccessFile);
                                            return;
                                        } catch (ConnectException unused5) {
                                            bufferedInputStream2 = bufferedInputStream;
                                            DownloadEntity downloadEntity6 = this.downloadEntity;
                                            if (downloadEntity6 != null) {
                                                downloadEntity6.setTaskStatus(4);
                                            }
                                            this.handler.sendEmptyMessage(4);
                                            h.a.e(bufferedInputStream2, inputStream, randomAccessFile);
                                            return;
                                        } catch (SocketTimeoutException unused6) {
                                            bufferedInputStream2 = bufferedInputStream;
                                            DownloadEntity downloadEntity7 = this.downloadEntity;
                                            if (downloadEntity7 != null) {
                                                downloadEntity7.setTaskStatus(4);
                                            }
                                            this.handler.sendEmptyMessage(4);
                                            h.a.e(bufferedInputStream2, inputStream, randomAccessFile);
                                            return;
                                        } catch (IOException e2) {
                                            e = e2;
                                            bufferedInputStream2 = bufferedInputStream;
                                            e.printStackTrace();
                                            h.a.e(bufferedInputStream2, inputStream, randomAccessFile);
                                            return;
                                        } catch (Throwable th) {
                                            th = th;
                                            bufferedInputStream2 = bufferedInputStream;
                                            h.a.e(bufferedInputStream2, inputStream, randomAccessFile);
                                            throw th;
                                        }
                                    }
                                } else {
                                    this.downloadEntity.setTaskStatus(4);
                                    this.handler.sendEmptyMessage(4);
                                }
                                inputStream = null;
                                h.a.e(bufferedInputStream2, inputStream, randomAccessFile);
                                return;
                            }
                            h.a.e(null, null, randomAccessFile);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            this.downloadEntity.setTaskStatus(4);
                            this.handler.sendEmptyMessage(4);
                            Intrinsics.e(e3.getMessage());
                            h.a.e(null, null, randomAccessFile);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                } catch (FileNotFoundException unused7) {
                    inputStream = null;
                } catch (ConnectException unused8) {
                    inputStream = null;
                } catch (SocketTimeoutException unused9) {
                    inputStream = null;
                } catch (IOException e4) {
                    e = e4;
                    inputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException unused10) {
            randomAccessFile = null;
            inputStream = null;
        } catch (ConnectException unused11) {
            randomAccessFile = null;
            inputStream = null;
        } catch (SocketTimeoutException unused12) {
            randomAccessFile = null;
            inputStream = null;
        } catch (IOException e8) {
            e = e8;
            randomAccessFile = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            inputStream = null;
        }
    }

    public final void setClient(OkHttpClient mClient) {
        this.mClient = mClient;
    }

    public final void setListener(com.cloud.h5update.download.a listener) {
        this.mListener = listener;
    }
}
