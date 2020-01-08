package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.entities.User;

import java.util.List;

@Dao
public abstract class UserDao implements BaseDao<User> {

    @Query("SELECT * FROM utilizatori")
    public abstract LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM utilizatori ORDER BY nume_utilizator ASC")
    public abstract LiveData<List<User>> getUsersSortedByUsernameAsc();

    @Query("SELECT * FROM utilizatori ORDER BY nume_utilizator DESC")
    public abstract LiveData<List<User>> getUsersSortedByUsernameDesc();

    @Query("SELECT * FROM utilizatori ORDER BY nume||' '||prenume ASC")
    public abstract LiveData<List<User>> getUsersSortedByFullNameAsc();

    @Query("SELECT * FROM utilizatori ORDER BY nume||' '||prenume DESC")
    public abstract LiveData<List<User>> getUsersSortedByFullNameDesc();

    @Query("SELECT * FROM utilizatori ORDER BY adresa_email ASC")
    public abstract LiveData<List<User>> getUsersSortedByEmailAsc();

    @Query("SELECT * FROM utilizatori ORDER BY adresa_email DESC")
    public abstract LiveData<List<User>> getUsersSortedByEmailDesc();

    @Query("SELECT * FROM utilizatori WHERE LOWER(nume_utilizator) LIKE LOWER(:username)")
    public abstract LiveData<User> getUserByUsername(@NonNull String username);

    @Query("DELETE FROM utilizatori WHERE nume_utilizator = :username")
    public abstract void deleteUserByUsername(String username);

    @Query("SELECT * " +
            "FROM utilizatori " +
            "WHERE LOWER(nume_utilizator) = LOWER(:userId) " +
            "AND (nume_utilizator IN(SELECT id_coach FROM probleme)\n" +
            "OR nume_utilizator IN(SELECT id_client FROM probleme));")
    public abstract LiveData<User> getUserThatHasProblems(@NonNull String userId);

    @Query("SELECT nume_utilizator " +
            "FROM utilizatori " +
            "WHERE LOWER(id_rol) LIKE LOWER(:roleId)")
    public abstract LiveData<List<String>> getUsernamesByRole(String roleId);

    public LiveData<List<String>> getAllCoachUsernames() {
        return getUsernamesByRole("coach");
    }

    public LiveData<List<String>> getAllClientUsernames() {
        return getUsernamesByRole("client");
    }

    @Query("SELECT utilizatori.* " +
            "FROM utilizatori " +
            "JOIN probleme ON(utilizatori.nume_utilizator = probleme.id_client)" +
            "JOIN sedinte ON(probleme.id_problema = sedinte.id_problema)" +
            "WHERE id_feedback = :feedbackId")
    public abstract LiveData<User> getUserWithFeedbackId(Long feedbackId);
}
