package assignment3;
//@author Irene Mutamuliza


import java.util.*;
import java.util.ArrayList;
import java.util.Random;
public class TrafficSystem {
	
	public static void main(String[] args) throws InterruptedException {
		
		// create a random instance that will generate random cars
		Random car = new Random();

		// declare an array list to store the cars
		ArrayList < Integer >  carqueue= new ArrayList < Integer > ();
		
	
		// Iteration for the traffic ad traffic lights
		while (true) {
			//Red light
			// it will take 20 seconds
			System.out.println("RED");
			// timer instance to control the light
			Timer mytimer = new Timer();
			int begin = 0;
			int timeInterval = 1000;
			mytimer.schedule(new TimerTask() {
				int count = 0;
				@Override
				public void run() {
					//a loop to add new cars to the queue
					for (int i = 1; i <= 20; i++) {
						if (carqueue.size() != 100) {
							carqueue.add(car.nextInt(21));
						} else {
							break;
						}
						if (i == 20 || carqueue.size() == 100){
							System.out.println("> " + i + " cars have been added to the Queue");
						}
					};
					count++;
					if (count == 1) {
						mytimer.cancel();
					}
				}
			}, begin, timeInterval);
			// red light will last 20 seconds=20000 milliseconds
			Thread.sleep(20000);
			// here we check if there are still cars in the queue if not, we stop the program
			if (carqueue.size() == 0) {
				break;
			}

			//Yellow light
			System.out.println("YELLOW");
			// for yellow light 1 car leaves after 2 seconds
			// timer instance to control the light
			Timer yourtimer = new Timer();
			int start = 0;
			int yellowInterval = 2000;
			yourtimer.schedule(new TimerTask() {
				int count = 0;
				@Override
				public void run() {
					//remove the first car in queue
					// if there are still cars in the queue we cancel
					if (carqueue.size() == 0) {
						yourtimer.cancel();
					} else {
						int pass = carqueue.get(0);
						carqueue.remove(0);
						System.out.println("Car " + pass + " passed");
						count++;
						// the reason we check it against 5 times is because only 5 cars can move every 2 seconds within 10 seconds
						if (count == 5) {
							yourtimer.cancel();
						}
					}
				}
			}, start, yellowInterval);
			// red light will last 10 seconds=10000 milliseconds
			Thread.sleep(10000);
			// check for cars in the queue if not break
			if (carqueue.size() == 0) {
				break;
			}

			// Green light
			System.out.println("GREEN");
			// for green light 1 car leaves after 1 second
			Timer thetimer = new Timer();
			int commence = 0;
			int greenInterval = 1000;
			thetimer.schedule(new TimerTask() {
				int count = 0;
				@Override
				public void run() {
					//remove the first car in queue
					// check for cars in the queue if not cancel
					if (carqueue.size() == 0) {
						thetimer.cancel();
					} else {
						int pass = carqueue.get(0);
						carqueue.remove(0);
						System.out.println("Car " + pass + " passed");
						count++;
						
						if (count == 30) {
							thetimer.cancel();
						}
					}

				}
			}, commence, greenInterval);
			// 30 seconds for green
			Thread.sleep(30000);
			// check for cars in the queue if not break
			if (carqueue.size() == 0) {
				break;
			}

		}
		System.out.println("no more cars in the queue!");
	}
}

