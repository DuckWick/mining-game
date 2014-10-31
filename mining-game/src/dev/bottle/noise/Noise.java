package dev.bottle.noise;

import java.util.Random;

public class Noise {
	
	float[][] points;
	Random rand;
	
	public Noise(Random rand,int width,int height)
	{
		this.rand=rand;
		this.points=new float[width][height];
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<height;j++)
			{
				this.points[i][j]=this.rand.nextFloat();
			}
		}
	}
	
	private float lerp(float a, float b, float c)
	{
		return (b-a)*c+a;
	}
	
	private float weight(float t)
	{
		return (3*t*t)-(2*t*t*t);
	}
	
	public float getArbitaryValue(float x,float y)
	{
		int px = (int)x;
		int py = (int)y;
		float q11 = points[px][py];
		float q12 = points[px][py+1];
		float q21 = points[px+1][py];
		float q22 = points[px+1][py+1];
		float lx1 = lerp(q11,q12,weight(x-px));
		float lx2 = lerp(q21,q22,weight(x-px));
		return lerp(lx1,lx2,weight(y-py));
	}

}
