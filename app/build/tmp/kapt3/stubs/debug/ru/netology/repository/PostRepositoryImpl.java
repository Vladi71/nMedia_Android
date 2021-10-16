package ru.netology.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0019\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010\u0015\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u001b\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lru/netology/repository/PostRepositoryImpl;", "Lru/netology/repository/PostRepository;", "dao", "Lru/netology/dao/PostDao;", "(Lru/netology/dao/PostDao;)V", "data", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/netology/dto/Post;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "getAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNewerCount", "", "id", "", "getPostById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "likeById", "markPostToShow", "removeById", "save", "post", "(Lru/netology/dto/Post;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveWithAttachment", "upload", "Lru/netology/dto/MediaUpload;", "(Lru/netology/dto/Post;Lru/netology/dto/MediaUpload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unLikeById", "Lru/netology/dto/Media;", "(Lru/netology/dto/MediaUpload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PostRepositoryImpl implements ru.netology.repository.PostRepository {
    private final ru.netology.dao.PostDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<ru.netology.dto.Post>> data = null;
    
    public PostRepositoryImpl(@org.jetbrains.annotations.NotNull()
    ru.netology.dao.PostDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<ru.netology.dto.Post>> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.lang.Integer> getNewerCount(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object markPostToShow(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPostById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.netology.dto.Post> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object save(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object removeById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object likeById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object unLikeById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object saveWithAttachment(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post, @org.jetbrains.annotations.NotNull()
    ru.netology.dto.MediaUpload upload, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object upload(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.MediaUpload upload, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.netology.dto.Media> continuation) {
        return null;
    }
}