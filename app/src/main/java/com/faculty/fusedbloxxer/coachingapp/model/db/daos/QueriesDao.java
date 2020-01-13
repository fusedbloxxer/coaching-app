package com.faculty.fusedbloxxer.coachingapp.model.db.daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.faculty.fusedbloxxer.coachingapp.model.db.containers.CoachWithScores;

import java.util.List;

@Dao
public interface QueriesDao {
    @Query("SELECT nume_utilizator AS coachName, MAX(puncte_evaluare) AS maxScore, AVG(medie_puncte) AS avgScore\n" +
            "FROM utilizatori\n" +
            "LEFT JOIN probleme ON(utilizatori.nume_utilizator = probleme.id_coach)\n" +
            "LEFT JOIN sedinte ON(probleme.id_problema = sedinte.id_problema)\n" +
            "LEFT JOIN feedbacks ON(sedinte.id_sedinta = feedbacks.id_sedinta)\n" +
            "JOIN (SELECT nume_utilizator nume_coach, AVG(puncte_evaluare) AS medie_puncte\n" +
            "      FROM utilizatori\n" +
            "      LEFT JOIN probleme ON(utilizatori.nume_utilizator = probleme.id_coach)\n" +
            "      LEFT JOIN sedinte ON(probleme.id_problema = sedinte.id_problema)\n" +
            "      LEFT JOIN feedbacks ON(sedinte.id_sedinta = feedbacks.id_sedinta)\n" +
            "      WHERE LOWER(id_rol) LIKE '%coach%'\n" +
            "      GROUP BY nume_utilizator, probleme.id_problema) ON(utilizatori.nume_utilizator = nume_coach)\n" +
            "WHERE LOWER(id_rol) LIKE '%coach%'\n" +
            "GROUP BY nume_utilizator\n" +
            "HAVING IFNULL(AVG(medie_puncte), 0) >= :avgScore\n" +
            "AND IFNULL(MAX(puncte_evaluare), 0) >= :maxScore\n" +
            "ORDER BY IFNULL(AVG(medie_puncte), 0) DESC, IFNULL(MAX(medie_puncte), 0) DESC;")
    LiveData<List<CoachWithScores>> groupCoachesHaving(@NonNull Float avgScore, @NonNull Float maxScore);
}
