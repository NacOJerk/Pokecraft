package com.kirelcodes.pokecraft.pathfinder;

public abstract class BasicPathfinder {
	private boolean isRunning = false;
	/**
	 * When this method returns true the pathFinder would start working
	 * 
	 * @return
	 */
	public abstract boolean shouldStart();

	/**
	 * By default this method returns the shouldStart Once it returns false the
	 * pathFinder goes on the waiting list agian
	 * 
	 * @return
	 */
	public boolean keepWorking() {
		return shouldStart();
	}

	/**
	 * This method is called once the path finding process starts
	 */
	public void onStart() {
	}

	/**
	 * Called after each time the update task method is called Could be used to
	 * create delays for example
	 */
	public void afterTask() {
	}

	/**
	 * Called every tick Basically the most important task
	 */
	public abstract void updateTask();

	/**
	 * Basically if the path finder should be the last one running and the one
	 * setting the navagation
	 * 
	 * @return
	 */
	public boolean canBeInterrupted() {
		return true;
	}
	public boolean isRunning(){
		return isRunning;
	}
	public void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
}
