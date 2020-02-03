/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frank Basile
 */
public class Shift implements Comparable<Shift>
{
    private int [] week = new int[7];
    private final int [] days = new int[14];
    private String name;
    
    //single input constructor (for the rotator subclass to reference)
    public Shift(String shiftName)
    {
        name = shiftName;
    }
    
    //takes in array of 1's and 0's to reference working days & name of shift
    public Shift(int [] dayBinaries, String shiftName)
    {
        week = dayBinaries;
        name = shiftName;  
        buildDays();
    }
    
    //builds two week array from single week input
        private void buildDays()
    {
        System.arraycopy(week, 0, days, 0, 7); //first week
        System.arraycopy(week, 0, days, 7, 7); //second week
    }
    
    //returns 1 or 0 depending if scheduled to work that day
    public int workingInquiry(int workQuery)
    {
        return days[workQuery];
    }
    
    //returns entire array of 1's and 0's for work schedule
    public int [] workSchedule()
    {
        return days;
    }
    
    //returns name of shift
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public int compareTo(Shift other)
    {
        return name.compareTo(other.getName());
    }
    
    @Override
    //returns string representation of shift
    public String toString()
    {
        return name;// + " shift = " + Arrays.toString(days) + "\n";
    }       
}
