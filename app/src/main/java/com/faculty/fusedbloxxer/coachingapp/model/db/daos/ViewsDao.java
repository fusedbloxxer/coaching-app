package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.views.SpecialTask;
import com.faculty.fusedbloxxer.coachingapp.model.db.views.UserWithRole;

import java.util.List;

@Dao
public interface ViewsDao {
//    @Query("SELECT * FROM UserWithRole")
//    LiveData<List<UserWithRole>> getUsersWithRoles();
//
//    @Query("SELECT * FROM SpecialTask")
//    LiveData<List<SpecialTask>> getSpecialTasks();
}
