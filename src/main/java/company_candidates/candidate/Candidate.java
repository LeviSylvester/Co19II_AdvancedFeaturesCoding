package company_candidates.candidate;

import company_candidates.department.DepartmentName;

public class Candidate {
    private String name; //toDo: full name
    private int levelOfCompetence;
    private CandidateStatus status;
    private DepartmentName departmentName;
    private Gender gender;

    public Candidate() {
    }

    public Candidate(String name,
                     int levelOfCompetence,
                     DepartmentName departmentName,
                     Gender gender) {
        this.name = name;
        this.levelOfCompetence = levelOfCompetence;
        this.departmentName = departmentName;
        this.gender = gender;
        this.status = CandidateStatus.AWAITING_RESPONSE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelOfCompetence() {
        return levelOfCompetence;
    }

    public void setLevelOfCompetence(int levelOfCompetence) {
        this.levelOfCompetence = levelOfCompetence;
    }

    public CandidateStatus getStatus() {
        return status;
    }

    public void setStatus(CandidateStatus status) {
        this.status = status;
    }

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nCandidate{" +
                "name='" + name + '\'' +
                ", levelOfCompetence=" + levelOfCompetence +
                ", status=" + status +
                ", departmentName='" + departmentName + '\'' +
                ", gender: " + gender +
                '}';
    }
}