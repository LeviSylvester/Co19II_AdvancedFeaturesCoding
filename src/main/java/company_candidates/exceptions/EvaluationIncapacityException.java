package company_candidates.exceptions;

public class EvaluationIncapacityException extends RuntimeException {
    public EvaluationIncapacityException() {
        super("The candidate cannot be evaluated");
    }
}
