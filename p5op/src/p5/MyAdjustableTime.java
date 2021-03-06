package p5;

import p5.exc.IllegalArgumentException;
import p5.interf.*;

public class MyAdjustableTime extends DefaultObservableProperty<Integer> implements AdjustableTime, PropertyObserver<Integer>{
	
	public MyAdjustableTime(Integer value) throws IllegalArgumentException{
		super(value);
		if(value < 0) throw new IllegalArgumentException();
	}
	
	@Override
	/**
	 * If the incremented value is not smaller than 0, increments value and notify observers
	 * @param inc the increment of the value
	 */
	public void incrementTime(int inc) throws IllegalArgumentException {
		Integer oldValue = super.value.orElse(0);
		Integer	newValue = oldValue + inc;
		if (newValue < 0){
			throw new IllegalArgumentException();
		}
		super.setValue(newValue);		
	}

	@Override
	/**
	 * The observer behaviour to a change is incrementing its value with the same inc as its observable property
	 * @param property the property that has changed
	 * @param oldValue 
	 */
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
		Integer inc = property.getValue() - oldValue;
		this.incrementTime(inc);
	}
	
	@Override
	public String toString(){
		return "" + super.value.orElse(0);
	}
	
	/**
	 * As MyAdjustableTime is observer and observed, when it is added as an observer, it has to increment its value as a property
	 * @param o
	 */
	public void addObserver( MyAdjustableTime o){
		super.addObserver(o);
		o.incrementTime(this.getValue());
	}
	/**
	 * As MyAdjustableTime is observer and observed, when it is removed as an observer, it has to decrement its value as a property
	 * @param o the PropertyObserver to remove
	 */
	public void removeObserver(MyAdjustableTime o){
		super.removeObserver(o);
		o.incrementTime(-1*this.getValue());
	}

}
