package ru.netology.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\t\u0010\'\u001a\u00020\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u000bH\u00c6\u0003J\t\u0010.\u001a\u00020\rH\u00c6\u0003J\t\u0010/\u001a\u00020\u000bH\u00c6\u0003Jy\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u00c6\u0001J\u0013\u00101\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\rH\u00d6\u0001J\t\u00104\u001a\u00020\u0006H\u00d6\u0001R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001f\u00a8\u00065"}, d2 = {"Lru/netology/dto/Post;", "", "id", "", "authorId", "author", "", "authorAvatar", "content", "published", "likedByMe", "", "likes", "", "showOrNot", "attachment", "Lru/netology/dto/Attachment;", "ownedByMe", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZIZLru/netology/dto/Attachment;Z)V", "getAttachment", "()Lru/netology/dto/Attachment;", "setAttachment", "(Lru/netology/dto/Attachment;)V", "getAuthor", "()Ljava/lang/String;", "getAuthorAvatar", "getAuthorId", "()J", "getContent", "getId", "getLikedByMe", "()Z", "getLikes", "()I", "getOwnedByMe", "getPublished", "getShowOrNot", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Post {
    private final long id = 0L;
    private final long authorId = 0L;
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
    private ru.netology.dto.Attachment attachment;
    private final boolean ownedByMe = false;
    
    @org.jetbrains.annotations.NotNull()
    public final ru.netology.dto.Post copy(long id, long authorId, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String authorAvatar, @org.jetbrains.annotations.NotNull()
    java.lang.String content, long published, boolean likedByMe, int likes, boolean showOrNot, @org.jetbrains.annotations.Nullable()
    ru.netology.dto.Attachment attachment, boolean ownedByMe) {
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
    
    public Post(long id, long authorId, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String authorAvatar, @org.jetbrains.annotations.NotNull()
    java.lang.String content, long published, boolean likedByMe, int likes, boolean showOrNot, @org.jetbrains.annotations.Nullable()
    ru.netology.dto.Attachment attachment, boolean ownedByMe) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getAuthorId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthorAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final long getPublished() {
        return 0L;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getLikedByMe() {
        return false;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getLikes() {
        return 0;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getShowOrNot() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.netology.dto.Attachment component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.netology.dto.Attachment getAttachment() {
        return null;
    }
    
    public final void setAttachment(@org.jetbrains.annotations.Nullable()
    ru.netology.dto.Attachment p0) {
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getOwnedByMe() {
        return false;
    }
}