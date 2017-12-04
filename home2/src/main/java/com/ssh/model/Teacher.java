package com.ssh.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Teacher {
    private int id;
    private String name;
    private String sex;
    private String birthday;
    private String professional;
    private String password;
    private Integer courseId;
    private Collection<Course> coursesById;
    private Course courseByCourseId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 20)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday", nullable = true, length = 60)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "professional", nullable = true, length = 40)
    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "course_id", nullable = true)
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (sex != null ? !sex.equals(teacher.sex) : teacher.sex != null) return false;
        if (birthday != null ? !birthday.equals(teacher.birthday) : teacher.birthday != null) return false;
        if (professional != null ? !professional.equals(teacher.professional) : teacher.professional != null)
            return false;
        if (password != null ? !password.equals(teacher.password) : teacher.password != null) return false;
        if (courseId != null ? !courseId.equals(teacher.courseId) : teacher.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (professional != null ? professional.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "teacherByTeacherId")
    public Collection<Course> getCoursesById() {
        return coursesById;
    }

    public void setCoursesById(Collection<Course> coursesById) {
        this.coursesById = coursesById;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }
}
