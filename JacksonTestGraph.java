package myclassproject.testgraph;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.storygraph.Graph;
import com.storygraph.NodeBuilder;

import myclassproject.mystorygraph.MyNodeLabels;
import myclassproject.questexample.NodeLabels;

public class JacksonTestGraph extends Graph {
	public JacksonTestGraph() {
		super(Stream.of(NodeLabels.values()).map(z->z.toString()).collect(Collectors.toList()));
	}
	public JacksonTestGraph(NodeLabels rootLabel) {
		super(Stream.of(MyNodeLabels.values()).map(z->z.toString()).collect(Collectors.toList()));    
	}
	public NodeBuilder getNodeBuilder() {
		return new JacksonTestNodeBuilder(nodes);
	}
	public NodeBuilder getEdgeBuilder() {
		return new JacksonTestEdgeBuilder(nodes);
	}
}


