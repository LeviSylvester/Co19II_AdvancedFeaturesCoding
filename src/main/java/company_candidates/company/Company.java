package company_candidates.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import company_candidates.candidate.Candidate;
import company_candidates.candidate.CandidateStatus;
import company_candidates.department.Department;
import company_candidates.department.Marketing;
import company_candidates.department.Production;
import company_candidates.exceptions.EvaluationIncapacityException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private List<Department> departments = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();

    public Company() {
        departments.add(Marketing.getInstance());
        departments.add(Production.getInstance());
    }

    public void recruiting() {
        readCandidatesFromJsonFile();

        candidates.sort(new Comparator<Candidate>() {
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
            } else if (candidate.getDepartmentName().equals(PRODUCTION)) {
                candidatesInProduction.add(candidate);
            } else {
                throw new EvaluationIncapacityException();
            }
        }
        List<Candidate> marketingCandidatesAccepted = getFinalCandidatesInMarketing(candidatesInMarketing);

        List<Candidate> productionCandidatesAccepted = getFinalCandidatesInProduction(candidatesInProduction);

        writeCandidatesToJsonFile(marketingCandidatesAccepted, "marketingCandidatesAccepted.json");
        writeCandidatesToJsonFile(productionCandidatesAccepted, "productionCandidatesAccepted.json");
    }

    //toDo: refactor to parametrized department
    private List<Candidate> getFinalCandidatesInProduction(List<Candidate> candidatesForProduction) {
        Production production = Production.getInstance();
        List<Candidate> finalCandidates = new ArrayList<>();

        if (candidatesForProduction.isEmpty()) {
            System.out.println("No candidates applied for production.");
            return finalCandidates;
        }

        for (Candidate c : candidatesForProduction) {
            CandidateStatus firstResponse = production.evaluateBasedOnCompetenceLevel(c);
            c.setStatus(firstResponse);
            if (firstResponse.equals(ACCEPTED)) {
                CandidateStatus finalResponse = production.evaluateBasedOnOtherCriteria(c);
                c.setStatus(finalResponse);
                if (finalResponse.equals(ACCEPTED)) {
                    finalCandidates.add(c);
                }
            }
        }
        return finalCandidates;
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
                c.setStatus(finalResponse);
                if (finalResponse.equals(ACCEPTED)) {
                    finalCandidates.add(c);
                }
            }
        }
        return finalCandidates;
    }

    private void writeCandidatesToJsonFile(List<Candidate> candidates, String pathname){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathname), candidates);
        } catch (Exception e){
            System.out.println("Writing to json file failed.");
        }
    }

    public void readCandidatesFromJsonFile(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            String input = new String(Files.readAllBytes(Paths.get("candidati-initiali.json")));

            this.candidates = objectMapper
                    .readValue(input, objectMapper.getTypeFactory()
                                    .constructCollectionType(List.class, Candidate.class));
//            System.out.println(candidates);
        } catch (IOException e) {
            System.out.println("Reading form file failed");
        }
    }

//    public void addCandidate(Candidate c) {
//        this.candidates.add(c);
//    }
//
//    public List<Candidate> getCandidates() {
//        return candidates;
//    }
//
//    public List<Department> getDepartments() {
//        return departments;
//    }
//
//
//    public int getNumberOfFemales() {
//        //1
//        int count = 0;
//        for (Candidate c : this.candidates) {
//            if (c.getGender().equals(F)) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public int getNumberOfFemalesUsingStreams() {
//        return this.candidates.stream()
//                .filter(candidate -> candidate.getGender().equals(F)) //toDo: ask: overrides method in predicate?
//                .collect(Collectors.toList()).size();
//
//    }
//
//    public int getNumberOfMalesUsingStreams() {
//        return this.candidates.stream()
//                .filter(candidate -> candidate.getGender().equals(M))
//                .collect(Collectors.toList()).size();
//    }
//
//    private void getCandidatesInMarketing(List<Candidate> candidatesForMarketing) {
//        Marketing marketing = Marketing.getInstance();
//        List<Candidate> finalCandidates = new ArrayList<>();
//
//        for (Candidate c : candidatesForMarketing) {
//            CandidateStatus firstResponse = marketing.evaluateBasedOnCompetenceLevel(c);
//
//            if (firstResponse.equals(ACCEPTED)) {
//                CandidateStatus finalResponse = marketing.evaluateBasedOnOtherCriteria(c);
//
//                if (finalResponse.equals(ACCEPTED)) {
//                    finalCandidates.add(c);
//                }
//
//            }
//        }
//    }
}
