package ru.netology.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0016H\u0003J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lru/netology/service/FCMService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "action", "", "appAuth", "Lru/netology/nmedia/auth/AppAuth;", "getAppAuth", "()Lru/netology/nmedia/auth/AppAuth;", "setAppAuth", "(Lru/netology/nmedia/auth/AppAuth;)V", "channelId", "content", "gson", "Lcom/google/gson/Gson;", "handleContent", "", "message", "Lru/netology/service/PushMessage;", "handleLike", "Lru/netology/service/Like;", "handleNewPost", "Lru/netology/service/NewPost;", "onCreate", "onMessageReceived", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class FCMService extends com.google.firebase.messaging.FirebaseMessagingService {
    @javax.inject.Inject
    public ru.netology.nmedia.auth.AppAuth appAuth;
    private final java.lang.String action = "action";
    private final java.lang.String content = "content";
    private final java.lang.String channelId = "remote";
    private final com.google.gson.Gson gson = null;
    
    public FCMService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final ru.netology.nmedia.auth.AppAuth getAppAuth() {
        return null;
    }
    
    public final void setAppAuth(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.auth.AppAuth p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull
    com.google.firebase.messaging.RemoteMessage message) {
    }
    
    private final void handleContent(ru.netology.service.PushMessage message) {
    }
    
    @java.lang.Override
    public void onNewToken(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    private final void handleLike(ru.netology.service.Like content) {
    }
    
    @android.annotation.SuppressLint(value = {"StringFormatInvalid"})
    private final void handleNewPost(ru.netology.service.NewPost content) {
    }
}