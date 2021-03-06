package dev.bottle.mining;

import dev.bottle.noise.Noise;

public class Chunk {
	
	Tile[][] tiles = new Tile[16][16];
	Noise noise;
	int cx,cy;
	public Chunk(Noise noise,float noiseScale,int cx, int cy)
	{
		this.noise=noise;
		this.cx=cx;
		this.cy=cy;
		for(int i=0;i<16;i++)
		{
			for(int j=0;j<16;j++)
			{
				float x = (cx+(i/16))/noiseScale;
				float y = (cy+(j/16))/noiseScale;
				int worldSpaceY=(int) (cy+y);
				float density = noise.getArbitaryValue(x,y);
				Tile tile = Tile.GRASS;
				if (worldSpaceY>1)
				{
					tile=Tile.DIRT;
				}
				if (worldSpaceY>100)
				{
					tile=Tile.STONE;
				}
				if (worldSpaceY>300)
				{
					tile=Tile.GRANITE;
				}
				if (worldSpaceY>600)
				{
					tile=Tile.OBSIDIAN;
				}
				if(worldSpaceY>1200)
				{
					tile=Tile.VOID;
				}
				if(density>0.5 && worldSpaceY<=1200)
				{
					tile=null;
				}
			}
		}
	}
	
	public Tile getTileAtWorldSpace(int x, int y)
	{
		return tiles[x][y];
	}

}
