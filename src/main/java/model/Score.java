package model;

public class Score {
    private int studentId, subjectId;
    private double score1, score2;

    public double getGrade() {
        return 0.3 * score1 + 0.7 * score2;
    }

    public String getLetterGrade() {
        double grade = getGrade();
        if (grade >= 8.0) return "A";
        if (grade >= 6.0) return "B";
        if (grade >= 4.0) return "D";
        return "F";
    }

    public Score() {
    }

    public Score(int studentId, int subjectId, double score1, double score2) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score1 = score1;
        this.score2 = score2;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }
}
