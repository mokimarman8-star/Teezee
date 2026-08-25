package vl;

import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.FileOperateStatus;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.task.compare.CompareRequest;
import com.transsion.lib_web.download_render.task.compare.CompareResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pl.h;
import ul.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements ul.b {
    private final String a = "DR_VersionSameCompareStep";

    @Override // ul.b
    public CompareResponse a(CompareRequest compareRequest, b.a aVar) {
        Intrinsics.h(compareRequest, "request");
        Intrinsics.h(aVar, "chain");
        PageData localPageData = compareRequest.getLocalPageData();
        PageData remotePageData = compareRequest.getRemotePageData();
        if (!Intrinsics.c(localPageData.getVersionCode(), remotePageData.getVersionCode())) {
            return aVar.a(compareRequest);
        }
        h hVar = h.a;
        hVar.a(b(), "<VersionSameCompareStep> load start");
        if (Intrinsics.c(localPageData.getDownloadStatus(), Boolean.TRUE)) {
            hVar.a(b(), "<VersionSameCompareStep> load end (no change)");
            return new CompareResponse(CollectionsKt.l(), CollectionsKt.l(), CollectionsKt.l(), 0L);
        }
        Map<String, FileData> localFileMap = localPageData.getLocalFileMap();
        List<FileData> files = remotePageData.getFiles();
        if (files == null) {
            files = CollectionsKt.l();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        long j = 0;
        for (FileData fileData : files) {
            Long size = fileData.getSize();
            j += size != null ? size.longValue() : 0L;
            FileData fileData2 = localFileMap.get(fileData.getFileUrl());
            if (fileData2 == null) {
                FileData c = c(fileData);
                String fileUrl = fileData.getFileUrl();
                if (fileUrl != null) {
                    if (c == null) {
                        fileData.setFileOperateStatus$lib_web_release(FileOperateStatus.DOWNLOAD);
                        linkedHashMap3.put(fileUrl, fileData);
                    } else {
                        linkedHashMap2.put(fileUrl, c);
                    }
                }
            } else if (Intrinsics.c(fileData2.getMd5(), fileData.getMd5())) {
                String fileUrl2 = fileData2.getFileUrl();
                if (fileUrl2 != null) {
                    linkedHashMap4.put(fileUrl2, fileData2);
                }
            } else {
                String fileUrl3 = fileData2.getFileUrl();
                if (fileUrl3 != null) {
                    fileData2.setFileOperateStatus$lib_web_release(FileOperateStatus.DELETE);
                    linkedHashMap.put(fileUrl3, fileData2);
                }
                FileData c2 = c(fileData);
                String fileUrl4 = fileData.getFileUrl();
                if (fileUrl4 != null) {
                    if (c2 == null) {
                        fileData.setFileOperateStatus$lib_web_release(FileOperateStatus.DOWNLOAD);
                        linkedHashMap3.put(fileUrl4, fileData);
                    } else {
                        linkedHashMap2.put(fileUrl4, c2);
                    }
                }
            }
        }
        for (Map.Entry<String, FileData> entry : localFileMap.entrySet()) {
            if (!linkedHashMap4.containsKey(entry.getKey())) {
                String key = entry.getKey();
                FileData value = entry.getValue();
                value.setFileOperateStatus$lib_web_release(FileOperateStatus.DELETE);
                linkedHashMap.put(key, value);
            }
        }
        h.a.a(b(), "<VersionSameCompareStep> load end");
        return new CompareResponse(CollectionsKt.R0(linkedHashMap.values()), CollectionsKt.R0(linkedHashMap2.values()), CollectionsKt.R0(linkedHashMap3.values()), j);
    }

    public String b() {
        return this.a;
    }

    public FileData c(FileData fileData) {
        return b.C0096b.a(this, fileData);
    }
}
