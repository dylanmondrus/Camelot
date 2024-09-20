package myclassproject.mystorygraph;

import static myclassproject.questexample.QuestStoryEntities.bandit;
import static myclassproject.questexample.QuestStoryEntities.city
import static myclassproject.questexample.QuestStoryEntities.cottage;
import static myclassproject.questexample.QuestStoryEntities.player;
import static myclassproject.questexample.QuestStoryEntities.sword;
import static myclassproject.questexample.QuestStoryEntities.town;

import java.util.List;

import com.actions.Draw;
import com.actions.EnableInput;
import com.actions.Face;
import com.actions.HideMenu;
import com.actions.HideDialog;
import com.actions.SetCameraFocus;
import com.actions.SetPosition;
import com.actions.ShowMenu;
import com.actions.utility.ShowDialog;
import com.sequences.CreateAll;
import com.sequences.CreateCharacterSequence;
import com.sequences.DialogSequence;
import com.storygraph.*;
import com.sequence.NarrationSequence;
import com.actions.HideNarration;



import myclassproject.questexample.NodeLabels;

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
		root.add(new CreateAll(List.of(city, tavern, forestPath, apple, sword, litTorch, bottle, coin, hammer, bag))))
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
		

	}
	@BuilderMethod
	public startGame() {
		var node = get(NodeLabels.startGame.toString());
		node.add(new HideMenu().add(new NarrationSequence("In this game you can visit multiple locations,"
				+ " interact with people, and accept quests. Your character is"
				+ " Doug Do Good. He has lived all his life as a peasant on a "
				+ "farm, but has decided to leave his home in search for more"
				+ " adventure. All his life he has lived as a good man. Your"
				+ " goal is to remain a good man."));
	}
	
	@BuilderMethod
	public void atCityActions() {
		var node = get(NodeLabels.atCity.toString());
		node.add(new HideDialog()).add(new HideMenu()).add(new EnableInput())
		.add(new ShowDialog("Inside the city square there are many places "
				+ "you can go and visit people to talk to."));
	}
	
	@BuilderMethod
	public void MerchantBillTalkActions() {
		var node = get(NodeLabels.MerchantBillTalk.toString());
		node.add(new DialogSequence(doug, merchantbill, List.of("Greeting, I am Merchant Bill. "
				+ "I have no goods to sell you because I was vicously beaten and robbed by a bandits."
				+ " They stole my precious and valuable bag filled with items. I would do anything to"
				+ " get it back, but I am just an old man who can not confront the bandits. Would you be"
				+ " so kind to help me. You will be rewarded handsomely If you help me."),
				List.of("Accept Quest!", "Decline Quest")));
	}
		
	
	@BuilderMethod
	public void acceptActions() {
		var node = get()
	}
	
}
	
	
	
	
	
	
	
	
