package myclassproject.mystorygraph;

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

public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	public static final Characters doug = new Characters("Doug", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	public static final Characters bandit = new Characters("Bandit", BodyTypes.F, Clothing.Bandit, HairStyle.Bald, Colors.Black, 4);
	public static final Place city = new Place("City", PlaceTypes.City);
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Characters beggar = new Characters("Beggar", BodyTypes.A, Clothing.Peasant, HairStyle.Long, Colors.Brown, 1);
	public static final Characters drunkard = new Characters("Drunkard", BodyTypes.D, Clothing.Peasant, HairStyle.Short_Full, Colors.Red, 1);
	public static final Characters merchantbill = new Characters("Merchant Bill", BodyTypes.B, Clothing.Merchant, HairStyle.Spiky, Colors.Gray, 1);
	public static final Characters bartender = new Characters("Bartender", BodyTypes.B, Clothing.Noble, HairStyle.Short_Full, Colors.Blonde, 1);
	public static final Place tavern = new Place("Tavern", PlaceTypes.Tavern);
	public static final Place forestpath = new Place("Forest Path", PlaceTypes.ForestPath);
	public static final Item apple = new Item("Apple", ItemTypes.Apple);
	public static final Item bottle = new Item("Beer", ItemTypes.Bottle);
	public static final Item bag = new Item("Bag", ItemTypes.Bag);
	public static final Item coin = new Item("Coin", ItemTypes.Coin);
	public static final Item littorch = new Item("Lit Torch", ItemTypes.LitTorch);
	public static final Item hammer = new Item("Hammer", ItemTypes.Hammer);
	public static final Furniture taverndoor = new Furniture(city, FurnitureTypes.RedHouseDoor);
	public static final Furniture cityExit = new Furniture(city, FurnitureTypes.NorthEnd);
	public static final Furniture forestexit = new Furniture(forestpath, FurnitureTypes.EastEnd);
	public static final Place dungeon = new Place("Dungeon", PlaceTypes.Dungeon);
	public static final Furniture fountain = new Furniture(city, FurnitureTypes.Fountain);
	public static final Furniture barrell = new Furniture(city, FurnitureTypes.Barrel);
	public static final Furniture tavernstool = new Furniture(tavern, FurnitureTypes.FrontLeftStool);
	public static final Furniture taverntable = new Furniture(tavern, FurnitureTypes.Table);
	public static final Furniture fireplace = new Furniture(tavern, FurnitureTypes.Fireplace);
	public static final Furniture roundtable = new Furniture(tavern, FurnitureTypes.RoundTable);
	public static final Furniture redhousedoor = new Furniture(city, FurnitureTypes.RedHouseDoor);
	//public static final Furniture cottageDoor = new Furniture(cottage, FurnitureTypes.Door);
	//public static final Furniture table = new Furniture(cottage, FurnitureTypes.Table);
	public static final Furniture dungeonDoor = new Furniture(city, FurnitureTypes.BlueHouseDoor);
	public static final Furniture well = new Furniture(forestpath, FurnitureTypes.Well);
	public static final Furniture tavernbar = new Furniture(tavern, FurnitureTypes.Bar);
	public static final Place drunkardhouse = new Place("Drunkard's House",PlaceTypes.Cottage);
	public static final Furniture drunkardhousedoor = new Furniture(drunkardhouse, FurnitureTypes.BrownHouseDoor);
}