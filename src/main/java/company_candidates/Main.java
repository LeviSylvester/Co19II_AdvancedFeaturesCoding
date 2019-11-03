package company_candidates;

import company_candidates.candidate.Candidate;
import company_candidates.candidate.CandidateStatus;
import company_candidates.candidate.Gender;
import company_candidates.department.*;

import java.util.HashSet;

import static company_candidates.department.DepartmentName.*;

//# Company- Employees
//The Candidate class is characterized by a full name,
// an integer indicating the level of competence and a string representing the name of the department
// for which the company_candidates.candidate chooses to be employed.
//Implement a constructor for this class to initialize these attributes and overide also the toString method.
//Class Company has a name and contains a list of candidates.
// A company_candidates.candidate.company has at least 2 departments: Marketing and Production.
//Each departament has an attribute of integer type representing the minimum value
// of the level of competencies required for a company_candidates.candidate to be admitted to that department.
//The 2 departments implement the Evaluator interface which contains the evaluateBasedOnCompetenceLevel() method that,
// for a company_candidates.candidate received as a parameter changes the company_candidates.candidate's status, in Rejected/Accepted.
//Initially, each company_candidates.candidate is assumed to be in Awaiting for a response mode.
//A company_candidates.candidate who has at least the level of competence required by the department he applied for,
// is considered accepted, otherwise rejected.
//--
//The class Company has a method called recruiting() which,
// on a company_candidates.candidate received as a parameter,
// delegates it to be evaluated by the department for which it is applying.
// If a department receives for evaluation a company_candidates.candidate who has not opted for that department,
// the exception of the type EvaluationIncapacity is thrown, together with a specific message.
//Don't allow a more than 2 deps, one Marketing, one Production.
//Add a number of vacant places on each departament and when after that number fills in, inform the user that.
//The proportion of male and females in each department must not be more than 40-60%.
//If there are more candidates than open positions on a dept,
// make sure you choose them based on this and on the experince level.
//- Create a main class to test each of the scenarios above.
//- Save the result to a file
//- Create a method that lets you read and write
// the candidates from/to a file (.json) - https://www.baeldung.com/jackson-object-mapper-tutorial
//- Send an email with the report  (https://dzone.com/articles/sending-mail-using-javamail-api-for-gmail-server)
public class Main {
    public static void main(String[] args) {
//        Candidate levi = new Candidate("Levi", 3, MARKETING);
        Candidate c1 = new Candidate("John", 5, MARKETING, Gender.M);
        Candidate c2 = new Candidate("Jane", 3, PRODUCTION, Gender.F);
        Candidate c3 = new Candidate("Paul", 10, MARKETING, Gender.M);
        Candidate c4 = new Candidate("Joe", 5, MARKETING, Gender.M);
        Candidate c5 = new Candidate("Jani", 3, PRODUCTION, Gender.M);
        Candidate c6 = new Candidate("Paulina", 10, MARKETING, Gender.F);
        Candidate c7 = new Candidate("Jolie", 5, MARKETING, Gender.F);
        Candidate c8 = new Candidate("Jamie", 3, PRODUCTION, Gender.F);
        Candidate c9 = new Candidate("Paolo", 10, MARKETING, Gender.M);
//        Candidate c3 = new Candidate("Paul", 10, HR);
//        Production production = new Production();
//        production.evaluateBasedOnCompetenceLevel(levi);
        Company company = new Company();
//        company.addCandidate(levi);
        company.addCandidate(c1);
        company.addCandidate(c2);
        company.addCandidate(c3);
        company.addCandidate(c4);
        company.addCandidate(c5);
        company.addCandidate(c6);
        company.addCandidate(c7);
        company.addCandidate(c8);
        company.addCandidate(c9);
//        company.addCandidate(c2);
//        company.addCandidate(c3);

        company.recruiting();

//        HashSet<Department> deps = new HashSet<>();
////        Marketing m1 = new Marketing();
////        Marketing m2 = new Marketing();
//        Marketing m1 = Marketing.getInstance();
//        Marketing m2 = Marketing.getInstance();
//        Production p = Production.getInstance();
//
//        deps.add(m1);
//        deps.add(m2);
//        deps.add(p);
//        System.out.println(deps.size());
    }
}
