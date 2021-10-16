package ru.netology.error;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lru/netology/error/ApiError;", "Lru/netology/error/AppError;", "status", "", "code", "", "(ILjava/lang/String;)V", "getStatus", "()I", "app_debug"})
public final class ApiError extends ru.netology.error.AppError {
    private final int status = 0;
    
    public ApiError(int status, @org.jetbrains.annotations.NotNull()
    java.lang.String code) {
        super(null);
    }
    
    public final int getStatus() {
        return 0;
    }
}