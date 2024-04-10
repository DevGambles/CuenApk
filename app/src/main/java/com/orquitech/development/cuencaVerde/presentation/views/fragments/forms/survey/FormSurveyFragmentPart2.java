//Georgi fixed
package com.orquitech.development.cuencaVerde.presentation.views.fragments.forms.survey;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orquitech.development.cuencaVerde.R;
import com.orquitech.development.cuencaVerde.databinding.FragmentFormSurveyPart2Binding;
import com.orquitech.development.cuencaVerde.presentation.factories.AppViewsFactory;
import com.orquitech.development.cuencaVerde.presentation.views.activities.form.SurveyActivityForm;
import com.orquitech.development.cuencaVerde.presentation.views.widgets.ToolBarListenerAdapter;

public class FormSurveyFragmentPart2 extends FormSurveyBaseFragment {

    public static FormSurveyFragmentPart2 getInstance(Bundle data) {
        FormSurveyFragmentPart2 fragment = new FormSurveyFragmentPart2();
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form_survey_part2, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        ((FragmentFormSurveyPart2Binding) binding).mainToolbar.setListener(new ToolBarListenerAdapter() {
            @Override
            public void onToolbarLeftIconClick() {
                activity.onBackPressed();
            }
        });
        return binding.getRoot();
    }

    @Override
    protected void setViewModel() {
        ((FragmentFormSurveyPart2Binding) binding).setViewModel(viewModel);
    }

    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public void onViewModelUpdated() {
        ((FragmentFormSurveyPart2Binding) binding).setViewModel(viewModel);
        if (viewModel.getSurvey().isNew()) {
            ((FragmentFormSurveyPart2Binding) binding).mainToolbar.setTitle(getString(R.string.new_form));
        }
    }

    @Override
    public void changeToView(int viewId) {
        ((SurveyActivityForm) activity).changeToView(viewId, 2);
    }

    @Override
    public int getNextViewId() {
        return AppViewsFactory.FORM_SURVEY_VIEW_PART_3;
    }

    @Override
    protected void setMunicipalities(String[] municipalitiesArray) {
        ((FragmentFormSurveyPart2Binding) binding).municipality.setData(municipalitiesArray);
    }

    @Override
    public boolean canGoToNextScreen() {
        return viewModel.canGoToNextScreen(2);
    }
}
