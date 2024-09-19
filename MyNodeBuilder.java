package myclassproject.mystorygraph;

import static myclassproject.questexample.QuestStoryEntities.bandit;
import static myclassproject.questexample.QuestStoryEntities.cottage;
import static myclassproject.questexample.QuestStoryEntities.player;
import static myclassproject.questexample.QuestStoryEntities.sword;
import static myclassproject.questexample.QuestStoryEntities.town;

import java.util.List;

import com.actions.Draw;
import com.actions.EnableInput;
import com.actions.Face;
import com.actions.HideMenu;
import com.actions.SetCameraFocus;
import com.actions.SetPosition;
import com.actions.ShowMenu;
import com.sequences.CreateAll;
import com.sequences.CreateCharacterSequence;
import com.storygraph.*;

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
		root.add(new CreateAll(List.of(city, tavern, forestPath, Apple, Sword, litTorch, bottle, coin, hammer, bag))))
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
	public void atCityActions() {
		var node = get(NodeLabels.atCity.toString());
		node.add(new HideMenu()).add(new EnableInput());
	
		
	}
}
	
	
