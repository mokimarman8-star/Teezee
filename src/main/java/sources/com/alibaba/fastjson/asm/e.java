package com.alibaba.fastjson.asm;

import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    int f14681a;

    /* renamed from: b, reason: collision with root package name */
    int f14682b;

    /* renamed from: c, reason: collision with root package name */
    int f14683c;

    /* renamed from: d, reason: collision with root package name */
    long f14684d;

    /* renamed from: e, reason: collision with root package name */
    String f14685e;

    /* renamed from: f, reason: collision with root package name */
    String f14686f;

    /* renamed from: g, reason: collision with root package name */
    String f14687g;

    /* renamed from: h, reason: collision with root package name */
    int f14688h;

    /* renamed from: i, reason: collision with root package name */
    e f14689i;

    e() {
    }

    e(int i5, e eVar) {
        this.f14681a = i5;
        this.f14682b = eVar.f14682b;
        this.f14683c = eVar.f14683c;
        this.f14684d = eVar.f14684d;
        this.f14685e = eVar.f14685e;
        this.f14686f = eVar.f14686f;
        this.f14687g = eVar.f14687g;
        this.f14688h = eVar.f14688h;
    }

    boolean a(e eVar) {
        int i5 = this.f14682b;
        if (i5 != 1) {
            if (i5 != 15) {
                if (i5 == 12) {
                    return eVar.f14685e.equals(this.f14685e) && eVar.f14686f.equals(this.f14686f);
                }
                if (i5 != 13) {
                    switch (i5) {
                        case 3:
                        case 4:
                            if (eVar.f14683c != this.f14683c) {
                                break;
                            }
                            break;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            if (!eVar.f14685e.equals(this.f14685e) || !eVar.f14686f.equals(this.f14686f) || !eVar.f14687g.equals(this.f14687g)) {
                                break;
                            }
                            break;
                    }
                    return false;
                }
            }
            return eVar.f14684d == this.f14684d;
        }
        return eVar.f14685e.equals(this.f14685e);
    }

    void b(int i5) {
        this.f14682b = 3;
        this.f14683c = i5;
        this.f14688h = (3 + i5) & DescriptorProtos$Edition.EDITION_MAX_VALUE;
    }

    void c(int i5, String str, String str2, String str3) {
        this.f14682b = i5;
        this.f14685e = str;
        this.f14686f = str2;
        this.f14687g = str3;
        if (i5 != 1 && i5 != 7 && i5 != 8) {
            if (i5 == 12) {
                this.f14688h = (i5 + (str.hashCode() * str2.hashCode())) & DescriptorProtos$Edition.EDITION_MAX_VALUE;
                return;
            } else if (i5 != 13) {
                this.f14688h = (i5 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & DescriptorProtos$Edition.EDITION_MAX_VALUE;
                return;
            }
        }
        this.f14688h = (i5 + str.hashCode()) & DescriptorProtos$Edition.EDITION_MAX_VALUE;
    }
}
