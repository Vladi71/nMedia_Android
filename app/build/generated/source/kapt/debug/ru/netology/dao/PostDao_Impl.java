package ru.netology.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.netology.entity.AttachmentEmbeddable;
import ru.netology.entity.PostEntity;
import ru.netology.nmedia.enumeration.AttachmentType;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PostDao_Impl implements PostDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PostEntity> __insertionAdapterOfPostEntity;

  private final PostDao.Converters __converters = new PostDao.Converters();

  private final SharedSQLiteStatement __preparedStmtOfShowOrNot;

  private final SharedSQLiteStatement __preparedStmtOfRemoveById;

  private final SharedSQLiteStatement __preparedStmtOfLikeById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAll;

  public PostDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPostEntity = new EntityInsertionAdapter<PostEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PostEntity` (`id`,`authorId`,`author`,`authorAvatar`,`content`,`published`,`likedByMe`,`likes`,`showOrNot`,`url`,`type`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PostEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getAuthorId());
        if (value.getAuthor() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuthor());
        }
        if (value.getAuthorAvatar() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAuthorAvatar());
        }
        if (value.getContent() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getContent());
        }
        stmt.bindLong(6, value.getPublished());
        final int _tmp;
        _tmp = value.getLikedByMe() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        stmt.bindLong(8, value.getLikes());
        final int _tmp_1;
        _tmp_1 = value.getShowOrNot() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
        final AttachmentEmbeddable _tmpAttachment = value.getAttachment();
        if(_tmpAttachment != null) {
          if (_tmpAttachment.getUrl() == null) {
            stmt.bindNull(10);
          } else {
            stmt.bindString(10, _tmpAttachment.getUrl());
          }
          final String _tmp_2;
          _tmp_2 = __converters.fromAttachmentType(_tmpAttachment.getType());
          if (_tmp_2 == null) {
            stmt.bindNull(11);
          } else {
            stmt.bindString(11, _tmp_2);
          }
        } else {
          stmt.bindNull(10);
          stmt.bindNull(11);
        }
      }
    };
    this.__preparedStmtOfShowOrNot = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE PostEntity Set showOrNot = ? WHERE showOrNot is not ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM PostEntity WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfLikeById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "\n"
                + "        UPDATE PostEntity SET\n"
                + "        likes = likes + CASE WHEN likedByMe THEN -1 ELSE 1 END,\n"
                + "        likedByMe = CASE WHEN likedByMe THEN 0 ELSE 1 END\n"
                + "        WHERE id = ?\n"
                + "        ";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM PostEntity";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final PostEntity post, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPostEntity.insert(post);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insert(final List<PostEntity> posts,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPostEntity.insert(posts);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object showOrNot(final boolean showOrNot, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfShowOrNot.acquire();
        int _argIndex = 1;
        final int _tmp;
        _tmp = showOrNot ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        final int _tmp_1;
        _tmp_1 = showOrNot ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfShowOrNot.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object removeById(final long id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfRemoveById.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object likeById(final long id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfLikeById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfLikeById.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object removeAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfRemoveAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public PagingSource<Integer, PostEntity> getAll() {
    final String _sql = "SELECT * FROM PostEntity WHERE showOrNot = 1  ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, PostEntity>() {
      @Override
      public LimitOffsetDataSource<PostEntity> create() {
        return new LimitOffsetDataSource<PostEntity>(__db, _statement, false, false , "PostEntity") {
          @Override
          protected List<PostEntity> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(cursor, "authorId");
            final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(cursor, "author");
            final int _cursorIndexOfAuthorAvatar = CursorUtil.getColumnIndexOrThrow(cursor, "authorAvatar");
            final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(cursor, "content");
            final int _cursorIndexOfPublished = CursorUtil.getColumnIndexOrThrow(cursor, "published");
            final int _cursorIndexOfLikedByMe = CursorUtil.getColumnIndexOrThrow(cursor, "likedByMe");
            final int _cursorIndexOfLikes = CursorUtil.getColumnIndexOrThrow(cursor, "likes");
            final int _cursorIndexOfShowOrNot = CursorUtil.getColumnIndexOrThrow(cursor, "showOrNot");
            final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(cursor, "url");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "type");
            final List<PostEntity> _res = new ArrayList<PostEntity>(cursor.getCount());
            while(cursor.moveToNext()) {
              final PostEntity _item;
              final long _tmpId;
              _tmpId = cursor.getLong(_cursorIndexOfId);
              final long _tmpAuthorId;
              _tmpAuthorId = cursor.getLong(_cursorIndexOfAuthorId);
              final String _tmpAuthor;
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _tmpAuthor = null;
              } else {
                _tmpAuthor = cursor.getString(_cursorIndexOfAuthor);
              }
              final String _tmpAuthorAvatar;
              if (cursor.isNull(_cursorIndexOfAuthorAvatar)) {
                _tmpAuthorAvatar = null;
              } else {
                _tmpAuthorAvatar = cursor.getString(_cursorIndexOfAuthorAvatar);
              }
              final String _tmpContent;
              if (cursor.isNull(_cursorIndexOfContent)) {
                _tmpContent = null;
              } else {
                _tmpContent = cursor.getString(_cursorIndexOfContent);
              }
              final long _tmpPublished;
              _tmpPublished = cursor.getLong(_cursorIndexOfPublished);
              final boolean _tmpLikedByMe;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfLikedByMe);
              _tmpLikedByMe = _tmp != 0;
              final int _tmpLikes;
              _tmpLikes = cursor.getInt(_cursorIndexOfLikes);
              final boolean _tmpShowOrNot;
              final int _tmp_1;
              _tmp_1 = cursor.getInt(_cursorIndexOfShowOrNot);
              _tmpShowOrNot = _tmp_1 != 0;
              final AttachmentEmbeddable _tmpAttachment;
              if (! (cursor.isNull(_cursorIndexOfUrl) && cursor.isNull(_cursorIndexOfType))) {
                final String _tmpUrl;
                if (cursor.isNull(_cursorIndexOfUrl)) {
                  _tmpUrl = null;
                } else {
                  _tmpUrl = cursor.getString(_cursorIndexOfUrl);
                }
                final AttachmentType _tmpType;
                final String _tmp_2;
                if (cursor.isNull(_cursorIndexOfType)) {
                  _tmp_2 = null;
                } else {
                  _tmp_2 = cursor.getString(_cursorIndexOfType);
                }
                _tmpType = __converters.toAttachmentType(_tmp_2);
                _tmpAttachment = new AttachmentEmbeddable(_tmpUrl,_tmpType);
              }  else  {
                _tmpAttachment = null;
              }
              _item = new PostEntity(_tmpId,_tmpAuthorId,_tmpAuthor,_tmpAuthorAvatar,_tmpContent,_tmpPublished,_tmpLikedByMe,_tmpLikes,_tmpShowOrNot,_tmpAttachment);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    }.asPagingSourceFactory().invoke();
  }

  @Override
  public Object count(final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COUNT(*) FROM PostEntity WHERE showOrNot = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getPostById(final long id, final Continuation<? super PostEntity> continuation) {
    final String _sql = "SELECT * FROM PostEntity WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PostEntity>() {
      @Override
      public PostEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfAuthorAvatar = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatar");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfPublished = CursorUtil.getColumnIndexOrThrow(_cursor, "published");
          final int _cursorIndexOfLikedByMe = CursorUtil.getColumnIndexOrThrow(_cursor, "likedByMe");
          final int _cursorIndexOfLikes = CursorUtil.getColumnIndexOrThrow(_cursor, "likes");
          final int _cursorIndexOfShowOrNot = CursorUtil.getColumnIndexOrThrow(_cursor, "showOrNot");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final PostEntity _result;
          if(_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpAuthorId;
            _tmpAuthorId = _cursor.getLong(_cursorIndexOfAuthorId);
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpAuthorAvatar;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatar)) {
              _tmpAuthorAvatar = null;
            } else {
              _tmpAuthorAvatar = _cursor.getString(_cursorIndexOfAuthorAvatar);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final long _tmpPublished;
            _tmpPublished = _cursor.getLong(_cursorIndexOfPublished);
            final boolean _tmpLikedByMe;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfLikedByMe);
            _tmpLikedByMe = _tmp != 0;
            final int _tmpLikes;
            _tmpLikes = _cursor.getInt(_cursorIndexOfLikes);
            final boolean _tmpShowOrNot;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfShowOrNot);
            _tmpShowOrNot = _tmp_1 != 0;
            final AttachmentEmbeddable _tmpAttachment;
            if (! (_cursor.isNull(_cursorIndexOfUrl) && _cursor.isNull(_cursorIndexOfType))) {
              final String _tmpUrl;
              if (_cursor.isNull(_cursorIndexOfUrl)) {
                _tmpUrl = null;
              } else {
                _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
              }
              final AttachmentType _tmpType;
              final String _tmp_2;
              if (_cursor.isNull(_cursorIndexOfType)) {
                _tmp_2 = null;
              } else {
                _tmp_2 = _cursor.getString(_cursorIndexOfType);
              }
              _tmpType = __converters.toAttachmentType(_tmp_2);
              _tmpAttachment = new AttachmentEmbeddable(_tmpUrl,_tmpType);
            }  else  {
              _tmpAttachment = null;
            }
            _result = new PostEntity(_tmpId,_tmpAuthorId,_tmpAuthor,_tmpAuthorAvatar,_tmpContent,_tmpPublished,_tmpLikedByMe,_tmpLikes,_tmpShowOrNot,_tmpAttachment);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object isEmpty(final Continuation<? super Boolean> continuation) {
    final String _sql = "SELECT COUNT(*) == 0 FROM PostEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Boolean>() {
      @Override
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp == null ? null : _tmp != 0;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
