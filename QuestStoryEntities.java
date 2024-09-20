package myclassproject.questexample;

import java.awt.Color;

import com.entities.*;
import com.enums.*;

public final class QuestStoryEntities {
	public static final Characters doug = new Characters("Doug", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	public static final Characters bandit = new Characters("Bandit", BodyTypes.F, Clothing.Bandit, HairStyle.Bald, Colors.Black, 4);
	public static final Place city = new Place("City", PlaceTypes.City);
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Furniture cottageDoor = new Furniture(cottage, FurnitureTypes.Door);
	public static final Furniture table = new Furniture(cottage, FurnitureTypes.Table);
	public static final Furniture chair = new Furniture(cottage, FurnitureTypes.Chair);
	public static final Furniture cityDoor = new Furniture(town, FurnitureTypes.RedHouseDoor);
	public static final Furniture cityExit = new Furniture(town, FurnitureTypes.NorthEnd);
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
	
	





}
