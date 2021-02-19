// 13707293
// robertjohnhill1@gmail.com


import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Chess {

	public static abstract class ChessPiece
	{
		private int locX, locY;

		ChessPiece( int x, int y )
		{
			locX = x;
			locY = y;
		}

		int getX()
		{
			return locX;
		}

		int getY()
		{
			return locY;
		}

		abstract boolean canAttack( ChessPiece p );
	}

	public static class King extends ChessPiece
	{
		King( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int xx = this.getX();
			int yy = this.getY();
			Boolean res = false;
			int[][] attack_sqs = new int[][]{{xx-1, yy-1}, {xx-1, yy}, {xx-1, yy+1}, {xx, yy-1}, {xx, yy+1}, {xx+1, yy+1}, {xx+1, yy}, {xx+1, yy-1}};
			int[] np = new int[]{p.getX(), p.getY()};
			for (int[] thing : attack_sqs){
				if (np[0] == thing[0] & np[1] == thing[1]){
					res = true;
				}
			}
			return res;
		}
	}


	public static class Bishop extends ChessPiece
	{
		Bishop( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int xx = this.getX();
			int yy = this.getY();

			if (Math.abs(xx - p.getX()) == Math.abs(yy - p.getY())){
				return true;
		}
			else {
				return false;
		}
		}

	}

	public static class Rook extends ChessPiece
	{
		Rook( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int xx = this.getX();
			int yy = this.getY();

			if (xx == p.getX() || yy == p.getY()){
				return true;
			}
			else{
				return false;
			}

		}		
	}

	public static class Queen extends ChessPiece
	{
		Queen( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int xx = this.getX();
			int yy = this.getY();

			if (xx == p.getX() || yy == p.getY() || Math.abs(xx - p.getX()) == Math.abs(yy - p.getY())){
			return true;
			}
			else{
				return false;
			}

		}
	}

	public static class Knight extends ChessPiece
	{
		Knight( int x, int y )
		{
			super( x, y );
		}
		boolean canAttack( ChessPiece p )
		{
			int xx = this.getX();
			int yy = this.getY();
			int px = p.getX();
			int py = p.getY();
			Boolean res = false;
			int[] x_sqs = {2, 1, -1, -2, -2, -1, 1, 2};
			int[] y_sqs = {1, 2, 2, 1, -1, -2, -2, -1};
			for (int i = 0; i <= 7; i++){
				if ((xx + x_sqs[i]) == px & yy + y_sqs[i] == py){
					res = true;
					break;
				}
				else{
					res = false;
				}
			}
			return res;

		}
	}


	public static void main(String[] args) { 

		// sample use of the classes
		ChessPiece a = new Bishop(4,7);
		ChessPiece b = new Queen(2,5);
		System.out.println( a.canAttack(b));

	}
}