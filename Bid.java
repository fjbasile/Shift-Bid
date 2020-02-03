/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Frank
 */
public class Bid
{
    private final Shift [] shifts;
    private final int size;
    private int fitnessScore;
    
    int [] h_array = {0,1,1,1,1,0,0};
    int [] e_array = {0,0,1,1,1,1,0};
    int [] d_array = {0,0,0,1,1,1,1};
    int [] c_array = {1,1,1,1,0,0,0};
    int [] p_array = {1,1,0,0,0,1,1};
    int [] a_array = {1,0,0,0,1,1,1};
    int [] m_array = {0,1,1,0,1,1,0};
    int [] n_array = {0,0,1,0,1,1,1};
    int [] o_array = {1,1,0,0,1,1,0};
    int [] r_array = {1,1,0,1,0,0,1};
    int [] u_array = {0,1,1,1,0,1,0};        
    int [] a1_array = {0,1,1,0,0,1,1};
    int [] a2_array = {0,1,1,1,0,0,1};
    int [] a3_array = {1,0,1,0,0,1,1};
    int [] a4_array = {1,0,0,1,0,1,1};
    int [] b1_array = {0,0,1,1,0,1,1};
    int [] b2_array = {1,1,0,1,1,0,0};
    int [] d1_array = {1,0,0,1,1,1,0};
    int [] d2_array = {1,0,0,1,1,0,1};
    int [] e1_array = {0,0,1,1,1,0,1};
    int [] n1_array = {0,1,0,0,1,1,1};
    int [] p1_array = {1,1,0,0,1,0,1};
    int [] q1_array = {1,1,1,0,0,0,1};
    int [] q2_array = {1,0,1,1,1,0,0};
    int [] q3_array = {1,0,1,1,0,0,1};
    int [] q4_array = {1,0,1,0,1,0,1};
    int [] r1_array = {1,1,1,0,1,0,0};
    int [] r2_array = {1,1,1,0,0,1,0};
    int [] r3_array = {1,1,0,1,0,1,0};
    int [] u1_array = {0,1,0,1,1,1,0};

    Shift H = new Shift(h_array, "H");
    Shift E = new Shift(e_array, "E");
    Shift D = new Shift(d_array, "D");
    Shift C = new Shift(c_array, "C");
    Shift P = new Shift(p_array, "P");
    Shift A = new Shift(a_array, "A");
    Shift M = new Shift(m_array, "M");
    Shift N = new Shift(n_array, "N");
    Shift O = new Shift(o_array, "O");
    Shift R = new Shift(r_array, "R");
    Shift U = new Shift(u_array, "U");      
    Shift U1 = new Shift(u1_array, "U1");
    Shift R3 = new Shift(r3_array, "R3");
    Shift R2 = new Shift(r2_array, "R2");
    Shift R1 = new Shift(r1_array, "R1");
    Shift Q4 = new Shift(q4_array, "Q4");
    Shift Q3 = new Shift(q3_array, "Q3");
    Shift Q2 = new Shift(q2_array, "Q2");
    Shift Q1 = new Shift(q1_array, "Q1");
    Shift P1 = new Shift(p1_array, "P1");
    Shift N1 = new Shift(n1_array, "N1");
    Shift E1 = new Shift(e1_array, "E1");
    Shift D2 = new Shift(d2_array, "D2");
    Shift D1 = new Shift(d1_array, "D1");
    Shift B2 = new Shift(b2_array, "B2");
    Shift B1 = new Shift(b1_array, "B1");
    Shift A4 = new Shift(a4_array, "A4");
    Shift A3 = new Shift(a3_array, "A3");
    Shift A2 = new Shift(a2_array, "A2");
    Shift A1 = new Shift(a1_array, "A1");

    Rotator H_D = new Rotator(H, D, "H-D");
    Rotator D_H = new Rotator(D, H, "D-H");
    Rotator E1_R1 = new Rotator(E1, R1, "E1-R1");
    Rotator R1_E1 = new Rotator(R1, E1, "R1-E1");
    Rotator B1_Q2 = new Rotator(B1, Q2, "B1-Q2");
    Rotator Q2_B1 = new Rotator(Q2, B1, "Q2-B1");
    Rotator D_D1 = new Rotator(D, D1, "D-D1");
    Rotator D1_D = new Rotator(D1, D, "D1-D");
    Rotator P_D = new Rotator(P, D, "P-D");
    Rotator D_P = new Rotator(D, P, "D-P");
    Rotator O_D = new Rotator(O, D, "O-D");
    Rotator D_O = new Rotator(D, O, "D-O");
    Rotator A1_C = new Rotator(A1, C, "A1-C");
    Rotator C_A1 = new Rotator(C, A1, "C-A1");
    Rotator A1_B2 = new Rotator(A1, B2, "A1-B2");
    Rotator A1_D1 = new Rotator(A1, D1, "A1-D1");
    Rotator A1_E = new Rotator(A1, E, "A1-E");
    Rotator A1_H = new Rotator(A1, H, "A1-H");
    Rotator A1_M = new Rotator(A1, M, "A1-M");
    Rotator A1_O = new Rotator(A1, O, "A1-O");
    Rotator A1_R1 = new Rotator(A1, R1, "A1-R1");
    Rotator B1_B2 = new Rotator(B1, B2, "B1-B2");
    Rotator B2_A1 = new Rotator(B2, A1, "B2-A1");
    Rotator B2_B1 = new Rotator(B2, B1, "B2-B1");
    Rotator C_E = new Rotator(C, E, "C-E");
    Rotator C_H = new Rotator(C, H, "C-H");
    Rotator C_P = new Rotator(C, P, "C-P");
    Rotator C_Q1 = new Rotator(C, Q1, "C-Q1");
    Rotator D1_A1 = new Rotator(D1, A1, "D1-A1");
    Rotator D_E = new Rotator(D, E, "D-E");
    Rotator E1_Q2 = new Rotator(E1, Q2, "E1-Q2");
    Rotator E_A1 = new Rotator(E, A1, "E-A1");
    Rotator E_D = new Rotator(E, D, "E-D");
    Rotator E_H = new Rotator(E, H, "E-H");
    Rotator E_Q2 = new Rotator(E, Q2, "E-Q2");
    Rotator H_A1 = new Rotator(H, A1, "H-A1");
    Rotator H_C = new Rotator(H, C, "H-C");
    Rotator H_E = new Rotator(H, E, "H-E");
    Rotator H_N1 = new Rotator(H, N1, "H-N1");
    Rotator M_A1 = new Rotator(M, A1, "M-A1");
    Rotator M_N1 = new Rotator(M, N1, "M-N1");
    Rotator N1_H = new Rotator(N1, H, "N1-H");
    Rotator N1_O = new Rotator(N1, O, "N1-O");
    Rotator N_A1 = new Rotator(N, A1, "N-A1");
    Rotator O_A1 = new Rotator(O, A1, "O-A1");
    Rotator P_C = new Rotator(P, C, "P-C");
    Rotator Q1_C = new Rotator(Q1, C, "Q1-C");
    Rotator Q2_E1 = new Rotator(Q2, E1, "Q2-E1");
    Rotator R2_A1 = new Rotator(R2, A1, "R2-A1");
    Rotator R2_A2 = new Rotator(R2, A2, "R2-A2");
    
    //two arg constructor takes in array of shifts & size of the array
    public Bid(Shift [] shiftsInput, int arraySize)
    {
        size = arraySize;
        shifts = shiftsInput;
    }
    
    //returns array of all the shifts in the bid
    public Shift [] getBid()
    {
        return shifts;
    }
    
    //returns size of the bid 
    public int getSize()
    {
        return size;
    }
    
    //returns total of all the workers in a given day
    public int getTotalWorkersPerDay(int day)
    {
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            sum += shifts[i].workingInquiry(day);
        }
        return sum;
    }
    
    //scores the Bids fitness based on how close it matches the targeted employee requirements
    public void setFitnessScore(int [] target)
    {
        
        int [] testArray = new int[14];
        for (int i = 0; i < 14; i++)
        {
            testArray[i] = getTotalWorkersPerDay(i);
        }
        
        int i = 0, n = 0, match = 0;
        while (i < testArray.length && n < target.length)
        {
            if (testArray[i] < target[i])
            {
                i++;
            }
            
            else if (testArray[i] > target[i])
            {
                n++;
            }
            
            else
            {
                match++;
                i++;
                n++;
            }
        }
        fitnessScore = (match * 100) / (target.length);
    }
    
    //returns fitness score
    public int getFitnessScore()
    {
        return fitnessScore;
    }
    
    //tests total working days against target working days
    public boolean isMatch(int [] target)
    {
        int [] testArray = new int [14];
        for(int i = 0; i < 14; i++)
            {
                testArray[i] = getTotalWorkersPerDay(i);
            }
        return Arrays.equals(testArray, target);
    }
    
    //sorts the bid alphabetically
    public void sortBid()
    {
        Arrays.sort(shifts);
    }
    
    public Shift getRandomShift()
    {
        Random random = new Random();
        return shifts[random.nextInt(size)];
    }
    
    public Shift [] getShifts()
    {
        return shifts;
    }
    
    public int instanceOf(Shift shift)
    {
        int matchCount = 0;
        for (Shift shift1 : shifts)
        {
            if (shift1.toString().compareTo(shift.toString()) == 0)
            {
                matchCount ++;
            }        
        }
        return matchCount;
    }
    
    public void makeRotator()
    {
        int countA1C = 0;
        int countDO = 0;
        for (int i = 0; i < shifts.length; i++)
        {
            if (shifts[i].getName().toString().compareTo("A1") == 0)
            {
                countA1C ++;
                shifts[i] = A1_C;
            } 
        }
        
        while (countA1C > 0)
        {
            for (int j = 0; j < shifts.length; j++)
            {
                if (shifts[j].getName().toString().compareTo("C") == 0 && countA1C > 0)
                {
                    countA1C --;
                    shifts[j] = C_A1;
                }
            }                          
        }
        
        for (int i = 0; i < shifts.length; i++)
        {
            if (shifts[i].getName().toString().compareTo("O") == 0)
            {
                countDO ++;
                shifts[i] = O_D;
            } 
        }
        
        while (countDO > 0)
        {
            for (int j = 0; j < shifts.length; j++)
            {
                if (shifts[j].getName().toString().compareTo("D") == 0 && countDO > 0)
                {
                    countDO --;
                    shifts[j] = D_O;
                }
            }                          
        }
     }
    
    @Override
    public String toString()
    {  
       return Arrays.toString(shifts);
    }    
}
