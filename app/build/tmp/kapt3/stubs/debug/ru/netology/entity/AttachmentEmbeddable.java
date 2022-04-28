package ru.netology.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lru/netology/entity/AttachmentEmbeddable;", "", "url", "", "type", "Lru/netology/nmedia/enumeration/AttachmentType;", "(Ljava/lang/String;Lru/netology/nmedia/enumeration/AttachmentType;)V", "getType", "()Lru/netology/nmedia/enumeration/AttachmentType;", "setType", "(Lru/netology/nmedia/enumeration/AttachmentType;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toDto", "Lru/netology/dto/Attachment;", "toString", "Companion", "app_debug"})
public final class AttachmentEmbeddable {
    @org.jetbrains.annotations.NotNull
    private java.lang.String url;
    @org.jetbrains.annotations.NotNull
    private ru.netology.nmedia.enumeration.AttachmentType type;
    @org.jetbrains.annotations.NotNull
    public static final ru.netology.entity.AttachmentEmbeddable.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final ru.netology.entity.AttachmentEmbeddable copy(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    ru.netology.nmedia.enumeration.AttachmentType type) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public AttachmentEmbeddable(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    ru.netology.nmedia.enumeration.AttachmentType type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final ru.netology.nmedia.enumeration.AttachmentType component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final ru.netology.nmedia.enumeration.AttachmentType getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.enumeration.AttachmentType p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final ru.netology.dto.Attachment toDto() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lru/netology/entity/AttachmentEmbeddable$Companion;", "", "()V", "fromDto", "Lru/netology/entity/AttachmentEmbeddable;", "dto", "Lru/netology/dto/Attachment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final ru.netology.entity.AttachmentEmbeddable fromDto(@org.jetbrains.annotations.Nullable
        ru.netology.dto.Attachment dto) {
            return null;
        }
    }
}