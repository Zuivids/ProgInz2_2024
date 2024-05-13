package com.example.service;

import java.util.ArrayList;

import com.example.model.Grade;

public interface IGradeFilterService {

	ArrayList<Grade> selectFailedGrades() throws Exception;

	ArrayList<Grade> selectGradesByStudnetId(int id) throws Exception;

	float calculateAVGGradeCourseId(int id) throws Exception;

}
