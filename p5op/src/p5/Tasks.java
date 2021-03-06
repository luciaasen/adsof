package p5;

import java.util.HashMap;
import p5.exc.*;
import java.util.Iterator;
import java.util.Map;


public class Tasks {
	private static HashMap<String,Task> tasks= new HashMap<String,Task>();
	
	private static Tasks sTasks;
	
	public static Tasks getTasksSingleton(){
		if (Tasks.sTasks==null){
			Tasks.sTasks= new Tasks();
		}
		
		return Tasks.sTasks;
	}
	
	private Tasks(){}
	
	
	
	
	public int estimatedTotal(){
		int res=0;
		Iterator iter = tasks.entrySet().iterator();
		while (iter.hasNext()) {
		    Map.Entry mEntry = (Map.Entry) iter.next();
		    res=res+((Task)mEntry).getEstimated().getValue();
		}
		return res;
	}
	
	public int dedivatedTotal(){
		int res=0;
		Iterator iter = tasks.entrySet().iterator();
		while (iter.hasNext()) {
		    Map.Entry mEntry = (Map.Entry) iter.next();
		    res=res+((Task)mEntry).getDedicated().getValue();
		}
		return res;
	}
	
	/**
	 * If it doesnt exist yet, adds a new task to the Tasks
	 * @param taskName name of the new task
	 * @return t the new task
	 * @throws p5.exc.IllegalArgumentException
	 */
	public static Task newTask(String taskName) throws p5.exc.IllegalArgumentException{
		Task t = new Task(taskName);
		if(Tasks.contains(t)) throw new p5.exc.IllegalArgumentException();
		Tasks.tasks.put(t.getName(), t);
		return t;
	}
	
	/**
	 * Another task adder that receives a task instead of a name, to make easier the tester
	 * @param t the task to add
	 * @return the added task
	 * @throws p5.exc.IllegalArgumentException when the task was already contained
	 */
	public static Task newTask(Task t) throws p5.exc.IllegalArgumentException{
		if(Tasks.contains(t)) throw new p5.exc.IllegalArgumentException();
		Tasks.tasks.put(t.getName(), t);
		return t;
	}
	public static Task getTask(String name){
		Iterator iter = tasks.entrySet().iterator();
		while (iter.hasNext()) {
		    Map.Entry mEntry = (Map.Entry) iter.next();
		    if(mEntry.getKey().equals(name)){
		    	return (Task) mEntry.getValue();
		    }
		}
		return null;
	}
	
	public static Iterator getTasks(){
		Iterator iter = tasks.entrySet().iterator();
		return iter;
	}
	
	public static boolean contains(Task t){
		return Tasks.tasks.values().contains(t);
	}
}
