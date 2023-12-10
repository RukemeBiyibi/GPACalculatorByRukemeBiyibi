public class CourseInputs {
    private String courseCode;
    private int courseUnit;
    private double score;
    private String grade;
    private int gradeUnit;

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseCode() {
        return this.courseCode;
        }
        public void setCourseUnit(int courseUnit) {
            this.courseUnit = courseUnit;
        }
        public int getCourseUnit() {
            return this.courseUnit;
        }
        public void setScore(double score) {
            this.score = score;
            if (this.score >= 70) {
                this.grade = "A";
                this.gradeUnit = 5;
            } else if (this.score >= 60) {
                this.grade = "B";
                this.gradeUnit = 4;
            } else if (this.score >= 50) {
                this.grade = "C";
                this.gradeUnit = 3;
            } else if (this.score >= 45) {
                this.grade = "D";
                this.gradeUnit = 2;
            } else if (this.score >= 40) {
                this.grade = "E";
                this.gradeUnit = 1;
            } else if (this.score >= 0) {
                this.grade = "F";
                this.gradeUnit = 0;
            }
        }
        public int getGradeUnit() {
            return this.gradeUnit;
        }
        public String getGrade() {
            return this.grade;
        }
}
