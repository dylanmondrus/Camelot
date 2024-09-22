package myclassproject.mystorygraph;

import static myclassproject.questexample.QuestStoryEntities.*;



import java.util.List;
import com.actions.*;
import com.sequences.*;
import com.storygraph.*;

import myclassproject.questexample.NodeLabels;

import com.entities.*;
import com.enums.*;
import com.playerInput.MenuChoice;
import com.playerInput.*;
import com.communication.*;
import com.actions.utility.*;






public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}
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
	root.add(new CreateAll(List.of(city, tavern, forestpath, apple, sword, littorch, bottle, coin, hammer, bag))
	.add(new CreateCharacterSequence(doug))
	.add(new CreateCharacterSequence(merchantbill))
	.add(new CreateCharacterSequence(bandit))
	.add(new CreateCharacterSequence(beggar))
	.add(new CreateCharacterSequence(drunkard))
	.add(new CreateCharacterSequence(bartender))
	.add(new SetPosition(doug, city))
	.add(new SetPosition(bandit, forestpath, "DirtPile"))
	.add(new SetPosition(merchantbill, city, "Bench"))
	.add(new SetPosition(beggar, city, "Fountain"))
	.add(new SetPosition(drunkard, tavern, "BackRightStool"))
	.add(new SetPosition(bartender, tavern, "Bar"))
	.add(new SetPosition(bottle, tavern, "Table"))
	.add(new SetPosition(apple, city, "Barrell"))
	.add(new SetPosition(littorch, tavern, "RoundTable" ))
	//.add(new Face(bandit, player)).add(new Draw(bandit, sword))
	.add(new SetCameraFocus(doug))
	.add(new ShowMenu()));
}
	
@BuilderMethod //narration sequence//
public void StartGame() {
	var node = get(NodeLabels.StartGame.toString());
	node.add(new HideMenu()).add(new NarrationSequence("This game is an open world game"
			+ " where you can visit multiple locations, interact with people,"
			+ " and accept quests. Your character is Doug Do Good. He has lived"
			+ " all his life as a peasant on a farm but has decided to leave his home "
			+ "in search for more adventure."))
	.add(new HideNarration());
	List.of("City Navigation");
	
}


private Edge HideMenu() {
	// TODO Auto-generated method stub
	return null;

}
@BuilderMethod
public void atCityActions() {
	var node = get(NodeLabels.atCity.toString());
	node.add(new HideNarration())
	.add(new NarrationSequence("Inside the city square there are many places you can go to interact with objects and people./n"))
	.add(new HideNarration())
	.add(new EnableInput());
	//.add(new MenuChoice(MenuChoice.Options))
	List.of("Talk to Merchant Bill", "Barrell");
	
}

@BuilderMethod
public void Barrell() { //Dylan
	var node = get(NodeLabels.Barrell.toString());
	node.add(new WalkTo(doug, barrell))
	.add(new NarrationSequence("At the barrell there is an apple. "
			+ "You pick them up but do not eat them. The lovely fountain captures your eye."))
	.add(new HideNarration())
	.add(new EnableInput())
	.add(new Pickup(doug, apple))
	.add(new Face(doug, fountain));
	List.of("Fountain");
}

@BuilderMethod
public void Fountain() { //Dylan
	var node = get(NodeLabels.Fountain.toString());
	node.add(new WalkTo(doug, fountain))
	.add(new DialogSequence(doug, beggar, List.of("I'm so hungry, can I have your apples?"),
			List.of("Yes", "No")))
	.add(new HideDialog());
	
}

@BuilderMethod
public void FountainYes() { //Dylan
	var node = get(NodeLabels.FountainYes.toString());
	node.add(new Give(doug, apple, beggar))
	.add(new NarrationSequence("She is so grateful for your kindness "
			+ " that she dances and reccommends you go to the tavern at the red house door"))
	.add(new Dance(beggar))
	.add(new HideNarration());
	List.of("Tavern");
}

@BuilderMethod
public void TavernActions() { //Dylan
	var node = get(NodeLabels.TavernActions.toString());
	node.add(new WalkTo(doug, city, "RedHouseDoor"))
	.add(new FadeOut())
	.add(new Enter(doug, taverndoor, true))
	.add(new WalkTo(doug, drunkard))
	.add(new NarrationSequence("At the tavern there are empty chairs to sit in"
			+ " where you can drink. There is also a drunkard who looks like"
			+ " he has had too many drinks."))
	.add(new HideNarration());
	List.of("Sit, Approach Drunkard");
}

@BuilderMethod
public void TavernSit() { //Dylan
	var node = get(NodeLabels.TavernSit.toString());
	node.add(new Sit(doug, tavernstool))
	.add(new Take(doug, bottle))
	.add(new Drink(doug))
	.add(new Sleep(drunkard, taverntable))
	.add(new NarrationSequence("You enjoy a beverage, "
			+ "but you can't help but notice the drunkard really needs help."
			+ " Do you ignore him or do you help him?"))
	.add(new HideNarration());
	List.of("Ignore Drunkard", "Approach Drunkard");
}

@BuilderMethod
public void IgnoreDrunkard() { //Dylan
	var node = get(NodeLabels.IgnoreDrunkard.toString());
	node.add(new NarrationSequence("Your thrist is still strong so you continue drinking"))
	.add(new Drink(doug))
	.add(new HideNarration());
	List.of("Continue drinking");
}

@BuilderMethod
public void ContinueDrinking() { //Dylan
	var node = get(NodeLabels.ContinueDrinking.toString());
	node.add(new Laugh(doug))
	.add(new Face(doug, fireplace))
	.add(new NarrationSequence("You start to get drunk and the fire catches your attention."
			+ "Do you go to the fireplace and watch or do you go to the "
			+ "torch that is on the table?"))
	.add(new HideNarration())
	List.of("Table,", "Fireplace");
}

@BuilderMethod
public void VisitTavernTable() { //Dylan
	var node = get(NodeLabels.VisitTavernTable.toString());
	node.add(new WalkTo(doug, taverntable))
	.add(new NarrationSequence("You know you are drunk and probably"
			+ "should not be playing with a torch but you have a strong desire to. "
			+ "Do you pick up the torch?"))
	.add(new HideNarration());
	List.of("Pickup torch", "Do not pickup torch");
}


@BuilderMethod
public void PickupTorch() { //Dylan
	var node = get(NodeLabels.PickupTorch.toString());
	node.add(new Pickup(doug, littorch))
	.add(new NarrationSequence("Your motor skills have been severely compromised and "
			+ "you drop the torch and the tavern begins to set fire. "
			+ "You can hardly move and you burn to death with the drunkard you ignored."))
	.add(new HideNarration())
	.add(new Die(doug));
	//put burning visual effect
	List.of("Burned to death");
}

@BuilderMethod
public void BurnedToDeath() {//Dylan
	var node = get(NodeLabels.BurnedToDeath.toString());
	node.add(new NarrationSequence("You let drinking and risky behavior take priority over"
			+ " being a good man. You and an innocent drunkard died because of your foolish "
			+ "actions."))
	.add(new HideNarration())
	.add(new FadeOut());
}

@BuilderMethod
public void DontPickupTorch() { //Dylan
	var node = get(NodeLabels.DontPickupTorch.toString());
	node.add(new NarrationSequence("You are still caught up on the fireplace"
			+ "and you want to look at it. You walk over to the fireplace"))
	.add(new HideNarration())
	.add(new WalkTo(doug, fireplace));
}
	
@BuilderMethod
public void GoToFireplace() { //Dylan
	var node = get(NodeLabels.GoToFireplace.toString());
	node.add(new WalkTo(doug, fireplace))
	.add(new LookAt(doug, fireplace))
	.add(new Die(doug))
	.add(new NarrationSequence("While walking over to the fireplace you trip "
			+ "and fall into the fire because you are too drunk. You burn"
			+ "to death"))
	.add(new HideNarration())
	.add(new FadeOut());
}



}

