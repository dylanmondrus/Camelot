package myclassproject.testgraph;
import myclassproject.mystorygraph.MyChoiceLabels;
import myclassproject.mystorygraph.MyEdgeBuilder;
import myclassproject.mystorygraph.MyNodeLabels;
import myclassproject.mystorygraph.MyStoryEntities;

import java.util.List;

import com.playerInput.DialogChoice;
import com.playerInput.MenuChoice;
import com.playerInput.PlayerInteraction;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.*;

public class JacksonTestEdgeBuilder2 extends MyEdgeBuilder {
	public JacksonTestEdgeBuilder2(List<Node> list) {
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
			var nextNode = get(MyNodeLabels.VisitTavernTable.toString());
			root.add(new Edge(choice, nextNode));
			
	}
	@BuilderMethod
	public void VisitTavernTableEdges() { //Jackson
		var node = get(MyNodeLabels.VisitTavernTable.toString());
		var nextNode1 = get(MyNodeLabels.PickupTorch.toString());
		var choice1 = new DialogChoice("Pick up the torch");
				//new PlayerInteraction(MyChoiceLabels.PickupTorchChoice.toString(),MyStoryEntities.doug, Icons.torch, "Pickup Torch");
		node.add(new Edge(choice1, nextNode1));
		var nextNode2 = get(MyNodeLabels.DontPickupTorch.toString());
		var choice2 = new DialogChoice("Pick up the torch");
		//node.add(new Edge(choice2, nextNode2));
	}
	
	
}