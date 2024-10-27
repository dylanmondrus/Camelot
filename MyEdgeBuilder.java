package myclassproject.mystorygraph;

import java.util.List;
import static myclassproject.mystorygraph.MyStoryEntities.*;

import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
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
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.atCity.toString());
		node.add(new Edge(choice, nextNode));

	}
	
	@BuilderMethod
	public void atCityEdges() {
		var node = get(MyNodeLabels.StartGame.toString());
		var nextNode = get(MyNodeLabels.Barrell.toString());
		var choice1 = new PlayerInteraction(doug, MyChoiceLabels.gotoBarrell.toString(), barrell);
		node.add(new Edge(choice1, nextNode));
		var nextNode2 = get(MyNodeLabels.merchantbillTalk.toString());
		var choice2 = new PlayerInteraction(doug, MyChoiceLabels.gotoMerchantBill.toString(), merchantbill);
		node.add(new Edge(choice2, nextNode2));	
	}
	@BuilderMethod
	public void PickUpAppleEdge() {
		var node = get(MyNodeLabels.Barrell.toString());
		var nextNode = get(MyNodeLabels.Fountain.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.PickUpApple.toString(),MyStoryEntities.apple, Icons.apple, "Pick up the apple");
		node.add(new Edge(choice, nextNode));
		
	}
	@BuilderMethod
	public void GoToFountainEdges() {
		var node = get(MyNodeLabels.Barrell.toString());
		var nextNode = get(MyNodeLabels.Fountain.toString());
		var choice = new PlayerInteraction(doug, MyChoiceLabels.WalkToFountain.toString(), fountain);
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void InteractBeggar() {
		var node = get(MyNodeLabels.Fountain.toString());
		var nextNode = get(MyNodeLabels.Fountain.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToBeggar.toString(), beggar, Icons.talk, "Talk To Beggar" );
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void TakToBeggarEdge() {
		var node = get(MyNodeLabels.Fountain.toString());
		var choice1 = new DialogChoice("Yes");
		var nextNode1 = get(MyNodeLabels.FountainYes.toString());
		node.add(new Edge(choice1, nextNode1));
		var choice2 = new DialogChoice("No");
		var nextNode2 = get(MyNodeLabels.FountainNo.toString());
		node.add(new Edge(choice2, nextNode2));
	}
	@BuilderMethod //Joshua
	public void YesToBeggarEdge() {
		var node = get(MyNodeLabels.FountainYes.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.WalkToTavern.toString(), taverndoor, Icons.door, "Open Door");
		var nextNode = get(MyNodeLabels.TavernActions.toString());
		node.add(new Edge(choice1, nextNode));
	}
	@BuilderMethod //Joshua
	public void NoToBeggarEdge() {
		var node = get(MyNodeLabels.FountainNo.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.WalkToTavern.toString(), taverndoor, Icons.door, "Open Door");
		var nextNode = get(MyNodeLabels.TavernActions.toString());
		node.add(new Edge(choice1, nextNode));
	}
	@BuilderMethod //Joshua
	public void InTavernEdge() {
		var node = get(MyNodeLabels.TavernActions.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.SitInTavern.toString(), tavernstool, Icons.chair, "Sit");
		var nextNode1 = get(MyNodeLabels.TavernSit.toString());
		node.add(new Edge(choice1, nextNode1));
		var choice2 = new PlayerInteraction(MyChoiceLabels.WalkToDrunkard.toString(), drunkard, Icons.talk, "Talk to Drunkard");
		var nextNode2 = get(MyNodeLabels.ApproachDrunkard.toString());
		node.add(new Edge(choice2, nextNode2));
	}
	@BuilderMethod // Joshua
	public void TavernSitEdges() {
		var node = get(MyNodeLabels.TavernSit.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.IgnoreDrunkard.toString(), drunkard, Icons.talk, "Ignore Drunkard"); //May need Editing
		var nextNode1 = get(MyNodeLabels.IgnoreDrunkard.toString());
		node.add(new Edge(choice1, nextNode1));
		var choice2 = new PlayerInteraction(MyChoiceLabels.TalkToDrunkard.toString(), drunkard, Icons.talk, "Approach Drunkard");
		var nextNode2 = get(MyNodeLabels.ApproachDrunkard.toString());
		node.add(new Edge(choice2, nextNode2));
		
	}
	//Having Problems
	@BuilderMethod // Joshua
	public void TalkToDrunkard() {
		var node = get(MyNodeLabels.ApproachDrunkard.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.WakeDrunkard.toString(),drunkard, Icons.talk, "Wake Drunkard");
		var nextNode1 = get(MyNodeLabels.WakeDrunkard.toString());
		node.add(new Edge(choice1, nextNode1));
		var choice2 = new PlayerInteraction(MyChoiceLabels.RobDrunkard.toString(), drunkard, Icons.talk, "Rob Drunkard");
		var nextNode2 = get(MyNodeLabels.RobDrunkard.toString());
		node.add(new Edge(choice2, nextNode2));
		
	}
	@BuilderMethod //Joshua
	public void WakeDrunkardEdge() {
		var node = get(MyNodeLabels.WakeDrunkard.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.LeaveDrunkard.toString(), drunkard, Icons.talk, "Continue Drinking");
		var nextNode1 = get(MyNodeLabels.ContinueDrinking.toString());
		node.add(new Edge(choice1, nextNode1));
		var choice2 = new PlayerInteraction(MyChoiceLabels.PersistDrunkard.toString(), drunkard, Icons.talk, "Persists Drunkard");
		var nextNode2 = get(MyNodeLabels.PersistDrunkard.toString());
		node.add(new Edge(choice2, nextNode2));
	}
	@BuilderMethod //Joshua
	public void PersistDrunkardEdge() {
		var node = get(MyNodeLabels.PersistDrunkard.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.GoToBar.toString(), drunkard, Icons.talk, "Buy Drunkard A drink");
		var nextNode1 = get(MyNodeLabels.GoToBar.toString());
		node.add(new Edge(choice1, nextNode1));
	}
	@BuilderMethod //Joshua
	public void GoToBarEdge() {
		var node = get(MyNodeLabels.GoToBar.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.BuyDrink.toString(), bartender, Icons.coins, "Pay Bartender");
		var nextNode1 = get(MyNodeLabels.LeaveBar.toString());
		node.add(new Edge(choice1, nextNode1));
	}
	@BuilderMethod //Joshua
	public void LeaveBarEdge() {
		var node = get(MyNodeLabels.LeaveBar.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.LeaveTavern.toString(), taverndoor, Icons.door, "Exit Door");
		var nextNode1 = get(MyNodeLabels.TakeDrunkardHome.toString());
		node.add(new Edge(choice1, nextNode1));
	}
	@BuilderMethod //Joshua
	public void TakeDrunkardHomeEdge() {
		var node = get(MyNodeLabels.TakeDrunkardHome.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.DrunkardDoor.toString(), drunkardhousedoor, Icons.door, "Exit Door");
		var nextNode1 = get(MyNodeLabels.Conclusion.toString());
		node.add(new Edge(choice1, nextNode1));
	}
}