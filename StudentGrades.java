/*
* Names: Aneeq Altaf
* netID: aaltaf4
* G#: 01496340
* Lecture section: 004
* Lab section: 205
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
public class StudentGrades {
    private double participation;
    private double midterm;
    private double finalExam;

    private Collection<Double> labs;
    private Collection<Double> exercises;
    private Collection<Double> projects;   
    private List<Double> readings;

    private double participationWeight;
    private double readingsWeight;
    private double labsWeight;
    private double exercisesWeight;
    private double projectsWeight;
    private double midtermWeight;
    private double finalExamWeight;

    private String studentName;
    private String gNumber;

    public StudentGrades(String name, String gNumber, double[] weights) {
        this.studentName = name;
        this.gNumber = gNumber;

        participationWeight= weights[0];
        readingsWeight= weights[1];
        labsWeight= weights[2];
        exercisesWeight= weights[3];
        projectsWeight= weights[4];
        midtermWeight= weights[5];
        finalExamWeight= weights[6];

        labs = new ArrayList<>();
        exercises = new ArrayList<>();
        projects = new ArrayList<>();
        readings = new ArrayList<>();
    }
    /**
     * a getter for participation
     * @return the participation field
     */
    public double getParticipation() {
        return participation;
    }
    /**
     * getter for midterm
     * 
     * @return midterm field
     */
    public double getMidterm() {
        return midterm;
    }
    /**
     * getter for finalExam field
     * @return finalExam field
     */
    public double getFinalExam() {
        return finalExam;
    }
    /**
     * getter for StudentName field
     * @return studentName field
     */
    public String getStudentName() {
        return studentName;
    }
    /**
     * getter for Gnumber field
     * @return gNumber field
     */
    public String getGNumber() {
        return gNumber;
    }
    /**
     * setter for participation field
     * @param participation parameter to set participation field
     */

    public void setParticipation(double participation) {
        this.participation=participation;
    }
   /**
    * setter for midterm field
    * @param midterm parameter to set midterm field
    */
    public void setMidterm(double midterm) {
        this.midterm=midterm;
    }
    /**
     * setter for finalExam
     * @param finalExam parameter to set finalExam field
     */
    public void setFinalExam(double finalExam) {
        this.finalExam=finalExam;
    }
    /**
     * setter for studentName field
     * @param studentName parameter to set studentName
     */
    public void setStudentName(String studentName) {
        this.studentName=studentName;
    }
    /**
     * setter for gNumber
     * @param gNumber parameter to set Gnumber field
     */
    public void setGNumber(String gNumber) {
        this.gNumber=gNumber;
    }
    /**
     * setter to add value reading field collection
     * @param d 
     */ 
    public void addReading(double d) {
        readings.add(d);
    }
    /**
     * setter to add value  collection field labs
     * @param d
     */
    public void addLab(double d) {
        labs.add(d);

    }
    /**
     * setter to add value  collection  field exercises
     * @param d
     */
    public void addExercise(double d) {
        exercises.add(d);
    }
    /**
     * setter to add value collection field projects
     * @param d
     */
    public void addProject(double d) {
        projects.add(d);
    }
    /**
     * setter for weights field
     * @param weights a parameter contains all ordered values for weights field
     */
    public void setWeights(double[] weights) {
        participationWeight= weights[0];
        readingsWeight= weights[1];
        labsWeight= weights[2];
        exercisesWeight= weights[3];
        projectsWeight= weights[4];
        midtermWeight= weights[5];
        finalExamWeight= weights[6];
    }

/*     public double unweightedReadingsScore() {
        Collections.sort(readings); // 0 to 14 drop no.s
        double total=0;
        
        for (int i=15; i<readings.size(); i++) {
            total += readings.get(i);
            
        }
        return total/(readings.size()-15);
    }  */
      /**
       *A method for calculating the unweighted score for the readings category
       * @return score for reading catergory unweighted
       */
    public double unweightedReadingsScore() {
        if (readings.size() < 16) return 100.0;
        List<Double> sorted = new ArrayList<>(readings);
        Collections.sort(sorted);
        double total = 0;
        for (int i = 15; i < sorted.size(); i++) {
            total += sorted.get(i);
        }
        return total / (sorted.size() - 15);
    }
    /**
     * A method for calculating the unweighted score for the labs category
     * @return labs score unweighted
     */
    public double unweightedLabsScore() {
        double total=0;
        if (labs.isEmpty()) {
            return 100.0;
        }
        for (double score : labs) {
            total+=score;
        }
        return total/labs.size();
    }
    /**
     * A method for calculating the unweighted score for the exercises category
     * @return exercises score unweighted
     */
    public double unweightedExercisesScore() {
        double total=0;
        if (exercises.isEmpty()) {
            return 100.0;
        }
        for (double s : exercises) {
            total+=s;
        }
        return total/exercises.size();
    }
    /**
     * A method for calculating the unweighted score for the projects category
     * @return projects score unweighted
     */
    public double unweightedProjectsScore() {
        double total=0;
        if (projects.isEmpty()) {
            return 100.0;
        }
        for (double s : projects) {
            total+=s;
        }
        return total/projects.size();
    }
    /**
     * method to determine whther final replaces midterm or not
     * @return boolean expression.
     */
    public boolean finalReplacesMidterm() {
        if(finalExam>midterm) {
            return true;
        }
        return false;
    }
    /**
     * method that determines whether u pass the final exam
     * @return boolean expression
     */
    public boolean finalIsPassing() {
        if (finalExam>=60.0) {
            return true;
        }
        return false;
    }
    /**
     * A method which computes the total score by combining the weighted scores from each category
     * @return a double value which gives total score of the course.
     */
    public double totalScore() {
        double midtermScore = finalReplacesMidterm() ? finalExam : midterm;
        return (participation * participationWeight)
             + (unweightedReadingsScore() * readingsWeight)
             + (unweightedLabsScore() * labsWeight)
             + (unweightedExercisesScore() * exercisesWeight)
             + (unweightedProjectsScore() * projectsWeight)
             + (midtermScore * midtermWeight)
             + (finalExam * finalExamWeight);
    }
    /**
     * A method which returns the letter grade corresponding to the current totalScore()
     * @return a String to determine grade student receiveeed.
     */
    public String letterGrade() {
        if (finalIsPassing()) {
            if ((totalScore() >= 98.0) && (totalScore() <= 100.0)) {
                return "A+";
            }
            else if ((totalScore() >= 92.0) && (totalScore() <= 98.0)) {
                return "A";
            }
            else if ((totalScore() >= 90.0) && (totalScore() <= 92.0)) {
                return "A-";
            }
            else if ((totalScore() >= 88.0) && (totalScore() <= 90.0)) {
                return "B+";
            }
            else if ((totalScore() >= 82.0) && (totalScore() <= 88.0)) {
                return "B";
            }
            else if ((totalScore() >= 80.0) && (totalScore() <= 82.0)) {
                return "B-";
            }
            else if ((totalScore() >= 78.0) && (totalScore() <= 80.0)) {
                return "C+";
            }
            else if ((totalScore() >= 72.0) && (totalScore() <= 78.0)) {
                return "C";
            }
            else if ((totalScore() >= 70.0) && (totalScore() <= 72.0)) {
                return "C-";
            }
            else if ((totalScore() >= 60.0) && (totalScore() <= 70.0)) {
                return "D";
            }
            else {
                return "F";
            }
        }

        else {
            return "F";
        }

    }
/**
 * a method that overrides parent toString() func 
 * @return a strong with score and letter grade.
 */
@Override
public String toString(){
    String rv = "Name: "+getStudentName()+"\n";
    rv += "G#: "+getGNumber()+"\n";
    rv += "Participation: "+getParticipation()+"\n";
    rv += "Readings: "+unweightedReadingsScore()+", "+readings+"\n";
    rv += "Labs: "+unweightedLabsScore()+", "+labs+"\n";
    rv += "Exercises: "+unweightedExercisesScore()+", "+exercises+"\n";
    rv += "Projects: "+unweightedProjectsScore()+", "+projects+"\n";
    rv += "Midterm: "+getMidterm()+"\n";
    rv += "Final Exam: "+getFinalExam()+"\n";
    rv += totalScore()+", "+letterGrade()+"\n";
    return rv;
}
    




}