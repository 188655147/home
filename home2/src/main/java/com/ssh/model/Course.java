package com.ssh.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Course {
    private int id;
    private String name;
    private Integer teacherId;
    private Teacher teacherByTeacherId;
    private Collection<Score> scoresById;
    private Collection<Teacher> teachersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "teacher_id", nullable = true)
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (teacherId != null ? !teacherId.equals(course.teacherId) : course.teacherId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public Teacher getTeacherByTeacherId() {
        return teacherByTeacherId;
    }

    public void setTeacherByTeacherId(Teacher teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<Score> getScoresById() {
        return scoresById;
    }

    public void setScoresById(Collection<Score> scoresById) {
        this.scoresById = scoresById;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<Teacher> getTeachersById() {
        return teachersById;
    }

    public void setTeachersById(Collection<Teacher> teachersById) {
        this.teachersById = teachersById;
    }
}
