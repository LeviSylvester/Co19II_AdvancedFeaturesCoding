package company_candidates.department;

import company_candidates.candidate.Candidate;
import company_candidates.candidate.CandidateStatus;

public interface Evaluator {
    CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate);
    CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate);
}
