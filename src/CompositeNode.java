import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class CompositeNode extends Node implements ICompositeNode {

    private List<INode> listOfNodes = new LinkedList<>();


    public CompositeNode(String code, String renderer) {
        super(code, renderer);
    }

    @Override
    public List<INode> getNodes() {
        return null;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getRenderer() {
        return null;
    }

    @Override
    public Stream<INode> toStream() {
        return Stream.concat(
                super.toStream(),
                listOfNodes.stream().flatMap(INode::toStream)
        );
    }
}
