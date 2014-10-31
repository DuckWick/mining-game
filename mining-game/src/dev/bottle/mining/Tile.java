package dev.bottle.mining;

import java.awt.image.BufferedImage;

public class Tile {
	
	public static final Tile GRASS = new Tile(0);
	public static final Tile DIRT = new Tile(1).setReactant(3,2);
	public static final Tile STONE = new Tile(3).setReactant(5,4);
	public static final Tile GRANITE = new Tile(5).setReactant(7,6);
	public static final Tile OBSIDIAN = new Tile(7).setReactant(9,8);
	public static final Tile VOID = new Tile(9);
	
	int tileTexture,reactant,product=-1;
	
	public Tile(int tileTexture)
	{
		this.tileTexture=tileTexture;
	}
	
	public Tile setReactant(int reactant,int product)
	{
		this.reactant=reactant;
		this.product=product;
		return this;
	}
	
	public BufferedImage getTileTexture(BufferedImage tileset,Tile reactant)
	{
		int texture=reactant!=null &&  reactant.tileTexture==this.reactant?this.product:this.tileTexture;
		return tileset.getSubimage((texture%16)*32,(int)(texture/16)*32,32,32);
	}

}
