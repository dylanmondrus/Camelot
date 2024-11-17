package myclassproject.testgraph;
import myclassproject.mystorygraph.MyChoiceLabels;
import myclassproject.mystorygraph.MyEdgeBuilder;
import myclassproject.mystorygraph.MyNodeLabels;
import myclassproject.mystorygraph.MyStoryEntities;

import java.util.List;

import com.playerInput.MenuChoice;
import com.playerInput.PlayerInteraction;
import com.storygraph.*;

public class JacksonTestEdgeBuilder extends MyEdgeBuilder {
	public JacksonTestEdgeBuilder(List<Node> list) {
		super(list);
	}

	@Override
	@BuilderMethod
	public void rootEdges() {
		var root = get(MyNodeLabels.root.toString());
		root.clearEdges();	
			//Example:
			//var root = get(NodeLabels.root.toString());
			//var choice = new MenuChoice(MenuChoice.Options.Start);
			//var nextNode = get(NodeLabels.atCottage.toString());
			//root.add(new Edge(choice, nextNode));
			var choice = new MenuChoice(MenuChoice.Options.Start);
			var nextNode = get(MyNodeLabels.GoToFireplace.toString());
			root.add(new Edge(choice, nextNode));
			
	}
	@BuilderMethod
	public void FirePlaceEdges() { //Jackson
		var node = get(MyNodeLabels.GoToFireplace.toString());
		var nextNode = get(MyNodeLabels.BurnedToDeath.toString());
		var choice = new PlayerInteraction(MyStoryEntities.doug,MyChoiceLabels.BurnedToDeathChoice.toString(), MyStoryEntities.fireplace);
		node.add(new Edge(choice, nextNode));
	}
	
	
}


