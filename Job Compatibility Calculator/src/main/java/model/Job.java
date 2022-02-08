package model;

import peopleInfo.curiculumInfo.PersonalProject;
import peopleInfo.curiculumInfo.WorkExperience;

import java.util.List;

public class Job {
    private String name;
    List<WorkExperience> workExperience;
    List<PersonalProject> personalProjects;
    private int matchingValue;

    public Job() {

    }

    public int getMatchingValue() {
        return matchingValue;
    }

    public void setMatchingValue(int matchingValue) {
        this.matchingValue = matchingValue;
    }

    public Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Job(List<WorkExperience> workExperience, List<PersonalProject> personalProjects) {
        this.workExperience = workExperience;
        this.personalProjects = personalProjects;
    }

    public List<WorkExperience> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<WorkExperience> workExperience) {
        this.workExperience = workExperience;
    }

    public List<PersonalProject> getPersonalProjects() {
        return personalProjects;
    }

    public void setPersonalProjects(List<PersonalProject> personalProjects) {
        this.personalProjects = personalProjects;
    }
}
