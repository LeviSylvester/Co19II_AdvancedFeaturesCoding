package company_candidates.department;

import company_candidates.candidate.Candidate;
import company_candidates.candidate.CandidateStatus;

public class Department implements Evaluator{
    private DepartmentName name;
    private int minLevelOfCompetence;
    private int openPositions;

    public Department(DepartmentName name, int minLevelOfCompetence, int openPositions) {
        this.name = name;
        this.minLevelOfCompetence = minLevelOfCompetence;
        this.openPositions = openPositions;
    }

    public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
        return CandidateStatus.AWAITING_RESPONSE;
    }

    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
        return CandidateStatus.AWAITING_RESPONSE;
    }

    public int getMinLevelOfCompetence() {
        return minLevelOfCompetence;
    }

    public int getOpenPositions() {
        return openPositions;
    }

//    public DepartmentName getName() {
//        return name;
//    }
//
//    public void setName(DepartmentName name) {
//        this.name = name;
//    }
//
//    public void setMinLevelOfCompetence(int minLevelOfCompetence) {
//        this.minLevelOfCompetence = minLevelOfCompetence;
//    }
}
