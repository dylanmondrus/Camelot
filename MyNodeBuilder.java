
package myclassproject.mystorygraph;

import static myclassproject.mystorygraph.MyStoryEntities.*;
import java.util.List;
import com.actions.*;
import com.sequences.*;
import com.storygraph.*;
import myclassproject.mystorygraph.MyNodeLabels;

public class MyNodeBuilder extends NodeBuilder {
    public MyNodeBuilder(List list) {
        super(list);
    }

    /**
     * Write a method for each node.
     * Use get to get a reference to the node using its label.
     * The method adds Camelot actions that execute in order when visiting that node.
     * These methods must have a BuilderMethod annotation.
     */
    @BuilderMethod
    // Jackson
    public void rootActions() {
        var root = get(MyNodeLabels.root.toString());
        root.add(new CreateAll(List.of(city, tavern, forestpath, apple, sword, littorch, bottle, coin, hammer, bag)))
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
            .add(new SetPosition(apple, city, "Barrel"))
            .add(new SetPosition(littorch, tavern, "RoundTable"))
            //.add(new Face(bandit, player))
            //.add(new Draw(bandit, sword))
            .add(new SetCameraFocus(doug))
            .add(new ShowMenu());
    }

    @BuilderMethod
    // Narration sequence // Jackson
    public void StartGame() {
        var node = get(MyNodeLabels.StartGame.toString());
        node.add(new HideMenu())
        .add(new NarrationSequence("This game is an open world game where you can visit multiple locations, interact with people, and accept quests."
        		+ " Your character is Doug Do Good. He has lived all his life as a peasant on a farm but has decided to leave his home in search for more adventure. "
        		+ "Inside the city square there are many places you can go to interact with objects and people."));
            
    }

    private Edge HideMenu() {
        // TODO Auto-generated method stub
        return null;
    }

    @BuilderMethod
    // Jackson
    public void atCity() {
        var node = get(MyNodeLabels.atCity.toString());
        node.add(new HideNarration())
        .add(new EnableInput());
        // .add(new MenuChoice(MenuChoice.Options))
    }

    @BuilderMethod
    public void Barrell() {
        // Dylan
        var node = get(MyNodeLabels.Barrell.toString());
        node.add(new WalkTo(doug, barrell))
            .add(new HideNarration())
            .add(new EnableInput())
            .add(new Pickup(doug, apple))
            .add(new Face(doug, fountain))
            .add(new DialogSequence(doug, beggar, List.of("At the barrell there is an apple. You pick them up but do not eat them. The lovely fountain captures your eye."), List.of("Fountain")));
    }

    @BuilderMethod
    public void Fountain() {
        // Dylan
        var node = get(MyNodeLabels.Fountain.toString());
        node.add (new HideDialog()).add(new WalkTo(doug, fountain))
            .add(new DialogSequence(doug, beggar, List.of("I'm so hungry, can I have your apples?"), List.of("Yes", "No")))
            .add(new HideDialog());
    }

    @BuilderMethod
    public void FountainYes() {
        // Dylan
        var node = get(MyNodeLabels.FountainYes.toString());
        node.add(new Give(doug, apple, beggar))
            .add(new DialogSequence(doug, beggar, List.of("She is so grateful for your kindness that she dances and recommends you go to the tavern at the red house door"), List.of("Tavern")))
            .add(new Dance(beggar))
            .add(new HideNarration());
    }

    @BuilderMethod
    public void TavernActions() {
        // Dylan
        var node = get(MyNodeLabels.TavernActions.toString());
        node.add(new WalkTo(doug, city, "RedHouseDoor"))
            .add(new FadeOut())
            .add(new Enter(doug, taverndoor, true))
            .add(new WalkTo(doug, drunkard))
            .add(new NarrationSequence("At the tavern there are empty chairs to sit in where you can drink. There is also a drunkard who looks like he has had too many drinks."))
            .add(new HideNarration())
            .add(new DialogSequence(doug, null, List.of(""), List.of("Sit", "Approach Drunkard")));
    }

    @BuilderMethod
    public void TavernSit() {
        // Dylan
        var node = get(MyNodeLabels.TavernSit.toString());
        node.add(new Sit(doug, tavernstool))
            .add(new Take(doug, bottle))
            .add(new Drink(doug))
            .add(new Sleep(drunkard, taverntable))
            .add(new NarrationSequence("You enjoy a beverage, but you can't help but notice the drunkard really needs help. Do you ignore him or do you help him?"))
            .add(new HideNarration())
            .add(new DialogSequence(doug, null, List.of(""), List.of("Ignore Drunkard", "Approach Drunkard")));
    }

    @BuilderMethod
    public void IgnoreDrunkard() {
        // Dylan
        var node = get(MyNodeLabels.IgnoreDrunkard.toString());
        node.add(new NarrationSequence("Your thirst is still strong so you continue drinking"))
            .add(new Drink(doug))
            .add(new HideNarration())
            .add(new DialogSequence(doug, null, List.of(""), List.of("Continue Drinking")));
    }

    @BuilderMethod
    public void ContinueDrinking() {
        // Dylan
        var node = get(MyNodeLabels.ContinueDrinking.toString());
        node.add(new Laugh(doug))
            .add(new Face(doug, fireplace))
            .add(new NarrationSequence("You start to get drunk and the fire catches your attention. Do you go to the fireplace and watch or do you go to the torch that is on the table?"))
            .add(new HideNarration())
            .add(new DialogSequence(doug, null, List.of(""), List.of("Table", "Fireplace")));
    }

    @BuilderMethod
    public void VisitTavernTable() {
        // Dylan
        var node = get(MyNodeLabels.VisitTavernTable.toString());
        node.add(new HideDialog())
        	//.add(new WalkTo(doug, taverntable))
        	.add(new EnableInput())
            .add(new NarrationSequence("You know you are drunk and probably should not be playing with a torch but you have a strong desire to. Do you pick up the torch?"))
            .add(new Wait(3))
            .add(new HideNarration())
            .add(new EnableInput())
            .add(new DialogSequence(doug, doug, List.of("You see a torch flickering enticingly nearby."), List.of("Pick up the torch", "Do not pick up the torch")));
    }

    @BuilderMethod
    public void PickupTorch() {
        // Dylan
        var node = get(MyNodeLabels.PickupTorch.toString());
        node.add(new EnableInput()).add(new Pickup(doug, littorch))
            .add(new NarrationSequence("Your motor skills have been severely compromised and you drop the torch and the tavern begins to set fire. You can hardly move and you burn to death with the drunkard you ignored."))
            .add(new HideNarration())
            .add(new Die(doug));
        // put burning visual effect
        node.add(new DialogSequence(doug, null, List.of(""), List.of("Burned to death")));
    }

    @BuilderMethod
    public void BurnedToDeath() {
        // Dylan
        var node = get(MyNodeLabels.BurnedToDeath.toString());
        node.add(new NarrationSequence("You let drinking and risky behavior take priority over being a good man. You and an innocent drunkard died because of your foolish actions."))
            .add(new HideNarration())
            .add(new FadeOut());
    }

    @BuilderMethod
    public void DontPickupTorch() {
        // Dylan
        var node = get(MyNodeLabels.DontPickupTorch.toString());
        node.add(new NarrationSequence("You are still caught up on the fireplace and you want to look at it. You walk over to the fireplace"))
            .add(new HideNarration())
            .add(new WalkTo(doug, fireplace));
    }

    @BuilderMethod
    public void GoToFireplace() {
        // Dylan
        var node = get(MyNodeLabels.GoToFireplace.toString());
        node.add(new WalkTo(doug, fireplace))
            .add(new LookAt(doug, fireplace))
            .add(new Die(doug))
            .add(new NarrationSequence("While walking over to the fireplace you trip and fall into the fire because you are too drunk. You burn to death."))
            .add(new Wait(10))
            .add(new HideNarration())
            .add(new FadeOut());
    }





@BuilderMethod // Joshua
public void merchantbillTalkActions() {
	var node = get(MyNodeLabels.merchantbillTalk.toString());
	node.add(new WalkTo(doug, merchantbill))
	.add(new HideNarration()).add(new EnableInput())
	.add(new DialogSequence(doug, merchantbill, List.of("Greeting, I am Merchant Bill."
			+ " I have no goods to sell you because I was vicously beaten and robbed by bandits."
			+ " They stole by precious and valuable bag filled with items."
			+ " I would do anything to get it back but I am just an old man who can not confront the bandits please help me."
			+ " Would you be so kind to help me. You will be rewarded handsomely If you help me."),
			List.of("Accept Quest", "Decline Quest")));
}
@BuilderMethod //Joshua
public void acceptActions() {
	var node = get(MyNodeLabels.acceptActions.toString());
	node.add(new WalkTo(doug, cityExit)).add(new HideDialog()).add(new EnableInput()).add(new Exit(doug, cityExit, true));
	
}
@BuilderMethod //Joshua
public void atForestPathActions() {
	var node = get(MyNodeLabels.atForestPath.toString());
	node.add(new FadeIn())
	.add(new NarrationSequence("In the forest path you notice a well a Bandit, a plant."));
}


@BuilderMethod // Joshua
public void ConfrontBanditActions() {
	var node = get(MyNodeLabels.ConfrontBandit.toString());
	node.add(new HideNarration()).add(new WalkTo(doug,bandit)).add(new EnableInput()).add(new NarrationSequence("When you confront the bandit and ask for the merchants stolen cargo he threatens you with a hammer."))
	.add(new Draw(bandit,hammer))
	.add(new DialogSequence(bandit, doug, List.of("Are you willing to get your brains smashed out for this cargo?"), List.of("No I am not")));
}
	
@BuilderMethod // Joshua 
public void ForestPlantActions() {
	var node = get(MyNodeLabels.ForestPlant.toString());
	node.add(new HideNarration()).add(new Kneel(doug)).add(new NarrationSequence("You are amazed by the plant and get distracted for a moment "
	+ "but you refocus on the mission at hand"))
	.add(new WalkTo( doug, well));
	
}
@BuilderMethod //Joshua
public void wellActions() {
	var node = get(MyNodeLabels.well.toString());
	node.add(new HideNarration()).add(new NarrationSequence("While at the well you discover a sword in the bottom of it."
			+ " Pick up the sword, and confront the bandit.")).add(new EnableInput()).add(new Pickup(doug, sword))
	.add(new WalkTo(doug,bandit));
}
@BuilderMethod  //Joshua
public void BanditSwordActions() {
	var node = get(MyNodeLabels.BanditSword.toString());
	node.add(new HideNarration()).add(new DialogSequence(doug, bandit, List.of("I have a sword and I am not afraid yo use it. Are you really willing to die for this cargo?"),
	List.of("I have a sword and I am not afraid yo use it. Are you really willing to die for this cargo?"))
	.add(new HideDialog()).add(new DialogSequence(bandit, doug,List.of("Bring it on"),List.of("Kill Bandit", "Retreat"))));
	
}
@BuilderMethod //Joshua
public void KillBanditActions() {
	var node = get(MyNodeLabels.KillBandit.toString());
	node.add(new NarrationSequence("You swiftly murdered the gaurd with your sword, and take the cargo, "
	+ "but you have broken your morals you are no longer a good man."))
	.add(new HideNarration())
	.add(new Draw(doug, sword))
	.add(new Attack(doug, bandit))
	.add(new Die(bandit))
	.add(new Take(doug, bag))
	.add(new WalkTo(doug, forestexit))
	.add(new Exit(doug, forestexit, true));	
}
@BuilderMethod //Joshua
public void RetreatActions() {
var node = get(MyNodeLabels.Retreat.toString());
node.add(new FadeIn())
.add(new NarrationSequence("As Doug Do Good you have sworn to never harm anybody and you will not fold your morals for money. "
+ "Although you may not have gotten the poor old Merchant Bill's goods you still have your pride and morals."))
.add(new FadeOut()).add(new WalkTo(doug, forestexit))
.add(new Exit(doug, forestexit, true));
}

@BuilderMethod //Joshua
public void MerchantRetreatActions() {
	var node = get(MyNodeLabels.MerchantRetreat.toString());
	node.add(new HideDialog())
	.add(new FadeIn()).add(new WalkTo(doug, merchantbill))
	.add(new DialogSequence(doug, merchantbill, List.of("I have failed to retrieve your cargo because I did not want to kill the bandit"), List.of("Return to City"))
	.add(new DialogSequence(merchantbill, doug, List.of("It is ok Dan Do Good. I am the king and I have no heirs to my throne."
	+ " I posed as a beggar merchant in need to see who has a kind enough heart to rule the city. "
	+ "I appoint you Dan Do Good as the heir to my throne lead well my friend. "
	+ "A good king can not fold on their morals and I see that you will not"), List.of("I accpet", "I dont"))));
}
@BuilderMethod// Joshua Start working here
public void AcceptKingActions() {
	var node = get(MyNodeLabels.AcceptKing.toString());
	node.add(new Die(doug));
}
@BuilderMethod// Joshua
public void DeathActions() {
	var node = get(MyNodeLabels.Death.toString());
	node.add(new HideDialog())
	.add(new NarrationSequence("You are remeber as being to kind to be king."
	+ " You die a good man and that is all that ever mattered to you"))
	.add(new FadeOut())
	.add(new CreditsSequence("Thank you for playing our game!//n"
	+ "Contributors: Joshua Burch, Jackson Burch, Joshua Burch"));
}
@BuilderMethod//Joshua
public void DenyKingActions() {
	var node = get(MyNodeLabels.DenyKing.toString());
	node.add(new DialogSequence(doug, merchantbill, List.of("I'm sorry, but I can not rule I am afraid"
	+ " that the power would change me and force me"
	+ " to make hard decisions that may force me to harm others"), List.of("End Game")));
}
@BuilderMethod // Joshua 
public void EndGameActions() {
	var node = get(MyNodeLabels.EndGame.toString());
	node.add(new HideDialog())
	.add(new NarrationSequence("Although you are not king you are still a good man"
	+ " and that is all that has ever mattered to you."))
	.add(new HideNarration())
	.add(new FadeOut())
	.add(new NarrationSequence("You Win"))
	.add(new HideNarration())
	.add(new CreditsSequence("Thank you for playing our game!/n"
	+ "Contributors: Joshua Burch, Jackson Burch, Joshua Burch"));
}
	

	

@BuilderMethod //Joshua
public void  MerchantKillActions() {
var node = get(MyNodeLabels.MerchantKill.toString());
node.add(new FadeIn())
.add(new NarrationSequence("You return to Merchant Bill and return his cargo.")
.add(new WalkTo(doug,merchantbill))
.add(new Give(doug,bag,merchantbill))
.add(new DialogSequence(merchantbill, doug, List.of("Thank you for retriving my cargo"
+ " you have the urge to interupt him and confess that you killed Bandit."),
List.of("Interupt", "Listen"))));

}

@BuilderMethod //Joshua
public void InetruptActions() {
	var node = get(MyNodeLabels.Interupt.toString());
	node.add(new HideNarration())
	.add(new NarrationSequence("You confess to killing the bandit")
	.add(new DialogSequence(merchantbill, doug, List.of("I posed as the a beggar Merchant to see if I could find an heir"
	+ " to my throne since i have none. You have failed me Doug Do Good."
	+ " As king I must punish you for murder. You will be sentenced to life locked in the dungeon."),
	List.of("Dungeon"))).add(new WalkTo(doug,dungeonDoor)).add(new Exit(doug, dungeonDoor, true)));
}
@BuilderMethod //Joshua
public void ListenActions() {
	var node = get(MyNodeLabels.Listen.toString());
	node.add(new HideNarration())
	.add(new HideDialog())
	.add(new FadeIn())
	.add(new DialogSequence(merchantbill, doug, List.of("Doug Do Good I am the king and I have no heirs to my throne."
	+ " I posed as a beggar merchant in need to see who has a kind enough heart to rule the city."
	+ " I appoint you Dan Do Good as the heir to my throne lead well my friend. "
	+ "A good king can not fold on their morals and I see that you will not"), List.of("Accept Offer", "Decine Offer")));
}
@BuilderMethod // Joshua --> roll credits
public void AcceptOfferActions() {
	var node = get(MyNodeLabels.AcceptOffer.toString());
	node.add(new HideDialog())
	.add(new NarrationSequence("The power got to your head and you were known as being a ruthless leader."
	+ " You were cruel to your people and vicious on the battle field. "
	+ "After you killed the Bandit your morals were compromised and you were blood thirsty."
	+ " You died doing what you loved, killing in the battle field."))
	.add(new Die(doug));
	
}
@BuilderMethod // Joshua --> Fade Credits
public void EndActions() {
	var node = get(MyNodeLabels.End.toString());
	node.add(new HideNarration())
	.add(new NarrationSequence("Although you became king you changed your morals changed and you were no longer a good man.\n"
	+ "You lose")).add(new FadeOut()).add(new CreditsSequence("Thank you for playing our game!//n"
			+ "Contributors: Joshua Burch, Jackson Burch, Joshua Burch"));
}
@BuilderMethod // Joshua
public void DungeonActions() {
	var node = get (MyNodeLabels.Dungeon.toString());
	node.add(new HideNarration())
	.add(new NarrationSequence("In prison you think of that day and how you killed that man. "
	+ "It is all that you think about, it haunts you. "
	+ "You die in prison knowing that you are a bad man"))
	.add(new Die(doug));
}
@BuilderMethod // Joshua
public void EndingActions() {
	var node = get(MyNodeLabels.Ending.toString());
	node.add(new HideNarration())
	.add(new NarrationSequence("You folded your morals and became a bad man.\n"
	+ "You lose")).add(new FadeOut())
	.add(new CreditsSequence("Thank you for playing our game!/n"
	+ "Contributors: Joshua Burch, Jackson Burch, Joshua Burch"));
}
//Jacksons Work Downward
@BuilderMethod
public void DeclineQuest() {
    var node = get(MyNodeLabels.DeclineQuest.toString());
    node.add(new DialogSequence(doug, merchantbill, List.of(
            "I have a sword and I am not afraid to use it. Are you really willing to die for this cargo?"), 
            List.of("Barrel"))
        .add(new HideDialog()));
}
@BuilderMethod
public void FountainNo() {
    var node = get(MyNodeLabels.FountainNo.toString());
    node.add(new NarrationSequence("You get thirsty and decide to go to the brown house door Tavern and have a drink.")
        .add(new HideNarration()))
        .add(new WalkTo(doug, city, "Tavern"))
        .add(new Enter(doug, taverndoor, true));
}
@BuilderMethod
public void ApproachDrunkard() {
    var node = get(MyNodeLabels.ApproachDrunkard.toString());
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
    var node = get(MyNodeLabels.RobDrunkard.toString());
    node.add(new Take(doug, coin, drunkard))
        .add(new NarrationSequence("With the drunkard's money in hand, you decide to buy another drink."))
        .add(new WalkTo(doug, tavernbar));
}
@BuilderMethod//Confuesed
public void WakeDrunkard() {
    var node = get(MyNodeLabels.WakeDrunkard.toString());
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
    var node = get(MyNodeLabels.PersistDrunkard.toString());
    node.add(new DialogSequence(doug, drunkard, List.of("I will buy you another drink if you promise to leave after."),List.of("Go to Bar"))
    	.add(new HideDialog())
        .add(new DialogSequence(drunkard, doug, List.of("I've never refused a free drink in my life. You got yourself a deal, Doug Do Good."),List.of("Go To Bar"))));
}
			
			
	
@BuilderMethod
public void GoToBar() {
    var node = get(MyNodeLabels.GoToBar.toString());
    node.add(new HideDialog())
    .add(new WalkTo(doug, tavernbar))
        .add(new WalkTo(drunkard, tavernbar))
        .add(new Give(doug, coin, bartender))
        .add(new Give(bartender, bottle, drunkard))
        .add(new Drink(drunkard))
        .add(new DialogSequence(drunkard, doug, List.of("Thank you. I have had a hard time recently and really needed someone to help me and be kind. You are a good man. Can you help me get home?"),List.of("Take Drunkard Home")));
}
@BuilderMethod
public void TakeDrunkardHome() {
    var node = get(MyNodeLabels.TakeDrunkardHome.toString());
    node.add(new WalkTo(doug, drunkardhousedoor))
        .add(new WalkTo(drunkard, drunkardhousedoor))
        .add(new Exit(drunkard, drunkardhousedoor, true));
}
@BuilderMethod
public void LeaveBar() {
	var node = get(MyNodeLabels.LeaveBar.toString());
	node.add(new HideDialog())
	.add(new WalkTo(doug, taverndoor))
    .add(new WalkTo(drunkard, taverndoor))
    .add(new Exit(doug, taverndoor, true))
    .add(new Exit(drunkard, taverndoor, true))
    .add(new Enter(doug,taverndoor, true))
	.add(new Enter(drunkard,taverndoor, true));
}
	
@BuilderMethod
public void Conclusion() {
    var node = get(MyNodeLabels.Conclusion.toString());
    node.add(new NarrationSequence("The drunkard sobered up the next day. He gratefully approached you and revealed that he was the king's brother. "
            + "He had recently found out that the king was searching for an heir to the throne but deemed him unfit to rule. "
            + "The drunkard took the news harshly, but your kindness saved him from spiraling down a dark path. "
            + "You were a good man and saved him. You win."))
    .add(new HideNarration());
}
}
