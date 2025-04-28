/*
* Names: Aneeq Altaf
* netID: aaltaf4
* G#: 01496340
* Lecture section: 004
* Lab section: 205
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Gradebook implements Comparator<StudentGrades> {
    
    private Collection<StudentGrades> grades;

    
    public Gradebook() {
        grades = new ArrayList<StudentGrades>();
    }

    /**
     * Compares two StudentGrades objects based on their total score.
     * 
     * @param left  the first StudentGrades to be compared
     * @param right the second StudentGrades to be compared
     * @return a negative integer, zero, or a positive integer as the total score of
     *         left is less than, equal to, or greater than that of right
     */
    @Override
    public int compare(StudentGrades left, StudentGrades right) {
        return (int) (left.totalScore() - right.totalScore());
    }

    /**
     * Adds a StudentGrades instance to the grades collection.
     * 
     * @param sg the StudentGrades instance to be added
     */
    public void addGrade(StudentGrades sg) {
        grades.add(sg);
    }

    /**
     * Computes the average totalScore of all StudentGrades in the grades collection.
     * 
     * @return the average totalScore
     */
    public double average() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (StudentGrades sg : grades) {
            sum += sg.totalScore();
        }
        return sum / grades.size();
    }

    /**
     * Finds the StudentGrades instance with the minimum totalScore in the grades
     * collection.
     * 
     * @return the StudentGrades with the minimum totalScore
     */
    public StudentGrades min() {
        StudentGrades minGrade = null;
        for (StudentGrades sg : grades) {
            if (minGrade == null || compare(sg, minGrade) < 0) {
                minGrade = sg;
            }
        }
        return minGrade;
    }

    /**
     * Finds the StudentGrades instance with the maximum totalScore in the grades
     * collection.
     * 
     * @return the StudentGrades with the maximum totalScore
     */
    public StudentGrades max() {
        StudentGrades maxGrade = null;
        for (StudentGrades sg : grades) {
            if (maxGrade == null || compare(sg, maxGrade) > 0) {
                maxGrade = sg;
            }
        }
        return maxGrade;
    }

    /**
     * Finds the StudentGrades instance corresponding to the median totalScore in the
     * grades collection. The collection is sorted, and the middle element is
     * returned.
     * 
     * @return the StudentGrades with the median totalScore
     */
    public StudentGrades median() {
        ArrayList<StudentGrades> sortedGrades = new ArrayList<>(grades);
        sortedGrades.sort(this); 
        int middleIndex = sortedGrades.size() / 2;
        return sortedGrades.get(middleIndex);
    }

    /**
     * Returns a string representation of the Gradebook, listing the grades and max, min, median, and * average.
     * 
     * @return a string representation of the Gradebook
     */
    @Override
    public String toString() {
        String rv = "Grades: [ ";
        for (StudentGrades sg : grades) {
            rv += "(" + sg.getStudentName() + ": " + sg.letterGrade() + "), ";
        }
        rv += "]\n";
        rv += "Max: " + max() + ", Median: " + median() + ", Average: " + average() + ", Min: " + min();
        return rv;
    }
}
