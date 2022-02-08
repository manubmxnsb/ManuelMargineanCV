package peopleInfo.curiculumInfo;

import java.util.Objects;

public class WorkExperience {
    private String name;

    public WorkExperience(String name) {
        this.name = name;
    }

    public WorkExperience() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkExperience that = (WorkExperience) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return  name;
    }
}
