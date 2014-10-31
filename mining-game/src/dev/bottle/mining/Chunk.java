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
				float density = noise.getArbitaryValue(x,y);
			}
		}
	}
	
	public Tile getTileAtWorldSpace(int x, int y)
	{
		return tiles[x][y];
	}

}
