package company_candidates.department;

import company_candidates.candidate.Candidate;
import company_candidates.candidate.CandidateStatus;

import static company_candidates.candidate.CandidateStatus.ACCEPTED;
import static company_candidates.candidate.CandidateStatus.REJECTED;
import static company_candidates.department.DepartmentName.PRODUCTION;

public class Production extends Department {
    private static Production instance = new Production();
    private int minNoOfPositionsWithMaxCompetenceLevel = getOpenPositions() * 20 / 100;
    private int maxLevelOfCompetence = 10;
    private int noOfAcceptedCandidatesWithMaxCompetenceLevel = 0;

    private Production() {
        super(PRODUCTION, 8, 10);
    }

    public static Production getInstance() {
        return instance;
    }

    @Override
    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
        if (candidate.getLevelOfCompetence() < this.getMinLevelOfCompetence()) {
            return CandidateStatus.REJECTED;
        } else {
            return ACCEPTED;
        }
    }0

    @Override
    public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
        if (candidate.getLevelOfCompetence() == maxLevelOfCompetence) {
            noOfAcceptedCandidatesWithMaxCompetenceLevel++;
            return ACCEPTED;
        } else if (noOfAcceptedCandidatesWithMaxCompetenceLevel >= minNoOfPositionsWithMaxCompetenceLevel) {
            return ACCEPTED;
        } else {
            return REJECTED;
        }
    }
}
