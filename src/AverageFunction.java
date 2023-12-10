public class AverageFunction {
    public double Average(CourseInputs [] data) {
        double totalGradePoint = 0;
        double totalGradeUnit = 0;

        for (CourseInputs course: data) {
            totalGradePoint += course.getGradeUnit() * course.getCourseUnit();
            totalGradeUnit += course.getCourseUnit();
        }
        double gpa = totalGradePoint / totalGradeUnit;
        return Math.round(gpa * 100) / 100.0;
    }
}
