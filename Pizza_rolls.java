
package com.mycompany.tostinos_pizza_rolls;
import javax.swing.*; 
public class Pizza_rolls 
{
    String OrderDetails="Order Details -\n____________________________";
    String temp;
    int temp2;
    int pizza_amount;
    boolean valid;
    
    int[][] pizza_list;
    int[] pizza_costs;
    String [][] Detials ={{"Small","medium","Large"},
            {"None","Normal","Extra","Extreme!"}};
    
    private int cost;
        
    Pizza_rolls()
    {
         temp=null;
         pizza_amount=0;
         valid=false;
         cost =0;
         
    }
    
    public void askPizzaAmount()
    {
        valid=false;
        while(valid==false)
        {
        temp = JOptionPane.showInputDialog("How many pizzas woud you like to order? \n (Max order of 9 - pizzas due to covid-19)");
        valid = set_amount(temp);  
        } 
    }
    
    public boolean set_amount(String x )
    {
        try
        {
            pizza_amount = Integer.parseInt(x);
            return rangeCheck(pizza_amount,1,9);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Please enter a value.");
            return false;
        }
    }
    
    public boolean set_toppings(String input, int options1, int options2)
    {
        
        try
        {
            temp2 = Integer.parseInt(input);
            return rangeCheck(temp2,options1,options2);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Please enter a value.");
            return false;
        }
    }
    
    public boolean rangeCheck(int number, int range1, int range2)
    {
        if(number>=range1 && number <=range2)
        {
            return true;
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"Please enter a number between "+range1+" and "+range2+".");
            return false;
        }
    }
    
    
    public void asking(String question, int options1,int options2)
    {
        valid=false;
        while(valid==false)
        {
        temp = JOptionPane.showInputDialog(null,question);
        valid = set_toppings(temp,options1,options2);
        
        }
    }
    
    public void order_detail(int amount)
    {
       pizza_list= new int[5][amount];
       for(int i=0;i<amount;i++)
       {
           //Pizza number
           pizza_list[0][i]=i+1;
 
           //Pizza size
           asking("Enter Pizza "+(i+1)+ " size. (1 - Small, 2 - Medium, 3 - Large)",1,3);
           pizza_list[1][i]=temp2;
           
           //Pizza cheese amount
           asking("Enter Pizza "+(i+1)+ " cheese amount. (0 - None, 1 - Normal, 2 - Extra, 3- Extreme!)",0,3);
           pizza_list[2][i]=temp2;
           
           //Pizza Pepperoni amount
           asking("Enter Pizza "+(i+1)+ " Pepperoni amount. (0 - None, 1 - Normal, 2 - Extra, 3- Extreme!)",0,3);
           pizza_list[3][i]=temp2;
           
           //Pizza Ham amount
           asking("Enter Pizza "+(i+1)+ " Ham amount. (0 - None, 1 - Normal, 2 - Extra, 3- Extreme!)",0,3);
           pizza_list[4][i]=temp2;
       }
    }
    
    public void calcCost()
    {
        
        for(int i=0;i<pizza_list[0].length;i++)
        {
                cost+=8+(2*(pizza_list[1][i]));
                cost+=(2*(pizza_list[2][i]));
                cost+=(2*(pizza_list[3][i]));
                cost+=(2*(pizza_list[4][i]));
        }
    }
    
    public void individual_cost()
    {
        pizza_costs= new int[pizza_list[0].length];
        
        for(int i=0;i<pizza_list[0].length;i++)
        {
                temp2=0;
                temp2+=8+(2*(pizza_list[1][i]));
                temp2+=(2*(pizza_list[2][i]));
                temp2+=(2*(pizza_list[3][i]));
                temp2+=(2*(pizza_list[4][i]));
                pizza_costs[i]=temp2;
        }
        
    }
    
    public void getDescription()
    {
       for(int i=0;i<pizza_list[0].length;i++)
        {
          OrderDetails+= "\n\nPizza Number "+(i+1)+" -";
          OrderDetails+= "\nSize: " + Detials[0][(pizza_list[1][i])-1];
          OrderDetails+= "\nCheese: "+ Detials[1][pizza_list[2][i]];
          OrderDetails+= "\nPepperoni: "+ Detials[1][pizza_list[3][i]];
          OrderDetails+= "\nHam: "+ Detials[1][pizza_list[4][i]];
          OrderDetails+= "\n Cost: "+ pizza_costs[i];
        }
       OrderDetails+="\n____________________________";
       OrderDetails+="\n\nCost: " +cost;
       OrderDetails+="\nTax: " + cost*0.08;
       OrderDetails+="\n\nTotal Amount: "+(cost+(cost*0.08));
        OrderDetails+="\n____________________________";
    }
    
    public static void main(String [] args)
    {
        Pizza_rolls order= new Pizza_rolls();
        order.askPizzaAmount();
        order.order_detail(order.pizza_amount);
        order.calcCost();
        order.individual_cost();
        order.getDescription();
        JOptionPane.showMessageDialog(null,order.OrderDetails);

    }
}
