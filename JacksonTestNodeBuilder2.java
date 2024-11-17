package myclassproject.testgraph;

import myclassproject.mystorygraph.MyNodeBuilder;
import myclassproject.mystorygraph.MyNodeLabels;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;

import com.actions.*;
import com.playerInput.MenuChoice;
import com.sequences.CreateAll;
import com.sequences.CreateCharacterSequence;
import com.sequences.DialogSequence;
import com.sequences.NarrationSequence;
import com.storygraph.*;

public class JacksonTestNodeBuilder2 extends MyNodeBuilder {
    public JacksonTestNodeBuilder2(List<Node> list) {
        super(list);
    }

    @Override
    @BuilderMethod
    public void rootActions() {
        var root = get(MyNodeLabels.root.toString());
        root.clearSequence();
        root.add(new CreateAll(List.of(city, tavern, forestpath, apple, sword, littorch, bottle, coin, hammer, bag)))
            .add(new CreateCharacterSequence(doug))
            .add(new CreateCharacterSequence(merchantbill))
            .add(new CreateCharacterSequence(bandit))
            .add(new CreateCharacterSequence(beggar))
            .add(new CreateCharacterSequence(drunkard))
            .add(new CreateCharacterSequence(bartender))
            .add(new SetPosition(doug, tavern))
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
    public void VisitTavernTable() {
        var node = get(MyNodeLabels.VisitTavernTable.toString());
        node.add(new HideMenu())
        	//.add(new WalkTo(doug, taverntable))
        	.add(new EnableInput())
            .add(new NarrationSequence("You know you are drunk and probably should not be playing with a torch but you have a strong desire to. Do you pick up the torch?"))
            .add(new Wait(3))
            .add(new HideNarration())
            .add(new DialogSequence(doug, doug, List.of("You see a torch flickering enticingly nearby."), List.of("Pick up the torch", "Do not pick up the torch")));
    }
}
