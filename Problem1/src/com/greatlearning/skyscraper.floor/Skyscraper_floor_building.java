package com.greatlearning.skyscraper.floor;
import com.greatlearning.floorsorting.FloorSorting;
import java.util.Stack;
import java.util.Objects;
import java.util.Scanner;

public class Skyscraper_floor_building {
	private int floors_num = 0;
	private int[] daywise_floorsize, sorting_floor_size;
	private Stack<Integer> creating_floor_stack;
	Scanner sc = new Scanner(System.in);
	
	public void skyscraper_implementation() {
		// let's enter the floor size in the building
		System.out.println("enter the total no of floors in the building");
		floors_num = sc.nextInt();

		// initialize the array for the floor size entered for every day
		daywise_floorsize = new int[floors_num];

		// get the size of the floor per day
		functionFloorSizePerDay();
		sc.close();

		// store the sorted floor size per day 
		storingSortedFloorSize();

		// Store the floor size in stack for future requirements
		storingFloorSizeInStack();

		// The function to display the floor has been constructed till this day
		displayingConstructedFloors();
	}
	
	// function to get the size of the floor per day
	private void functionFloorSizePerDay() {
		for (int i = 0; i < floors_num; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			daywise_floorsize[i] = sc.nextInt();
			}
		}

		// we need to store floor size entered per day in ascending order
	private void storingSortedFloorSize() {
		sorting_floor_size = daywise_floorsize.clone();
		FloorSorting.sort(sorting_floor_size, 0, sorting_floor_size.length - 1);
		}

	// let's define a function to store the size of floors in a stack
		// floor when needed
	private void storingFloorSizeInStack() {
		creating_floor_stack = new Stack<>();
			for (int size : sorting_floor_size) {
				creating_floor_stack.push(size);
			}
		}

	// check for size of floors of each day 
	private void displayingConstructedFloors() {
			System.out.println("The order of construction is as follows");
			Stack<Integer> creating_temp_stack = new Stack<>();
			for (int i = 0; i < floors_num; i++) {
				System.out.println("Day " + (i + 1));
				int floorSizeOfTheDay = daywise_floorsize[i];

				int largest_floor_size = creating_floor_stack.peek();
				if (floorSizeOfTheDay != largest_floor_size) {
					creating_temp_stack.push(floorSizeOfTheDay);
				} else {
					System.out.print(creating_floor_stack.pop() + " ");
					while (!creating_temp_stack.isEmpty() && Objects.equals(creating_floor_stack.peek(), creating_temp_stack.peek())) {
						System.out.print(creating_floor_stack.pop() + " ");
						creating_temp_stack.pop();
					}
				}
				System.out.println();
			}
		}
		

}

