package peopleInfo.curiculumInfo;

import java.util.Objects;

public class PersonalProject {
    private String name;

    public String getName() {
        return name;
    }

    public PersonalProject(String name) {
        this.name = name;
    }

    public PersonalProject() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalProject that = (PersonalProject) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
