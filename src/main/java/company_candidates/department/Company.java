package company_candidates.department;

import company_candidates.candidate.Candidate;
import company_candidates.candidate.CandidateStatus;
import company_candidates.exceptions.EvaluationIncapacityException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static company_candidates.candidate.CandidateStatus.ACCEPTED;
import static company_candidates.candidate.Gender.*;
import static company_candidates.department.DepartmentName.MARKETING;
import static company_candidates.department.DepartmentName.PRODUCTION;

public class Company {
    //    private List<Candidate> candidates;
//    private List<Department> departments;
    private List<Candidate> candidates = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();

    public Company() {
//        this.candidates = new ArrayList<>();
//        this.departments = new ArrayList<>();
//        Marketing m = new Marketing();
//        Production p = new Production();
        departments.add(Marketing.getInstance());
        departments.add(Production.getInstance());
    }

    public void addCandidate(Candidate c) {
        this.candidates.add(c);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    private List<Candidate> getFinalCandidatesInMarketing(List<Candidate> candidatesForMarketing) {
        Marketing marketing = Marketing.getInstance();
        List<Candidate> finalCandidates = new ArrayList<>();

        if (candidatesForMarketing.isEmpty()) {
            System.out.println("No candidates applied for marketing.");
            return finalCandidates;
        }

        for (Candidate c : candidatesForMarketing) {
            CandidateStatus firstResponse = marketing.evaluateBasedOnCompetenceLevel(c);
            c.setStatus(firstResponse);
            if (firstResponse.equals(ACCEPTED)) {
                CandidateStatus finalResponse = marketing.evaluateBasedOnOtherCriteria(c);
                if (finalResponse.equals(ACCEPTED)) {
                    finalCandidates.add(c);
                }
            }
        }
//        System.out.println(finalCandidates);
        for(Candidate candidate : finalCandidates){
            System.out.println(candidate);
        }
        return finalCandidates;
    }


    public void recruiting() {
//        Production production = Production.getInstance();
        Collections.sort(candidates, new Comparator<Candidate>() {
            @Override
            public int compare (Candidate o1, Candidate o2){
                if (o1.getLevelOfCompetence() > o2.getLevelOfCompetence()){
                    return -1;
                } else if (o1.getLevelOfCompetence() < o2.getLevelOfCompetence()){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        List<Candidate> candidatesInMarketing = new ArrayList<>();
        List<Candidate> candidatesInProduction = new ArrayList<>();

        for (Candidate candidate : candidates) {
            if (candidate.getDepartmentName().equals(MARKETING)) {
                candidatesInMarketing.add(candidate);
//                System.out.println(candidate);
            } else if (candidate.getDepartmentName().equals(PRODUCTION)) {
                candidatesInProduction.add(candidate);
            } else {
                throw new EvaluationIncapacityException();
            }
        }
        getFinalCandidatesInMarketing(candidatesInMarketing);
    }

    public int getNumberOfFemales() {
        //1
        int count = 0;
        for (Candidate c : this.candidates) {
            if (c.getGender().equals(F)) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfFemalesUsingStreams() {
        return this.candidates.stream()
                .filter(candidate -> candidate.getGender().equals(F))
                .collect(Collectors.toList()).size();

    }

    public int getNumberOfMalesUsingStreams() {
        return this.candidates.stream()
                .filter(candidate -> candidate.getGender().equals(M))
                .collect(Collectors.toList()).size();
    }

    private void getCandidatesInMarketing(List<Candidate> candidatesForMarketing) {
        Marketing marketing = Marketing.getInstance();
        List<Candidate> finalCandidates = new ArrayList<>();

        for (Candidate c : candidatesForMarketing) {
            CandidateStatus firstResponse = marketing.evaluateBasedOnCompetenceLevel(c);

            if (firstResponse.equals(ACCEPTED)) {
                CandidateStatus finalResponse = marketing.evaluateBasedOnOtherCriteria(c);

                if (finalResponse.equals(ACCEPTED)) {
                    finalCandidates.add(c);
                }

            }
        }
    }
}
