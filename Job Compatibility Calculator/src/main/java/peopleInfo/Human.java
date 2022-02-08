package peopleInfo;

import peopleInfo.curiculumInfo.Interest;

public class Human {
    private String name;
    private String gender;
    private String nationality;
    private String age;
    private Interest interest;

    public Human(String name, String gender, String nationality, String age) {
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Human(String gender, String nationality, String age) {
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
    }
}
