package z1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final List f18845a;

    /* renamed from: b, reason: collision with root package name */
    private final List f18846b;

    /* renamed from: c, reason: collision with root package name */
    private final List f18847c;

    private n(List list, List list2, List list3) {
        this.f18845a = list;
        this.f18846b = list2;
        this.f18847c = list3;
    }

    public static n b(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        c(str, arrayList, arrayList2, arrayList3);
        return new n(arrayList, arrayList2, arrayList3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void c(String str, List list, List list2, List list3) {
        String str2;
        boolean z5;
        list.add("");
        int i5 = 0;
        while (i5 < str.length()) {
            int indexOf = str.indexOf("$", i5);
            if (indexOf == -1) {
                list.set(list2.size(), ((String) list.get(list2.size())) + str.substring(i5));
                i5 = str.length();
            } else if (indexOf != i5) {
                list.set(list2.size(), ((String) list.get(list2.size())) + str.substring(i5, indexOf));
                i5 = indexOf;
            } else if (str.startsWith("$$", i5)) {
                list.set(list2.size(), ((String) list.get(list2.size())) + "$");
                i5 += 2;
            } else {
                list3.add("");
                int i6 = i5 + 1;
                int indexOf2 = str.indexOf("$", i6);
                String substring = str.substring(i6, indexOf2);
                if (substring.equals("RepresentationID")) {
                    list2.add(1);
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x") && !str2.endsWith("X")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                z5 = false;
                                break;
                            }
                            z5 = -1;
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                z5 = true;
                                break;
                            }
                            z5 = -1;
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                z5 = 2;
                                break;
                            }
                            z5 = -1;
                            break;
                        default:
                            z5 = -1;
                            break;
                    }
                    switch (z5) {
                        case false:
                            list2.add(2);
                            break;
                        case true:
                            list2.add(4);
                            break;
                        case true:
                            list2.add(3);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    list3.set(list2.size() - 1, str2);
                }
                list.add("");
                i5 = indexOf2 + 1;
            }
        }
    }

    public String a(String str, long j5, int i5, long j6) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < this.f18846b.size(); i6++) {
            sb.append((String) this.f18845a.get(i6));
            if (((Integer) this.f18846b.get(i6)).intValue() == 1) {
                sb.append(str);
            } else if (((Integer) this.f18846b.get(i6)).intValue() == 2) {
                sb.append(String.format(Locale.US, (String) this.f18847c.get(i6), Long.valueOf(j5)));
            } else if (((Integer) this.f18846b.get(i6)).intValue() == 3) {
                sb.append(String.format(Locale.US, (String) this.f18847c.get(i6), Integer.valueOf(i5)));
            } else if (((Integer) this.f18846b.get(i6)).intValue() == 4) {
                sb.append(String.format(Locale.US, (String) this.f18847c.get(i6), Long.valueOf(j6)));
            }
        }
        sb.append((String) this.f18845a.get(this.f18846b.size()));
        return sb.toString();
    }
}
