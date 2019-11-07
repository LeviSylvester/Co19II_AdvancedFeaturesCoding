package company_candidates.department;

import company_candidates.candidate.Candidate;
import company_candidates.candidate.CandidateStatus;

import static company_candidates.candidate.CandidateStatus.ACCEPTED;
import static company_candidates.candidate.CandidateStatus.REJECTED;
import static company_candidates.candidate.Gender.F;
import static company_candidates.candidate.Gender.M;
import static company_candidates.department.DepartmentName.MARKETING;

public class Marketing extends Department {
    private static Marketing instance = new Marketing();
    private int maximNoOfOpenPositionsForMales = getOpenPositions() * 40 / 100;
    private int maximNoOfOpenPositionsForFemales = getOpenPositions() * 60 / 100;
    //toDo: add a number of vacant places on each department and after that number fills in, inform the user

    private Marketing() {
        super(MARKETING, 5, 10);
    }

    public static Marketing getInstance() {
        return instance;
    }

    @Override
    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
        if (candidate.getLevelOfCompetence() < this.getMinLevelOfCompetence()) {
            return REJECTED;
        } else {
            return ACCEPTED;
        }
    }

    @Override
    public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
        if (candidate.getGender().equals(M) && maximNoOfOpenPositionsForMales > 0) {
            maximNoOfOpenPositionsForMales = maximNoOfOpenPositionsForMales - 1;
            return ACCEPTED;
        } else if (candidate.getGender().equals(F) && maximNoOfOpenPositionsForFemales > 0) {
            maximNoOfOpenPositionsForFemales = maximNoOfOpenPositionsForFemales - 1;
            return ACCEPTED;
        }
        return REJECTED;
    }
}
