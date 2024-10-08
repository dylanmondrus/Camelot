package myclassproject.questexample;

import com.entities.*;
import com.enums.*;

public final class QuestStoryEntities {
	public static final Characters doug = new Characters("Doug", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 1);
	public static final Characters bandit = new Characters("Bandit", BodyTypes.F, Clothing.Bandit, HairStyle.Bald, Colors.Black, 1);
	public static final Characters beggar = new Characters("Beggar", BodyTypes.A, Clothing.Peasant, HairStyle.Long, Colors.Brown, 1);
	public static final Characters drunkard = new Characters("Drunkard", BodyTypes.D, Clothing.Peasant, HairStyle.Short_Full, Colors.Red, 1);
	public static final Characters merchantbill = new Characters("Merchant Bill", BodyTypes.D, Clothing.Merchant, HairStyle.Spiky, Colors.Gray, 1);
	public static final Characters bartender = new Characters("Bartender", BodyTypes.B, Clothing.Noble, HairStyle.Short_Full, Colors.Blonde, 1);
	public static final Place city = new Place("Town", PlaceTypes.City);
	public static final Place tavern = new Place("Tavern", PlaceTypes.Tavern);
	public static final Place forestpath = new Place("Forest Path", PlaceTypes.ForestPath);
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Item apple = new Item("Apple", ItemTypes.Apple);
	public static final Item bag = new Item("Bag", ItemTypes.Apple);
	public static final Item littorch = new Item("Lit Torch", ItemTypes.LitTorch);
	public static final Item bottle = new Item("Beer", ItemTypes.Bottle);
	public static final Item hammer = new Item("Hammer", ItemTypes.Hammer);
	public static final Item coin = new Item("Coins", ItemTypes.Coin);
	public static final Furniture taverndoor = new Furniture(city, FurnitureTypes.RedHouseDoor);
	public static final Furniture cityExit = new Furniture(city, FurnitureTypes.NorthEnd);
	public static final Furniture forestexit = new Furniture(forestpath, FurnitureTypes.EastEnd);
	public static final Place dungeon = new Place("Dungeon", PlaceTypes.Dungeon);
	public static final Furniture dungeonDoor = new Furniture(city, FurnitureTypes.BlueHouseDoor);
	public static final Furniture well = new Furniture(forestpath, FurnitureTypes.Well);
	public static final Furniture fountain = new Furniture(city, FurnitureTypes.Fountain);
	public static final Furniture barrell = new Furniture(city, FurnitureTypes.Barrel);
	public static final Furniture tavernstool = new Furniture(tavern, FurnitureTypes.FrontLeftStool);
	public static final Furniture taverntable = new Furniture(tavern, FurnitureTypes.Table);
	public static final Furniture fireplace = new Furniture(tavern, FurnitureTypes.Fireplace);
	public static final Furniture roundtable = new Furniture(tavern, FurnitureTypes.RoundTable);
	public static final Furniture redhousedoor = new Furniture(city, FurnitureTypes.RedHouseDoor);
	public static final Furniture tavernbar = new Furniture(tavern, FurnitureTypes.Bar);
	public static final Place drunkardhouse = new Place("Drunkard's House",PlaceTypes.Cottage);
	public static final Furniture drunkardhousedoor = new Furniture(drunkardhouse, FurnitureTypes.BrownHouseDoor);
}
