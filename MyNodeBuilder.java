package myclassproject.mystorygraph;

import static myclassproject.questexample.QuestStoryEntities.*;

import java.util.List;
import com.actions.*;
import com.sequences.*;
import com.storygraph.*;

public class QuestNodeBuilder extends NodeBuilder {
	public QuestNodeBuilder(List<Node> list) {
		super(list);





import java.util.List;

import com.actions.Draw;
import com.actions.EnableInput;
import com.actions.Face;
import com.actions.HideDialog;
import com.actions.HideMenu;
import com.actions.SetCameraFocus;
import com.actions.SetPosition;
import com.actions.ShowMenu;
import com.entities.Characters;
import com.entities.Furniture;
import com.entities.Item;
import com.entities.Place;
import com.enums.BodyTypes;
import com.enums.Clothing;
import com.enums.Colors;
import com.enums.FurnitureTypes;
import com.enums.HairStyle;
import com.enums.ItemTypes;
import com.enums.PlaceTypes;
import com.sequences.CreateAll;
import com.sequences.CreateCharacterSequence;
import com.sequences.DialogSequence;
import com.storygraph.*;
import com.sequences.NarrationSequence;
import com.actions.HideNarration;

import myclassproject.questexample.NodeLabels;
import myclassproject.questexample.ShowDialogue;

public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	@BuilderMethod
	public void rootActions() {
		//Example:
		var root = get(NodeLabels.root.toString());
		root.add(new CreateAll(List.of(city, tavern, forestpath, apple, sword, littorch, bottle, coin, hammer, bag))))
		.add(new CreateCharacterSequence(doug))
		.add(new CreateCharacterSequence(merchantbill))
		.add(new CreateCharacterSequence(bandit))
		.add(new CreateCharacterSequence(beggar))
		.add(new CreateChracterSequence(drunkard))
		.add(new CreateCharacterSequence(bartender))
		.add(new SetPosition(doug, city))
		.add(new SetPosition(bandit, forestpath, "DirtPile"))
		.add(new SetPosition(merchantbill, city, "Bench"))
		.add(new SetPosition(beggar, city, "Fountain"))
		.add(new SetPosition(drunkard, tavern, "BackRightStool"))
		.add(new SetPosition(bartender, tavern, "Bar"))
		//.add(new Face(bandit, player)).add(new Draw(bandit, sword))
		.add(new SetCameraFocus(doug))
		.add(new ShowMenu());
	
		
	@BuilderMethod
	public void StartGame() {
		var node = get(NodeLablels.StartGame.toString());
		node.add(HideMenu().add(new NarrationSequence("This game is an open world game where you can visit multiple locations interact with people,"
				+ " and accept quests. Your character is Doug Do Good. He has lived all his life as a peasant on a farm,"
				+ " but has decided to leave his home in search for more adventure."));
	}
				
	@BuilderMethod
	public void atCityActions() {
		var node = get(NodeLabels.atCity.toString());
		node.add(new HideNarration()).add(new NarrationSequence("Inside the city square there are many places you can go to interact with objects and people./n"
				+.add(new EnableInput());
	}
		
	}
	@BuilderMethod
	public void merchantbillTalkActions() {
		var node = get(NodeLabels.merchantbillTalk.toString());
		node.add(new HideNarration().add(new DialogSequence(player, merchantbill, List.of("Greeting, I am Merchant Bill."
				+ " I have no goods to sell you because I was vicously beaten and robbed by bandits."
				+ " They stole by precious and valuable bag filled with items."
				+ " I would do anything to get it back but I am just an old man who can not confront the bandits please help me."
				+ " Would you be so kind to help me. You will be rewarded handsomely If you help me."),
				List.of("Accept Quest", "Decline Quest")));
	}
	@BuilderMethod
	public void acceptActions() {
		var node = get
		
	}
	
}
	