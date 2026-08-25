package yf;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b implements b8.b {
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        sb.append("Thread: name: ");
        sb.append(thread != null ? thread.getName() : null);
        sb.append(" , threadId: ");
        sb.append(thread != null ? Long.valueOf(thread.getId()) : null);
        return sb.toString();
    }
}
