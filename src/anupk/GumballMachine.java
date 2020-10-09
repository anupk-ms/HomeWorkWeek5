package anupk;

public class GumballMachine {
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	
	State state = soldOutState;
	int count = 0;
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		
		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}
	public void insertQuarter() {
		state.insertQuarter();
	}
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	void setState(State state) {
		this.state = state;
	}
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}
	int getCount() {
		return this.count;
	}
	
	public State getHasQuarterState() {
		// TODO Auto-generated method stub
		return this.hasQuarterState;
	}
	
	public State getNoQuarterState() {
		// TODO Auto-generated method stub
		return this.noQuarterState;
	}
	
	public State getWinnerState() {
		// TODO Auto-generated method stub
		return  this.winnerState;
	}
	
	public State getSoldState() {
		// TODO Auto-generated method stub
		return this.soldState;
	}
	
	public State getSoldOutState() {
		// TODO Auto-generated method stub
		return this.soldOutState;
	}
}