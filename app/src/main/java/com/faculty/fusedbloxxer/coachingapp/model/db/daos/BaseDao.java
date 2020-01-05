package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

@Dao
public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(T... objects);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(T... objects);

    @Delete
    void delete(T... objects);
}
