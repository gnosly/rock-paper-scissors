
public class Tie implements Result {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof Tie) return true;

        return false;
    }
}
