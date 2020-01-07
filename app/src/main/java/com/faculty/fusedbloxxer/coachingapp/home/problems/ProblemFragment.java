package com.faculty.fusedbloxxer.coachingapp.home.problems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Problem;

import java.util.List;

public class ProblemFragment extends TableFragment<Long> {

    private ProblemAdapter problemAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(problemAdapter = new ProblemAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllProblems().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getAllProblems().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            case 0:
                vm.getProblemsSortedByIdAsc().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getProblemsSortedByIdAsc().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            case 1:
                vm.getProblemsSortedByIdDesc().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getProblemsSortedByIdDesc().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            case 2:
                vm.getProblemsSortedByTitleAsc().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getProblemsSortedByTitleAsc().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            case 3:
                vm.getProblemsSortedByTitleDesc().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getProblemsSortedByTitleDesc().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            case 4:
                vm.getProblemsSortedByStateAsc().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getProblemsSortedByStateAsc().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            case 5:
                vm.getProblemsSortedByStateDesc().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getProblemsSortedByStateDesc().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            case 6:
                vm.getProblemsSortedByDescriptionAsc().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getProblemsSortedByDescriptionAsc().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            case 7:
                vm.getProblemsSortedByDescriptionDesc().observe(this, new Observer<List<Problem>>() {
                    @Override
                    public void onChanged(List<Problem> problems) {
                        vm.getProblemsSortedByDescriptionDesc().removeObserver(this);
                        problemAdapter.setProblems(problems);
                    }
                });
                break;
            default:
                throw new RuntimeException("Invalid problem sort option was chosen.");

        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Id (Mic-Mare)",
                "Id (Mare-Mic)",
                "Titlu (A-Z)",
                "Titlu (Z-A)",
                "Stare (A-Z)",
                "Stare (Z-A)",
                "Lungime descriere (Mica-Mare)",
                "Lungime descriere (Mare-Mica)"
        };
    }

    @Override
    protected void onFabClick() {
        navController.navigate(ProblemFragmentDirections.actionProblemeToProblemModFragment());
    }

    @Override
    protected String getSortKey() {
        return "PROBLEM_SORT";
    }

    @Override
    public void updateOrDelete(Long element, int option) {
        if (option == 0) {
            navController.navigate(ProblemFragmentDirections.actionProblemeToProblemModFragment().setProblemId(String.valueOf(element)));
        } else {
            vm.deleteProblemWithId(element);
        }
    }
}
