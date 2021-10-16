package ru.netology.entity;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\nH\u00c6\u0003J\t\u0010\'\u001a\u00020\fH\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003Je\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\fH\u00d6\u0001J\u0006\u0010.\u001a\u00020/J\t\u00100\u001a\u00020\u0005H\u00d6\u0001R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001c\u00a8\u00062"}, d2 = {"Lru/netology/entity/PostEntity;", "", "id", "", "author", "", "authorAvatar", "content", "published", "likedByMe", "", "likes", "", "showOrNot", "attachment", "Lru/netology/entity/AttachmentEmbeddable;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZIZLru/netology/entity/AttachmentEmbeddable;)V", "getAttachment", "()Lru/netology/entity/AttachmentEmbeddable;", "setAttachment", "(Lru/netology/entity/AttachmentEmbeddable;)V", "getAuthor", "()Ljava/lang/String;", "getAuthorAvatar", "getContent", "getId", "()J", "getLikedByMe", "()Z", "getLikes", "()I", "getPublished", "getShowOrNot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toDto", "Lru/netology/dto/Post;", "toString", "Companion", "app_debug"})
public final class PostEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String author = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String authorAvatar = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    private final long published = 0L;
    private final boolean likedByMe = false;
    private final int likes = 0;
    private final boolean showOrNot = false;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Embedded()
    private ru.netology.entity.AttachmentEmbeddable attachment;
    @org.jetbrains.annotations.NotNull()
    public static final ru.netology.entity.PostEntity.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ru.netology.entity.PostEntity copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String authorAvatar, @org.jetbrains.annotations.NotNull()
    java.lang.String content, long published, boolean likedByMe, int likes, boolean showOrNot, @org.jetbrains.annotations.Nullable()
    ru.netology.entity.AttachmentEmbeddable attachment) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public PostEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String authorAvatar, @org.jetbrains.annotations.NotNull()
    java.lang.String content, long published, boolean likedByMe, int likes, boolean showOrNot, @org.jetbrains.annotations.Nullable()
    ru.netology.entity.AttachmentEmbeddable attachment) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getPublished() {
        return 0L;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getLikedByMe() {
        return false;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getLikes() {
        return 0;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getShowOrNot() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.netology.entity.AttachmentEmbeddable component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.netology.entity.AttachmentEmbeddable getAttachment() {
        return null;
    }
    
    public final void setAttachment(@org.jetbrains.annotations.Nullable()
    ru.netology.entity.AttachmentEmbeddable p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.netology.dto.Post toDto() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lru/netology/entity/PostEntity$Companion;", "", "()V", "fromDto", "Lru/netology/entity/PostEntity;", "dto", "Lru/netology/dto/Post;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ru.netology.entity.PostEntity fromDto(@org.jetbrains.annotations.NotNull()
        ru.netology.dto.Post dto) {
            return null;
        }
    }
}