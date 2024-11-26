package myclassproject.main;

import com.storygraph.Story;

import myclassproject.mystorygraph.MyChoiceLabels;
import myclassproject.mystorygraph.MyEdgeBuilder;
import myclassproject.mystorygraph.MyGraph;
import myclassproject.mystorygraph.MyNodeBuilder;
import myclassproject.mystorygraph.MyNodeLabels;
import myclassproject.mystorygraph.MyStoryEntities;
import myclassproject.testgraph.DylanEdgeBuilder;
import myclassproject.testgraph.DylanNodeBuilder;
import myclassproject.testgraph.DylanTestGraph;
import myclassproject.testgraph.DylanEdgeBuilder2;
import myclassproject.testgraph.DylanNodeBuilder2;












public class MainClass {

	//This is the start of your program
	public static void main(String[] args) {
		//Create an object of your story class.
		var story = new Story();
		//Simply call run.
		story.Run(new MyGraph());
	}

}
