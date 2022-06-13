package ru.netology.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0001\u001aJ\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\'J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0015\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\u0016\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lru/netology/dao/PostDao;", "", "count", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Landroidx/paging/PagingSource;", "Lru/netology/entity/PostEntity;", "getPostById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "posts", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "(Lru/netology/entity/PostEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEmpty", "", "likeById", "removeAll", "removeById", "showOrNot", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Converters", "app_debug"})
public abstract interface PostDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM PostEntity WHERE showOrNot = 1  ORDER BY id DESC")
    public abstract androidx.paging.PagingSource<java.lang.Integer, ru.netology.entity.PostEntity> getAll();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COUNT(*) FROM PostEntity WHERE showOrNot = 0")
    public abstract java.lang.Object count(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE PostEntity Set showOrNot = :showOrNot WHERE showOrNot is not :showOrNot")
    public abstract java.lang.Object showOrNot(boolean showOrNot, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM PostEntity WHERE id = :id")
    public abstract java.lang.Object getPostById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.netology.entity.PostEntity> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COUNT(*) == 0 FROM PostEntity")
    public abstract java.lang.Object isEmpty(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    ru.netology.entity.PostEntity post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    java.util.List<ru.netology.entity.PostEntity> posts, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM PostEntity WHERE id = :id")
    public abstract java.lang.Object removeById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "\n        UPDATE PostEntity SET\n        likes = likes + CASE WHEN likedByMe THEN -1 ELSE 1 END,\n        likedByMe = CASE WHEN likedByMe THEN 0 ELSE 1 END\n        WHERE id = :id\n        ")
    public abstract java.lang.Object likeById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM PostEntity")
    public abstract java.lang.Object removeAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\b"}, d2 = {"Lru/netology/dao/PostDao$Converters;", "", "()V", "fromAttachmentType", "", "value", "Lru/netology/nmedia/enumeration/AttachmentType;", "toAttachmentType", "app_debug"})
    public static final class Converters {
        
        public Converters() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @androidx.room.TypeConverter()
        public final ru.netology.nmedia.enumeration.AttachmentType toAttachmentType(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @androidx.room.TypeConverter()
        public final java.lang.String fromAttachmentType(@org.jetbrains.annotations.NotNull()
        ru.netology.nmedia.enumeration.AttachmentType value) {
            return null;
        }
    }
}