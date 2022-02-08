package model;

import peopleInfo.curiculumInfo.PersonalProject;
import peopleInfo.curiculumInfo.WorkExperience;

import java.util.ArrayList;
import java.util.List;

public class WantedJob {
    List<WorkExperience> workExperienceList;
    List<PersonalProject> personalProjectList;

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<PersonalProject> getPersonalProjectList() {
        return personalProjectList;
    }

    public void setPersonalProjectList(List<PersonalProject> personalProjectList) {
        this.personalProjectList = personalProjectList;
    }

    public void addWorkExperience(WorkExperience workExperience) {
        if (workExperienceList == null) {
            workExperienceList = new ArrayList<>();
        }
        workExperienceList.add(workExperience);
    }
    public void addPersonalProject(PersonalProject personalProject) {
        if (personalProjectList == null) {
            personalProjectList = new ArrayList<>();
        }
        personalProjectList.add(personalProject);
    }
}
