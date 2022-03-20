package ru.netology.Activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lru/netology/Activity/AppActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "firebaseInstanceId", "Lcom/google/firebase/iid/FirebaseInstanceId;", "getFirebaseInstanceId", "()Lcom/google/firebase/iid/FirebaseInstanceId;", "setFirebaseInstanceId", "(Lcom/google/firebase/iid/FirebaseInstanceId;)V", "googleApiAvailability", "Lcom/google/android/gms/common/GoogleApiAvailability;", "getGoogleApiAvailability", "()Lcom/google/android/gms/common/GoogleApiAvailability;", "setGoogleApiAvailability", "(Lcom/google/android/gms/common/GoogleApiAvailability;)V", "viewModel", "Lru/netology/viewModel/AuthViewModel;", "getViewModel", "()Lru/netology/viewModel/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkGoogleApiAvailability", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class AppActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject()
    public com.google.android.gms.common.GoogleApiAvailability googleApiAvailability;
    @javax.inject.Inject()
    public com.google.firebase.iid.FirebaseInstanceId firebaseInstanceId;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public AppActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.common.GoogleApiAvailability getGoogleApiAvailability() {
        return null;
    }
    
    public final void setGoogleApiAvailability(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.GoogleApiAvailability p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.iid.FirebaseInstanceId getFirebaseInstanceId() {
        return null;
    }
    
    public final void setFirebaseInstanceId(@org.jetbrains.annotations.NotNull()
    com.google.firebase.iid.FirebaseInstanceId p0) {
    }
    
    private final ru.netology.viewModel.AuthViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkGoogleApiAvailability() {
    }
}