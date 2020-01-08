package com.faculty.fusedbloxxer.coachingapp.home.feedbacks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.faculty.fusedbloxxer.coachingapp.R;
import com.faculty.fusedbloxxer.coachingapp.core.TableFragment;
import com.faculty.fusedbloxxer.coachingapp.model.db.entities.Feedback;

import java.util.List;

public class FeedbackFragment extends TableFragment<Long> {

    private FeedbackAdapter mFeedbackAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.table_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(mFeedbackAdapter = new FeedbackAdapter(this));
    }

    @Override
    protected void fetchDataFromDatabase(int i) {
        switch (i) {
            case -1:
                vm.getAllFeedbacks().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getAllFeedbacks().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 0:
                vm.getFeedbacksSortedByIdAsc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByIdAsc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 1:
                vm.getFeedbacksSortedByIdDesc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByIdDesc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 2:
                vm.getFeedbacksSortedBySessionAsc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedBySessionAsc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 3:
                vm.getFeedbacksSortedBySessionDesc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedBySessionDesc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 4:
                vm.getFeedbacksSortedByTitleAsc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByTitleAsc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 5:
                vm.getFeedbacksSortedByTitleDesc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByTitleDesc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 6:
                vm.getFeedbacksSortedByContentLengthAsc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByContentLengthAsc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 7:
                vm.getFeedbacksSortedByContentLengthDesc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByContentLengthDesc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 8:
                vm.getFeedbacksSortedByRatingAsc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByRatingAsc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 9:
                vm.getFeedbacksSortedByRatingDesc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByRatingDesc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 10:
                vm.getFeedbacksSortedByEmissionDateAsc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByEmissionDateAsc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            case 11:
                vm.getFeedbacksSortedByEmissionDateDesc().observe(this, new Observer<List<Feedback>>() {
                    @Override
                    public void onChanged(List<Feedback> feedbacks) {
                        vm.getFeedbacksSortedByEmissionDateDesc().removeObserver(this);
                        mFeedbackAdapter.setFeedbacks(feedbacks);
                    }
                });
                break;
            default:
                throw new RuntimeException("An invalid option was chosen.");
        }
    }

    @Override
    protected String[] getOptions() {
        return new String[]{
                "Id (Mic-Mare)",
                "Id (Mare-Mic)",
                "Sedinta (Mic-Mare)",
                "Sedinta (Mare-Mic)",
                "Titlu (A-Z)",
                "Titlu (Z-A)",
                "Lungime continut (Mic-Mare)",
                "Lungime continut (Mare-Mic)",
                "Puncte evaluare (Mic-Mare)",
                "Puncte evaluare (Mare-Mic)",
                "Data emitere (Recent-Vechi)",
                "Data emitere(Vechi-Recent)"
        };
    }

    @Override
    protected void onFabClick() {

    }

    @Override
    protected String getSortKey() {
        return "FEEDBACKS_SORT";
    }

    @Override
    public void updateOrDelete(Long element, int option) {

    }
}
