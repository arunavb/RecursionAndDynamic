package pemutations;

import java.util.ArrayList;
import java.util.List;

public class Multiplication
{
  /**
   * firstNumber and secondNumber are reversed
   */
  List<Integer> firstNumber;
  List<Integer> secondNumber;
  List<List<Integer>> intermediateResults;
  public void multiply(String number1,String number2)
  {
    firstNumber=new ArrayList<Integer>();
    secondNumber=new ArrayList<Integer>();
    while(!number1.isEmpty())
    {
      char firstChar=number1.charAt(0);
      number1=number1.substring(1);
      firstNumber.add(0,Character.getNumericValue(firstChar));
    }
    while(!number2.isEmpty())
    {
      char firstChar=number2.charAt(0);
      number2=number2.substring(1);
      secondNumber.add(0,Character.getNumericValue(firstChar));
    }
  this.intermediateResults=new ArrayList<List<Integer>>();
  int index=0;
  while(secondNumber.size()>0)
  {
    int value=secondNumber.remove(0);
    List<Integer> result=addHelper(firstNumber,value,0);
    int concatenateZero=0;
    while(concatenateZero<index)
    {
      result.add(0,0);
      concatenateZero++;
    }
    intermediateResults.add(result);
    index++;
  }
  List<Integer> finalResult=sumAll(intermediateResults);
  String finalAnswer="";
  for(int i:finalResult)
  {
    finalAnswer=String.valueOf(i)+finalAnswer;
  }
  System.out.println(finalAnswer);
  }
  
  private List<Integer> sumAll(List<List<Integer>> results)
  {
    if(results.size()==1)
    {
      return results.remove(0);
    }
    List<Integer> firstNumber=results.remove(0);
    List<Integer> secondNumber=results.remove(0);
    List<Integer> added=add(firstNumber,secondNumber,0);
    results.add(0,added);
    return sumAll(results);
  }

  private List<Integer> add(List<Integer> firstNumber,
      List<Integer> secondNumber,int carryOver)
  {
    List<Integer> result=new ArrayList<Integer>();
    while(firstNumber.size()>0&&secondNumber.size()>0)
    {
      int first=firstNumber.remove(0);
      int second=secondNumber.remove(0);
      int value=(first+second+carryOver)%10;
      carryOver=(first+second+carryOver)/10;
      result.add(value);
    }
    while(firstNumber.size()>0)
    {
      int first=firstNumber.remove(0);
      int value=(first+carryOver)%10;
      carryOver=(first+carryOver)/10;
      result.add(value);
    }
    while(secondNumber.size()>0)
    {
      int second=secondNumber.remove(0);
      int value=(second+carryOver)%10;
      carryOver=(second+carryOver)/10;
      result.add(value);
    }
    if(carryOver!=0)
    {
      result.add(carryOver);
    }
    return result;
  }

  private List<Integer> addHelper(List<Integer> firstNumber,int multiply,
      int carryOver)
      {
        List<Integer> result=new ArrayList<Integer>();
        for(int index=0;index<firstNumber.size();index++)
        {
          result.add(((firstNumber.get(index)*multiply)+carryOver)%10);
          carryOver=((firstNumber.get(index)*multiply)+carryOver)/10;
        }
        if(carryOver!=0)
        {
          result.add(carryOver);
        }
        return result;
      }
  public static void main(String args[])
  {
    Multiplication m=new Multiplication();
    m.multiply("21", "21");
  }
}
