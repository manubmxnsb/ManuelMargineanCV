package ex4;

import java.util.Objects;

public class Definition {
    private String description;

    public Definition() {
    }

    public Definition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    public String toString() {
        return "Definition{" +
                "description='" + description + '\'' +
                '}';
    }
}
