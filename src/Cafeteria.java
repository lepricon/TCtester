public class Cafeteria {

	String latestTime(int[] offset, int[] walkingTime, int[] drivingTime) {
		int targetTime = 870; //in minutes
		int N = offset.length;
		int latestStart = 0;
		for (int i = 0; i < N; i++) {
			int latestBusStart = targetTime - drivingTime[i];
			if ((latestBusStart%60)%10 != offset[i]) {
				latestBusStart = latestBusStart - (latestBusStart%60)%10 - 10 + offset[i]; 
			}
			if (latestStart < latestBusStart - walkingTime[i]) {
				latestStart = latestBusStart - walkingTime[i];
			}
		}
		String result = "";
		if (latestStart/60 < 13) {
			result += String.valueOf(latestStart/60);
		}
		else {
			result += "0" + String.valueOf(latestStart/60 - 12);
		}
		if (latestStart%60 < 10) {
			result += ":0" + String.valueOf(latestStart%60);	
		}
		else {
			result += ":" + String.valueOf(latestStart%60);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Cafeteria cf = new Cafeteria();
		int[] offset      ={7,4,0,0,2,1,6,7,7,0,8,6,0,5,0,6,7,9,0,2,4,8,4,7,9,2,4,4,3,1,4,5,8,8,2,5,7,8,7,5,6,8,8,0,1,3,5,0,8};
		int[] walkingTime ={26,14,1,4,16,28,16,6,4,5,21,18,5,2,21,21,28,22,5,22,26,16,14,19,19,19,4,12,24,4,30,16,28,20,25,2,30,18,4,6,9,22,8,3,7,29,8,30,6};
		int[] drivingTime ={151,264,280,89,63,57,15,120,28,296,76,269,90,106,31,222,291,52,102,73,140,248,44,187,76,49,296,106,54,119,54,283,263,285,275,127,108,82,84,241,169,203,244,256,109,288,9,262,103};
			
		System.out.println(cf.latestTime(offset, walkingTime, drivingTime));
	}
}
