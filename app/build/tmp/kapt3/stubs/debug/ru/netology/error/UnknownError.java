package ru.netology.error;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/netology/error/UnknownError;", "Lru/netology/error/AppError;", "()V", "app_debug"})
public final class UnknownError extends ru.netology.error.AppError {
    @org.jetbrains.annotations.NotNull
    public static final ru.netology.error.UnknownError INSTANCE = null;
    
    private UnknownError() {
        super(null);
    }
}