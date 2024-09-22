package myclassproject.mystorygraph;

import static myclassproject.questexample.QuestStoryEntities.*;



import java.util.List;
import com.actions.*;
import com.sequences.*;
import com.storygraph.*;
import com.entities.*;
import com.enums.*;
import com.communication.*;
import com.actions.utility.*;

import java.util.List;



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
//.add(new Face(bandit, player)).add(new Draw(bandit, sword))
    .add(new SetCameraFocus(doug))
    .add(new ShowMenu()));
}
@BuilderMethod //nararation sequence//
public void StartGame() {
	var node = get(NodeLabels.StartGame.toString());
	node.add(new HideMenu())
	.add(new NarrationSequence("This game is an open world game where you can visit multiple locations interact with people,"
+ " and accept quests. Your character is Doug Do Good. He has lived all his life as a peasant on a farm,"
+ " but has decided to leave his home in search for more adventure.")));
}
@BuilderMethod
public void atCityActions() {
	var node = get(NodeLabels.atCity.toString());
	node.add(new HideNarration()).add(new NarrationSequence("Inside the city square there are many places you can go to interact with objects and people./n")
	.add(new EnableInput()));
}
}
@BuilderMethod
public void merchantbillTalkActions() {
	var node = get(NodeLabels.merchantbillTalk.toString());
	node.add(new HideNarration()).add(new DialogSequence(doug, merchantbill, List.of("Greeting, I am Merchant Bill."
+ " I have no goods to sell you because I was vicously beaten and robbed by bandits."
+ " They stole by precious and valuable bag filled with items."
+ " I would do anything to get it back but I am just an old man who can not confront the bandits please help me."
+ " Would you be so kind to help me. You will be rewarded handsomely If you help me."),
			List.of("Accept Quest", "Decline Quest"))));
}
@BuilderMethod
public void acceptActions() {
	var node = get(NodeLabels.accept.toString());
	node.add(new HideDialog()).add(new Exit(doug, cityExit, boolean FadeOut));
}
@BuilderMethod //work on
public void atForestPathActions() {
	var node = get(NodeLabels.atForestPath.toString());
	node.add(new NarrationSequence("In the forest path you notice a well a bandit, a plant."))
	List.of("Confront the Bandit", "Ivestigate Well", "Investigate Plant")
	.add(new HideNarration());
}
@BuilderMethod
public void wellActions() {
	var node = get(NodeLabels.well.toString());
	node.add(new NarrationSequence("While at the well you discover a sword in the bottom of it."
+ " Pick up the sword, and confront the bandit.")).add(new HideNarration()).add(new Pickup(doug, sword));
}
@BuilderMethod 
public void BanditSwordActions() {
	var node = get(NodeLabels.BanditSword.toString());
	node.add(new DialogSequence(doug, bandit, List.of("I have a sword and I am not afraid yo use it. Are you really willing to die for this cargo?"),
			List.of("I have a sword and I am not afraid yo use it. Are you really willing to die for this cargo?"))
.add(new HideDialog()).add(new DialogSequence(bandit, doug,List.of("Bring it on"),List.of("Kill Bandit", "Retreat"))));
}
@BuilderMethod
public void KillBanditActions() {
	var node = get(NodeLabels.KillBandit.toString());
	node.add(new NarrationSequence("You swiftly murdered the gaurd with your sword, "
+ "but you have broken your morals you are no longer a good man."))
	.add(new HideNarration())
	.add(new Draw(doug, sword))
	.add(new Attack(doug, bandit))
	.add(new Die(bandit))
	.add(new Exit(doug, forestexit, true)); 
}
@BuilderMethod
public void RetreatActions() {
	var node = get(NodeLabels.Retreat.toString());
	node.add(new NarrationSequence("As Doug Do Good you have sworn to never harm anybody and you will not fold your morals for money. "
+ "Although you may not have gotten the poor old Merchant Bill's goods you still have your pride and morals."))
	.add(new HideNarration())
	.add(new Exit(doug, forestexit, true)) ; 
}
@BuilderMethod
public void  MerchantKill() {

}
@BuilderMethod
public void DeclineQuest() {
    var node = get(NodeLabels.DeclineQuest.toString());
    node.add(new DialogSequence(doug, merchantbill, List.of(
            "I have a sword and I am not afraid to use it. Are you really willing to die for this cargo?"), 
            List.of("Barrel"))
        .add(new HideDialog()));
}

@BuilderMethod
public void No() {
    var node = get(NodeLabels.No.toString());
    node.add(new NarrationSequence("You get thirsty and decide to go to the brown house door Tavern and have a drink.")
        .add(new HideNarration()))
        .add(new WalkTo(doug, city, "Tavern"))
        .add(new Enter(doug, taverndoor, true));
}

@BuilderMethod
public void ApproachDrunkard() {
    var node = get(NodeLabels.ApproachDrunkard.toString());
    node.add(new DialogSequence(doug, drunkard, List.of("Do you need any help? It looks like you are about to pass out."),List.of("Rob Drunkard")))
        .add(new HideDialog())
        .add(new NarrationSequence("The drunkard is wobbling and slurring his words."))
        .add(new HideNarration())
        .add(new DialogSequence(drunkard, doug, List.of("I, I don't need anythiiiii..."),List.of("Wake Drunkard")))
        .add(new Die(drunkard)) // The drunkard passes out, but revive will be used later to wake him.
        .add(new HideDialog())
        .add(new NarrationSequence("The drunkard has passed out. Do you rob the drunkard or wake him?"))
        .add((new HideNarration()));
}

@BuilderMethod
public void RobDrunkard() {
    var node = get(NodeLabels.RobDrunkard.toString());
    node.add(new Take(doug, coin, drunkard))
        .add(new NarrationSequence("With the drunkard's money in hand, you decide to buy another drink."))
        .add(new WalkTo(doug, tavernbar));
}



@BuilderMethod
public void WakeDrunkard() {
    var node = get(NodeLabels.WakeDrunkard.toString());
    node.add(new Clap(doug))
        .add(new Revive(drunkard)) //using revive as a way for drunkard to wake up
        .add(new NarrationSequence("Your claps have awoken the drunkard, but he is angry that you woke him."))
        .add(new HideNarration())
        .add(new DialogSequence(drunkard, doug, List.of("I, I, I'm not drunk. I'm stone cold sober. You are drunk, not me!"),List.of("Persist Drunkard or Ignore Drunkard")))
        .add(new HideDialog())
        .add(new NarrationSequence("You are beginning to feel frustrated with the drunkard. Will you persist in trying to help him?"))
        .add(new HideNarration());
}

@BuilderMethod 
public void PersistDrunkard() {
    var node = get(NodeLabels.PersistDrunkard.toString());
    node.add(new DialogSequence(doug, drunkard, List.of("I will buy you another drink if you promise to leave after."),List.of("Go to Bar"))
    	.add(new HideDialog())
        .add(new DialogSequence(drunkard, doug, List.of("I've never refused a free drink in my life. You got yourself a deal, Doug Do Good."),List.of("Go To Bar"))))
    	.add(new HideDialog());
}

			
			
	

@BuilderMethod
public void GoToBar() {
    var node = get(NodeLabels.GoToBar.toString());
    node.add(new WalkTo(doug, tavernbar))
        .add(new WalkTo(drunkard, tavernbar))
        .add(new Give(doug, coin, bartender))
        .add(new Give(bartender, bottle, drunkard))
        .add(new Drink(drunkard))
        .add(new DialogSequence(drunkard, doug, List.of("Thank you. I have had a hard time recently and really needed someone to help me and be kind. You are a good man. Can you help me get home?"),List.of("Take Drunkard Home")))
        .add(new HideDialog());
}

@BuilderMethod
public void TakeDrunkardHome() {
    var node = get(NodeLabels.TakeDrunkardHome.toString());
    node.add(new WalkTo(doug, taverndoor))
        .add(new WalkTo(drunkard, taverndoor))
        .add(new Exit(doug, taverndoor, true))
        .add(new Exit(drunkard, taverndoor, true))
        .add(new WalkTo(doug, city, "BrownHouseDoor"))
        .add(new WalkTo(drunkard, city,"BrownHouseDoor"))
        .add(new Enter(drunkard, drunkardhousedoor, true));
}
	

@BuilderMethod
public void Conclusion() {
    var node = get(NodeLabels.Conclusion.toString());
    node.add(new NarrationSequence("The drunkard sobered up the next day. He gratefully approached you and revealed that he was the king's brother. "
            + "He had recently found out that the king was searching for an heir to the throne but deemed him unfit to rule. "
            + "The drunkard took the news harshly, but your kindness saved him from spiraling down a dark path. "
            + "You were a good man and saved him. You win."))
    .add(new HideNarration());
}
	
			

