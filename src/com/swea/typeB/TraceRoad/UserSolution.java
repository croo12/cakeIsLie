package com.swea.typeB.TraceRoad;

import java.util.HashMap;
import java.util.Map;

class UserSolution {
	
	Place[] pIds;
	Map<Long,int[]> lineMap;
	//9999 9999 19998 9999
	// r     c   r+c   r-c
	Map<Integer,int[]> userMap;
	
	void init() {
		pIds = new Place[50001];
		lineMap = new HashMap<>();
		userMap = new HashMap<>();
	}

	void addPlace(int pID, int r, int c) {
		pIds[pID] = new Place(pID, r,c);

		int[] tmp;
		long key = 0;
		
		for (int i = 0; i < 4; i++) {
			switch(i) {
			case 0 :
				key = r * 10000000000000L;
				break;
			case 1 :
				key = c * 1000000000L;
				break;
			case 2 :
				key = (r + c) * 10000;
				break;
			case 3 :
				key = (r - c);
				break;
			}
			
			tmp = lineMap.get(key);
			if(tmp == null) tmp = new int[10];
			
			for (int j = 0; j < 10; j++) {
				
			}
			
			int k = 0;
			while(pIds[tmp[k]] != null)
				k++;
			tmp[k] = pID;
			lineMap.put(key, tmp);
		}
	}

	void removePlace(int pID) {

	}

	void contactTracing(int uID, int visitNum, int moveInfo[], int visitList[]) {

	}

	void disinfectPlaces(int uID) {

	}
	
	class Place{
		Place[] link; 
		int r, c;
		int pId;
		boolean district;
		Place(int pId, int r, int c){
			this.pId = pId;
			this.r = r;
			this.c = c;
			link = new Place[8];
		}
	}
}