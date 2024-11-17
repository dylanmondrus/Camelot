package myclassproject.testgraph;
import myclassproject.mystorygraph.MyNodeBuilder;
import myclassproject.mystorygraph.MyNodeLabels;

import static myclassproject.mystorygraph.MyStoryEntities.*;


import java.util.List;

import com.actions.*;
import com.actions.FadeOut;
import com.actions.HideNarration;
import com.actions.LookAt;
import com.actions.SetCameraFocus;
import com.actions.SetPosition;
import com.actions.ShowMenu;
import com.actions.WalkTo;
import com.playerInput.MenuChoice;
import com.sequences.CreateAll;
import com.sequences.CreateCharacterSequence;
import com.sequences.NarrationSequence;
import com.storygraph.*;

public class JacksonTestNodeBuilder extends MyNodeBuilder {
	public JacksonTestNodeBuilder(List<Node> list) {
		super(list);
	}

	@Override
	@BuilderMethod
	public void rootActions() {
		var root = get(MyNodeLabels.root.toString());
		root.clearSequence();
		//root.add
		root.add(new CreateAll(List.of(city, tavern, forestpath, apple, sword, littorch, bottle, coin, hammer, bag)))
        .add(new CreateCharacterSequence(doug))
        .add(new CreateCharacterSequence(merchantbill))
        .add(new CreateCharacterSequence(bandit))
        .add(new CreateCharacterSequence(beggar))
        .add(new CreateCharacterSequence(drunkard))
        .add(new CreateCharacterSequence(bartender))
        .add(new SetPosition(doug, fireplace))
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
	public void GoToFireplace() {
	    var node = get(MyNodeLabels.GoToFireplace.toString()); // Ensure GoToFireplace is defined in MyNodeLabels
	    node.add(new HideMenu())
	        .add(new WalkTo(doug, fireplace))
	        .add(new LookAt(doug, fireplace))
	        .add(new Die(doug)) // Ensure "Die" is a valid action in your framework
	        .add(new NarrationSequence("While walking over to the fireplace you trip and fall into the fire because you are too drunk. You burn to death."))
	        .add(new Wait(10))
	        .add(new HideNarration())
	        .add(new FadeOut());
	}
}


