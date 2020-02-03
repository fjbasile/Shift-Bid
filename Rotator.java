/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frank Basile
 */
public class Rotator extends Shift
{
    private final Shift shiftOne;
    private final Shift shiftTwo;
    private final String name;
    private final int [] days = new int[14];

    //constructor takes in two shifts and the name of new shift
    public Rotator(Shift firstShift, Shift secondShift, String shiftName)
    {
        super(shiftName); //shift name is passed to Shift constructor
        shiftOne = firstShift;
        shiftTwo = secondShift;
        name = shiftName;
        buildDays();
    }
    
    //builds array by merging working days of two shifts input to constructor
    private void buildDays()
    {
        System.arraycopy(shiftOne.workSchedule(), 0, days, 0, 7); //first week
        System.arraycopy(shiftTwo.workSchedule(), 0, days, 7, 7); //second week
    }

    
    @Override
    //returns string representation of shift
    public String toString()
    {
        return name;// + " shift = " + Arrays.toString(days) + "\n";
    }
    
    
}
