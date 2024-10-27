package myclassproject.mystorygraph;

import java.util.List;


import com.entities.IInteract;
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
	public void rootEdges() { //Dylan
		//Example:
		//var root = get(NodeLabels.root.toString());
		//var choice = new MenuChoice(MenuChoice.Options.Start);
		//var nextNode = get(NodeLabels.atCottage.toString());
		//root.add(new Edge(choice, nextNode));
		var root = get(MyNodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.StartGame.toString());
		root.add(new Edge(choice, nextNode));
		}
	
	@BuilderMethod
	public void StartGameEdges() { //Dylan
		var node = get(MyNodeLabels.StartGame.toString());
		var nextNode = get(MyNodeLabels.atCity.toString());
		var choice = new CloseNarrationChoice();
		node.add(new Edge(choice, nextNode));

	}

	
	
	@BuilderMethod
	public void atCityEdges() { //Dylan
		var node = get(MyNodeLabels.atCity.toString());
		var nextNode1 = get(MyNodeLabels.Barrell.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.InteractWithBarrell.toString(), MyStoryEntities.apple, Icons.apple, "Pick up apple");
		node.add(new Edge(choice1, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.merchantbillTalk.toString());
		var choice2 = new PlayerInteraction(MyChoiceLabels.TalkToMerchantBill.toString(), MyStoryEntities.merchantbill, Icons.talk, "Talk to Merchant Bill");
		node.add(new Edge(choice2, nextNode2));
	}
	
	@BuilderMethod
	public void BarrellEdges() { //Dylan
		var node = get(MyNodeLabels.Barrell.toString());
		var nextNode = get(MyNodeLabels.Fountain.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.InteractWithBeggar.toString(), MyStoryEntities.beggar, Icons.talk, "Talk to the beggar");
		node.add(new Edge(choice, nextNode));
		
	}
	

	
	@BuilderMethod
	public void TalkBeggarEdges() { //Dylan
		var node = get(MyNodeLabels.Fountain.toString());
		var nextNode1 = get(MyNodeLabels.FountainYes.toString());
		var choice1 = new DialogChoice("Yes, here's an apple");
		node.add(new Edge(choice1, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.FountainNo.toString());
		var choice2 = new DialogChoice("No, get a job you filthy beggar");
		node.add(new Edge(choice2, nextNode2));
		
	}

		
	
	@BuilderMethod
	public void MerchantBillInteractEdges() { //Dylan
		var node = get(MyNodeLabels.CityOpenWorld.toString());
		var nextNode = get(MyNodeLabels.merchantbillTalk.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToMerchantBill.toString(), MyStoryEntities.merchantbill, Icons.talk, "Talk to Merchant Bill");
		node.add(new Edge(choice, nextNode));
		
	}
	
	@BuilderMethod
	public void MerchantBillQuestEdges() { //Dylan
		var node = get(MyNodeLabels.merchantbillTalk.toString());
		var nextNode1 = get(MyNodeLabels.acceptActions.toString());
		var choice1 = new DialogChoice("Accept Quest");
		node.add(new Edge(choice1, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.DeclineQuest.toString());
		var choice2 = new DialogChoice("Decline Quest");
		node.add(new Edge(choice2, nextNode2));
	}
	
	@BuilderMethod
	public void DeclineQuestActionsEdges() { //Dylan
		var node = get(MyNodeLabels.DeclineQuest.toString());
		var nextNode = get(MyNodeLabels.Barrell.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.InteractWithBarrell.toString(), MyStoryEntities.apple, Icons.apple, "Pick up apple");
		node.add(new Edge(choice, nextNode));
		
	}
	
	@BuilderMethod
	public void AcceptQuestActionsEdges() { //Dylan
		var node = get(MyNodeLabels.merchantbillTalk.toString());
		var nextNode = get(MyNodeLabels.atForestPath.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.EnterForest.toString(), MyStoryEntities.cityExit, Icons.exit, "Leave city");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void ForestPathActionsEdges() { //Dylan
		var node = get(MyNodeLabels.atForestPath.toString());
		var nextNode1 = get(MyNodeLabels.ForestPlant.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.InteractWithForestPlant.toString(), MyStoryEntities.forestplant, Icons.plant, "Touch plant");
		node.add(new Edge(choice1, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.well.toString());
		var choice2 = new PlayerInteraction(MyChoiceLabels.InteractWithWell.toString(), MyStoryEntities.well, Icons.well, "Investigate well");
		node.add(new Edge(choice2, nextNode2));
		
		var nextNode3 = get(MyNodeLabels.ConfrontBandit.toString());
		var choice3 = new PlayerInteraction(MyChoiceLabels.NoSwordInteractWithBandit.toString(), MyStoryEntities.bandit, Icons.talk, "Confront Bandit");
		node.add(new Edge(choice3, nextNode3));
		
	}
	
	@BuilderMethod
	public void ForestPlantEdges() { //Dylan
		var node = get(MyNodeLabels.ForestPlant.toString());
		var nextNode = get(MyNodeLabels.well.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.InteractWithWell.toString(), MyStoryEntities.doug, Icons.well, "Investigate well");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void TalkToBanditEdges() { //Dylan
		var node = get(MyNodeLabels.well.toString());
		var nextNode = get(MyNodeLabels.BanditSword.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.InteractWithBandit.toString(), MyStoryEntities.bandit, Icons.talk, "Confront bandit");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void ConfrontBanditEdges() { //Dylan
		var node = get(MyNodeLabels.BanditSword.toString());
		var nextNode1 = get(MyNodeLabels.KillBandit.toString());
		var choice1 = new DialogChoice("Kill Bandit");
		node.add(new Edge(choice1, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.Retreat.toString());
		var choice2 = new DialogChoice("Retreat");
		node.add(new Edge(choice2, nextNode2));
		
	}
	
	@BuilderMethod
	public void KillBanditEdges() { //Dylan
		var node = get(MyNodeLabels.KillBandit.toString());
		var nextNode = get(MyNodeLabels.MerchantKill.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.ReturnToMerchant.toString(), MyStoryEntities.merchantbill, Icons.talk, "Talk to Merchant Bill");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void MerchantKillActionsEdges() { //Dylan
		var node = get(MyNodeLabels.MerchantKill.toString());
		var nextNode1 = get(MyNodeLabels.Interupt.toString());
		var choice1 = new DialogChoice("Interrupt");
		node.add(new Edge(choice1, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.Listen.toString());
		var choice2 = new DialogChoice("Listen");
		node.add(new Edge(choice2, nextNode2));
	}
	
	@BuilderMethod
	public void InterruptEdges() { //Dylan
		var node = get(MyNodeLabels.Interupt.toString());
		var nextNode = get(MyNodeLabels.Dungeon.toString());
		var choice = new DialogChoice("Dungeon");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void OpenDungeonDoorEdges() { //Dylan
		var node = get(MyNodeLabels.Interupt.toString());
		var nextNode = get(MyNodeLabels.Dungeon.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.InteractWithDungeonDoor.toString(), MyStoryEntities.dungeonDoor, Icons.door, "Enter dungeon");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void DungeonActionsEdges() { //Dylan
		var node = get(MyNodeLabels.Dungeon.toString());
		var nextNode = get(MyNodeLabels.EndGame.toString());
		var choice = new DialogChoice("Game Over");
		node.add(new Edge(choice, nextNode));
		
	}
	
	@BuilderMethod
	public void DungeonActionsEndGameEdges() { //Dylan
		var node = get(MyNodeLabels.EndGame.toString());
		var nextNode = get(MyNodeLabels.EndGame.toString());
		var choice = new MenuChoice(MenuChoice.Options.Quit);
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void ListenEdges() { //Dylan
		var node = get(MyNodeLabels.Listen.toString());
		var nextNode1 = get(MyNodeLabels.AcceptOffer.toString());
		var choice1 = new DialogChoice("Accept Offer");
		node.add(new Edge(choice1, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.DenyKing.toString());
		var choice2 = new DialogChoice("Decline Offer");
		node.add(new Edge(choice2, nextNode2));
		
	}
	
	@BuilderMethod
	public void DeclineOfferEdges() { //Dylan
		var node = get(MyNodeLabels.DenyKing.toString());
		var nextNode = get(MyNodeLabels.EndGame.toString());
		var choice = new DialogChoice("End Game");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void DeclineOfferEndGameEdges() { // Dylan
		//Killed bandit, offered to be king, declined
		var node =  get(MyNodeLabels.EndGame.toString());
		var nextNode = get(MyNodeLabels.EndGame.toString());//What is the last node?
		var choice = new MenuChoice(MenuChoice.Options.Quit);
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void AcceptOfferEdges() { //Dylan
		var node = get(MyNodeLabels.AcceptOffer.toString());
		var nextNode = get(MyNodeLabels.End.toString());
		var choice = new DialogChoice("End Game");
		node.add(new Edge(choice, nextNode));
		
	}
	
	@BuilderMethod
	public void AcceptOfferEndGameEdges() { //Dylan
		//Killed bandit, offered to be king, accepted
		var node = get(MyNodeLabels.End.toString());
		var nextNode = get(MyNodeLabels.End.toString());//What is the last node?
		var choice = new MenuChoice(MenuChoice.Options.Quit);
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void BanditRetreatInteractMerchantEdges() { //Dylan
		var node = get(MyNodeLabels.Retreat.toString());
		var nextNode = get(MyNodeLabels.MerchantRetreat.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.InteractWithMerchant.toString(), MyStoryEntities.merchantbill, Icons.talk, "Talk to Merchant Bill");
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RetreatReturnToMerchantEdges() { //Dylan
		//Is the previous node retreat?
		var node = get(MyNodeLabels.MerchantRetreat.toString());
		var nextNode1 = get(MyNodeLabels.AcceptKing.toString());
		var choice1 = new DialogChoice("I accept");
		node.add(new Edge(choice1, nextNode1));
		
		var nextNode2 = get(MyNodeLabels.Death.toString());
		var choice2 = new DialogChoice("I decline");
		node.add(new Edge(choice2, nextNode2));
	}
	
	@BuilderMethod
	public void RetreatAcceptKingEdges() { //Dylan
		var node = get(MyNodeLabels.AcceptKing.toString());
		var nextNode = get(MyNodeLabels.AcceptKing.toString()); //What is the last node?
		var choice = new MenuChoice(MenuChoice.Options.Quit);
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void RetreatDenyKingEdges() { //Dylan
		var node = get(MyNodeLabels.Death.toString()); //What is the last node?
		var nextNode = get(MyNodeLabels.Death.toString());
		var choice = new MenuChoice(MenuChoice.Options.Quit);
		node.add(new Edge(choice, nextNode)); 
	}
	
	
	
	@BuilderMethod
	public void NoSwordConfrontBanditEdges() { //Dylan
		var node = get(MyNodeLabels.ConfrontBandit.toString());
		var nextNode = get(MyNodeLabels.atForestPath.toString());
		var choice = new DialogChoice("No I am not");
		node.add(new Edge(choice, nextNode));
	}
	
	
}











