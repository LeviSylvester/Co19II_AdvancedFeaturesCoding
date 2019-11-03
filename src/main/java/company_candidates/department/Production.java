package company_candidates.department;

import company_candidates.candidate.Candidate;
import company_candidates.candidate.CandidateStatus;

import static company_candidates.department.DepartmentName.PRODUCTION;

public class Production extends Department {
    private static Production instance = new Production();

    public Production() {
        super(PRODUCTION, 8, 3);
    }

    public static Production getInstance() {
        return instance;
    }

    @Override
    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
        if (candidate.getLevelOfCompetence() < this.getMinLevelOfCompetence()) {
            candidate.setStatus(CandidateStatus.REJECTED);
//            System.out.println(CandidateStatus.REJECTED);

        } else {
            candidate.setStatus(CandidateStatus.ACCEPTED);

//            System.out.println(CandidateStatus.ACCAPTED);
        }
        return null;
    }

//    @Override
    public CandidateStatus evaluateBsedOnOtherCriteria(Candidate candidate){
        return CandidateStatus.AWAITING_RESPONSE;
    }
}
