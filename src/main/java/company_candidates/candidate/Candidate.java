package company_candidates.candidate;

import company_candidates.department.DepartmentName;

public class Candidate {
    private String name;
    private int levelOfCompetence;
    private CandidateStatus status;
    private DepartmentName departmentName; //toDo change type? - solved
    private Gender gender;

    public Candidate(String name, int levelOfCompetence, DepartmentName departmentName, Gender gender) {
        this.name = name;
        this.levelOfCompetence = levelOfCompetence;
        this.status = CandidateStatus.AWAITING_RESPONSE;
        this.departmentName = departmentName;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", levelOfCompetence=" + levelOfCompetence +
                ", status=" + status +
                ", departmentName='" + departmentName + '\'' + ", gender: " + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
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
}
