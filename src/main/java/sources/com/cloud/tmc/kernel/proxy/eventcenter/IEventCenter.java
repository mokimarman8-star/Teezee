package com.cloud.tmc.kernel.proxy.eventcenter;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IEventCenter {
    boolean containsEventKey(String str);

    void destroy();

    void postEvent(String str, IEvent iEvent);

    void register(String str, IEventSubscriber iEventSubscriber);

    void unregister(String str);

    void unregister(String str, IEventSubscriber iEventSubscriber);
}
