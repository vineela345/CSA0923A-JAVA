class ExamException extends Exception {
    ExamException(String message) {
        super(message);
    }
}

class Main {
    static void submitExam(String student, boolean registered, boolean windowOpen)
            throws ExamException {
        if (!windowOpen)
            throw new ExamException("Exam window is closed");

        if (!registered)
            throw new ExamException(student + " is not registered");

        System.out.println(student + " submitted the exam successfully");
    }

    public static void main(String[] args) {
        try {
            submitExam("Student1", true, true);
            submitExam("Student2", false, true);
            submitExam("Student3", true, false);
        } catch (ExamException e) {
            System.out.println("Submission failed: " + e.getMessage());
        }
    }
}
