package com.faculty.fusedbloxxer.coachingapp.home.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Task;

import java.util.List;

public class TaskFragment extends TableFragment<Long> {

    private TaskAdapter taskAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(taskAdapter = new TaskAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllTasks().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getAllTasks().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 0:
                vm.getTasksSortedByIdAsc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByIdAsc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 1:
                vm.getTasksSortedByIdDesc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByIdDesc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 2:
                vm.getTasksSortedByTitleAsc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByTitleAsc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 3:
                vm.getTasksSortedByTitleDesc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByTitleDesc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 4:
                vm.getTasksSortedByScoreAsc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByScoreAsc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 5:
                vm.getTasksSortedByScoreDesc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByScoreDesc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 6:
                vm.getTasksSortedByDescriptionLenAsc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByDescriptionLenAsc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 7:
                vm.getTasksSortedByDescriptionLenDesc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByDescriptionLenDesc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 8:
                vm.getTasksSortedByTimeAsc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByTimeAsc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            case 9:
                vm.getTasksSortedByTimeDesc().observe(this, new Observer<List<Task>>() {
                    @Override
                    public void onChanged(List<Task> tasks) {
                        vm.getTasksSortedByTimeDesc().removeObserver(this);
                        taskAdapter.setTasks(tasks);
                    }
                });
                break;
            default:
                throw new RuntimeException("Invalid option.");
        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Id (Mic-Mare)",
                "Id (Mare-Mic)",
                "Titlu (A-Z)",
                "Titlu (Z-A)",
                "Puncte premiu (Mic-Mare)",
                "Puncte premiu (Mare-Mic)",
                "Lungime descriere (Mic-Mare)",
                "Lungime descriere (Mare-Mic)",
                "Timp estimat (Mic-Mare)",
                "Timp estimat (Mare-Mic)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(TaskFragmentDirections.actionSarciniToModFragment());
    }

    @Override
    protected String getSortKey() {
        return "TASKS_SORT";
    }

    @Override
    public void updateOrDelete(Long element, int option) {
        if (option == 0) {
            navController.navigate(TaskFragmentDirections.actionSarciniToModFragment()
                    .setTaskId(element.toString()));
        } else {
            vm.deteleTaskWithId(element);
        }
    }
}
