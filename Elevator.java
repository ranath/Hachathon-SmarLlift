import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements ElevatorFactory {
  private Integer currentFloor;
  private Integer ID;
  private Queue<Integer> destinationFloors;

  public Elevator(Integer number, Integer currentFloor) {
	this.ID = number;
    this.currentFloor = currentFloor;
    this.destinationFloors = new LinkedList<Integer>();
  }

  public int nextDestionation(){
    return this.destinationFloors.peek();
  }

  public Queue<Integer> destinationFloors(){
	    return this.destinationFloors;
	  }
  
  public int number() {
	  return this.ID;
  }
  public int currentFloor(){
    return this.currentFloor;
  }

  public void popDestination(){
    this.destinationFloors.remove();
  }
  @Override
  public void addNewDestinatoin(Integer destination) {
    this.destinationFloors.add(destination);
  }

  @Override
  public void moveUp() {
    currentFloor++;
  }

  @Override
  public void moveDown() {
    currentFloor--;
  }

  @Override
  public ElevatorDirection direction() {
    if (destinationFloors.size() > 0){
      if (currentFloor < destinationFloors.peek()){
        return ElevatorDirection.ELEVATOR_UP;
      } else if (currentFloor > destinationFloors.peek()) {
        return ElevatorDirection.ELEVATOR_DOWN;
      }
    }
    return ElevatorDirection.ELEVATOR_HOLD;
  }

  @Override
  public ElevatorStatus status() {
    return (destinationFloors.size() > 0)?ElevatorStatus.ELEVATOR_OCCUPIED:ElevatorStatus.ELEVATOR_EMPTY;
  }
  
  public static void main(String[] args) {
      System.out.println("evevator simulator !"); // Display the string.
  }
  
}
