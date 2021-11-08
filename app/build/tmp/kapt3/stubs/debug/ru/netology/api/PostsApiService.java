package ru.netology.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J+\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lru/netology/api/PostsApiService;", "", "dislikeById", "Lretrofit2/Response;", "Lru/netology/dto/Post;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getById", "getNewer", "likeById", "registerUser", "Lru/netology/dto/AuthUser;", "login", "", "pass", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeById", "", "save", "post", "(Lru/netology/dto/Post;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upload", "Lru/netology/dto/Media;", "media", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PostsApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "posts")
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<ru.netology.dto.Post>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "posts/{id}/newer")
    public abstract java.lang.Object getNewer(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<ru.netology.dto.Post>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "posts/{id}")
    public abstract java.lang.Object getById(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.netology.dto.Post>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "posts")
    public abstract java.lang.Object save(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.netology.dto.Post post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.netology.dto.Post>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.DELETE(value = "posts/{id}")
    public abstract java.lang.Object removeById(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "posts/{id}/likes")
    public abstract java.lang.Object likeById(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.netology.dto.Post>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.DELETE(value = "posts/{id}/likes")
    public abstract java.lang.Object dislikeById(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.netology.dto.Post>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "media")
    @retrofit2.http.Multipart()
    public abstract java.lang.Object upload(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part media, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.netology.dto.Media>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "users/authentication")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "login")
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "pass")
    java.lang.String pass, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.netology.dto.AuthUser>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "users/registration")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object registerUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "login")
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "pass")
    java.lang.String pass, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "name")
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.netology.dto.AuthUser>> continuation);
}