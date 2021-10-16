package ru.netology.nmedia.db;

import java.lang.System;

@androidx.room.TypeConverters(value = {ru.netology.dao.PostDao.Converters.class})
@androidx.room.Database(entities = {ru.netology.entity.PostEntity.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lru/netology/nmedia/db/AppDb;", "Landroidx/room/RoomDatabase;", "()V", "postDao", "Lru/netology/dao/PostDao;", "Companion", "app_debug"})
public abstract class AppDb extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final ru.netology.nmedia.db.AppDb.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile ru.netology.nmedia.db.AppDb instance;
    
    public AppDb() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.netology.dao.PostDao postDao();
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lru/netology/nmedia/db/AppDb$Companion;", "", "()V", "instance", "Lru/netology/nmedia/db/AppDb;", "buildDatabase", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ru.netology.nmedia.db.AppDb getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final ru.netology.nmedia.db.AppDb buildDatabase(android.content.Context context) {
            return null;
        }
    }
}