package com.ssh.model;

import javax.persistence.*;

@Entity
public class Score {
    private int id;
    private Double score;
    private Integer courseId;
    private Integer studentId;
    private Course courseByCourseId;
    private Student studentByStudentId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "score", nullable = true, precision = 2)
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "course_id", nullable = true)
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "student_id", nullable = true)
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score1 = (Score) o;

        if (id != score1.id) return false;
        if (score != null ? !score.equals(score1.score) : score1.score != null) return false;
        if (courseId != null ? !courseId.equals(score1.courseId) : score1.courseId != null) return false;
        if (studentId != null ? !studentId.equals(score1.studentId) : score1.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }
}
