package capture12;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IntHandle implements Iterable{
    private String name = "阿达";
    int [] nums = new int[10];

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
