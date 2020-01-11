package com.faculty.fusedbloxxer.coachingapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.faculty.fusedbloxxer.coachingapp.model.db.database.PersonalDevelopmentDatabase;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Feedback;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Location;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Material;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Problem;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Role;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Session;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.User;

import java.util.List;

public class PersonalDevelopmentViewModel extends AndroidViewModel {
    private PersonalDevelopmentDatabase personalDevelopmentDatabase;

    public PersonalDevelopmentViewModel(@NonNull final Application application) {
        super(application);
        personalDevelopmentDatabase = PersonalDevelopmentDatabase.getDatabase(application);
    }

    public LiveData<List<Role>> getAllRoles() {
        return personalDevelopmentDatabase.roleDao().getAllRoles();
    }

    public LiveData<List<Role>> getRolesSortedAscById() {
        return personalDevelopmentDatabase.roleDao().getRolesSortedAscById();
    }

    public LiveData<List<Role>> getRolesSortedDescById() {
        return personalDevelopmentDatabase.roleDao().getRolesSortedDescById();
    }

    public LiveData<List<Role>> getRolesSortedAscByDescLen() {
        return personalDevelopmentDatabase.roleDao().getRolesSortedAscByDescLen();
    }

    public LiveData<List<Role>> getRolesSortedDescByDescLen() {
        return personalDevelopmentDatabase.roleDao().getRolesSortedDescByDescLen();
    }

    public LiveData<Role> getRoleById(@NonNull String roleId) {
        return personalDevelopmentDatabase.roleDao().getRoleById(roleId);
    }

    public void insertRoles(Role... roles) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.roleDao().insert(roles));
    }

    public void updateRoles(Role... roles) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.roleDao().update(roles));
    }

    public void deleteRoleById(String roleId) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.roleDao().deleteRoleById(roleId));
    }

    public LiveData<List<User>> getUsersSortedByUsernameAsc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByUsernameAsc();
    }

    public LiveData<List<User>> getUsersSortedByUsernameDesc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByUsernameDesc();
    }

    public LiveData<List<User>> getUsersSortedByFullNameAsc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByFullNameAsc();
    }

    public LiveData<List<User>> getUsersSortedByFullNameDesc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByFullNameDesc();
    }

    public LiveData<List<User>> getUsersSortedByEmailAsc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByEmailAsc();
    }

    public LiveData<List<User>> getUsersSortedByEmailDesc() {
        return personalDevelopmentDatabase.userDao().getUsersSortedByEmailDesc();
    }

    public LiveData<User> getUserByUsername(String username) {
        return personalDevelopmentDatabase.userDao().getUserByUsername(username);
    }

    public LiveData<User> getUserThatHasProblems(String username) {
        return personalDevelopmentDatabase.userDao().getUserThatHasProblems(username);
    }

    public LiveData<List<User>> getAllUsers() {
        return personalDevelopmentDatabase.userDao().getAllUsers();
    }

    public void deleteUserByUsername(String username) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.userDao().deleteUserByUsername(username));
    }

    public void updateUsers(User... users) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.userDao().update(users));
    }

    public void insertUsers(User... users) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.userDao().insert(users));
    }

    public LiveData<List<String>> getAllCoachUsernames() {
        return personalDevelopmentDatabase.userDao().getAllCoachUsernames();
    }

    public LiveData<List<String>> getAllClientUsernames() {
        return personalDevelopmentDatabase.userDao().getAllClientUsernames();
    }

    public LiveData<List<Problem>> getAllProblems() {
        return personalDevelopmentDatabase.problemDao().getAllProblems();
    }

    public LiveData<List<Problem>> getProblemsSortedByIdAsc() {
        return personalDevelopmentDatabase.problemDao().getProblemsSortedByIdAsc();
    }

    public LiveData<List<Problem>> getProblemsSortedByIdDesc() {
        return personalDevelopmentDatabase.problemDao().getProblemsSortedByIdDesc();
    }

    public LiveData<List<Problem>> getProblemsSortedByDescriptionAsc() {
        return personalDevelopmentDatabase.problemDao().getProblemsSortedByDescriptionAsc();
    }

    public LiveData<List<Problem>> getProblemsSortedByDescriptionDesc() {
        return personalDevelopmentDatabase.problemDao().getProblemsSortedByDescriptionDesc();
    }

    public LiveData<List<Problem>> getProblemsSortedByStateAsc() {
        return personalDevelopmentDatabase.problemDao().getProblemsSortedByStateAsc();
    }

    public LiveData<List<Problem>> getProblemsSortedByStateDesc() {
        return personalDevelopmentDatabase.problemDao().getProblemsSortedByStateDesc();
    }

    public LiveData<Problem> getProblemById(@NonNull Long problemId) {
        return personalDevelopmentDatabase.problemDao().getProblemById(problemId);
    }

    public void deleteProblemWithId(@NonNull Long problemId) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.problemDao().deleteProblemWithId(problemId));
    }

    public LiveData<List<Problem>> getProblemsSortedByTitleAsc() {
        return personalDevelopmentDatabase.problemDao().getProblemsSortedByTitleAsc();
    }

    public LiveData<List<Problem>> getProblemsSortedByTitleDesc() {
        return personalDevelopmentDatabase.problemDao().getProblemsSortedByTitleDesc();
    }

    public void updateProblems(Problem... problems) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.problemDao().update(problems));
    }

    public void insertProblems(Problem... problems) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.problemDao().insert(problems));
    }

    public LiveData<List<Location>> getAllLocations() {
        return personalDevelopmentDatabase.locationDao().getAllLocations();
    }

    public LiveData<List<Location>> getLocationsSortedByAliasAsc() {
        return personalDevelopmentDatabase.locationDao().getLocationsSortedByAliasAsc();
    }

    public LiveData<List<Location>> getLocationsSortedByAliasDesc() {
        return personalDevelopmentDatabase.locationDao().getLocationsSortedByAliasDesc();
    }

    public LiveData<List<Location>> getLocationsSortedByStreetAsc() {
        return personalDevelopmentDatabase.locationDao().getLocationsSortedByStreetAsc();
    }

    public LiveData<List<Location>> getLocationsSortedByStreetDesc() {
        return personalDevelopmentDatabase.locationDao().getLocationsSortedByStreetDesc();
    }

    public LiveData<List<Location>> getLocationsSortedByIdAsc() {
        return personalDevelopmentDatabase.locationDao().getLocationsSortedByIdAsc();
    }

    public LiveData<List<Location>> getLocationsSortedByIdDesc() {
        return personalDevelopmentDatabase.locationDao().getLocationsSortedByIdDesc();
    }

    public LiveData<Location> getLocationById(@NonNull Long locationId) {
        return personalDevelopmentDatabase.locationDao().getLocationById(locationId);
    }

    public void deleteLocationById(@NonNull Long locationId) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.locationDao().deleteLocationById(locationId));
    }

    public void updateLocations(Location... locations) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.locationDao().update(locations));
    }

    public void insertLocations(Location... locations) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.locationDao().insert(locations));
    }

    public LiveData<List<Feedback>> getAllFeedbacks() {
        return personalDevelopmentDatabase.feedbackDao().getAllFeedbacks();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByIdAsc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByIdAsc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByIdDesc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByIdDesc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedBySessionAsc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedBySessionAsc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedBySessionDesc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedBySessionDesc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByTitleAsc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByTitleAsc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByTitleDesc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByTitleDesc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByContentLengthAsc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByContentLengthAsc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByContentLengthDesc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByContentLengthDesc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByRatingAsc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByRatingAsc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByRatingDesc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByRatingDesc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByEmissionDateAsc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByEmissionDateAsc();
    }

    public LiveData<List<Feedback>> getFeedbacksSortedByEmissionDateDesc() {
        return personalDevelopmentDatabase.feedbackDao().getFeedbacksSortedByEmissionDateDesc();
    }

    public LiveData<Feedback> getFeedbackById(Long feedbackId) {
        return personalDevelopmentDatabase.feedbackDao().getFeedbackById(feedbackId);
    }

    public void deleteFeedbackById(Long feedbackId) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.feedbackDao().deleteFeedbackById(feedbackId));
    }

    public LiveData<Long> isFeedbackConfirmed(Long feedbackId) {
        return personalDevelopmentDatabase.feedbackDao().isFeedbackConfirmed(feedbackId);
    }

    public LiveData<List<Session>> getSessionsWithoutFeedback() {
        return personalDevelopmentDatabase.sessionDao().getSessionsWithoutFeedback();
    }

    public LiveData<Session> getSessionByFeedbackId(Long feedbackId) {
        return personalDevelopmentDatabase.sessionDao().getSessionByFeedbackId(feedbackId);
    }

    public LiveData<User> getUserWithFeedbackId(Long feedbackId) {
        return personalDevelopmentDatabase.userDao().getUserWithFeedbackId(feedbackId);
    }

    public LiveData<List<Long>> getIdsForSessionsWithoutFeedback() {
        return personalDevelopmentDatabase.sessionDao().getIdsForSessionsWithoutFeedback();
    }

    public void insertFeedbacks(Feedback... feedbacks) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.feedbackDao().insert(feedbacks));
    }

    public void updateFeedbacks(Feedback... feedbacks) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.feedbackDao().update(feedbacks));
    }

    public LiveData<List<Material>> getAllMaterials() {
        return personalDevelopmentDatabase.materialDao().getAllMaterials();
    }

    public LiveData<List<Material>> getMaterialsSortedByTimeAsc() {
        return personalDevelopmentDatabase.materialDao().getMaterialsSortedByTimeAsc();
    }

    public LiveData<List<Material>> getMaterialsSortedByTimeDesc() {
        return personalDevelopmentDatabase.materialDao().getMaterialsSortedByTimeDesc();
    }

    public LiveData<List<Material>> getMaterialsSortedByTitleAsc() {
        return personalDevelopmentDatabase.materialDao().getMaterialsSortedByTitleAsc();
    }

    public LiveData<List<Material>> getMaterialsSortedByTitleDesc() {
        return personalDevelopmentDatabase.materialDao().getMaterialsSortedByTitleDesc();
    }

    public LiveData<List<Material>> getMaterialsSortedByIdAsc() {
        return personalDevelopmentDatabase.materialDao().getMaterialsSortedByIdAsc();
    }

    public LiveData<List<Material>> getMaterialsSortedByIdDesc() {
        return personalDevelopmentDatabase.materialDao().getMaterialsSortedByIdDesc();
    }

    public void deleteMaterialById(@NonNull Long materialId) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.materialDao().deleteMaterialById(materialId));
    }

    public LiveData<Material> getMaterialWithId(@NonNull Long materialId) {
        return personalDevelopmentDatabase.materialDao().getMaterialWithId(materialId);
    }

    public void updateMaterials(Material... materials) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.materialDao().update(materials));
    }

    public void insertMaterials(Material... materials) {
        PersonalDevelopmentDatabase.databaseWriterExecutor.execute(() ->
                personalDevelopmentDatabase.materialDao().insert(materials));
    }
}
