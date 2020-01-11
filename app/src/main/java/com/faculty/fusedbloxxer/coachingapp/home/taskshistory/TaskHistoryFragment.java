package com.faculty.fusedbloxxer.coachingapp.home.taskshistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.TaskHistory;
import com.faculty.fusedbloxxer.coachingapp.utilities.Pair;

import java.util.List;

public class TaskHistoryFragment extends TableFragment<Pair<Long, Long>> {

    private TaskHistoryAdapter taskHistoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(taskHistoryAdapter = new TaskHistoryAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllTasksHistory().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getAllTasksHistory().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            case 0:
                vm.getTasksHistorySortedByDateAsc().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getTasksHistorySortedByDateAsc().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            case 1:
                vm.getTasksHistorySortedByDateDesc().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getTasksHistorySortedByDateDesc().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            case 2:
                vm.getTasksHistorySortedByRatingAsc().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getTasksHistorySortedByRatingAsc().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            case 3:
                vm.getTasksHistorySortedByRatingDesc().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getTasksHistorySortedByRatingDesc().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            case 4:
                vm.getTasksHistorySortedByCommentLenAsc().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getTasksHistorySortedByCommentLenAsc().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            case 5:
                vm.getTasksHistorySortedByCommentLenDesc().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getTasksHistorySortedByCommentLenDesc().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            case 6:
                vm.getTasksHistorySortedByTaskIdAsc().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getTasksHistorySortedByTaskIdAsc().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            case 7:
                vm.getTasksHistorySortedByTaskIdDesc().observe(this, new Observer<List<TaskHistory>>() {
                    @Override
                    public void onChanged(List<TaskHistory> taskHistories) {
                        vm.getTasksHistorySortedByTaskIdDesc().removeObserver(this);
                        taskHistoryAdapter.setTaskHistoryList(taskHistories);
                    }
                });
                break;
            default:
                throw new RuntimeException("Invalid option !");
        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Data (Recent-Vechi)",
                "Data (Vechi-Recent)",
                "Evaluare incredere (Mic-Mare)",
                "Evaluare incredere (Mare-Mic)",
                "Lungime comentariu (Mic-Mare)",
                "Lungime comentariu (Mare-Mic)",
                "Id sarcina (Mic-Mare)",
                "Id sarcina (Mare-Mic)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(TaskHistoryFragmentDirections.actionIstoricSarciniToTaskHistoryModFragment());
    }

    @Override
    protected String getSortKey() {
        return "TASKS_HISTORY_SORT";
    }

    @Override
    public void updateOrDelete(Pair<Long, Long> element, int option) {
        if (option == 0) {
            navController.navigate(TaskHistoryFragmentDirections
                    .actionIstoricSarciniToTaskHistoryModFragment()
                    .setTaskId(element.getT1().toString())
                    .setDate(element.getT2().toString())
            );
        } else {
            vm.deleteTaskHistoryByTaskIdAndDate(element.getT1(), element.getT2());
        }
    }
}
