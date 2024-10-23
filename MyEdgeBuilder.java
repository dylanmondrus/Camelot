package myclassproject.mystorygraph;

import java.util.List;

import com.playerInput.MenuChoice;
import com.storygraph.BuilderMethod;
import com.storygraph.Edge;
import com.storygraph.Node;
import com.storygraph.NodeBuilder;

import myclassproject.questexample.NodeLabels;

public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method should add the edges of the node one by one. 
	 * These methods must have a BuilderMethod annotation.
	 */
	@BuilderMethod
	public void rootEdges() {
		//Example:
		//var root = get(NodeLabels.root.toString());
		//var choice = new MenuChoice(MenuChoice.Options.Start);
		//var nextNode = get(NodeLabels.atCottage.toString());
		//root.add(new Edge(choice, nextNode));
		var root = get(MyNodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.atCity.toString());
		root.add(new Edge(choice, nextNode));
		}
	
	@BuilderMethod
	public void StartGameEdges() {
		var node = get(MyNodeLabels.root.toString());
		var choice = new(CloseNarrationChoice());
		var nextNode = get(MyNodeLabels.atCity.toString());
		node.add(new Edge(choice, nextNode));

	}
	
	@BuilderMethod
	public void atCityEdges() {
		var node = get(MyNodeLabels.StartGame.toString());
		var nextNode = get(MyNodeLabels.Barrell.toString());
		var choice1 = new PlayerInteraction(doug, )
	}
}





