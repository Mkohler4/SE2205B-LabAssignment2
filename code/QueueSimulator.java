import java.lang.*;

public class QueueSimulator{
  public enum Event { ARRIVAL, DEPARTURE };
  private double currTime;
  private double arrivalRate;
  private double serviceTime;
  private double timeForNextArrival;
  private double timeForNextDeparture;
  private double totalSimTime;
  LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
  LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
  private Event e;
  
  public double getRandTime(double arrivalRate){
    double num, time1, max=1, min=0, randNUM;
    randNUM= Math.random();
    time1= (-1/arrivalRate) * (Math.log(1-randNUM));
    //System.out.println(time1);
    return time1;
  }
  
  public QueueSimulator(double aR, double servT, double simT){
      arrivalRate = aR;
      serviceTime = servT;
      totalSimTime = simT;
      currTime = 0;
      timeForNextArrival = getRandTime(arrivalRate);
      timeForNextDeparture = timeForNextArrival + serviceTime;
  }
  
  public double calcAverageWaitingTime(){
      double size = eventQueue.size();
      double time = 0;
      System.out.print(size);
      while(!eventQueue.isEmpty())
      {
          Data values = new Data();
          values = eventQueue.dequeue();
          time += values.getDepartureTime() - values.getArrivalTime();
      }
      return time/size;
  }
  
  public double runSimulation(){
      while(currTime < totalSimTime)
      {
          if(timeForNextArrival < timeForNextDeparture || buffer.isEmpty())
          {
              Data data = new Data();
              data.setArrivalTime(timeForNextArrival);
              buffer.enqueue(data);
              currTime += timeForNextArrival;
              timeForNextArrival  = timeForNextArrival + getRandTime(arrivalRate);
          }
          else
          {
            Data data = buffer.dequeue();
            data.setDepartureTime(timeForNextDeparture);
            eventQueue.enqueue(data);
            currTime = timeForNextDeparture;
            if(buffer.isEmpty())
            {
                timeForNextDeparture = timeForNextArrival + serviceTime;
            }
            else
            {
                timeForNextDeparture = timeForNextDeparture + serviceTime;
            }
          }
      }
      return calcAverageWaitingTime();
  }
}






