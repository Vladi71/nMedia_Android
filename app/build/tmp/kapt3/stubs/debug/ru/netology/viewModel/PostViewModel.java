package ru.netology.viewModel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%J\u001a\u0010&\u001a\u00020\u000f2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*J\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0018J\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J\u000e\u00103\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0018J\u0006\u00104\u001a\u000201J\u000e\u00105\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/J\u0006\u00106\u001a\u00020\u000fJ\u000e\u00107\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00180\u00180\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lru/netology/viewModel/PostViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lru/netology/repository/PostRepository;", "appAuth", "Lru/netology/nmedia/auth/AppAuth;", "(Lru/netology/repository/PostRepository;Lru/netology/nmedia/auth/AppAuth;)V", "_dataState", "Landroidx/lifecycle/MutableLiveData;", "Lru/netology/model/FeedModelState;", "_photo", "Lru/netology/model/PhotoModel;", "kotlin.jvm.PlatformType", "_postCreated", "Lru/netology/SingleLiveEvent;", "", "data", "Landroidx/lifecycle/LiveData;", "Lru/netology/model/FeedModel;", "getData", "()Landroidx/lifecycle/LiveData;", "dataState", "getDataState", "edited", "Lru/netology/dto/Post;", "getEdited", "()Landroidx/lifecycle/MutableLiveData;", "newerCount", "", "getNewerCount", "photo", "getPhoto", "postCreated", "getPostCreated", "cancelChange", "changeContent", "content", "", "changePhoto", "uri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "edit", "post", "likeById", "id", "", "loadPosts", "Lkotlinx/coroutines/Job;", "makeReadPosts", "openPost", "refreshPosts", "removeById", "save", "unLikeById", "app_debug"})
public final class PostViewModel extends androidx.lifecycle.ViewModel {
    private final ru.netology.repository.PostRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<ru.netology.model.FeedModel> data = null;
    private final androidx.lifecycle.MutableLiveData<ru.netology.model.FeedModelState> _dataState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> newerCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<ru.netology.dto.Post> edited = null;
    private final ru.netology.SingleLiveEvent<kotlin.Unit> _postCreated = null;
    private final androidx.lifecycle.MutableLiveData<ru.netology.model.PhotoModel> _photo = null;
    
    @javax.inject.Inject()
    public PostViewModel(@org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository repository, @org.jetbrains.annotations.NotNull()
    ru.netology.nmedia.auth.AppAuth appAuth) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<ru.netology.model.FeedModel> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<ru.netology.model.FeedModelState> getDataState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getNewerCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<ru.netology.dto.Post> getEdited() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Unit> getPostCreated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<ru.netology.model.PhotoModel> getPhoto() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job refreshPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job makeReadPosts() {
        return null;
    }
    
    public final void save() {
    }
    
    public final void edit(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post) {
    }
    
    public final void changeContent(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void likeById(long id) {
    }
    
    public final void removeById(long id) {
    }
    
    public final void unLikeById(long id) {
    }
    
    public final void openPost(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post) {
    }
    
    public final void cancelChange() {
    }
    
    public final void changePhoto(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri, @org.jetbrains.annotations.Nullable()
    java.io.File file) {
    }
}