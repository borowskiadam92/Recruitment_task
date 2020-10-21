import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


public class MyStructure implements IMyStructure {
    private final List<INode> listOfNodes = new LinkedList<>();

    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Given code is null!");
        } else {
            return findByPredicate(c -> code.equals(c.getCode()));
        }
    }

    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Given renderer is null");
        } else {
            return findByPredicate(r -> renderer.equals(r.getRenderer()));
        }
    }

    @Override
    public int count() {
        return (int) listOfNodes.stream().flatMap(INode::toStream).count();
    }

    private INode findByPredicate(Predicate<INode> predicate) {
        return listOfNodes.stream()
                .flatMap(INode::toStream)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public void addNode(Node node) {
        listOfNodes.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStructure that = (MyStructure) o;
        return Objects.equals(listOfNodes, that.listOfNodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfNodes);
    }
}
